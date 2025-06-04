package uo.mp.battleship.model.player;

import java.util.HashSet;

import uo.mp.battleship.interaction.GameInteractor;
import uo.mp.battleship.model.board.Board;
import uo.mp.battleship.model.board.Coordinate;
import uo.mp.battleship.model.board.Damage;
import uo.mp.util.check.ArgumentChecks;

public class Player {
	

	private String name;
	private Board myShips;
	private Board myOpponentShips;
	private GameInteractor gi;
	private HashSet<Coordinate> firedCoordinates = new HashSet<Coordinate>();
	public Player(String name) {
		setName(name);
		
	}

	/**
	 * @param name the name to set
	 */
	private void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	public void setInteractor(GameInteractor gi) {
		ArgumentChecks.isNotNull(gi);
		this.gi = gi;
	}

	public void setMyShips(Board board) {
		this.myShips = board;
	}

	public void setOpponentShips(Board board) {
		this.myOpponentShips = board;
	}

	public  Damage shootAt(Coordinate position) {
		return getMyShips().shootAt(position);
	}

	public Board getMyShips() {
		return myShips;
	}
	public GameInteractor getGameInteractor() {
		return gi;
	}

	public Board getOpponentShips() {
		return myOpponentShips;
	}

	public boolean hasWon() {
		return myOpponentShips.isFleetSunk();
	}

	public Coordinate makeChoice() {
		Coordinate choice = gi.getTarget();
		while(getFiredCoordinates().contains(choice)) {
			System.out.println("This position has already been shot, choose another one");
			choice = gi.getTarget();
		}
		firedCoordinates.add(choice);
		return choice;
	}
	
	private HashSet<Coordinate> getFiredCoordinates() {
		return firedCoordinates;
	}
	@Override
	public String toString() {
		return name;
	}

}