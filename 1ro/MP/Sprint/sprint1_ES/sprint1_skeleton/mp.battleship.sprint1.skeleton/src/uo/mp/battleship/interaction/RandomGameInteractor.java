package uo.mp.battleship.interaction;

import java.util.Random;

import uo.mp.battleship.model.board.Board;
import uo.mp.battleship.model.board.Coordinate;

public class RandomGameInteractor implements GameInteractor{
private Random random;
	public RandomGameInteractor() {
        random = new Random();
    }
	  public Coordinate getTarget() {
	        // Generar coordenada aleatoria
	        int row = random.nextInt(Board.MIN_GRID_SIZE);
	        int col = random.nextInt(Board.MIN_GRID_SIZE);
	        return new Coordinate(row, col);
	    }
	

}
