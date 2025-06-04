package fernandez_medina_elias_lab03_post;
import java.util.ArrayList;

public class NetworkApp {
	public void simulateClient() {
		SocialNetwork socialNetwork = new SocialNetwork();
		 // Agregar varios posts de dos usuarios diferentes (mensajes de texto y fotos)
        try {
            TextMessage textMessage1 = new TextMessage("user1");
            TextMessage textMessage2 = new TextMessage("user2");
            Image image1 = new Image("user1");
            Image image2 = new Image("user2");

            socialNetwork.addPost(textMessage1);
            socialNetwork.addPost(textMessage2);
            socialNetwork.addPost(image1);
            socialNetwork.addPost(image2);
        } catch (IllegalArgumentException e) {
            System.out.println("Error creating post: " + e.getMessage());
        }

        // Imprimir todos los posts de la red social
        System.out.println("All posts in the social network:");
        socialNetwork.listAllPosts(System.out);

        // Buscar e imprimir todos los posts asociados a un usuario
        String userId = "user1";
        ArrayList<Post> userPosts = socialNetwork.findPostsByUser(userId);
        System.out.println("\nPosts associated with user " + userId + ":");
        for (Post post : userPosts) {
            System.out.println(post.toString());
        }
        System.out.println("Post en formato Html");
        System.out.print(socialNetwork.toHtmlFormat());
        
    }
	}

