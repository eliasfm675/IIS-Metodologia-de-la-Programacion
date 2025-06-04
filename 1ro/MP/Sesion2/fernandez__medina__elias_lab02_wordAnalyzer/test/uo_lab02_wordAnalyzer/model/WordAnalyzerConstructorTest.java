package uo_lab02_wordAnalyzer.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class WordAnalyzerConstructorTest {
	/**
	 * Casos de prueba del constructor que recibe la palabra como parámetro
	 * 1.- Recibe cualquiera.
	 * 2.- Recibe una palabra con únicamente blancos --> salta excepción.
	 * 3.- Recibe una palabra que es null --> salta excepción.
	 * 4.- Recibe palabra vacía --> salta excepción
	 */
	/**
	 * GIVEN una palabra cualquiera 
	 * WHEN se intenta crear un analizador con esa palabra
	 * THEN se crea el analizador y dentro contiene la palabra.
	 */
	@Test
	void AnyWord() {
		String word = "abcdefgh";
		WordAnalyzer analyzer = new WordAnalyzer(word);
		assertEquals(word, analyzer.getWord());
	}

}
