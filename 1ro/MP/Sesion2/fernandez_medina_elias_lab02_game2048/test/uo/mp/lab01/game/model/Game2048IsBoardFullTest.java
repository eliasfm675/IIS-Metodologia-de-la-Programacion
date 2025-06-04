package uo.mp.lab01.game.model;

import static org.junit.Assert.*;

import org.junit.Test;

import uo.mp.lab01.game.model.util.ForTesting;

public class Game2048IsBoardFullTest {
	// Escenarios:
		// caso 1: matriz completamente llena
		// caso 2: matriz parcialmente llena
	    // caso 3: matriz vacia

		@Test
		public void isBoardFull() {
		
		 // caso 1: matriz completamente llena  
			int[][] matrix = {{2,2,2},{2,2,2},{2,2,2}};
		Game2048 game = new Game2048(matrix); //{{2,2,2},{2,2,2},{2,2,2}}
		assertTrue (game.isBoardFull());
	  }
		
		@Test
		public void notIsBoardFull() {
		
		 // caso 2: matriz parcialmente llena  
		int[][] matrix = {{2,2,0},{2,2,0},{2,2,0}};
		Game2048 game = new Game2048(matrix); //{{2,2,0},{2,2,0},{2,2,0}}
		assertFalse (game.isBoardFull());
	  }
		
		@Test
		public void isBoardEmpty() {

		// caso 3: matriz vacia
			int[][] matrix = {{0,0,0},{0,0,0},{0,0,0}};
		Game2048 game = new Game2048(ForTesting.EMPTY); //{{0,0,0},{0,0,0},{0,0,0}}
		assertFalse (game.isBoardFull());
	  }
}
