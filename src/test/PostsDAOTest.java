package test;

import java.util.List;

import dao.PostsDAO;
import model.Post;

public class PostsDAOTest {

	public static void main(String[] args) {
		testDisplayPosts();

	}

	public static void testDisplayPosts() {
		PostsDAO dao = new PostsDAO();
		List<Post> pl = dao.displayPosts();

		for(Post post: pl) {
			System.out.println(post.getId());
			System.out.println(post.getTitle());
			System.out.println(post.getContent());
		}

	}

}
