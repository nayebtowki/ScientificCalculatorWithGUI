
import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.Math.*;

public class Calculator extends JFrame {

	// Fields
	JPanel mypanel;

	JButton mybutton0, mybuttonDecimal, mybuttonPlus, mybuttonpi;

	JButton mybuttonNfac, mybutton1, mybutton2, mybutton3, mybuttonMinus;

	JButton mybuttonXpow, mybutton4, mybutton5, mybutton6, mybuttonMultiply;

	JButton mybuttonXcube, mybutton7, mybutton8, mybutton9, mybuttonDivide;

	JButton mybuttonXtopowY, mybuttonPercent, mybuttonfirstb, mybuttonlastb, mybuttonLog;

	JButton mybuttonSin, mybuttonCos, mybuttonTan, mybuttonSqr, mybuttonCbr;

	JButton mybuttonEqual, mybuttonClear, mybuttonBackSpace;
	JButton  mybuttonMr, mybuttonMp;
	/**
	 * *
	 * MR = Memory Recall uses
	 * the number in memory
	 * MP = Adds numbers to the memory,
	 */

	JRadioButton myRadioButtonOn, myRadioButtonOff;
	double num, m1;
	int k = 1;
	String str, save, recall;
	Font font = new Font("saxmono", Font.BOLD, 30);
	// radiobuttongroup
	private final ButtonGroup buttonGroup = new ButtonGroup();

	JLabel tf1, result;
	Events e1 = new Events();

	// constructor
	public Calculator() {
		mypanel = new JPanel();
		mypanel.setLayout(null);

		// -------------------------------------
		// set the buttons location
		// set the width and height is 70*50 for each and every button
		mybuttonNfac = new JButton("x!");
		mybuttonNfac.setBounds(15, 490, 70, 50);

		mybutton0 = new JButton("0");
		mybutton0.setBounds(85, 490, 140, 50);

		mybuttonDecimal = new JButton(".");
		mybuttonDecimal.setBounds(225, 490, 70, 50);

		mybuttonPlus = new JButton("+");
		mybuttonPlus.setBounds(295, 440, 70, 100);
		mybuttonPlus.setForeground(Color.decode("0x0000FF"));

		// -------------------------------------

		mybuttonXpow = new JButton("x^2");
		mybuttonXpow.setBounds(15, 440, 70, 50);

		mybutton1 = new JButton("1");
		mybutton1.setBounds(85, 440, 70, 50);

		mybutton2 = new JButton("2");
		mybutton2.setBounds(155, 440, 70, 50);

		mybutton3 = new JButton("3");
		mybutton3.setBounds(225, 440, 70, 50);

		mybuttonMinus = new JButton("-");
		mybuttonMinus.setBounds(295, 390, 70, 50);
		mybuttonMinus.setForeground(Color.decode("0x0000FF"));

		// -------------------------------------

		mybuttonXcube = new JButton("x^3");
		mybuttonXcube.setBounds(15, 390, 70, 50);

		mybutton4 = new JButton("4");
		mybutton4.setBounds(85, 390, 70, 50);

		mybutton5 = new JButton("5");
		mybutton5.setBounds(155, 390, 70, 50);

		mybutton6 = new JButton("6");
		mybutton6.setBounds(225, 390, 70, 50);

		mybuttonMultiply = new JButton("*");
		mybuttonMultiply.setBounds(295, 340, 70, 50);
		mybuttonMultiply.setForeground(Color.decode("0x0000FF"));
		// -------------------------------------

		mybuttonXtopowY = new JButton("x^y");
		mybuttonXtopowY.setBounds(15, 340, 70, 50);

		mybutton7 = new JButton("7");
		mybutton7.setBounds(85, 340, 70, 50);

		mybutton8 = new JButton("8");
		mybutton8.setBounds(155, 340, 70, 50);

		mybutton9 = new JButton("9");
		mybutton9.setBounds(225, 340, 70, 50);

		mybuttonDivide = new JButton("/");
		mybuttonDivide.setBounds(295, 290, 70, 50);
		mybuttonDivide.setForeground(Color.decode("0x0000FF"));

		// -------------------------------------

		mybuttonLog = new JButton("log");
		mybuttonLog.setBounds(15, 290, 70, 50);

		mybuttonPercent = new JButton("%");
		mybuttonPercent.setBounds(85, 290, 70, 50);

		mybuttonfirstb = new JButton("(");
		mybuttonfirstb.setBounds(155, 290, 70, 50);

		mybuttonlastb = new JButton(")");
		mybuttonlastb.setBounds(225, 290, 70, 50);

		mybuttonpi = new JButton("pi");
		mybuttonpi.setBounds(295, 240, 70, 50);

		// -------------------------------------

		mybuttonSin = new JButton("sin");
		mybuttonSin.setBounds(15, 240, 70, 50);

		mybuttonCos = new JButton("cos");
		mybuttonCos.setBounds(85, 240, 70, 50);

		mybuttonTan = new JButton("tan");
		mybuttonTan.setBounds(155, 240, 70, 50);

		mybuttonSqr = new JButton("√");// sqr root
		mybuttonSqr.setBounds(225, 240, 70, 50);

		mybuttonCbr = new JButton("3√");
		mybuttonCbr.setBounds(155, 190, 70, 50);

		// -------------------------------------
		mybuttonBackSpace = new JButton("Del");
		mybuttonBackSpace.setBounds(225, 190, 70, 50);
		mybuttonBackSpace.setForeground(Color.decode("0xFF0000"));

		mybuttonClear = new JButton("CLR");
		mybuttonClear.setBounds(295, 190, 70, 50);
		mybuttonClear.setForeground(Color.decode("0xFF0000"));
		mybuttonEqual = new JButton("=");
		mybuttonEqual.setBounds(155, 140, 210, 50);

		mybuttonMr = new JButton("MR");
		mybuttonMr.setBounds(15, 140, 140, 50);

		mybuttonMp = new JButton("M+");
		mybuttonMp.setBounds(15, 190, 140, 50);

		myRadioButtonOn = new JRadioButton("ON", true);
		buttonGroup.add(myRadioButtonOn);
		myRadioButtonOn.setBounds(15, 100, 50, 30);

		myRadioButtonOff = new JRadioButton("OFF");
		buttonGroup.add(myRadioButtonOff);
		myRadioButtonOff.setBounds(100, 100, 50, 30);

		tf1 = new JLabel("", SwingConstants.LEFT);
		tf1.setText("");
		tf1.setBounds(15, 15, 350, 40);
		tf1.setFont(font);
		tf1.setForeground(Color.decode("0xA9A9A9"));
		result = new JLabel("", SwingConstants.RIGHT);
		result.setText("");
		result.setBounds(15, 55, 350, 40);
		result.setFont(font);

		// -------------------------------------

		// -------------------------------------

		add(mypanel);
		// adding buttons to the panel
		mypanel.add(mybutton0);
		mypanel.add(mybuttonDecimal);
		mypanel.add(mybuttonPlus);
		mypanel.add(mybuttonpi);

		mypanel.add(mybuttonNfac);
		mypanel.add(mybutton1);
		mypanel.add(mybutton2);
		mypanel.add(mybutton3);
		mypanel.add(mybuttonMinus);

		mypanel.add(mybuttonXpow);
		mypanel.add(mybutton4);
		mypanel.add(mybutton5);
		mypanel.add(mybutton6);
		mypanel.add(mybuttonMultiply);

		mypanel.add(mybuttonXcube);
		mypanel.add(mybutton7);
		mypanel.add(mybutton8);
		mypanel.add(mybutton9);
		mypanel.add(mybuttonDivide);

		mypanel.add(mybuttonXtopowY);
		mypanel.add(mybuttonPercent);
		mypanel.add(mybuttonfirstb);
		mypanel.add(mybuttonlastb);
		mypanel.add(mybuttonLog);

		mypanel.add(mybuttonSin);
		mypanel.add(mybuttonCos);
		mypanel.add(mybuttonTan);
		mypanel.add(mybuttonSqr);
		mypanel.add(mybuttonCbr);

		mypanel.add(mybuttonEqual);
		mypanel.add(mybuttonClear);
		mypanel.add(mybuttonBackSpace);
		mypanel.add(mybuttonMr);
		mypanel.add(mybuttonMp);

		mypanel.add(myRadioButtonOff);
		mypanel.add(myRadioButtonOn);

		mypanel.add(tf1);
		mypanel.add(result);
		// add the action listener to the buttons

		mybutton1.addActionListener(e1);
		mybutton2.addActionListener(e1);
		mybutton3.addActionListener(e1);
		mybutton4.addActionListener(e1);
		mybutton5.addActionListener(e1);
		mybutton6.addActionListener(e1);
		mybutton7.addActionListener(e1);
		mybutton8.addActionListener(e1);
		mybutton9.addActionListener(e1);
		mybutton0.addActionListener(e1);

		mybuttonNfac.addActionListener(e1);
		mybuttonXpow.addActionListener(e1);
		mybuttonXcube.addActionListener(e1);
		mybuttonXtopowY.addActionListener(e1);
		mybuttonPercent.addActionListener(e1);
		mybuttonfirstb.addActionListener(e1);
		mybuttonlastb.addActionListener(e1);
		mybuttonpi.addActionListener(e1);
		mybuttonLog.addActionListener(e1);
		mybuttonDecimal.addActionListener(e1);

		mybuttonSin.addActionListener(e1);
		mybuttonCos.addActionListener(e1);
		mybuttonTan.addActionListener(e1);
		mybuttonSqr.addActionListener(e1);
		mybuttonCbr.addActionListener(e1);

		mybuttonPlus.addActionListener(e1);
		mybuttonMinus.addActionListener(e1);
		mybuttonMultiply.addActionListener(e1);
		mybuttonDivide.addActionListener(e1);

		mybuttonEqual.addActionListener(e1);
		mybuttonClear.addActionListener(e1);
		mybuttonBackSpace.addActionListener(e1);

		mybuttonMr.addActionListener(e1);
		mybuttonMp.addActionListener(e1);

		// this radio button turn off the calculator
		myRadioButtonOff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mybutton1.setEnabled(false);
				mybutton2.setEnabled(false);
				mybutton3.setEnabled(false);
				mybutton4.setEnabled(false);
				mybutton5.setEnabled(false);
				mybutton6.setEnabled(false);
				mybutton7.setEnabled(false);
				mybutton8.setEnabled(false);
				mybutton9.setEnabled(false);
				mybutton0.setEnabled(false);

				mybuttonNfac.setEnabled(false);
				mybuttonXpow.setEnabled(false);
				mybuttonXcube.setEnabled(false);
				mybuttonXtopowY.setEnabled(false);
				mybuttonPercent.setEnabled(false);
				mybuttonfirstb.setEnabled(false);
				mybuttonlastb.setEnabled(false);
				mybuttonpi.setEnabled(false);
				mybuttonLog.setEnabled(false);
				mybuttonDecimal.setEnabled(false);

				mybuttonSin.setEnabled(false);
				mybuttonCos.setEnabled(false);
				mybuttonTan.setEnabled(false);
				mybuttonSqr.setEnabled(false);
				mybuttonCbr.setEnabled(false);

				mybuttonPlus.setEnabled(false);
				mybuttonMinus.setEnabled(false);
				mybuttonMultiply.setEnabled(false);
				mybuttonDivide.setEnabled(false);

				mybuttonEqual.setEnabled(false);
				mybuttonClear.setEnabled(false);
				mybuttonBackSpace.setEnabled(false);

				mybuttonMr.setEnabled(false);
				mybuttonMp.setEnabled(false);

				if (e.getSource() == myRadioButtonOff) {
					tf1.setText(null);
					result.setText(null);
					tf1.setEnabled(false);
					result.setEnabled(false);
				}
			}
		});
		// this radio button turn on the calculator
		myRadioButtonOn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mybutton1.setEnabled(true);
				mybutton2.setEnabled(true);
				mybutton3.setEnabled(true);
				mybutton4.setEnabled(true);
				mybutton5.setEnabled(true);
				mybutton6.setEnabled(true);
				mybutton7.setEnabled(true);
				mybutton8.setEnabled(true);
				mybutton9.setEnabled(true);
				mybutton0.setEnabled(true);

				mybuttonNfac.setEnabled(true);
				mybuttonXpow.setEnabled(true);
				mybuttonXcube.setEnabled(true);
				mybuttonXtopowY.setEnabled(true);
				mybuttonPercent.setEnabled(true);
				mybuttonfirstb.setEnabled(true);
				mybuttonlastb.setEnabled(true);
				mybuttonpi.setEnabled(true);
				mybuttonLog.setEnabled(true);
				mybuttonDecimal.setEnabled(true);

				mybuttonSin.setEnabled(true);
				mybuttonCos.setEnabled(true);
				mybuttonTan.setEnabled(true);
				mybuttonSqr.setEnabled(true);
				mybuttonCbr.setEnabled(true);

				mybuttonPlus.setEnabled(true);
				mybuttonMinus.setEnabled(true);
				mybuttonMultiply.setEnabled(true);
				mybuttonDivide.setEnabled(true);

				mybuttonEqual.setEnabled(true);
				mybuttonClear.setEnabled(true);
				mybuttonBackSpace.setEnabled(true);
				mybuttonMr.setEnabled(true);
				mybuttonMp.setEnabled(true);
				if (e.getSource() == myRadioButtonOn) {
					tf1.setText("");
					result.setText(null);
					tf1.setEnabled(true);
					result.setEnabled(true);
				}

			}
		});

	}

	// methods
	public static void main(String[] args) {
		// GUI for calculator
		JFrame Calculator = new Calculator();
		Calculator.setTitle("Scientic Calculator-GUI");
		Calculator.setSize(400, 590);// width and height 400*590
		Calculator.setLocationRelativeTo(null);// calculator will be center of the screen
		Calculator.setVisible(true);
		Calculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void saveData(String data) throws IOException {
		FileWriter saveHandle = new FileWriter(
				"\\C:\\Users\\User\\git\\Scientific-Calculator-with-GUI-Java\\Memory.txt");
		BufferedWriter bufferedWriterSaveData = new BufferedWriter(saveHandle);
		bufferedWriterSaveData.write(data);
		bufferedWriterSaveData.close();
		saveHandle.close();

	}

	public static String readData() throws IOException {
		FileReader recallHandle = new FileReader(
				"\\C:\\Users\\User\\git\\Scientific-Calculator-with-GUI-Java\\Memory.txt");
		BufferedReader bufferedRaderRecallData = new BufferedReader(recallHandle);
		String num = bufferedRaderRecallData.readLine();
		bufferedRaderRecallData.close();
		recallHandle.close();
		return num;

	}

	private class Events implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String str1 = tf1.getText();
			if (e.getSource() == mybuttonBackSpace) {
				if (str1.length() > 0) {
					tf1.setText(str1.substring(0, str1.length() - 1));
				}
			}
			if (e.getSource() == mybuttonClear) {
				tf1.setText("");
				result.setText("");
			}
			if (e.getSource() == mybuttonEqual) {
				if (!tf1.getText().isEmpty()) {
					try {
						result.setText(String.valueOf((long) Expression.eval(tf1.getText())));
					} catch (Exception exception) {
						result.setText(exception.getMessage());
					}
				}
			}
			if (e.getSource() == mybutton7) {
				tf1.setText(str1 + "7");
			}
			if (e.getSource() == mybutton8) {
				tf1.setText(str1 + "8");
			}
			if (e.getSource() == mybutton9) {
				tf1.setText(str1 + "9");
			}
			if (e.getSource() == mybuttonPlus) {
				tf1.setText(str1 + "+");
			}
			if (e.getSource() == mybutton4) {
				tf1.setText(str1 + "4");
			}
			if (e.getSource() == mybutton5) {
				tf1.setText(str1 + "5");
			}
			if (e.getSource() == mybutton6) {
				tf1.setText(str1 + "6");
			}
			if (e.getSource() == mybuttonMinus) {
				tf1.setText(str1 + "-");
			}
			if (e.getSource() == mybutton1) {
				tf1.setText(str1 + "1");
			}
			if (e.getSource() == mybutton2) {
				tf1.setText(str1 + "2");
			}
			if (e.getSource() == mybutton3) {
				tf1.setText(str1 + "3");
			}
			if (e.getSource() == mybuttonMultiply) {
				tf1.setText(str1 + "*");
			}
			if (e.getSource() == mybutton0) {
				tf1.setText(str1 + "0");
			}
			if (e.getSource() == mybuttonDecimal) {
				tf1.setText(str1 + ".");
			}

			///
			if (e.getSource() == mybuttonDivide) {
				tf1.setText(str1 + "/");
			}
			if (e.getSource() == mybuttonXpow) {
				tf1.setText(str1 + "^2");
			}
			if (e.getSource() == mybuttonXcube) {
				tf1.setText(str1 + "^3");
			}
			if (e.getSource() == mybuttonXtopowY) {
				tf1.setText(str1 + "^");
			}
			if (e.getSource() == mybuttonfirstb) {
				tf1.setText(str1 + "(");
			}
			if (e.getSource() == mybuttonSqr) {
				tf1.setText(str1 + "sqrt(");
			}
			if (e.getSource() == mybuttonCbr) {
				tf1.setText(str1 + "cbrt(");
			}
			if (e.getSource() == mybuttonNfac) {
				tf1.setText(str1 + "!");
			}
			if (e.getSource() == mybuttonlastb) {
				tf1.setText(str1 + ")");
			}
			if (e.getSource() == mybuttonSin) {
				tf1.setText(str1 + "sin(");
			}
			if (e.getSource() == mybuttonCos) {
				tf1.setText(str1 + "cos(");
			}
			if (e.getSource() == mybuttonTan) {
				tf1.setText(str1 + "tan(");
			}
			if (e.getSource() == mybuttonLog) {
				tf1.setText(str1 + "log(");
			}
			if (e.getSource() == mybuttonpi) {
				tf1.setText(str1 + Math.PI);
			}
			if (e.getSource() == mybuttonPercent) {
				double n1 = Double.parseDouble(str1);
				n1 = (n1 * num) / 100;
				str = String.valueOf(n1);
				tf1.setText("");
				result.setText(str);
			}
			if (e.getSource() == mybuttonMr) {
				try {
					recall = readData();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				result.setText(recall);
			}
			if (e.getSource() == mybuttonMp) {
				save = result.getText();
				try {
					saveData(save);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
	}
}