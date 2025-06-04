package uo.mp.lab01.game.model;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import uo.mp.lab01.game.model.util.ForTesting;

public class Game2048CompactUpTest {
		/*
		 * Casos de uso
		 * 1. Matriz con un valor por columna en fila 0
		 * 2- Matriz con un valor por columna en fila 1
		 * 3- Matriz con un valor por columna en fila 2
		 * 
		 * 4- Matriz con 2 valores por columna (en 1 y 2)
		 * 5- Matriz con 2 valores por columna (en 0 y 1)
		 * 6- Matriz con 2 valores por columna (en 1 y 3)
		 * 
		 * 7- Matriz con 3 valores por columna 
		 * 
		 */
		/**
		 * 1. Matriz con un valor por columna en fila 0
		 */
		@Test
		public void OneValueForRowInRow0() {
			 int[][] SEMIFULL31 =   {{0,0,0},
									{0,0,0},
									{2,2,2}};
			Game2048 gm = new Game2048(SEMIFULL31);
			gm.compactUp();
			assertArrayEquals(ForTesting.SEMIFULL3_UPCOMPACTED, gm.getBoard());
		}
		/**
		 * 2- Matriz con un valor por columna en fila 1
		 */
		@Test
		public void OneValueForRowInRow1() {
			int[][] SEMIFULL32 =   {{0,0,0},
									{2,2,2},
									{0,0,0}};
			Game2048 gm = new Game2048(SEMIFULL32);
			gm.compactUp();
			assertArrayEquals(ForTesting.SEMIFULL3_UPCOMPACTED, gm.getBoard());
		}
		/**
		 * 3- Matriz con un valor por columna en fila 2
		 */
		@Test
		public void OneValueForRowInRow2() {
			 int[][] SEMIFULL33 =   {{2,2,2},
									{0,0,0},
									{0,0,0}};
			Game2048 gm = new Game2048(SEMIFULL33);
			gm.compactUp();
			assertArrayEquals(ForTesting.SEMIFULL3_UPCOMPACTED, gm.getBoard());
		}
		/**
		 * 4- Matriz con 2 valores por columna (en 1 y 2)
		 */
		@Test
		public void OneValueForColumnInRow1and2() {
			 int[][] SEMIFULL43 = 	{{2,2,2},
									{2,2,2},
									{0,0,0}};
			Game2048 gm = new Game2048(SEMIFULL43);
			gm.compactUp();
			assertArrayEquals(ForTesting.SEMIFULL43, gm.getBoard());
		}
		/**
		 * 5- Matriz con 2 valores por columna (en 0 y 1)
		 */
		@Test
		public void OneValueForColummnInRow0and1() {
			 int[][] SEMIFULL41 = 	{{0,0,0},
									{2,2,2},
									{2,2,2}};
			Game2048 gm = new Game2048(SEMIFULL41);
			gm.compactUp();
			assertArrayEquals(ForTesting.SEMIFULL43, gm.getBoard());
		}
		/**
		 *  6- Matriz con 2 valores por columna (en 1 y 3)
		 */
		@Test
		public void TwoValuesForColumnInRow1and3() {
			
			 int[][] SEMIFULL42 =   {{2,2,2},
									{0,0,0},
									{2,2,2}};
			 Game2048 gm = new Game2048(SEMIFULL42);
			gm.compactUp();
			assertArrayEquals(ForTesting.SEMIFULL43, gm.getBoard());
		}
		/**
		 *  7- Matriz con 3 valores por columna 
		 */
		@Test
		public void ThreeValuesForRow() {
			 int[][] FULL =   {{2,2,2},
					 			{2,2,2},
								{2,2,2}};

			Game2048 gm = new Game2048(FULL);
			gm.compactUp();
			assertArrayEquals(ForTesting.FULL, gm.getBoard());
		}
	}

	
