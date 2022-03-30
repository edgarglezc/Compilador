import lexer.*;
import token.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Compilador {

	public static void main(String[] args) throws IOException {
		System.out.println("Analizador Léxico (CTRL + C para salir)");
		
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(System.in)
		);
		
		System.out.println("Ingresa comandos: ");
		String input = reader.readLine();
		
		Lexer lexer = new Lexer(input);
		Token token = lexer.nextToken();
		while(true) {
			System.out.println(token);
			if(token.getToken() == token.EOF) {
				break;
			}
			token = lexer.nextToken();
		}
		System.out.println("Hasta pronto.");
	}

}
