
import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.lang.Math.*;

public class Calculator extends JFrame implements ActionListener {

	// Fields
	JPanel mypanel;

	JButton mybutton0, mybuttonDecimal, mybuttonPlus, mybuttonpi;

	JButton mybuttonNfac, mybutton1, mybutton2, mybutton3, mybuttonMinus;

	JButton mybuttonXpow, mybutton4, mybutton5, mybutton6, mybuttonMultiply;

	JButton mybuttonXcube, mybutton7, mybutton8, mybutton9, mybuttonDivide;

	JButton mybuttonXtopowY, mybuttonPercent, mybuttonfirstb, mybuttonlastb, mybuttonLog;

	JButton mybuttonSin, mybuttonCos, mybuttonTan, mybuttonSqr, mybuttonCbr;

	JButton mybuttonEqual, mybuttonClear, mybuttonBackSpace;
	JButton mybuttonMc, mybuttonMr, mybuttonMm, mybuttonMp;
	/** * * * ** * * *
	 * MC = Memory Clear sets the memory to 0
	 * MR = Memory Recall uses the number in memory, acts as if you had keyed in that number yourself
	 * MM = Delete Memory Stored number from the memory
	 * M+ = Adds numbers to the memory, and puts the result into memory
	 * * * ** * * */
	
	JRadioButton myRadioButtonOn, myRadioButtonOff;

	JTextField mytext1, mytext2;

	Font font = new Font("Serif", Font.BOLD, 20);

	// int count = 0;

	double num = 0.0, result = 0.0, m1;
	double temp, temp1, a;
	int k=1;
	boolean firstEntry = true, firstOperation = true, plus = false, minus = false, multiply = false, divide = false,
			firstperiod = false;
	String lastOperation = "", str;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	// constructor
	public Calculator() {
		mypanel = new JPanel();
		mypanel.setLayout(null);

		// -------------------------------------

		mybuttonNfac = new JButton("n!");
		mybuttonNfac.setBounds(15, 490, 70, 50);

		mybutton0 = new JButton("0");
		mybutton0.setBounds(85, 490, 140, 50);

		mybuttonDecimal = new JButton(".");
		mybuttonDecimal.setBounds(225, 490, 70, 50);

		mybuttonPlus = new JButton("+");
		mybuttonPlus.setBounds(295, 440, 70, 100);
		mybuttonPlus.setForeground(Color.decode("0x0000FF"));

		// -------------------------------------

		mybuttonXpow = new JButton("x²");
		mybuttonXpow.setBounds(15, 440, 70, 50);

		mybutton1 = new JButton("1");
		mybutton1.setBounds(85, 440, 70, 50);

		mybutton2 = new JButton("2");
		mybutton2.setBounds(155, 440, 70, 50);

		mybutton3 = new JButton("3");
		mybutton3.setBounds(225, 440,70, 50);

		mybuttonMinus = new JButton("-");
		mybuttonMinus.setBounds(295, 390, 70, 50);
		mybuttonMinus.setForeground(Color.decode("0x0000FF"));

		// -------------------------------------

		mybuttonXcube = new JButton("x³");
		mybuttonXcube.setBounds(15, 390,70, 50);

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

		mybuttonLog = new JButton("Log");
		mybuttonLog.setBounds(15, 290, 70, 50);

		mybuttonPercent = new JButton("%");
		mybuttonPercent.setBounds(85, 290, 70, 50);

		mybuttonfirstb = new JButton("(");
		mybuttonfirstb.setBounds(155, 290, 70, 50);

		mybuttonlastb = new JButton(")");
		mybuttonlastb.setBounds(225, 290, 70, 50);

		mybuttonpi = new JButton("π");
		mybuttonpi.setBounds(295, 240, 70, 50);

		// -------------------------------------

		mybuttonSin = new JButton("sin");
		mybuttonSin.setBounds(15, 240, 70, 50);

		mybuttonCos = new JButton("cos");
		mybuttonCos.setBounds(85, 240, 70, 50);

		mybuttonTan = new JButton("tan");
		mybuttonTan.setBounds(155, 240, 70, 50);

		mybuttonSqr = new JButton("\u221a");//sqr root
		mybuttonSqr.setBounds(225, 240, 70, 50);

		mybuttonCbr = new JButton("∛");
		mybuttonCbr.setBounds(155, 190, 70, 50);
		
		// -------------------------------------
		mybuttonBackSpace = new JButton("\u232b");
		mybuttonBackSpace.setBounds(225, 190, 70, 50);
		mybuttonBackSpace.setForeground(Color.decode("0xFF0000"));
		
		mybuttonClear = new JButton("C");
		mybuttonClear.setBounds(295, 190, 70, 50);
		mybuttonClear.setForeground(Color.decode("0xFF0000"));
		mybuttonEqual = new JButton("=");
		mybuttonEqual.setBounds(155, 140, 210, 50);

		
		mybuttonMc = new JButton("MC");
		mybuttonMc.setBounds(15, 140, 70, 50);

		mybuttonMr = new JButton("MR");
		mybuttonMr.setBounds(85, 140, 70, 50);

		mybuttonMp = new JButton("M+");
		mybuttonMp.setBounds(15, 190, 70, 50);

		mybuttonMm = new JButton("M-");
		mybuttonMm.setBounds(85, 190, 70, 50);
		
		myRadioButtonOn = new JRadioButton("ON", true);
		buttonGroup.add(myRadioButtonOn);
		myRadioButtonOn.setBounds(15, 100, 50, 30);

		myRadioButtonOff = new JRadioButton("OFF");
		buttonGroup.add(myRadioButtonOff);
		myRadioButtonOff.setBounds(100, 100, 50, 30);

		mytext1 = new JTextField(40);
		mytext1.setText("0.0");
		mytext1.setBounds(15, 15, 350, 40);
		mytext1.setEditable(false);
		mytext1.setFont(font);
		mytext1.setBackground(Color.decode("0x457EAC"));
		mytext2 = new JTextField(20);
		mytext2.setText("");
		mytext2.setBounds(15, 55, 350, 40);
		mytext2.setEditable(false);
		mytext2.setFont(font);
		mytext2.setBackground(Color.decode("0x9191E9"));

		// -------------------------------------

		// -------------------------------------

		add(mypanel);

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
		mypanel.add(mybuttonMc);
		mypanel.add(mybuttonMr);
		mypanel.add(mybuttonMp);
		mypanel.add(mybuttonMm);
		
		mypanel.add(myRadioButtonOff);
		mypanel.add(myRadioButtonOn);

		mypanel.add(mytext1);
		mypanel.add(mytext2);

		mybutton1.addActionListener(this);
		mybutton2.addActionListener(this);
		mybutton3.addActionListener(this);
		mybutton4.addActionListener(this);
		mybutton5.addActionListener(this);
		mybutton6.addActionListener(this);
		mybutton7.addActionListener(this);
		mybutton8.addActionListener(this);
		mybutton9.addActionListener(this);
		mybutton0.addActionListener(this);

		mybuttonNfac.addActionListener(this);
		mybuttonXpow.addActionListener(this);
		mybuttonXcube.addActionListener(this);
		mybuttonXtopowY.addActionListener(this);
		mybuttonPercent.addActionListener(this);
		mybuttonfirstb.addActionListener(this);
		mybuttonlastb.addActionListener(this);
		mybuttonpi.addActionListener(this);
		mybuttonLog.addActionListener(this);
		mybuttonDecimal.addActionListener(this);

		mybuttonSin.addActionListener(this);
		mybuttonCos.addActionListener(this);
		mybuttonTan.addActionListener(this);
		mybuttonSqr.addActionListener(this);
		mybuttonCbr.addActionListener(this);

		mybuttonPlus.addActionListener(this);
		mybuttonMinus.addActionListener(this);
		mybuttonMultiply.addActionListener(this);
		mybuttonDivide.addActionListener(this);

		mybuttonEqual.addActionListener(this);
		mybuttonClear.addActionListener(this);
		mybuttonBackSpace.addActionListener(this);

		mybuttonMc.addActionListener(this);
		mybuttonMr.addActionListener(this);
		mybuttonMp.addActionListener(this);
		mybuttonMm.addActionListener(this);
		
		
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
				
				mybuttonMc.setEnabled(false);
				mybuttonMr.setEnabled(false);
				mybuttonMp.setEnabled(false);
				mybuttonMm.setEnabled(false);
				
				
				if (e.getSource() == myRadioButtonOff) {
					mytext1.setText(null);
					mytext2.setText(null);
					mytext1.setEnabled(false);
					mytext2.setEnabled(false);
				}
			}
		});

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
				

				mybuttonMc.setEnabled(true);
				mybuttonMr.setEnabled(true);
				mybuttonMp.setEnabled(true);
				mybuttonMm.setEnabled(true);
				if (e.getSource() == myRadioButtonOn) {
					mytext1.setText("0.0");
					mytext2.setText(null);
					mytext1.setEnabled(true);
					mytext2.setEnabled(true);
				}

			}
		});

	}

	// methods
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame Calculator = new Calculator();

		Calculator.setTitle("Calculator");
		Calculator.setSize(400, 590);
		Calculator.setLocation(500, 10);
		Calculator.setVisible(true);
		Calculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mybutton0) {
			if (firstEntry == true) {
				mytext1.setText("0");
				firstEntry = false;
			} else
				mytext1.setText(mytext1.getText() + "0");
		} else if (e.getSource() == mybutton1) {
			if (firstEntry == true) {
				mytext1.setText("1");
				firstEntry = false;
			} else
				mytext1.setText(mytext1.getText() + "1");
		} else if (e.getSource() == mybutton2) {
			if (firstEntry == true) {
				mytext1.setText("2");
				firstEntry = false;
			} else
				mytext1.setText(mytext1.getText() + "2");
		} else if (e.getSource() == mybutton3) {
			if (firstEntry == true) {
				mytext1.setText("3");
				firstEntry = false;
			} else
				mytext1.setText(mytext1.getText() + "3");
		} else if (e.getSource() == mybutton4) {
			if (firstEntry == true) {
				mytext1.setText("4");
				firstEntry = false;
			} else
				mytext1.setText(mytext1.getText() + "4");
		} else if (e.getSource() == mybutton5) {
			if (firstEntry == true) {
				mytext1.setText("5");
				firstEntry = false;
			} else
				mytext1.setText(mytext1.getText() + "5");
		} else if (e.getSource() == mybutton6) {
			if (firstEntry == true) {
				mytext1.setText("6");
				firstEntry = false;
			} else
				mytext1.setText(mytext1.getText() + "6");
		} else if (e.getSource() == mybutton7) {
			if (firstEntry == true) {
				mytext1.setText("7");
				firstEntry = false;
			} else
				mytext1.setText(mytext1.getText() + "7");
		} else if (e.getSource() == mybutton8) {
			if (firstEntry == true) {
				mytext1.setText("8");
				firstEntry = false;
			} else
				mytext1.setText(mytext1.getText() + "8");
		} else if (e.getSource() == mybutton9) {
			if (firstEntry == true) {
				mytext1.setText("9");
				firstEntry = false;
			} else
				mytext1.setText(mytext1.getText() + "9");
		}
		//////////////////////////////////////////////////

		else if (e.getSource() == mybuttonDecimal) {
			if (firstperiod != true) {
				mytext1.setText(mytext1.getText() + ".");
				firstperiod = true;
			}
		}

		//////////////////////////////////////////////////
		// Arithmetic Operations

		else if (e.getSource() == mybuttonPlus) {
			if (lastOperation.equalsIgnoreCase("+")) {
				num = num + Double.parseDouble(mytext1.getText());
				mytext2.setText(String.valueOf(num));
				mytext1.setText("");
				lastOperation = "+";
				firstperiod = false;
			} else if (lastOperation.equalsIgnoreCase("-")) {
				num = num - Double.parseDouble(mytext1.getText());
				mytext2.setText(String.valueOf(num));
				mytext1.setText("");
				lastOperation = "+";
				firstperiod = false;
			} else if (lastOperation.equalsIgnoreCase("*")) {
				num = num * Double.parseDouble(mytext1.getText());
				mytext2.setText(String.valueOf(num));
				mytext1.setText("");
				lastOperation = "+";
				firstperiod = false;
			} else if (lastOperation.equalsIgnoreCase("/")) {
				num = num / Double.parseDouble(mytext1.getText());
				mytext2.setText(String.valueOf(num));
				mytext1.setText("");
				lastOperation = "+";
				firstperiod = false;
			} else {
				num = Double.parseDouble(mytext1.getText());
				mytext1.setText("");
				lastOperation = "+";
				firstperiod = false;
			}
		} else if (e.getSource() == mybuttonMinus) {
			if (lastOperation.equalsIgnoreCase("+")) {
				num = num + Double.parseDouble(mytext1.getText());
				mytext2.setText(String.valueOf(num));
				mytext1.setText("");
				lastOperation = "-";
				firstperiod = false;
			} else if (lastOperation.equalsIgnoreCase("-")) {
				num = num - Double.parseDouble(mytext1.getText());
				mytext2.setText(String.valueOf(num));
				mytext1.setText("");
				lastOperation = "-";
				firstperiod = false;
			} else if (lastOperation.equalsIgnoreCase("*")) {
				num = num * Double.parseDouble(mytext1.getText());
				mytext2.setText(String.valueOf(num));
				mytext1.setText("");
				lastOperation = "-";
				firstperiod = false;
			} else if (lastOperation.equalsIgnoreCase("/")) {
				num = num / Double.parseDouble(mytext1.getText());
				mytext2.setText(String.valueOf(num));
				mytext1.setText("");
				lastOperation = "-";
				firstperiod = false;
			} else {
				num = Double.parseDouble(mytext1.getText());
				mytext1.setText("");
				lastOperation = "-";
				firstperiod = false;
			}
		} else if (e.getSource() == mybuttonMultiply) {
			if (lastOperation.equalsIgnoreCase("+")) {
				num = num + Double.parseDouble(mytext1.getText());
				mytext2.setText(String.valueOf(num));
				mytext1.setText("");
				lastOperation = "*";
				firstperiod = false;
			} else if (lastOperation.equalsIgnoreCase("-")) {
				num = num - Double.parseDouble(mytext1.getText());
				mytext2.setText(String.valueOf(num));
				mytext1.setText("");
				lastOperation = "*";
				firstperiod = false;
			} else if (lastOperation.equalsIgnoreCase("*")) {
				num = num * Double.parseDouble(mytext1.getText());
				mytext2.setText(String.valueOf(num));
				mytext1.setText("");
				lastOperation = "*";
				firstperiod = false;
			} else if (lastOperation.equalsIgnoreCase("/")) {
				num = num / Double.parseDouble(mytext1.getText());
				mytext2.setText(String.valueOf(num));
				mytext1.setText("");
				lastOperation = "*";
				firstperiod = false;
			} else {
				num = Double.parseDouble(mytext1.getText());
				mytext1.setText("");
				lastOperation = "*";
				firstperiod = false;
			}
		} else if (e.getSource() == mybuttonDivide) {
			if (lastOperation.equalsIgnoreCase("+")) {
				num = num + Double.parseDouble(mytext1.getText());
				mytext2.setText(String.valueOf(num));
				mytext1.setText("");
				lastOperation = "/";
				firstperiod = false;
			} else if (lastOperation.equalsIgnoreCase("-")) {
				num = num - Double.parseDouble(mytext1.getText());
				mytext2.setText(String.valueOf(num));
				mytext1.setText("");
				lastOperation = "/";
				firstperiod = false;
			} else if (lastOperation.equalsIgnoreCase("*")) {
				num = num * Double.parseDouble(mytext1.getText());
				mytext2.setText(String.valueOf(num));
				mytext1.setText("");
				lastOperation = "/";
				firstperiod = false;
			} else if (lastOperation.equalsIgnoreCase("/")) {
				num = num / Double.parseDouble(mytext1.getText());
				mytext2.setText(String.valueOf(num));
				mytext1.setText("");
				lastOperation = "/";
				firstperiod = false;
			} else {
				num = Double.parseDouble(mytext1.getText());
				mytext1.setText("");
				lastOperation = "/";
				firstperiod = false;
			}
		}

		//////////////////////////////////////////////////
		// Trigonometric, Power and logs Operations

		else if (e.getSource() == mybuttonpi) {
			if (mytext1.getText().equals("")) {
				mytext1.setText("");
			} else {
				a = Math.PI * (Double.parseDouble(mytext1.getText()));
				mytext1.setText("");
				mytext2.setText(mytext2.getText() + a);
			}
		} else if (e.getSource() == mybuttonSqr) {
			if (mytext1.getText().equals("")) {
				mytext1.setText("");
			} else {
				a = Math.sqrt(Double.parseDouble(mytext1.getText()));
				mytext1.setText("");
				mytext2.setText(mytext2.getText() + a);
			}
		} else if (e.getSource() == mybuttonCbr) {
			if (mytext1.getText().equals("")) {
				mytext1.setText("");
			} else {
				a = Math.cbrt(Double.parseDouble(mytext1.getText()));
				mytext1.setText("");
				mytext2.setText(mytext2.getText() + a);
			}
		} else if (e.getSource() == mybuttonSin) {
			if (mytext1.getText().equals("")) {
				mytext1.setText("");
			} else {
				a = Math.sin(Double.parseDouble(mytext1.getText()));
				mytext1.setText("");
				mytext2.setText(mytext2.getText() + a);
			}
		} else if (e.getSource() == mybuttonCos) {
			if (mytext1.getText().equals("")) {
				mytext1.setText("");
			} else {
				a = Math.cos(Double.parseDouble(mytext1.getText()));
				mytext1.setText("");
				mytext2.setText(mytext2.getText() + a);
			}
		} else if (e.getSource() == mybuttonTan) {
			if (mytext1.getText().equals("")) {
				mytext1.setText("");
			} else {
				a = Math.tan(Double.parseDouble(mytext1.getText()));
				mytext1.setText("");
				mytext2.setText(mytext2.getText() + a);
			}
		} else if (e.getSource() == mybuttonLog) {
			if (mytext1.getText().equals("")) {
				mytext1.setText("");
			} else {
				a = Math.log(Double.parseDouble(mytext1.getText()));
				mytext1.setText("");
				mytext2.setText(mytext2.getText() + a);
			}
		} else if (e.getSource() == mybuttonPercent) {
			double n1 = Double.parseDouble(mytext1.getText());
			n1 = (n1 * num) / 100;
			str = String.valueOf(n1);
			mytext1.setText("");
			mytext2.setText(str);
		} else if (e.getSource() == mybuttonXpow) {
			if (mytext1.getText().equals("")) {
				mytext1.setText("");
			} else {
				a = Math.pow(Double.parseDouble(mytext1.getText()), 2);
				mytext1.setText("");
				mytext2.setText(mytext2.getText() + a);
			}
		} else if (e.getSource() == mybuttonXcube) {
			if (mytext1.getText().equals("")) {
				mytext1.setText("");
			} else {
				a = Math.pow(Double.parseDouble(mytext1.getText()), 3);
				mytext1.setText("");
				mytext2.setText(mytext2.getText() + a);
			}
		}
		if (e.getSource() == mybuttonNfac) {
			if (mytext1.getText().equals("")) {
				mytext1.setText("");
			} else {
				a = (Double.parseDouble(mytext1.getText()));
				double f = 1;
				while (a != 0) {
					f = f * a;
					a--;
				}
				mytext1.setText("");
				mytext2.setText(mytext2.getText() + f);
			}
		}

		else if (e.getSource() == mybuttonEqual) {
			if (lastOperation.equals("+"))
				mytext2.setText(String.valueOf(num + Double.parseDouble(mytext1.getText())));
			else if (lastOperation.equals("-"))
				mytext2.setText(String.valueOf(num - Double.parseDouble(mytext1.getText())));
			else if (lastOperation.equals("*"))
				mytext2.setText(String.valueOf(num * Double.parseDouble(mytext1.getText())));
			else if (lastOperation.equals("/"))
				mytext2.setText(String.valueOf(num / Double.parseDouble(mytext1.getText())));
			firstEntry = true;
			firstperiod = false;
			// lastOperation = "";
			// firstOperation = true;
			result = 0;
		} 
		
		/////////////////

		else if (e.getSource() == mybuttonMc) {
			m1 = 0;
			mytext2.setText("");
		}
		else if (e.getSource() == mybuttonMr) {
			mytext1.setText("");
			mytext2.setText(mytext1.getText() + m1);
		}
		if (e.getSource() == mybuttonMp) {
			if (k == 1) {
				m1 = Double.parseDouble(mytext2.getText());
				k++;
			} else {
				m1 += Double.parseDouble(mytext2.getText());
				mytext2.setText("" + m1);
			}
		}
		if (e.getSource() == mybuttonMm) {
			if (k == 1) {
				m1 = Double.parseDouble(mytext2.getText());
				k++;
			} else {
				m1 -= Double.parseDouble(mytext2.getText());
				mytext2.setText("" + m1);
			}
		}
		
		/////////////////
		  else if(e.getSource()==mybuttonBackSpace)
	      {
	          int len;
	          str=mytext1.getText();
	          len=str.length();
	          if(len>=1)
	            str=str.substring(0,len-1);
	          mytext1.setText(str);
	      }
		else if (e.getSource() == mybuttonClear) {
			mytext1.setText("0.0");
			mytext2.setText(null);
			firstEntry = true;
			firstperiod = false;
			firstOperation = true;
			plus = false;
			minus = false;
			multiply = false;
			divide = false;
			// lastOperation = "";
			// firstOperation = true;
			result = 0;
			num = 0.0;
		}
	}

}