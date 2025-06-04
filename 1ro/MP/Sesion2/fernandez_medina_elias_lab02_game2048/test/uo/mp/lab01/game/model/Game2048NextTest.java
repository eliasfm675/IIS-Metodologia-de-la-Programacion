package uo.mp.lab01.game.model;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

import org.junit.Test;

import uo.mp.lab01.game.model.util.ForTesting;

public class Game2048NextTest {
/**
 * Clase de pruebas del método next(). Casos de uso:
 * 1.-Matriz vacía
 * 2.-Matriz parcialmente llena
 * 3.-MAtriz llena
 */
/**
 * 1.-Matriz vacía
 */
	@Test
	public void emptyMatrixNext() {
		Game2048 gm = new Game2048();
		gm.next();
		int counter=0;
		for(int i=0; i<gm.getBoard().length; i++) {
			for(int j=0; j<gm.getBoard()[0].length; j++) {
				if(gm.getBoard()[i][j]!=0) {
					counter++;
				}
			}
		}
		assertEquals(counter, 1);
	}

/**
 * 2.-Matriz parcialmente llena
 */
	@Test
	public void partialMatrixNext() {
		Game2048 gm = new Game2048();
		for(int i=0; i<5; i++) {
			gm.next();
		}
		int counter=0;
		int dimension= gm.getBoard().length * gm.getBoard()[0].length;
		for(int i=0; i<gm.getBoard().length; i++) {
			for(int j=0; j<gm.getBoard()[0].length; j++) {
				if(gm.getBoard()[i][j]==0) {
					counter++;
				}
			}
		}
		assertNotSame(counter, dimension);
	}

/**
 * 3.-Matriz  llena
 */
	@Test
	public void fullMatrixNext() {
		Game2048 gm = new Game2048(ForTesting.FULL);
		gm.next();
		assertArrayEquals(gm.getBoard(),ForTesting.FULL);
		
	}
}
