package uo.mp.battleship.interaction;

import uo.mp.battleship.model.board.Coordinate;

public interface GameInteractor {
	
	/**
	 * Generates a new Coordinate
	 * 
	 * @return the coordinate
	 */
	Coordinate getTarget();

}
