package uo.mp.battleship;

import uo.mp.battleship.model.board.Board;
import uo.mp.battleship.model.game.Game;
import uo.mp.battleship.model.player.ComputerPlayer;
import uo.mp.battleship.model.player.HumanPlayer;
import uo.mp.battleship.model.player.Player;

public class Main {

	private Game game;
	private boolean gameMode = false;

	public static void main(String[] args) {
		new Main()
			.configure(args)
			.run();
	}

	private boolean readDebugMode(String mode) {
		if (mode == null ||
				"DEBUG".equals(mode.toUpperCase()))
			return true;
		return false;
	}
	
	private Main configure(String[] args) {
		Player user = new Player("User");
		Player computer = new Player("Computer");
		game = new Game( user, computer, 10);
		gameMode = readDebugMode("debugmode");
		game.setDebugMode(gameMode);
		return this;
	}

	private void run() {
		game.play();
	}
}
