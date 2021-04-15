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
		System.out.println(pl);
	}

}
