package uo.mp.lab01.game.model;

/**
 * <p> Titulo: Clase Game2048 </p>
 * 
 * <p> Descripcion: A partir de un array bidimensional de numeros y a traves de
 * diferentes operaciones se simula un juego llamado "2048" </p>
 *
 * <p> Copyright: Copyright (c) 2024 </p>
 * <p> Empresa: Escuela de Ingenieri Informatica - Uiversidad de Oviedo </p>
 * 
 * @author Profesores-MP
 * @version 2024
 */
public class Game2048 {
	
	//Completar y corregir los comentarios javadoc

	/**
	 * Constructor sin parametros con tablero por defecto de 3*3 
	 * Inicialmente todas las posiciones con valor 0
	 */
	public Game2048() {
	   // Completar
	}

	/**
	 *Constructor que recibe el tama�o del tablero
	 *
	 *@param size tamanio del tablero cuadrado. Si el tamanio no esta entre el m�nimo (2) 
	 *y el maximo (5) se crea un tablero con el valor por defecto (3)
	 */
	public Game2048(int size) {
		// Completar	
	}
	
	/**
	 * Inicializa el tablero con la matriz recibida como parametro, Util para prop�sito de 
	 * test.
	 * Se crea UNA COPIA (se denomina copia defensiva)del parametro 
	 * en el tablero interno para evitar que desde fuera se pueda 
	 * modificar los valores del tablero a posteriori
	 * 
	 * @param matriz cuadrada, de dimensiones entre maximo (5x5) y el m�nimo (3x3)
	 * conteniendo solo valores potencia de 2. 
	 * 
	 * @throws IllegalArgumentException si parametro null, la dimension es erronea, o 
	 * hay valores inadecuados (no son potencia de 2).
	 */
	
	protected Game2048(int[][] board) {
		// Completar
	}
		
	/**
	 * Reinicia todas las posiciones a 0 y llama a next para que incluya un
	 * 2 en una posicion aleatoria
	 */
	public void restart() {
		// Completar
	}
	
	
	/**
	 * Aniade un nuevo  2 en una posicion aleatoria vacia
	 * siempre que exista alguna
	 * 
	 */
	public void next() {
		// Completar
	}
	
	/**
	 * Comprueba si el tablero est� lleno. Esto ocurre cuando todas las celdas
	 * o posiciones del tablero tienen un n�mero distinto de cero
	 * @return true si esta el tablero lleno, false si hay algun hueco
	 */
	public boolean isBoardFull() {
		// Completar
		
		return false; // sustituir al completar
		
	}
	
	/**
	 * Compacta el tablero a la izquierda, 
	 * dejando en cada fila todos los valores distintos de cero consecutivos 
	 * en las primeras posiciones de la fila 
	 * y todos los ceros en las ultimas posiciones de la fila
	 */
	public void compactLeft() {
		// Completar
	}
	
	/**
	 * Compacta una fila a la izquierda
	 * Recorre la fila y si la posicion contiene 0 se busca una posicion a la derecha
	 * que no contenga 0 y se hace intercambio de valores.
	 * Asegurate de que el algoritmo es eficiente. Si ya esta compactada no sigue comprobando
	 * 
	 */
	private void compactRowLeft(int row) {
		// Completar
	}
	
	/**
	 * Busca una posici�n (columna) a la derecha de la posicion column que 
	 * que contenga un valor distinto de cero y devuelve la posicion si lo encuentra
	 * 
	 * @param row, fila en la que se quire trabajar
	 * @param column, columna a partir de la cual se busca un valor hacia la derecha
	 * @return columna encontrada con valor positivo 
	 *         o -1 si no encuentra ninguna a su derecha
	 */
	private int findPositionAtRightWithValueFor(int row, int column) {
		//completar
		
		return 0;  // sustituir al completar
	}

	/**
	 * Compacta el tablero a la derecha, 
	 * dejando en cada fila todos los valores distintos de cero consecutivos 
	 * en las ultimas posiciones de la fila 
	 * y todos los ceros en las primeras posiciones de la fila
	 */
	public void compactRight() {
		//completar
	}
	
	
	
	/**
	 * Compacta el tablero hacia arriba, 
	 * dejando en cada columna todos los valores distintos de cero consecutivos 
	 * en las primeras posiciones de las columnas 
	 * y todos los ceros en las ultimas posiciones
	 */
	public void compactUp() {
		//completar
	}
	
	/**
	 * Compacta el tablero hacia abajo, 
	 * dejando en cada columna todos los valores distintos de cer consecutivos 
	 * en las ultimas posiciones de las columnas
	 * y todos los ceros en las primeras posiciones
	 */
	public void compactDown() {
		//completar
	}
	
	
	/**
	 * @return un String con los datos de la matriz en formato para ser mostrado por pantalla
	 * Habra 5 espacios para cada posicion en la misma fila y un \n al final de cada fila
	 * Ejemplo. Para luego escribir:
	 *    2    2    0
	 *    2    0    0
	 *    2    0    2
	 *    Se devuelve el String "2    2    0\n2    0    0\n2    0    2\n"
	 */
	public String toString() {
		//completar
		
		return null; // sustituir al completar
	}
	
	
	/**
	 * Devuelve UNA COPIA de la matriz 
	 * 
	 * @return copia exacta del tablero
	 */
	protected int[][] getBoard() {
		// Completar
		
		return null; // sustituir al completar		
	}
	
	
	/**
	 * @param n entero >= 0
	 * @return true si n is potencia de 2; false en otro caso
	 * 
	 */
	private boolean powerOfTwoBitwise(int n) {
		return (n & (n - 1)) == 0;  // No hay que hacer nada en este metodo
	}
	
	

}
