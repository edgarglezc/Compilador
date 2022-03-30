package lexer;

import token.Token;

public class Lexer {
	/* ATRIBUTOS */
	
	// El input de entrada para el Lexer
	private String input;
	
	
	// La posición actual que estamos leyendo en el input
	private int position;
	
	
	// La próxima posición a leer en el input
	// (una posición después que 'position')
	private int readPosition;
	
	
	// El caracter actual que está en examinación
	private Character ch;
	
	/* MÉTODOS */
	
	// Constructor de la clase Lexer
	// Recibe el input de entrada y lo guarda 
	// en el atributo input de la clase
	public Lexer(final String input) {
		this.input = input;
		this.readChar();
	}
	
	
	// Primero evalúa si la posición de lectura está en el rango del input
	// Si ya está fuera de rango: asigna 0 que es NUL en ASCII
	// Sino: asigna a 'ch' el caracter que se encuentra en la posición readPosition
	// Después asigna readPosition a position y aumenta readPosition en 1
	private void readChar() {
		if(this.readPosition >= this.input.length()) {
			this.ch = 0;
		} else {
			this.ch = this.input.charAt(this.readPosition);
		}
		this.position = this.readPosition;
		this.readPosition++;
	}
	
	
	public void testNextToken() {
		String input = """
				let five = 5;
				let ten = 10;
				
				let add = fn(x, y) {
					x + y;
				};
				
				let result = add(five, ten);
				!-/*5;
				5 < 10 > 5;
				
				if(5 < 10) {
					return true;
				} else {
					return false;
				}
				
				10 == 10;
				10 != 9;
		""";

				
				
	}
	
	
	public Token nextToken() {
		Token tk = null;
		
		this.skipWhiteSpace();
		
		switch(this.ch) {		
		case '=':
			tk =  new Token(Token.ASSIGN, this.ch);
		case ';':
			tk = new Token(Token.SEMICOLON, this.ch);
		case '(':
			tk = new Token(Token.LPAREN, this.ch);
		case ')':
			tk = new Token(Token.RPAREN, this.ch);
		case ',':
			tk = new Token(Token.COMMA, this.ch);
		case '+':
			tk = new Token(Token.PLUS, this.ch);
		case '{':
			tk = new Token(Token.LBRACE, this.ch);
		case '}':
			tk = new Token(Token.RBRACE, this.ch);
		case 0:
			tk = new Token(Token.EOF, ' '); // <- DUDAS AQUI
		default:
			if(this.isLetter(this.ch)) {
				tk.setLiteral(this.readIdentifier());
				tk.setToken(tk.lookUpIdent(tk.getLiteral()));
				return tk;
			} else {
				tk = new Token(Token.ILLEGAL, this.ch);
			}
		}
		
		this.readChar();
		
		return tk;
	}
	
	
	private String readNumber() {
		int pos = this.position;
		while(this.isDigit(this.ch)) {
			this.readChar();
		}
		return this.input.substring(pos, this.position);
	}
	
	
	private boolean isDigit(Character ch) {
		return '0' <= ch && ch <= '9';
	}
	
	
	private String readIdentifier() {
		int position = this.position;
		while(this.isLetter(this.ch)) {
			this.readChar();
		}
		return this.input.substring(position, this.position);
	}
	
	
	private boolean isLetter(final Character ch) {
		return 'a' <= ch && ch <= 'z' || 'A' <= ch && ch <= 'Z' || ch == '_'; 
	}
	
	private void skipWhiteSpace() {
		while(this.ch == ' ' || this.ch == '\t' || this.ch == '\n' || this.ch == '\r') {
			this.readChar();
		}
	}
	
	private Character peekChar() {
		if(this.readPosition >= this.input.length()) {
			return 0;
		} else {
			return this.input.charAt(this.readPosition);
		}
	}
}
