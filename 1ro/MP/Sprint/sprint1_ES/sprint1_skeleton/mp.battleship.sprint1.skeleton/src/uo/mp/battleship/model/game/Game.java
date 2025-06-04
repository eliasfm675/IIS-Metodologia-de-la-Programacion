package uo.mp.battleship.model.game;

import java.util.List;

import uo.mp.battleship.console.ConsoleGameInteractor;
import uo.mp.battleship.console.ConsoleGamePresenter;
import uo.mp.battleship.interaction.ConsoleWriter;
import uo.mp.battleship.interaction.GameInteractor;
import uo.mp.battleship.interaction.GamePresenter;
import uo.mp.battleship.interaction.RandomGameInteractor;
import uo.mp.battleship.model.board.Board;
import uo.mp.battleship.model.board.Coordinate;
import uo.mp.battleship.model.board.Damage;
import uo.mp.battleship.model.player.Player;
import uo.mp.util.check.ArgumentChecks;

public class Game {
	private boolean gameMode;
	private Player leftPlayer;
	private Player rightPlayer;
	private GamePresenter gp;
	public Game(Player user, Player computer, int size) {
		Board blp = new Board(size);
		Board brp = new Board(size);
		user.setMyShips(blp);
		user.setOpponentShips(brp);
		computer.setMyShips(brp);
		computer.setOpponentShips(blp);
		user.setInteractor(new ConsoleGameInteractor());
		computer.setInteractor(new RandomGameInteractor());
		setPresenter(gp);
		this.leftPlayer =  user;
		this.rightPlayer =  computer;
		
	}
	
	public void setDebugMode ( boolean gameMode ) {
		this.gameMode = gameMode;
	}
	public void setPresenter(GamePresenter arg) {
		ArgumentChecks.isNotNull(arg);
		this.gp = arg;
	}
	 public void configurePlayerInteractors(GameInteractor humanInteractor, GameInteractor computerInteractor) {
	        leftPlayer.setInteractor(humanInteractor);
	        rightPlayer.setInteractor(computerInteractor);
	    }

	public void play() {
	    // Inicializar el selector de turnos
	    TurnSelector turnSelector = new TurnSelector(leftPlayer, rightPlayer);
	    // Mostrar un mensaje de inicio del juego
	    System.out.println("Welcome to Battleship");
	    //Inicializar los player interactors
	    configurePlayerInteractors(new ConsoleGameInteractor(), new RandomGameInteractor());

	    // Bucle principal del juego
	    while (true) {
	        // Obtener el jugador cuyo turno es ahora
	        Player currentPlayer = (turnSelector.next() == TurnSelector.PLAYER_TURN) ? leftPlayer : rightPlayer;

	        // Mostrar el mensaje de turno
	        gp.showTurn(currentPlayer);

	        // Mostrar la matriz de juego
	        gp.showGameStatus(leftPlayer.getMyShips(), rightPlayer.getMyShips(), gameMode);

	        // Obtener la coordenada elegida por el jugador actual
	        if(currentPlayer == leftPlayer) {
	        	currentPlayer.setInteractor(new ConsoleGameInteractor());
	        }else {
	        	currentPlayer.setInteractor(new RandomGameInteractor());
	        }
	        Coordinate shotCoordinate = currentPlayer.makeChoice();

	        // Realizar el disparo en el tablero del oponente
	        Damage hit = currentPlayer == leftPlayer ?
	                        rightPlayer.shootAt(shotCoordinate) :
	                        leftPlayer.shootAt(shotCoordinate);
	        
	        // Mostrar el resultado del disparo
	        gp.showShootingAt(shotCoordinate);
	        gp.showShotMessage(hit);
	        //Repetir turno
	        if(hit.equals(Damage.MASSIVE_DAMAGE) || hit.equals(Damage.SEVERE_DAMAGE)) {
	        	turnSelector.repeat();
	        }

	        // Mostrar la matriz de juego actualizada después del disparo
	        for(int i=0; i<5; i++) {
	        	System.out.println();
	        }
	        gp.showGameStatus(leftPlayer.getMyShips(), rightPlayer.getMyShips(), gameMode);
	        for(int i=0; i<5; i++) {
	        	System.out.println();
	        }

	        // Verificar si el juego ha terminado
	        if (leftPlayer.hasWon() || rightPlayer.hasWon()) {
	            // Mostrar el mensaje de fin de juego
	           gp.showGameOver();
	            
	            // Mostrar al ganador
	            Player winner = leftPlayer.hasWon() ? leftPlayer : rightPlayer;
	            gp.showWinner(winner);
	            
	            // Salir del bucle
	            break;
	        }
	    }
	}



}
