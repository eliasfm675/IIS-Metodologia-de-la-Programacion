package uo.mp.battleship.model.board;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import uo.mp.battleship.model.board.Board;
import uo.mp.battleship.model.board.Coordinate;

class isFleetSunkTest {
	private static Board board;
	private static Coordinate cor;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	public static void setUp() {
		board = new Board(10);
		cor = new Coordinate(0, 0);
	}

	/**
	 * Clase de pruebas del método isFleetSunk().Casos de uso:
	 * 1.- Todos los barcos están hundidos. Devuelve True
	 * 2.- Todos los barcos, salvo uno que le falta una posición sin disparar,
	 * están hundidos. Devuelve false
	 * 3.- Varios barcos no han sido disparados. Devuelve false
	 */
	/**
	 * GIVEN that all ships are sunken
	 * WHEN calling the method
	 * THEN returns true
	 */
	@Test
	public void isFleetSunkAll() {
		for(int i=0; i<Coordinate.MIN_GRID_SIZE; i++) {
			for(int j=0; j<Coordinate.MIN_GRID_SIZE; j++) {
				board.shootAt(new Coordinate(j, i));
			}
		}
		assertTrue(board.isFleetSunk());
	}
	/**
	 * GIVEN that all ships but one are sunken
	 * WHEN calling the method
	 * THEN returns false
	 */
	@Test
	public void isFleetSunkAllButOne() {
		int counter = 0;
		for(int i=0; i<Coordinate.MIN_GRID_SIZE; i++) {
			for(int j=0; j<Coordinate.MIN_GRID_SIZE; j++) {
				if(counter<Coordinate.MIN_GRID_SIZE) {
				board.shootAt(new Coordinate(j, i));
				counter++;
				}else {
					break;
				}
			}
		}
		assertFalse(board.isFleetSunk());
	}
	/**
	 * GIVEN that some ships are sunken
	 * WHEN calling the method
	 * THEN returns false
	 */
	@Test
	public void isFleetSunkSome() {
		board.shootAt(new Coordinate(0, 0));
		board.shootAt(new Coordinate(0, 2));
		assertFalse(board.isFleetSunk());
	}
	
}
