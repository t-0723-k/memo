package test;

import java.sql.SQLException;
import java.util.List;

import model.Post;
import service.PostsService;

public class PostsDAOTest {

	public static void main(String[] args) throws SQLException {
		testDisplayPosts();
//		testShowPost(1);
//		testUpdatePost(1, "aaa", "aaa");
//		testCreatePost("新規", "新規");
//		testDeletePost(10);

	}

	public static void testDisplayPosts() throws SQLException {
		PostsService ps = new PostsService();
		List<Post> lp = ps.allPost();

		for(Post post: lp) {
			System.out.println(post.getId());
			System.out.println(post.getTitle());
			System.out.println(post.getContent());
		}

	}

	public static void testShowPost(int id) throws SQLException {
		PostsService ps = new PostsService();
		Post p = ps.showPost(id);
		System.out.println(p.getId());
		System.out.println(p.getTitle());
		System.out.println(p.getContent());
	}

	public static void testUpdatePost(int id, String editTitle, String editContent) throws SQLException {
		PostsService ps = new PostsService();
		ps.updatePost(id, editTitle, editContent);
	}

	public static void testCreatePost(String createTitle, String createContent) throws SQLException {
		PostsService ps = new PostsService();
		ps.createPost(createTitle, createContent);
	}

	public static void testDeletePost(int id) throws SQLException {
		PostsService ps = new PostsService();
		ps.deletePost(id);
	}

}
