package fernandez_medina_elias_lab03_post;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class addPostTest {
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
	 * Clase de pruebas del método addPost. Casos de uso:
	 * 1.-Se añade un post
	 * 2.-Se añade null
	 */
	/**
	 * GIVEN a post with valid arguments
	 * WHEN said post is called on the methos
	 * THEN the post gets added;
	 */
	@Test
	public void addPostNotNull() {
		sn.addPost(po);
		assertEquals(po, sn.getPosts(0));
	}
	/**
	 * GIVEN a post with valid arguments
	 * WHEN said post is called on the methos
	 * THEN the post gets added;
	 */
	@Test
	public void addPostNull() {
		try {
			sn.addPost(null);
		}catch(IllegalArgumentException i) {
			assertEquals("null is an invalid value for the argument.", i.getMessage());
		}
		
	
	}
}
