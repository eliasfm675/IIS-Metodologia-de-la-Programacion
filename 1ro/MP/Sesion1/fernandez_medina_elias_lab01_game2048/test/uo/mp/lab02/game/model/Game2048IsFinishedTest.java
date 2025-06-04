package uo.mp.lab02.game.model;

import static org.junit.Assert.*;


import org.junit.Test;

public class Game2048IsFinishedTest {
	// Escenarios:
	// caso 1: matriz completamente llena
	// caso 2: matriz tiene 2048
	// caso 3: matriz normal

	@Test
	public void isFinishedFull() {

		// caso 1: matriz completamente llena
		int[][] matrix = { { 2, 2, 2 }, { 2, 2, 2 }, { 2, 2, 2 } };
		Game2048 game = new Game2048(matrix); // {{2,2,2},{2,2,2},{2,2,2}}
		assertTrue(game.isFinished());
	}

	@Test
	public void isFinishedHas2048() {

		// caso 2: matriz tiene 2048
		int[][] matrix = { { 0, 0, 2048 }, { 0, 0, 0 }, { 0, 0, 0 } };
		Game2048 game = new Game2048(matrix); // {{0,0,0},{0,0,0},{0,0,0}}
		assertTrue(game.isFinished());
	}
	@Test
	public void IsNotFinished() {

		// caso 3: matriz normal
		int[][] matrix = { { 2, 0, 2 }, { 0, 2, 2 }, { 2, 0, 2 } };
		Game2048 game = new Game2048(matrix); // {{2,2,0},{2,2,0},{2,2,0}}
		assertTrue(game.isFinished());
	
}
}
