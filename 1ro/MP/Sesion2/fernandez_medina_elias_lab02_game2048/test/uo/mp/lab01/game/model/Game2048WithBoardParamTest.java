package uo.mp.lab01.game.model;

import static org.junit.Assert.*;


import org.junit.Test;

import uo.mp.lab01.game.model.Game2048;

public class Game2048WithBoardParamTest {
	/**
	 * Clase de pruebas del constructor con array. Casos de uso:
	 * 1.- Matriz de 3x3
	 * 2.-Matriz de 4x4
	 * 3.-Matriz de 5x5
	 * 4.-Matriz de 2x2
	 * 5.-Matriz es null --> salta excepción
	 * 6.-Matriz de dimensiones erróneas --> salta excepción
	 * 7.-Matriz no cuadradada --> salta excepción
	 */
	/**
	 * 1.- Matriz de 3x3 
	 */
	@Test
	public void ThreeXThreeMatrix() {
		int[][] array = {{1,2,3},
						{4,5,6},
						{7,8,9}};
		Game2048 gm = new Game2048(array);
		assertArrayEquals(array, gm.getBoard());
	}
	/**
	 * 2.-Matriz de 4x4 
	 */
	@Test
	public void FourXFourMatrix() {
		int[][] array = {{1,2,3,4},
						{4,5,6,7},
						{7,8,9,10},
						{1,2,3,4}};
		Game2048 gm = new Game2048(array);
		assertArrayEquals(array, gm.getBoard());
	}
	/**
	 * 3.-Matriz de 5x5
	 */
	@Test
	public void FiveXFiveMatrix() {
		int[][] array = {{1,2,3,4,5},
						{4,5,6,7,8},
						{7,8,9,10,11},
						{1,2,3,4,5},
						{1,2,3,4,5}};
		Game2048 gm = new Game2048(array);
		assertArrayEquals(array, gm.getBoard());
	}
	/**
	 * 4.- Matriz de 2x2
	 */
	@Test
	public void TwoXTwoMatrix() {
		int[][] array = {{1,2},
						{4,5}};
		Game2048 gm = new Game2048(array);
		assertArrayEquals(array, gm.getBoard());
	}
	/**
	 * 5.-Matriz es null --> salta excepción
	 */
	@Test
	public void NullMatrix() {
		try {
			int[][] array = null;
			Game2048 gm = new Game2048(array);
		}catch(IllegalArgumentException ex) {
			assertEquals("Tablero inadecuado o null",ex.getMessage());
		}
	}
	/**
	 * 6.-Matriz de dimensiones erróneas --> salta excepción
	 */
	@Test
	public void InvalidMatrix() {
		try {
			int[][] array = {{1,2,3,4,5,6,6,6},
					{4,5,6,7,8,6,6,6},
					{7,8,9,10,11,6,6,6},
					{1,2,3,4,5,6,6,6},
					{1,2,3,4,5,6,6,6},
					{6,6,6,6,6,6,6,6},
					{6,6,6,6,6,6,6,6},
					{6,6,6,6,6,6,6,6}};
	Game2048 gm = new Game2048(array);
		}catch(IllegalArgumentException ex) {
			assertEquals("Tablero inadecuado o null",ex.getMessage());
		}
	}
	/**
	 * 4.- Matriz de 2x2
	 */
	@Test
	public void InvalidDimensionMatrix() {
		try {
			int[][] array = {{1,2},
					{4,5,67,898,5}};
			Game2048 gm = new Game2048(array);
		}catch(IllegalArgumentException ex) {
			assertEquals("Tablero inadecuado o null",ex.getMessage());
		}
	}
}
