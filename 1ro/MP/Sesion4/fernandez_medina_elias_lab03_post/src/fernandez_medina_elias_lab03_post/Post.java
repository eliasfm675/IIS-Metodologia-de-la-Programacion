package fernandez_medina_elias_lab03_post;
import java.util.ArrayList;

import src.uo.mp.util.check.ArgumentChecks;

public abstract class Post {
private String user;
private int likes;
private ArrayList<String> comments;
public Post(String user) {
	ArgumentChecks.isNotNull(user);
	ArgumentChecks.isNotBlank(user);
	ArgumentChecks.isNotEmpty(user);
	setUser(user);
	setLikes(0);
	this.comments = new ArrayList<>();
	
}
/**
 * @return the user
 */
protected String getUser() {
	return user;
}
/**
 * @param user the user to set
 */
private void setUser(String user) {
	this.user = user;
}
/**
 * @return the likes
 */
protected int getLikes() {
	return likes;
}
/**
 * @param likes the likes to set
 */
public void setLikes(int likes) {
	this.likes = likes;
}
/**
 * Método para añadir comentarios a la lista
 */
public void addComments(String comment) {
	comments.add(comment);
}
/**
 * Método que devuelve un elemento de la lista
 */
public String getComment(int index) {
	ArgumentChecks.isTrue(index>0 && index < comments.size(), "index is invalid");
	return comments.get(index);
}
/**
 * Método to string
 */
@Override
public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("User: ").append(user)
      .append(", Likes: ").append(likes)
      .append(", Comments: ").append(comments.size());
    return sb.toString();
}
public abstract String getFormat();
}
