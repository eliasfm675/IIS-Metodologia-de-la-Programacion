package uo.mp.battleship.model.game;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import uo.mp.battleship.model.player.ComputerPlayer;
import uo.mp.battleship.model.player.HumanPlayer;
import uo.mp.battleship.model.player.Player;

class repeatTest {
	private static TurnSelector ts;
	private static Player user;
	private static Player computer;
	@BeforeAll
	public static void setUp() {
		user = new HumanPlayer("user");
		computer = new ComputerPlayer("computer");
		ts = new TurnSelector(user, computer);
	}
	/**
	 * Clase de pruebas del método next.
	 */
	/**
	 * GIVEN a random turn
	 * WHEN giving the turn the correspondent player
	 * THEN returns the same player
	 */
	@Test
	public void repeatTest() {
		int turn1 = ts.next();
		ts.repeat();
		assertEquals(turn1, ts.next());
	}

	

}
