package uo.mp.battleship.interaction;

import uo.mp.battleship.model.board.Board;
import uo.mp.battleship.model.board.Coordinate;
import uo.mp.battleship.model.player.Player;

public interface GamePresenter {
	
	/**
	 * It displays the information in the boards, human always on the left
	 * and computer always on the right.
	 * The information on the right will depend on the gameMode
	 *  
	 * @param left Human player board
	 * @param right Computer player board
	 * @param gameMode debug (true) or normal (false)
	 */
	void showGameStatus(Board left, Board right, boolean gameMode);
	
	/**
	 * It will display a Congratulations message 
	 * 
	 * @param theWinner player who won the game
	 */
	void showWinner(Player theWinner);
	
	/**
	 * It displays the message "Game Over"  
	 */
	void showGameOver();
	
	/**
	 * It informs the user the result of the shot with messages 
	 * as “Hit! Continue”, “Hit and sunk! Continue” or “Miss!”.
	 * 
	 * @param impact the integer encoding the result of a shot
	 * 			NO_DAMAGE, SEVERE_DAMAGE or MASSIVE_DAMAGE 
	 */
	void showShotMessage(Damage impact);
	
	/**
	 * It prints the name of the player who leads as: 
	 * “Now, the turn is for player <PLAYER NAME>”
	 * 
	 * @param player the player
	 */
	void showTurn(Player player);
	
	/**
	 * It prints a message identifying target square: 
	 * Shoot at <coordinate in user-friendly format>
	 *  
	 * @param coordinate the target coordinate
	 */
	void showShootingAt(Coordinate coordinate);
}
