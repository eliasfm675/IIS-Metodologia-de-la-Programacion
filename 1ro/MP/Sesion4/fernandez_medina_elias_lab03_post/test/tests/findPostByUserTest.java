/**
 * 
 */

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import fernandez_medina_elias_lab03_post.Post;
import fernandez_medina_elias_lab03_post.SocialNetwork;

/**
 * 
 */
class findPostByUserTest {

	private String user;
	private int likes;
	private ArrayList<String> comments;
	private ArrayList<Post> posts;
	private String fileName;
	private String caption;
	private Image im;
	private Post po;
	private SocialNetwork sn;
	
	
	@BeforeEach
	public void setup() {
		po = new Post("user1");
		sn = new SocialNetwork();
	}
	
	/**
	 * Clase de pruebas del método findPostByUser(). Casos de uso:
	 * 1.-Encuentra los posts de un usuario
	 * 2.-No encuentra ningún post de ese usuario
	 */
	/**
	 * GIVEN a post with valid arguments
	 * WHEN the method is called
	 * THEN returns user's posts
	 */
	@Test
	public void findPostByUserValid() {
		Post other = new Post("Osas");
		sn.addPost(po);
		sn.addPost(po);
		sn.addPost(po);
		sn.addPost(other);
		sn.addPost(other);
		ArrayList<Post> list = sn.findPostsByUser("user1");
		assertEquals(3, list.size());
		assertEquals(po, list.get(0));
	}
	/**
	 * GIVEN a post with valid arguments
	 * WHEN the method is called
	 * THEN returns user's posts
	 */
	@Test
	public void findPostByUserNone() {
		
		ArrayList<Post> list = sn.findPostsByUser("user1");
		assertEquals(0, list.size());
	}

}
