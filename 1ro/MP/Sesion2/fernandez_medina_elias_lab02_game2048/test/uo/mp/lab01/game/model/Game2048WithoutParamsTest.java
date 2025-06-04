package uo.mp.lab01.game.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class Game2048WithoutParamsTest {
	/**
	 * Clase de pruebas del constructor sin parámetros
	 */
	@Test
	public void Game2048WithoutParams() {
		Game2048 gm = new Game2048();
		int[][] array = new int[Game2048.STANDARD_LENGTH][Game2048.STANDARD_LENGTH];
		assertEquals(array.length, gm.getBoard().length);
		assertEquals(array[0].length, gm.getBoard()[0].length);

	}
	
}
