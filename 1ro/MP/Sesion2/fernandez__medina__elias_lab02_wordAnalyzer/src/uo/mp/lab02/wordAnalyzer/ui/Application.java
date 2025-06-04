package uo.mp.lab02.wordAnalyzer.ui;

import uo.mp.lab02.wordAnalyzer.model.WordAnalyzer;
import uo.mp.util.console.Console;

/**
 * Aplication que muestra diferentes operaciones con cadenas de caracteres
 */
public class Application {
	
		
	/**
	 * Pide una palabra al usuario y la analiza
	 */
	public void run() {
		System.out.print("Escribe una palabra: ");
		String word = Console.readString();
		WordAnalyzer analyzer = new WordAnalyzer(word);
		System.out.println("Primer car�cter repetido: " //repetido consecutio		
		                    + analyzer.firstRepeatedCharacter());
		System.out.println("Primer car�cter m�ltiple: "//repetido no consecutivo
		                    + analyzer.firstMultipleCharacter());
		System.out.println("Grupos de caracteres repetidos: " 		
		                    + analyzer.countGroupsOfRepeatedCharacters());			
	}

}