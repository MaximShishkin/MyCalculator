package CalculatorPackage;

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

public class WindowCalculator extends JFrame {

	// текстовое поле для результата
	private JTextArea text;
	// координаты кнопок
	private int x = 10;
	private int y = 55;
	// переменные для хранения двух введённых чисел
	private double p1 = 0, p2 = 0;
	// переменная для хранения решения
	private double resh = 0;
	// тип операции, выбранной пользователем
	private int oper = 0;
	// создаём кнопки
	private JButton[] button = new JButton[20];
	
	public WindowCalculator()
	{
		// создадим 3 шрифта
		Font buttonFont = new Font("serif",0,30);
		Font labelFont = new Font("arial",1,30);
		Font textFont = new Font("arial",2,30);
		
		// переменная для доступа к содержимому окна
		Container cont = getContentPane();
		
		// создаём панель для окна
		JPanel mypanel = new JPanel();
		
		// произвольное размещение элементов на панели
		mypanel.setLayout(null);
		
		// создаём текстовую надпись
		JLabel label = new JLabel("Результат:");
		
		// задаём размеры и местоположение
		label.setBounds(15, 15, 300, 50);
		
		//установим шрифт
		label.setFont(labelFont);
		
		// прикрепляем надпись к панели
		// mypanel.add(label);
		
		// создаём текстовое поле
		text = new JTextArea();
		
		// устанавливаем размеры для текстового поля
		text.setBounds(10,10,430,35);
		
		//установим шрифт
		text.setFont(textFont);
		
		// прикрепляем текстовое поле к панели
		mypanel.add(text);
		
		// цикл для кнопок
		for(int i = 0; i < 20; i++) {
			
			if (i % 4 == 0 && i > 0 ) 
			{
				x = 10;
				y = y + 110;	
			}
			
			// создаём кнопку
			button[i] = new JButton();
			
			// устанавливаем размер
			button[i].setSize(100, 100);
			
			// устанавливаем шрифт
			button[i].setFont(buttonFont);
			
			// устанавливаем расположение
			button[i].setLocation(x, y);
			
			if (i<10) {	
				// устанавливаем надпись на кнопку
				button[i].setText("" + i);
			}
			
			// подключение обработчика событий
			button[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					buttonClick((JButton) e.getSource());
				}
			});
				
			// прикрепляем кнопку к панели
			mypanel.add(button[i]);
			
			x = x + 110;
		}
		
		// устанавливаем надпись на кнопку
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
		
		// прикрепляем панель к окну
		cont.add(mypanel);
		
		// устанавливаем размеры окна
		setBounds(0,0,465,645);
		
		// название окна
		setTitle("МОЙ КАЛЬКУЛЯТОР");
		
		// запретить измененение размеров окна
		setResizable(false);
		
		// окончание работы приложения при закрытии окна
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// показваем (отображаем) окно
		setVisible(true);
	}
	
	// метод для обработки нажатия клавиш
	private void buttonClick(JButton buttonClick)
	{
		// System.out.println(button.getText());
		// название кнопки, которую нажали
		String namebutton = buttonClick.getText();
		
		if (namebutton.equals("+"))
		{
			// если нажали на +
			// устанавливаем значение операции
			oper = 1;
			// записываем значение в переменную p1
			// с переводом из строки в число
			p1 =  Double.parseDouble(text.getText());
			// очищаем поле ввода
			text.setText("");
			// установим зелёный цвет
			button[12].setBackground(Color.GREEN);
		}
		else if (namebutton.equals("-"))
		{
			// если нажали на -
			// устанавливаем значение операции
			oper = 2;
			// записываем значение в переменную p1
			// с переводом из строки в число
			p1 =  Double.parseDouble(text.getText());
			// очищаем поле ввода
			text.setText("");
			// установим зелёный цвет		
			button[13].setBackground(Color.GREEN);
		}
		else if (namebutton.equals("*"))
		{
			// если нажали на *
			// устанавливаем значение операции
			oper = 3;
			// записываем значение в переменную p1
			// с переводом из строки в число
			p1 =  Double.parseDouble(text.getText());
			// очищаем поле ввода
			text.setText("");
			// установим зелёный цвет		
			button[14].setBackground(Color.GREEN);		
		}
		else if (namebutton.equals("/"))
		{
			// если нажали на /
			// устанавливаем значение операции
			oper = 4;
			// записываем значение в переменную p1
			// с переводом из строки в число
			p1 =  Double.parseDouble(text.getText());
			// очищаем поле ввода
			text.setText("");
			// установим зелёный цвет	
			button[15].setBackground(Color.GREEN);
		}
		else if (namebutton.equals("^"))
		{
			// если нажали на ^
			// устанавливаем значение операции
			oper = 5;
			// записываем значение в переменную p1
			// с переводом из строки в число
			p1 = Double.parseDouble(text.getText());
			// очищаем поле ввода
			text.setText("");
			// установим зелёный цвет	
			button[16].setBackground(Color.GREEN);
		}
		else if (namebutton.equals("^2"))
		{
			// если нажали на ^2
			// записываем значение в переменную p1
			// с переводом из строки в число
			p1 =  Double.parseDouble(text.getText());
			// ^2
			resh = Math.pow(p1, 2);
			text.setText("" + resh);
		}
		else if (namebutton.equals("sqrt"))
		{
			// если нажали на sqrt
			// записываем значение в переменную p1
			// с переводом из строки в число
			p1 =  Double.parseDouble(text.getText());
			// sqrt
			resh = Math.sqrt(p1);
			text.setText("" + resh);
		}
		else if (namebutton.equals("C"))
		{
			// если нажали на С
			// очищаем поле ввода
			text.setText("");
			p1 = 0;
			p2 = 0;
			oper = 0;
		}
		else if (namebutton.equals("="))
		{
			// если нажали на =
			// записываем значение в переменную p1
			// с переводом из строки в число
			p2 =  Double.parseDouble(text.getText());
		
			// в зависимости от операции, будет выполняться какое-то действие
			if (oper==1) {
				// +
				resh = p1 + p2;
				text.setText("" + resh);
			}
			else if (oper==2) {
				// - 
				resh = p1 - p2;
				text.setText("" + resh);
			}
			else if (oper==3) {
				// * 
				resh = p1 * p2;
				text.setText("" + resh);
			}
			else if (oper==4) {
				// / 
				resh = p1 / p2;
				text.setText("" + resh);
			}
			else if (oper==5) {
				// ^ 
				resh = Math.pow(p1, p2);
				text.setText("" + resh);
			}
			
			// установим цвет по умолчанию
			button[12].setBackground(null);
			button[13].setBackground(null);
			button[14].setBackground(null);
			button[15].setBackground(null);
			button[16].setBackground(null);
		}
		else {
			// добавляем символ в строку
			text.setText("" + text.getText() + namebutton);
		}
	}
}
