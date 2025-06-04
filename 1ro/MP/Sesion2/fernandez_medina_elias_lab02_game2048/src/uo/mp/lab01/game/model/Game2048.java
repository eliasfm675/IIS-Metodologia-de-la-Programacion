package uo.mp.lab01.game.model;

import java.util.Random;

/**
 * <p>
 * Titulo: Clase Game2048
 * </p>
 * 
 * <p>
 * Descripcion: A partir de un array bidimensional de numeros y a traves de
 * diferentes operaciones se simula un juego llamado "2048"
 * </p>
 *
 * <p>
 * Copyright: Copyright (c) 2024
 * </p>
 * <p>
 * Empresa: Escuela de Ingenieri Informatica - Uiversidad de Oviedo
 * </p>
 * 
 * @author Profesores-MP
 * @version 2024
 */
public class Game2048 {

	// Completar y corregir los comentarios javadoc
	private int[][] board;
	/**
	 * Constantes para las dimensiones
	 */
	public static final int MAX_LENGTH = 5;
	public static final int MIN_LENGTH = 2;
	public static final int STANDARD_LENGTH = 3;

	/**
	 * Constructor sin parametros con tablero por defecto de 3*3 Inicialmente todas
	 * las posiciones con valor 0
	 */

	public Game2048() {
		board = new int[STANDARD_LENGTH][STANDARD_LENGTH];
	}

	/**
	 * Constructor que recibe el tama�o del tablero
	 *
	 * @param size tamanio del tablero cuadrado. Si el tamanio no esta entre el
	 *             m�nimo (2) y el maximo (5) se crea un tablero con el valor por
	 *             defecto (3)
	 */
	public Game2048(int size) {
		this();
		if (size >= MIN_LENGTH && size <= MAX_LENGTH) {
			board = new int[size][size];
		}
	}

	/**
	 * Inicializa el tablero con la matriz recibida como parametro, Util para
	 * prop�sito de test. Se crea UNA COPIA (se denomina copia defensiva)del
	 * parametro en el tablero interno para evitar que desde fuera se pueda
	 * modificar los valores del tablero a posteriori
	 * 
	 * @param matriz cuadrada, de dimensiones entre maximo (5x5) y el m�nimo (3x3)
	 *               conteniendo solo valores potencia de 2.
	 * 
	 * @throws IllegalArgumentException si parametro null, la dimension es erronea,
	 *                                  o hay valores inadecuados (no son potencia
	 *                                  de 2).
	 */

	protected Game2048(int[][] board) {
		checkParam(board != null, "Tablero inadecuado o null");
		checkParam(board.length == board[0].length, "Tablero inadecuado o null");
		checkParam((board.length >= MIN_LENGTH && board.length <= MAX_LENGTH)&& (board[0].length >= MIN_LENGTH && board[0].length <= MAX_LENGTH),"Tablero inadecuado o null");
		this.board = new int[board.length][board[0].length];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				this.board[i][j] = board[i][j];
			}
		}
	}

	/**
	 * Reinicia todas las posiciones a 0 y llama a next para que incluya un 2 en una
	 * posicion aleatoria
	 */
	public void restart() {
		Random r = new Random();
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				board[i][j] = 0;
			}
		}
		board[r.nextInt(board.length)][r.nextInt(board[0].length)] = 2;

	}

	/**
	 * Aniade un nuevo 2 en una posicion aleatoria vacia siempre que exista alguna
	 * 
	 */
	public void next() {
		Random r = new Random();
		int randomRow = r.nextInt(board.length);
		int randomColumn = r.nextInt(board[0].length);
		if(board[randomRow][randomColumn]==0){
			board[randomRow][randomColumn]=2;
		}
	}

	/**
	 * Comprueba si el tablero est� lleno. Esto ocurre cuando todas las celdas o
	 * posiciones del tablero tienen un n�mero distinto de cero
	 * 
	 * @return true si esta el tablero lleno, false si hay algun hueco
	 */
	public boolean isBoardFull() {
		int counter = 0;
		int totalCells = board.length * board[0].length;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] != 0) {
					counter++;
				}
			}
		}
		return counter == totalCells;

	}

	/**
	 * Compacta el tablero a la izquierda, dejando en cada fila todos los valores
	 * distintos de cero consecutivos en las primeras posiciones de la fila y todos
	 * los ceros en las ultimas posiciones de la fila
	 */
	public void compactLeft() {
			for(int i=0; i<board.length; i++) {
				compactRowLeft(i);
			}
			}

	/**
	 * Compacta una fila a la izquierda Recorre la fila y si la posicion contiene 0
	 * se busca una posicion a la derecha que no contenga 0 y se hace intercambio de
	 * valores. Asegurate de que el algoritmo es eficiente. Si ya esta compactada no
	 * sigue comprobando
	 * 
	 */
	private void compactRowLeft(int row) {
	    for (int i = 0; i < board[0].length; i++) {
	        if (board[row][i] == 0) {
	            int temp = findPositionAtRightWithValueFor(row, i);
	            if (temp != -1) {
	                board[row][i] = board[row][temp];
	                board[row][temp] = 0;
	            }
	        }
	    }
	}


	

	/**
	 * Busca una posici�n (columna) a la derecha de la posicion column que que
	 * contenga un valor distinto de cero y devuelve la posicion si lo encuentra
	 * 
	 * @param row,    fila en la que se quire trabajar
	 * @param column, columna a partir de la cual se busca un valor hacia la derecha
	 * @return columna encontrada con valor positivo o -1 si no encuentra ninguna a
	 *         su derecha
	 */
	private int findPositionAtRightWithValueFor(int row, int column) {
		for(int i=column+1; i<board[0].length; i++) {
			if(board[row][i]!=0) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Compacta el tablero a la derecha, dejando en cada fila todos los valores
	 * distintos de cero consecutivos en las ultimas posiciones de la fila y todos
	 * los ceros en las primeras posiciones de la fila
	 */
	public void compactRight() {
		for(int i=0; i<board.length; i++) {
			compactRowRight(i);
		}
	}
	/**
	 * Método que compacta una fila ala derecha
	 */
	private void compactRowRight(int row) {
		for(int i=board[0].length -1; i>=0; i--) {
			if(board[row][i]==0) {
				int temp=0;
				temp=findPositionAtLeftWithValueFor(row, i);
				if(temp!=-1) {
					board[row][i]=board[row][temp];
					board[row][temp]=0;
				}
			}
		}
	}
	/**
	 * Método que encuentra el primer valor distinto de 0 en un fila
	 */
	/**
	 * @param row
	 * @param column
	 * @return
	 */
	private int findPositionAtLeftWithValueFor(int row, int column) {
		for(int i=column-1; i>=0; i--) {
			if(board[row][i]!=0) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Compacta el tablero hacia arriba, dejando en cada columna todos los valores
	 * distintos de cero consecutivos en las primeras posiciones de las columnas y
	 * todos los ceros en las ultimas posiciones
	 */
	public void compactUp() {
		for(int i=0; i<board[0].length; i++) {
			compactRowUp(i);
		}
	}
	/**
	 * Compacta una fila hacia arriba 
	 */
	private void compactRowUp(int column) {
		int aux = 0;
		for(int i=0; i<board.length; i++) {
			if(board[i][column]!=0) {
				int temp=0;
				temp=findPositionBelowWithValueFor(temp, column);
				if(temp!=-1) {
					board[aux][column]=board[i][column];
					if(aux !=i) {
						board[i][column]=0;
					}
					aux++;
				}
			}
		}
	}
/**
 * Encuentra un elemento por debajo de la fila que sea disyinto de 0
 */
	private int findPositionBelowWithValueFor(int row, int column) {
		for(int i=row+1; i<board.length; i++) {
			if(board[i][column]!=0) {
				return i;
			}
			
		}
		return -1;
	}
	/**
	 * Compacta el tablero hacia abajo, dejando en cada columna todos los valores
	 * distintos de cer consecutivos en las ultimas posiciones de las columnas y
	 * todos los ceros en las primeras posiciones
	 */
	public void compactDown() {
		for(int i=0; i<board[0].length; i++) {
			compactRowDown(i);
		}
	}
	/**
	 * Compacta una fila hacia abajo
	 */
	private void compactRowDown(int column) {
		int aux = board.length -1;
		for(int i=board.length -1; i>=0; i--) {
			if(board[i][column]!=0) {
				int temp=0;
				temp=findPositionAboveWithValueFor(i, column);
				if (temp!=-1) {
					board[temp][column]=board[i][column];
					if(temp != aux) {
						board[i][column] = 0;
					}
					aux--;
				}
			}
		}
		
	}
/**
 * Busca una posición hacia arriba que no tenga un 0
 */
	private int findPositionAboveWithValueFor(int row, int column) {
		for(int i=row - 1; i>=0; i--) {
			if(board[i][column]!=0) {
				return i;
			}
		}
		return -1;
	}
//	/**
//	 * @return un String con los datos de la matriz en formato para ser mostrado por
//	 *         pantalla Habra 5 espacios para cada posicion en la misma fila y un \n
//	 *         al final de cada fila Ejemplo. Para luego escribir: 2 2 0 2 0 0 2 0 2
//	 *         Se devuelve el String "2 2 0\n2 0 0\n2 0 2\n"
//	 */
//	public String toString() {
//		String result = "";
//		for (int i = 0; i < board.length; i++) {
//			for (int j = 0; j < board[0].length; j++) {
//				result += board[i][j] + " ";
//			}
//			result += "\n";
//		}
//		return result;
//	}
	/**
//	 * @return un String con los datos de la matriz en formato para ser mostrado por
//	 *         pantalla Habra 5 espacios para cada posicion en la misma fila y un \n
//	 *         al final de cada fila Ejemplo. Para luego escribir: 2 2 0 2 0 0 2 0 2
//	 *         Se devuelve el String "2 2 0\n2 0 0\n2 0 2\n"
 * 
 * 
 * Es más eficiente así
 */
//	 */
	public String toString() {
		StringBuilder sb = new  StringBuilder();
		for(int i=0; i<board.length; i++) {
			for(int j=0; j<board[0].length; j++) {
				sb.append(String.format("%-5s", board[i][j]));
			}
			sb.append("\n");
		}
		return sb.toString();	
		}

	/**
	 * Devuelve UNA COPIA de la matriz
	 * 
	 * @return copia exacta del tablero
	 */
	protected int[][] getBoard() {
		int[][] copy = new int[board.length][board[0].length];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				copy[i][j] = board[i][j];
			}
		}
		return copy;
	}

	/**
	 * @param n entero >= 0
	 * @return true si n is potencia de 2; false en otro caso
	 * 
	 */
	private boolean powerOfTwoBitwise(int n) {
		return (n & (n - 1)) == 0; // No hay que hacer nada en este metodo
	}

	/**
	 * Método que lanza una excepción si no se cumple una condición
	 * 
	 * @param msg
	 * @param condition
	 * @throws IllegalArgumentException
	 */
	private void checkParam(boolean condition, String msg) {
		if (!condition) {
			throw new IllegalArgumentException(msg);
		}
	}

}
