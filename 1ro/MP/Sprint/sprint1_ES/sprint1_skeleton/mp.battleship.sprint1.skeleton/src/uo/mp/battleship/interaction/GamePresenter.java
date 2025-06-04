package uo.mp.battleship.interaction;

import java.io.PrintStream;

import uo.mp.battleship.model.board.Board;
import uo.mp.battleship.model.board.Coordinate;
import uo.mp.battleship.model.board.Damage;
import uo.mp.battleship.model.player.Player;

public interface GamePresenter {
	void showGameStatus(Board left, Board right, boolean gameMode);
	void showGameOver();
	void showWinner (Player theWinner);
	void showShotMessage (Damage impact);
	void showTurn (Player player);
	void showShootingAt (Coordinate coordinate);
}
