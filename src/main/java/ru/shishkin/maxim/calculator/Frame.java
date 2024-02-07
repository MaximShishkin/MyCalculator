package ru.shishkin.maxim.calculator;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Frame extends JFrame {
    private JTextArea text;
    private int x = 10;
    private int y = 55;
    private double p1 = 0, p2 = 0;
    private double resh = 0;
    private int oper = 0;
    private JButton[] button = new JButton[20];

    public Frame() {
        Font buttonFont = new Font("serif", 0, 30);
        Font labelFont = new Font("arial", 1, 30);
        Font textFont = new Font("arial", 2, 30);

        Container cont = getContentPane();
        JPanel mypanel = new JPanel();
        mypanel.setLayout(null);
        JLabel label = new JLabel("Resault:");
        label.setBounds(15, 15, 300, 50);
        label.setFont(labelFont);
        text = new JTextArea();
        text.setBounds(10, 10, 430, 35);
        text.setFont(textFont);
        mypanel.add(text);

        for (int i = 0; i < 20; i++) {
            if (i % 4 == 0 && i > 0) {
                x = 10;
                y = y + 110;
            }

            button[i] = new JButton();
            button[i].setSize(100, 100);
            button[i].setFont(buttonFont);
            button[i].setLocation(x, y);

            if (i < 10) {
                button[i].setText("" + i);
            }

            button[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    buttonClick((JButton) e.getSource());
                }
            });

            mypanel.add(button[i]);
            x = x + 110;
        }

        button[10].setText(".");
        button[11].setText("C");
        button[12].setText("+");
        button[13].setText("-");
        button[14].setText("*");
        button[15].setText("/");
        button[16].setText("^");
        button[17].setText("^2");
        button[18].setText("sqrt");
        button[19].setText("=");

        cont.add(mypanel);
        setBounds(0, 0, 465, 645);
        setTitle("Calculator");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void buttonClick(JButton buttonClick) {
        String namebutton = buttonClick.getText();
        if (namebutton.equals("+")) {
            oper = 1;
            p1 = Double.parseDouble(text.getText());
            text.setText("");
            button[12].setBackground(Color.GREEN);
        } else if (namebutton.equals("-")) {
            oper = 2;
            p1 = Double.parseDouble(text.getText());
            text.setText("");
            button[13].setBackground(Color.GREEN);
        } else if (namebutton.equals("*")) {
            oper = 3;
            p1 = Double.parseDouble(text.getText());
            text.setText("");
            button[14].setBackground(Color.GREEN);
        } else if (namebutton.equals("/")) {
            oper = 4;
            p1 = Double.parseDouble(text.getText());
            text.setText("");
            button[15].setBackground(Color.GREEN);
        } else if (namebutton.equals("^")) {
            oper = 5;
            p1 = Double.parseDouble(text.getText());
            text.setText("");
            button[16].setBackground(Color.GREEN);
        } else if (namebutton.equals("^2")) {
            p1 = Double.parseDouble(text.getText());
            resh = Math.pow(p1, 2);
            text.setText("" + resh);
        } else if (namebutton.equals("sqrt")) {
            p1 = Double.parseDouble(text.getText());
            resh = Math.sqrt(p1);
            text.setText("" + resh);
        } else if (namebutton.equals("C")) {
            text.setText("");
            p1 = 0;
            p2 = 0;
            oper = 0;
        } else if (namebutton.equals("=")) {
            p2 = Double.parseDouble(text.getText());
            if (oper == 1) {
                resh = p1 + p2;
                text.setText("" + resh);
            } else if (oper == 2) {
                resh = p1 - p2;
                text.setText("" + resh);
            } else if (oper == 3) {
                resh = p1 * p2;
                text.setText("" + resh);
            } else if (oper == 4) {
                resh = p1 / p2;
                text.setText("" + resh);
            } else if (oper == 5) {
                resh = Math.pow(p1, p2);
                text.setText("" + resh);
            }
            button[12].setBackground(null);
            button[13].setBackground(null);
            button[14].setBackground(null);
            button[15].setBackground(null);
            button[16].setBackground(null);
        } else {
            text.setText("" + text.getText() + namebutton);
        }
    }
}
