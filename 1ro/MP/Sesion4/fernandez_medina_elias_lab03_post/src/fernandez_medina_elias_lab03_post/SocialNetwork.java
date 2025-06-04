package fernandez_medina_elias_lab03_post;
import java.io.PrintStream;
import java.util.ArrayList;

import src.uo.mp.util.check.ArgumentChecks;

public class SocialNetwork {
private ArrayList<Post> posts;
public SocialNetwork() {
	setPosts(posts);
}

/**
 * @param posts the posts to set
 */
private void setPosts(ArrayList<Post> posts) {
	this.posts = posts;
}

/**
 * Método que devuelve un post de la lista
 * @param index
 * @return
 */
public Post getPosts(int index) {
	ArgumentChecks.isTrue(index>=0 && index < posts.size(), "Invalid index");
	return posts.get(index);
}
/**
 * Método que añade posts a la lista
 */
public void addPost(Post post) {
	ArgumentChecks.isNotNull(post);
	posts.add(post);
}
/**
 * Método que imprime la información
 *  de todos los posts de la red social
 */
public void listAllPosts(PrintStream out) {
	for(Post thePost: posts) {
		if(thePost instanceof Image) {
			out.print(thePost.toString());
		}
	}
}
/**
 * Método que devuelve los posts de un usuario
 */
public ArrayList<Post> findPostsByUser(String user){
	ArrayList<Post> userList = new ArrayList<>();
	for(Post userPost: posts) {
		if(userPost.getUser().equals(user)) {
			userList.add(userPost);
		}
	}
	return userList;
}
/**
 * Método que permite formatear los posts y devuelve una lista de cadenas con todos los post 
formateados en html, teniendo en cuenta que el formato mensaje sereá distinto al de la imagen
 */
public String toHtmlFormat() {
	StringBuilder sb = new StringBuilder();
	for(Post thePost: posts) {
		sb.append(thePost.getFormat() + "\n");
	}

return sb.toString();
}
}
