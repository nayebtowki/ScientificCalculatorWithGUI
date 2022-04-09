
public class Expression {
	public static double eval(final String str) {
		return new Object() {
			int pos = -1, ch;
			void nextChar() {
				ch = (++pos < str.length()) ? str.charAt(pos) : -1;
			}

			boolean eat(int charToEat) {
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
				if (pos < str.length())
					throw new RuntimeException("Unexpected: " + (char) ch);
				return x;
			}

			double parseExpression() {
				double x = parseTerm();
				for (;;) {
					if (eat('+'))
						x += parseTerm();
					else if (eat('-'))
						x -= parseTerm();
					else
						return x;
				}
			}
			double parseTerm() {
				double x = parseFactor();
				for (;;) {
					if (eat('*'))
						x *= parseFactor();
					else if (eat('/'))
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
				if (eat('+'))
					return parseFactor();
				if (eat('-'))
					return -parseFactor();
				double x;
				int startPos = this.pos;
				if (eat('(')) {
					x = parseExpression();
					eat(')');
				} else if ((ch >= '0' && ch <= '9') || ch == '.') {
					while ((ch >= '0' && ch <= '9') || ch == '.')
						nextChar();
					x = Double.parseDouble(str.substring(startPos, this.pos));
				} else if (ch >= 'a' && ch <= 'z') {
					while (ch >= 'a' && ch <= 'z')
						nextChar();
					String func = str.substring(startPos, this.pos);
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
				if (eat('^'))
					x = Math.pow(x, parseFactor());
				return x;
			}
		}.parse();
	}
}