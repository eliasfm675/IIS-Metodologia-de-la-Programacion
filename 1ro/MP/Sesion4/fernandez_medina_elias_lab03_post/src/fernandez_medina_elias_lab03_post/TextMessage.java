package fernandez_medina_elias_lab03_post;
import src.uo.mp.util.check.ArgumentChecks;

public class TextMessage extends Post {
	private String message;
	public TextMessage(String user) {
		super(user);
		ArgumentChecks.isNotNull(user);
		ArgumentChecks.isNotBlank(user);
		ArgumentChecks.isNotEmpty(user);
		setMessage(message);
	}
	/**
	 * @return the message
	 */
	protected String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	private void setMessage(String message) {
		this.message = message;
	}
	/**
	 * Método que devuelve informacion sobre el TextMessage
	 */
	 @Override
	    public String toString() {
	        return "TextMessage: " + getMessage() + ", " + super.toString();
	    }
	@Override
	public String getFormat() {
		return "<p> " + message + "</p>";
	}
}
