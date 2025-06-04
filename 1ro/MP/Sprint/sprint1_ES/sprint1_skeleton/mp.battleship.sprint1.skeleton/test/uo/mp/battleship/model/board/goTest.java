package uo.mp.battleship.model.board;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class goTest {
	private static Coordinate cor;
	private static int x;
	private static int y;
	@BeforeAll
	static void setUpBeforeClass() {
	}

	/**
	 * Clase de pruebas del método go. Casos de uso:
	 * 1.-Comprueba un Coordinate para columna A, dirección Oeste 
	 * 2.-Comprueba un Coordinate para fila 0, dirección Norte 
	 * 3.-Comprueba todas las direcciones con un Coordinate en fila y columna diferente a 0 
	 */
	/**
	 * GIVEN a coordinate on the left edge
	 * WHEN using the go method to the west
	 * THEN it stays the same
	 */
	@Test
	public void goWestEdge() {
		x=0;
		y=0;
		cor = new Coordinate(x, y);
		cor.go(Direction.WEST);
		assertEquals(0, cor.getCol());
		assertEquals(0, cor.getRow());
	}
	/**
	 * GIVEN a coordinate on the top edge
	 * WHEN using the go method to the north
	 * THEN it stays the same
	 */
	@Test
	public void goNorthEdge() {
		x=0;
		y=0;
		cor = new Coordinate(x, y);
		cor.go(Direction.NORTH);
		assertEquals(0, cor.getCol());
		assertEquals(0, cor.getRow());
	}
	/**
	 * GIVEN a coordinate on any position besides de edges
	 * WHEN using the go method to any direction
	 * THEN it moves 1 position according to the parameter
	 */
	@Test
	public void goAnyDirection() {
		Coordinate cor = new Coordinate(1, 1);
		Coordinate corW = cor.go(Direction.WEST);
		Coordinate corS = cor.go(Direction.SOUTH);
		Coordinate corN = cor.go(Direction.NORTH);
		Coordinate corE = cor.go(Direction.EAST);
		assertEquals(0, corW.getCol());
		assertEquals(1, corW.getRow());
		assertEquals(1, corS.getCol());
		assertEquals(2, corS.getRow());
		assertEquals(1, corN.getCol());
		assertEquals(0, corN.getRow());
		assertEquals(2, corE.getCol());
		assertEquals(1, corE.getRow());
	}

}
