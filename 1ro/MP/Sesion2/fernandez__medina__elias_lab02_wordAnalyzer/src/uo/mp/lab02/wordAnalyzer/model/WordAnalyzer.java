package uo.mp.lab02.wordAnalyzer.model;

import uo.mp.util.check.ArgumentChecks;

/**
 * Clase que analiza palabras
 */
public class WordAnalyzer {
	
	/**
	 * La palabra a analizar
	 */
	private String word;

	/**
	 * Constructor que crea un objeto analizador con la palabra recibida
	 * 
	 * @param aWord  La palabra a ser analizada
	 */
	public WordAnalyzer(String aWord) {
		ArgumentChecks.isNotNull(aWord);
		ArgumentChecks.isNotEmpty(aWord);
		ArgumentChecks.isNotBlank(aWord, "No se permite palabra con blancos únicamente");
		word = aWord;
	}

	/**
	 * Obtiene el primer car�cter repetido. Un car�cter est� <i>repetido</i> si
	 * aparece al menos dos veces en posiciones adyacentes.
     *    Por ejemplo, 'l' est� repetida  en  "pollo", pero 'o' no est�.
	 * 
	 * @return el primer caracter repetido, o 0 si no lo encuentra
	 */
	public char firstRepeatedCharacter() {
		for (int i = 0; i < word.length()-1; i++) {
			char ch = word.charAt(i);
			if (ch == word.charAt(i + 1))
				return ch;
		}
		return 0;
	}

	/**
	 * Obtiene el primer car�cter m�ltiple que aparece. Un car�cter es
	 * <i>m�ltiple</i> si aparece al menos dos veces en la palabra, 
	 * no necesariamente en posiciones adyacentes. 
	 *    Por ejemplo, 'o' y 'l' son m�ltiples en "pollo", pero 'p' no es.
	 * 
	 * @return el primer car�cter m�ltiple repetido o 0 si no lo encuentra
	 */
	public char firstMultipleCharacter() {
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			if (find(ch, i) >= 0)
				return ch;
		}
		return 0;
	}

	/**
	 * Encuentra la posici�n de un car�cter en la palabra, 
	 * comenzando en una posici�n espec�fica.
	 *  
	 * @param c El car�cter que se quiere encontrar
	 * @param pos La posici�n de comienzo
	 * @return La posici�n del car�cter en la palabra,
	 *         � -1 si el car�cetr no est� en la palabra
	 */
	private int find(char c, int pos) {
		for (int i = pos; i < word.length(); i++) {
			if (word.charAt(i) == c) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Cuenta los grupos de caracteres repetidos. Por ejemplo, "mississippi!!!"
	 * tiene cuatro grupos: ss, ss, pp y !!!.
	 * 
	 * @return el n�mero de grupos de caracteres repetidos
	 */
	public int countGroupsOfRepeatedCharacters() {
		int count = 0;
		for (int i = 1; i < word.length() - 1; i++) {
			if (word.charAt(i) == word.charAt(i + 1)) {  // encuentra repetici�n
				if (word.charAt(i - 1) != word.charAt(i) ) 
					count++;
			}
		}
		return count;
	}
	/**
	 * Método que devuelve el valor de word
	 */
	protected String getWord() {
		return word;
	}

}