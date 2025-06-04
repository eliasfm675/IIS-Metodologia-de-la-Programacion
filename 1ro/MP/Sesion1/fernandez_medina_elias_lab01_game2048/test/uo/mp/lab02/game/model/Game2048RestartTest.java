package uo.mp.lab02.game.model;


import static org.junit.Assert.assertEquals;



import org.junit.Test;


import uo.mp.lab02.game.model.util.ForTesting;

public class Game2048RestartTest {

	/**
	 * Clase de pruebas del método restart(). Casos de uso: 1.-Matriz vacía
	 * 2.-Matriz parcialmente llena 3.-MAtriz llena
	 */
	/**
	 * 1.-Matriz vacía
	 */
	@Test
	public void emptyMatrixNext() {
		Game2048 gm = new Game2048();
		int counter = 0;
		int dimension = gm.getBoard().length * gm.getBoard()[0].length;
		for (int i = 0; i < gm.getBoard().length; i++) {
			for (int j = 0; j < gm.getBoard()[0].length; j++) {
				if (gm.getBoard()[i][j] == 0) {
					counter++;
				}
			}
		}
		assertEquals(counter, dimension);
	}

	/**
	 * 2.-Matriz parcialmente llena
	 */
	@Test
	public void partialMatrixNext() {
		Game2048 gm = new Game2048();
		for (int i = 0; i < 5; i++) {
			gm.next();
		}
		gm.restart();
		int counter = 0;
		int dimension = gm.getBoard().length * gm.getBoard()[0].length;
		for (int i = 0; i < gm.getBoard().length; i++) {
			for (int j = 0; j < gm.getBoard()[0].length; j++) {
				if (gm.getBoard()[i][j] == 0) {
					counter++;
				}
			}
		}
		assertEquals(counter, dimension - 1);
	}

	/**
	 * 3.-Matriz llena
	 */
	@Test
	public void fullMatrixNext() {
		Game2048 gm = new Game2048(ForTesting.FULL);
		gm.restart();
		int counter = 0;
		int dimension = gm.getBoard().length * gm.getBoard()[0].length;
		for (int i = 0; i < gm.getBoard().length; i++) {
			for (int j = 0; j < gm.getBoard()[0].length; j++) {
				if (gm.getBoard()[i][j] == 0) {
					counter++;
				}
			}
		}
		assertEquals(counter, dimension - 1);
	}
}
