/**

 * 
 */
package uo.mp.battleship.model.board;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uo.mp.battleship.model.board.Board;
import uo.mp.battleship.model.board.Coordinate;

/**
 * 
 */
class shootAtTest {
	private static int SIZE_FOR_TEST = 10;
	private static Square[][] boardForTest = new Square[SIZE_FOR_TEST][SIZE_FOR_TEST];
	private static Board board = new Board(10);
	private Coordinate cor;

	/**
	 * @throws java.lang.Exception
	 */
	private static final int SUBMARINE = 1;
	private static final int DESTROYER = 2;
	private static final int CRUISER = 3;
	private static final int BATTLESHIP = 4;


	@BeforeEach
	public  void setUpBeforeClass() {
		Square[][] boardForTest = new Square[SIZE_FOR_TEST][SIZE_FOR_TEST];
		
		Ship s1 = new Ship(SUBMARINE);
		Ship s2 = new Ship(SUBMARINE);
		Ship s3 = new Ship(SUBMARINE);
		Ship s4 = new Ship(SUBMARINE);

		Ship d1 = new Ship(DESTROYER);
		Ship d2 = new Ship(DESTROYER);
		Ship d3 = new Ship(DESTROYER);

		Ship c1 = new Ship(CRUISER);
		Ship c2 = new Ship(CRUISER);

		Ship b = new Ship(BATTLESHIP);

		boardForTest[0][0] = new Square(s1);
		boardForTest[0][1] = new Square(new Water());
		boardForTest[0][2] = new Square(s2);
		boardForTest[0][3] = new Square(new Water());
		boardForTest[0][4] = new Square(s3);
		boardForTest[0][5] = new Square(new Water());
		boardForTest[0][6] = new Square(s4);
		boardForTest[0][7] = new Square(new Water());

		for (int i=0; i<SIZE_FOR_TEST; i++) {
			boardForTest[1][i] = new Square(new Water());
		}
	
		boardForTest[2][0] = new Square(d1);
		boardForTest[2][1] = new Square(d1);
		boardForTest[2][2] = new Square(new Water());
		boardForTest[2][3] = new Square(d2);
		boardForTest[2][4] = new Square(d2);
		boardForTest[2][5] = new Square(new Water());
		boardForTest[2][6] = new Square(d3);
		boardForTest[2][7] = new Square(d3);

		for (int i=0; i<SIZE_FOR_TEST; i++) {
			boardForTest[3][i] = new Square(new Water());
		}

		boardForTest[4][0] = new Square(c1);
		boardForTest[4][1] = new Square(c1);
		boardForTest[4][2] = new Square(c1);
		boardForTest[4][3] = new Square(new Water());
		boardForTest[4][4] = new Square(c2);
		boardForTest[4][5] = new Square(c2);
		boardForTest[4][6] = new Square(c2);
		boardForTest[4][7] = new Square(new Water());

		for (int i=0; i<SIZE_FOR_TEST; i++) {
			boardForTest[5][i] = new Square(new Water());
		}

		boardForTest[6][0] = new Square(new Water());
		boardForTest[6][1] = new Square(new Water());
		boardForTest[6][2] = new Square(new Water());
		boardForTest[6][3] = new Square(new Water());
		boardForTest[6][4] = new Square(b);
		boardForTest[6][5] = new Square(b);
		boardForTest[6][6] = new Square(b);
		boardForTest[6][7] = new Square(b);

		for (int i=0; i<SIZE_FOR_TEST; i++) {
			boardForTest[7][i] = new Square(new Water());
		}
		
		board = new Board(boardForTest);
		
	}
	/**
	 * Clase de pruebas del método shootAt(). Casos de uso:
	 * 1.-Disparo a agua, devuelve NO_DAMAGE
	 * 2.-Disparo a un submarino, devuelve MASSIVE_DAMAGE
	 * 3.-Disparo a una posición de un destructor, devuelve SEVERE_DAMAGE
	 * 4.-Disparo a la última posición del destructor, que lo hunde, devuelve MASSIVE_DAMAGE
	 */
	/**
	 * GIVEN a full board
	 * WHEN shooting a water square
	 * THEN it returns NO_DAMAGE
	 */
	@Test
	public void noDamageShootAt() {
		cor = new Coordinate(0, 1);
		assertEquals(Damage.NO_DAMAGE, board.shootAt(cor));
	}
	/**
	 * GIVEN a full board
	 * WHEN shooting a submarine square
	 * THEN it returns MASSIVE_DAMAGE
	 */
	@Test
	public void massiveDamageShootAt() {
		cor = new Coordinate(0,0);
		assertEquals(Damage.MASSIVE_DAMAGE, board.shootAt(cor));
	}
	/**
	 * GIVEN a full board
	 * WHEN shooting a destroyer square
	 * THEN it returns SEVERE_DAMAGE
	 */
	@Test
	public void severeDamageShootAt() {
		cor = new Coordinate(0,2);
		assertEquals(Damage.SEVERE_DAMAGE, board.shootAt(cor));
	}
	/**
	 * GIVEN a full board
	 * WHEN shooting a destroyer square
	 * THEN it returns SEVERE_DAMAGE
	 */
	@Test
	public void massiveDamageShootAtDestroyer() {
		cor = new Coordinate(0,2);
		Coordinate cor1 = new Coordinate(1,2);
		assertEquals(Damage.SEVERE_DAMAGE, board.shootAt(cor));
		assertEquals(Damage.MASSIVE_DAMAGE, board.shootAt(cor1));
	}
	
	

}
