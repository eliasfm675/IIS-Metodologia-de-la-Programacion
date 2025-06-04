package fernandez_medina_elias_lab03_post;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class toHtmlFormatTest {
	private Image im;
	private TextMessage tx;
	private SocialNetwork sn;
	@BeforeEach
	public void setUp()
	{
		im = new Image("Julio");
		tx = new TextMessage("Javier")
		sn = new SocialNetwork();
	}
	/**´
	 * Clase de pruebas del método toHtmlFormat().Casos de uso:
	 * 1.-Devuelve una cadena de una imagen
	 * 2.-Devuelve una cadena de un mensaje
	 * 3.-Devuelve una cadena de una imagen y un mensaje
	 */
	/**
	 * GIVEN a valid image
	 * WHEN calling the method
	 * THEN the method returns a valid String
	 */
	 @Test
	 public void toHtmlFormat() {
		 sn.addPost(im);
		 assertEquals("<img src = " + im.getFileName()  + ">" +  im.getCaption + "</img>"+"\n", sn.toHtmlFormat());
	 }
	 /**
		 * GIVEN a valid text
		 * WHEN calling the method
		 * THEN the method returns a valid String
		 */
		 @Test
		 public void toHtmlFormat() {
			 sn.addPost(tx);
			 assertEquals("<p> " + tx.getMessage() + "</p>"+"\n", sn.toHtmlFormat());
		 }
		 /**
			 * GIVEN a both a valid image and a valid text
			 * WHEN calling the method
			 * THEN the method returns a valid String
			 */
			 @Test
			 public void toHtmlFormat() {
				 sn.addPost(im);
				 sn.addPost(tx);
				 assertEquals("<img src = " + im.getFileName()  + ">" +  im.getCaption + "</img>" +"\n" + "<p> " + tx.getMessage() + "</p>", sn.toHtmlFormat());
			 }
}
