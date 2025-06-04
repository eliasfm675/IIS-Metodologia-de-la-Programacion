package uo.mp.battleship.model.board;

import java.util.ArrayList;
import java.util.List;

import uo.mp.util.check.ArgumentChecks;

public class Board {
	/**
	 * Constante de dimensión del tablero
	 */
	public static final int MIN_GRID_SIZE = 10;
	private static final int MAX_GRID_SIZE = 20;
	/**
	 * Numero privisonal de barcos
	 */
	private static final int SHIP_NUMBER = 10;
	/**
	 * COnstantes de referencia a los barcos
	 */
	private static final char BATTLESHIP = 'B';
	private static final char CRUISER = 'C';
	private static final char DESTROYER = 'D';
	private static final char SUBMARINE = 'S';
	private static final char HIT = '*';
	private static final char MISSED_SHOT = 'Ø';
	private static final char BLANK = ' ';

	private Square[][] grid;
	public Board(int size) {
		ArgumentChecks.isTrue(size>=MIN_GRID_SIZE && size<=MAX_GRID_SIZE, null);
		grid = BoardBuilder.build(size);
	}
	protected Board(Square[][] board) {
		grid = board;
	}

	public Damage shootAt(Coordinate position) {
		return grid[position.getRow()][position.getCol()].shootAt();

	}

	public boolean isFleetSunk() {
	    for (int i = 0; i < grid.length; i++) {
	        for (int j = 0; j < grid[0].length; j++) {
	            if(grid[i][j].toChar()=='B' || grid[i][j].toChar()=='C' || grid[i][j].toChar()=='S' || grid[i][j].toChar()=='D') {
	            	return false;
	            }
	        }
	    }
	    return true;
	}


	public int getSize() {
		return grid.length * grid[0].length;
	}

	public char[][] getFullStatus() {
		  char[][] status = new char[grid.length][grid[0].length];
	        for (int i = 0; i < grid.length; i++) {
	            for (int j = 0; j < grid[i].length; j++) {
	                status[i][j] = grid[i][j].toChar();
	            }
	        }
	        return status;
	}

	public char[][] getMinimalStatus() {
		 char[][] status = new char[grid.length][grid[0].length];
		for (int i = 0; i < status.length; i++) {
			for (int j = 0; j < status[i].length; j++) {
					status[i][j] = grid[i][j].minimalChar();
				}
			}
		return status;
		}

	public Square[][] getInnerArray() {
		Square[][] copy = new Square[grid.length][grid[0].length];
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				copy[i][j] = grid[i][j];
			}
		}
		return copy;
	}
	public int getLength() {
		return grid.length;
	}
//	public Damage shootAt2(Coordinate position) {
//		grid[position.getRow()][position.getCol()].getContent();
//		return grid[position.getRow()][position.getCol()].shootAt();
//	}

}
