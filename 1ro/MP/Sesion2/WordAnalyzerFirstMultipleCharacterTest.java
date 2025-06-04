package uo.mp.lab02.analyzer.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;



public class WordAnalyzerFirstMultipleCharacterTest {

		
	
		
	/**
	 * caso 1
	 * GIVEN: 	Analizador con una palabra sin caracteres repetidos 
	 * WHEN:	Se invoca al m�todo 
	 * THEN:	Devuelve 0
	 */
	@Test
	public void noMultipleCharacter() {			
		WordAnalyzer abcdefg = new WordAnalyzer("abcdef");
		assertEquals('\0',abcdefg.firstMultipleCharacter());
	}
		
	/**
	 * caso 2
	 * GIVEN: 	Analizador con una palabra que contiene m�ltiples caracteres repetidos 
	 *           consecutivos al principio
	 * WHEN:	Se invoca al m�todo
	 * THEN:	Devuelve el primer car�cter repetido
	 */
	@Test
	public void consecutiveMultipleCharacterAtBeginnig() {			 
		WordAnalyzer aaabcddddcbc = new WordAnalyzer("aaabcddddcbc");
		assertEquals('a',aaabcddddcbc.firstMultipleCharacter());
	}
	/**
	 * caso 3
	 * GIVEN: 	Analizador con una palabra que contiene m�ltiples caracteres repetidos 
	 *           consecutivos en el medio 
	 * WHEN:	Se invoca al m�todo 
	 * THEN:	Devuelve el primer car�cter repetido
	 */
	@Test
	public void consecutiveMultipleCharacterAtMidle() {
		WordAnalyzer abcccdddef = new WordAnalyzer("abcccdddef");
		assertEquals('c',abcccdddef.firstMultipleCharacter());
	}
	
	/**
	 * caso 4
	 * GIVEN: 	Analizador con una palabra que contiene m�ltiples caracteres repetidos 
	 *           consecutivos en el final
	 * WHEN:	Se invoca al m�todo 
	 * THEN:	Devuelve el primer car�cter repetido
	 */
	@Test
	public void consecutiveMultipleCharacterAtEnd() {			
		WordAnalyzer abcdefff = new WordAnalyzer("abcdefff");
		assertEquals('f',abcdefff.firstMultipleCharacter());
    }
	/**
	 * caso 5
	 * GIVEN: 	Analizador con una palabra que contiene m�ltiples caracteres repetidos 
	 *          y no solo al final          
	 * WHEN:	Se invoca al m�todo 
	 * THEN:	Devuelve el primer car�cter repetido
	 */
	@Test
	public void noConsecutiveMultipleCharacter() {			
		WordAnalyzer abcdefff = new WordAnalyzer("abcadefff");
		assertEquals('a',abcdefff.firstMultipleCharacter());
    }
	
}
