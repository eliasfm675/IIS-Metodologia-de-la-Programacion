package uo.mp.lab02.game.model;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;



class Game2048MoveRightTest {

	/**
	 * Clase de pruebas del método moveRight(). Casos de uso:
	 * 1.-Matriz llena
	 * 2.-Columnas pares
	 * 3.-Columnas impares
	 */
	/**
	 * 1.-Matriz llena
	 */
	@Test
	public void moveRightFullMatrix() {
		int[][] array = {{2,2,2},{2,2,2},{2,2,2}};
		Game2048 gm = new Game2048(array);
		gm.moveRight();
		int[][] expected = {{0,4,2},{0,4,2},{0,4,2}};
		assertArrayEquals(expected, gm.getBoard());
		
	}
	/**
	 * 2.-Columnas pares
	 */
	@Test
	public void moveRightEvenMatrix() {
		int[][] array = {{2,0,2,0},{2,0,2,0},{2,0,2,0},{2,0,2,0}};
		Game2048 gm = new Game2048(array);
		gm.moveRight();
		int[][] expected = {{0,0,0,4},{0,0,0,4},{0,0,0,4},{0,0,0,4}};
		assertArrayEquals(expected, gm.getBoard());
		
	}
	/**
	 * 3.-Columnas impares
	 */
	@Test
	public void moveRightOddMatrix() {
		int[][] array = {{0,2,0,2},{0,2,0,2},{0,2,0,2},{0,2,0,2}};
		Game2048 gm = new Game2048(array);
		gm.moveRight();
		int[][] expected = {{0,0,0,4},{0,0,0,4},{0,0,0,4},{0,0,0,4}};
		assertArrayEquals(expected, gm.getBoard());
		
	}

}
