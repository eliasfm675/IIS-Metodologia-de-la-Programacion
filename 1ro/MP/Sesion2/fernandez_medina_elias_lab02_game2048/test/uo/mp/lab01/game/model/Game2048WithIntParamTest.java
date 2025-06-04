package uo.mp.lab01.game.model;

import static org.junit.Assert.*;

import org.junit.Test;

import uo.mp.lab01.game.model.Game2048;


public class Game2048WithIntParamTest {
	
	/**
	 * Clase de pruebas del constructor con parametro int. Casos de uso:
	 * 1.-Dimensión 4x4
	 * 2.-Dimensión por debajo --> matriz 3x3
	 * 3.-Dimensión por encima --> matriz 3x3
	 */
	/*
	 *  1.-Dimensión 4x4
	 */
	@Test
	public void ThreeXThreeBoard(){
		Game2048 gm = new Game2048(4);
		int rowLength = gm.getBoard().length;
		int columnLength = gm.getBoard()[0].length;
		assertEquals(rowLength, 4);
		assertEquals(columnLength, 4);
	}


/*
 *  2.-Dimensión por debajo --> matriz 3x3
 */
@Test
public void FourXFourBoard(){
	Game2048 gm = new Game2048(-1);
	int rowLength = gm.getBoard().length;
	int columnLength = gm.getBoard()[0].length;
	assertEquals(rowLength, 3);
	assertEquals(columnLength, 3);
}


/*
 * 3.-Dimensión por encima --> matriz 3x3
 */
@Test
public void SixXSixBoard(){
	Game2048 gm = new Game2048(848);
	int rowLength = gm.getBoard().length;
	int columnLength = gm.getBoard()[0].length;
	assertEquals(rowLength, 3);
	assertEquals(columnLength, 3);
}

}
