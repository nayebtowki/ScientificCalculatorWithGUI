
public class Expression {
	//The LL(1) top-down parsing algorithm
	public static double eval(final String str) {
		return new Object() {
			int possition = -1, ch;
			//Identifier of the equation
			void nextChar() {
				ch = (++possition < str.length()) ? str.charAt(possition) : -1;
			}
			boolean clear(int charToEat) {
				while (ch == ' ')
					nextChar();
				if (ch == charToEat) {
					nextChar();
					return true;
				}
				return false;
			}
			double parse() {
				nextChar();
				double x = parseExpression();
				if (possition < str.length())
					throw new RuntimeException("Unexpected: " + (char) ch);
				return x;
			}
			//Prefix operators
			double parseExpression() {
				double x = parseTerm();
				for (;;) {
					if (clear('+'))
						x += parseTerm();
					else if (clear('-'))
						x -= parseTerm();
					else
						return x;
				}
			}			
			//Infix operators
			double parseTerm() {
				double x = parseFactor();
				for (;;) {
					if (clear('*'))
						x *= parseFactor();
					else if (clear('/'))
						x /= parseFactor();
					else
						return x;
				}
			}
			
			private double factorial(double x) {
				double fact=1;
				if(x==0 || x==1) {
					fact=1;
				}else {
					for(int i=2; i<=x; i++) {
						fact*=i;
					}
				}
				return fact;
			}
			double parseFactor() {
				if (clear('+'))
					return parseFactor();
				if (clear('-'))
					return -parseFactor();
				double x;
				int startPos = this.possition;
				//checking parens
				if (clear('(')) {
					x = parseExpression();
					clear(')');
				} else if ((ch >= '0' && ch <= '9') || ch == '.') {
					while ((ch >= '0' && ch <= '9') || ch == '.')
						nextChar();
					x = Double.parseDouble(str.substring(startPos, this.possition));
				} else if (ch >= 'a' && ch <= 'z') {
					while (ch >= 'a' && ch <= 'z')
						nextChar();
					String func = str.substring(startPos, this.possition);
					x = parseFactor();
					switch (func) {
					case "sqrt":
						x = Math.sqrt(x);
						break;
					case "sin":
						x = Math.sin(Math.toRadians(x));
						break;
					case "cos":
						x = Math.cos(Math.toRadians(x));
						break;
					case "tan":
						x = Math.tan(Math.toRadians(x));
						break;
					case "log":
						x = Math.log10(x);
						break;
					case "cbrt":
						x = Math.cbrt(x);
						break;
					case "!":
						x = factorial(x);
						break;
					default:
						throw new RuntimeException("Unknown function: " + func);
					}
				} else {
					throw new RuntimeException("Unexpected: " + (char) ch);
				}
				if (clear('^'))
					x = Math.pow(x, parseFactor());
				return x;
			}
		}.parse();
	}
}