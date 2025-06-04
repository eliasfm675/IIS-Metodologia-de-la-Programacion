package uo.mp.battleship.model.game;

import java.util.Random;

import uo.mp.battleship.model.player.Player;

class TurnSelector {
	/**
	 * Constantes de turnos
	 */
	static final int PLAYER_TURN = 1;
	private static final int MACHINE_TURN = 0;
	private Player player;
	private Player computer;
	private int turn;
	private boolean repeat;

	

	TurnSelector(Player user, Player computer) {
		setPlayer(player);
		setComputer(computer);
		setRepeat(false);
		setRandomTurn();
	}
	/**
	 * @param player the player to set
	 */
	private void setPlayer(Player player) {
		this.player = player;
	}
	/**
	 * @return the player
	 */
	private Player getPlayer() {
		return player;
	}


	/**
	 * @return the computer
	 */
	private Player getComputer() {
		return computer;
	}

	/**
	 * @param computer the computer to set
	 */
	private void setComputer(Player computer) {
		this.computer = computer;
	}

	/**
	 * @return the repeat
	 */
	private boolean isRepeat() {
		return repeat;
	}

	/**
	 * @param repeat the repeat to set
	 */
	private void setRepeat(boolean repeat) {
		this.repeat = repeat;
	}
	
	private int getTurn() {
		return turn;
	}

	private void setTurn(int turn) {
		this.turn = turn;
	}

	int next() {
		if(repeat) {
			repeat = false;
			return turn = (turn==PLAYER_TURN) ? PLAYER_TURN : MACHINE_TURN;
		}else {
			turn = (turn==PLAYER_TURN) ? MACHINE_TURN : PLAYER_TURN;
			return turn;
		}
		
	}
	private void setRandomTurn() {
		Random r = new Random();
		turn = r.nextInt(2);
	}
	public void repeat() {
		repeat = true;
	}
}

