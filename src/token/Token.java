package token;

import java.util.Hashtable;

/* 
 * Type será utilizado para identificar a los tipos de Token.
 * Debido a la falta de 'typedef' en Java, utilizamos el tipo
 * de dato String de manera directa.
 * 
 * Lo normal hubiera sido definir un tipo de dato llamado TokenType
 * que en esencia es un String, pero para mayor legibilidad y 
 * entendimiento del código, nos convendría poder escribirlo como
 * TokenType.
 * 
 * Literal es el caracter o caracteres que estamos
 * analizando en cuestión.
 * */

public class Token {
	private String Type; 
	private String Literal;
	
	private Hashtable<String, String> keywords = new Hashtable<>();
	
	public Token() {
		keywords.put("fn", FUNCTION);
		keywords.put("let", LET);
		keywords.put("true", TRUE);
		keywords.put("false", FALSE);
		keywords.put("if", IF);
		keywords.put("else", ELSE);
		keywords.put("switch", SWITCH);
		keywords.put("case", CASE);
		keywords.put("default", DEFAULT);
		keywords.put("for", FOR);
		keywords.put("while", WHILE);
		keywords.put("null", NULL);
		keywords.put("println", PRINTLN);
		keywords.put("readln", READLN);
		keywords.put("return", RETURN);
	}
	
	public Token(String tokenType, Character ch) {
		this.Type = tokenType;
		this.Literal = ch.toString();
	}
	
	public void setToken(final String tokenType) {
		this.Type = tokenType;		
	}
	
	public String getToken() {
		return this.Type;
	}
	
	public void setLiteral(final Character ch) {
		this.Literal = ch.toString();
	}
	
	public void setLiteral(final String str) {
		this.Literal = str;
	}
	
	public String getLiteral() {
		return this.Literal;
	}
	
	public String lookUpIdent(final String ident) {
		return (keywords.get(ident) == NULL) ? this.IDENT : keywords.get(ident);
	}
	
	// Estados
	public static final String ILLEGAL = "ILLEGAL";
	public static final String EOF = "EOF";
	
	// Identificadores y Literales
	public static final String IDENT = "IDENTIFIER";
	public static final String INT = "INT";
	public static final String FLOAT = "FLOAT";
	public static final String STRING = "STRING";
	
	// Operadores de asignación
	public static final String ASSIGN = "=";
	public static final String PLUS_EQUALS = "+=";
	public static final String MINUS_EQUALS = "-=";
	public static final String ASTERISK_EQUALS = "*=";
	public static final String SLASH_EQUALS = "/=";
	public static final String MOD_EQUALS = "%=";
	
	// Operadores aritméticos
	public static final String PLUS = "+";
	public static final String PLUS_PLUS = "++";
	public static final String MINUS = "-";
	public static final String MINUS_MINUS = "--";
	public static final String ASTERISK = "*";
	public static final String SLASH = "/";
	public static final String MOD = "%";
	
	// Operadores relacionales
	public static final String EQ = "==";
	public static final String NOT_EQ = "!=";
	public static final String LT = "<";
	public static final String LT_EQUALS = "<=";
	public static final String GT = ">";
	public static final String GT_EQUALS = ">=";
	
	// Operadores a nivel bit
	public static final String BITWISE_AND = "&";
	public static final String BITWISE_OR = "|";
	public static final String BITWISE_XOR = "^";
	
	// Delimitadores
	public static final String COMMA = ",";
	public static final String SEMICOLON = ";";
	public static final String COLON = ":";
	public static final String LPAREN = "(";
	public static final String RPAREN = ")";
	public static final String LBRACE = "{";
	public static final String RBRACE = "}";
	public static final String LBRACKET = "[";
	public static final String RBRACKET = "]";
	
	// Palabras clave
	public static final String FUNCTION = "FUNCTION";
	public static final String LET = "LET";
	public static final String TRUE = "TRUE";
	public static final String FALSE = "FALSE";
	public static final String IF = "IF";
	public static final String ELSE = "ELSE";
	public static final String SWITCH = "SWITCH";
	public static final String CASE = "CASE";
	public static final String DEFAULT = "DEFAULT";
	public static final String FOR = "FOR";
	public static final String WHILE = "WHILE";
	public static final String PRINTLN = "PRINTLN";
	public static final String READLN = "READLN";
	public static final String NULL = "NULL";
	public static final String RETURN = "RETURN";
}
