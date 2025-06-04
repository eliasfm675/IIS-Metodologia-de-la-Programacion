package uo.mp.battleship.interaction;

	import java.util.Scanner;

	public class Console {
	    private static final Scanner scanner = new Scanner(System.in);

	    /**
	     * Lee un carácter de la entrada estándar.
	     * @return el carácter leído
	     */
	    public static char readChar() {
	        return scanner.next().charAt(0);
	    }

	    /**
	     * Lee un entero de la entrada estándar.
	     * @return el entero leído
	     */
	    public static int readInt() {
	        return scanner.nextInt();
	    }

	    /**
	     * Lee una línea de la entrada estándar.
	     * @return la línea leída
	     */
	    public static String readLine() {
	        return scanner.nextLine();
	    }
	}


