/**
 * 
 */
package uo.mp.newsstand.exception;

/**
 * @author UO299673
 *
 */
public class NewsstandException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;//esto sirve por si el proyecto se guarda en disco para que no desaparezca

	/**
	 * 
	 */
	public NewsstandException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public NewsstandException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public NewsstandException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public NewsstandException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public NewsstandException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
