package uo_lab02_wordAnalyzer.model;





import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;


public class WordAnalyzerCountGroupsOfRepeatedCharactersTest {

	
	
		
	/**
	 * caso 1
	 * GIVEN: 	Analizador con una palabra sin grupos de caracteres repetidos,
	 *          al comienzo, en el medio y al final
	 * WHEN:	Se invoca al m�todo 
	 * THEN:	Devuelve 0
	 */
	@Test
	public void noGroupRepeatedCharacter() {
		WordAnalyzer noneRepeated = new WordAnalyzer("abcde");	
		assertEquals(0,noneRepeated.countGroupsOfRepeatedCharacters());
	}
	
	/**
	 * caso 2
	 * GIVEN: 	Analizador con una palabra con varios grupos de caracteres repetidos
	 *          al comienzo, en el medio y al final
	 * WHEN:	Se invoca al m�todo 
	 * THEN:	Devuelve el n�mero de grupos que haya
	 */
	@Test
	public void groupsAtBeginingMidleAndEnd() {
		WordAnalyzer repeated = new WordAnalyzer("aaabccdeeee");	
		assertEquals(3,repeated.countGroupsOfRepeatedCharacters());		
	}
	
	

}
