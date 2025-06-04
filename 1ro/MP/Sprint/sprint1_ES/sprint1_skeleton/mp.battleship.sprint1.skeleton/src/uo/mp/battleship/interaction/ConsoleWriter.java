package uo.mp.battleship.interaction;

import java.io.PrintStream;
import java.util.Iterator;

import uo.mp.battleship.model.board.Board;
import uo.mp.battleship.model.board.Coordinate;
import uo.mp.battleship.model.board.Damage;

public class ConsoleWriter {

	public void showGameStatus(Board left, Board right, boolean debugMode) {
		
		if (!debugMode) {
			showHeader(System.out, left);
			showBoardMinimal(left, right, System.out);
		} else {
			showHeader(System.out, left);
			showBoardFull(left, right,  System.out);
		}
	}
	private void showBoardFull(Board playerBoard, Board computerBoard, PrintStream out) {
		char[][] board = playerBoard.getFullStatus();
		char [][] cboard = computerBoard.getFullStatus();
		int counter = 1;
		int space = 1;
		for(int i=0; i<board.length; i++) {
			if(counter<10) {
				out.print(" " + counter+"|");
			}else {
				out.print(counter+"|");
			}
			
			counter++;
			for(int j=0; j<board[0].length; j++) {
				out.print(board[i][j] + "|");
			}
			out.print("                                 ");
			if(space<10) {
				out.print(" " + space+"|");
			}else {
				out.print(space+"|");
			}
			
			space++;
			for(int k=0; k<cboard[0].length; k++) {
				out.print(cboard[i][k] + "|");
			}
			out.println();
		}
	}
	private void showBoardMinimal(Board playerBoard, Board computerBoard, PrintStream out) {
		char[][] board = playerBoard.getFullStatus();
		char [][] cboard = computerBoard.getMinimalStatus();
		int counter = 1;
		int space = 1;
		for(int i=0; i<board.length; i++) {
			if(counter<10) {
				out.print(" " + counter+"|");
			}else {
				out.print(counter+"|");
			}
			
			counter++;
			for(int j=0; j<board[0].length; j++) {
				out.print(board[i][j] + "|");
			}
			out.print("                                 ");
			if(space<10) {
				out.print(" " + space+"|");
			}else {
				out.print(space+"|");
			}
			
			space++;
			for(int k=0; k<cboard[0].length; k++) {
				out.print(cboard[i][k] + "|");
			}
			out.println();
		}
	}
	private void showHeader(PrintStream out, Board board) {
		char[] letters = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','0','P','Q','R','S','T'};
		out.print("   ");
		for(int i=0; i<board.getInnerArray().length;i++) {
			out.print(letters[i] + " ");
		}
		out.print("                                    ");
		for(int i=0; i<board.getInnerArray().length;i++) {
			out.print(letters[i] + " ");
		}
		out.println();
	}

	/*
	 * Expected message The winner is ... winner name
	 */
	public void showWinner(String winner, PrintStream out) {
		out.println("The winner is ... " + winner);
	}

	/*
	 * Expected message The game is over!!
	 */
	public void showGameOver(PrintStream out) {
		out.println("The game is over!!");
	}

	/*
	 * Expected message Now the turn is for the player player name
	 */
	public void showTurn(String playerName, PrintStream out) {
		out.println("Now the turn is for the player " + playerName);
	}

	/*
	 * Expected message Shoot at user-friendly
	 */
	public void showShootingAt(Coordinate position, PrintStream out) {
		out.println("Shoot at " + position.toUserString());

	}

	/*
	 * Expected message Depending on the shot result: MISS, HIT!! (sprint 1) MISS,
	 * HIT!!. Continue, HIT AND SUNK!!. Continue (from sprint 2 on)
	 */
	public void showShotMessage(Damage damage, PrintStream out) {
		String message = null;
		switch ( damage ) {
		case NO_DAMAGE: message = "MISS!!! LOSE YOUR TURN ";
				break;
		case SEVERE_DAMAGE: message = "HIT!!! REPEAT";
				break;
		case MASSIVE_DAMAGE: message = "HIT AND SUNK!!! REPEAT";
				break;
		}
		out.println( message );
	}
}