package test;

import java.util.List;

import dao.PostsDAO;
import model.Post;

public class PostsDAOTest {

	public static void main(String[] args) {
		testDisplayPosts();
//		testShowPost(1);
//		testUpdatePost(1, "aaa", "aaa");
//		testCreatePost("新規", "新規");
//		testDeletePost(10);

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

	public static void testShowPost(int id) {
		PostsDAO dao = new PostsDAO();
		Post showPost = dao.showPost(id);
		System.out.println(showPost.getId());
		System.out.println(showPost.getTitle());
		System.out.println(showPost.getContent());
	}

	public static void testUpdatePost(int id, String editTitle, String editContent) {
		PostsDAO dao = new PostsDAO();
		dao.updatePost(id, editTitle, editContent);
	}

	public static void testCreatePost(String createTitle, String createContent) {
		PostsDAO dao = new PostsDAO();
		dao.createPost(createTitle, createContent);
	}

	public static void testDeletePost(int id) {
		PostsDAO dao = new PostsDAO();
		dao.deletePost(id);
	}

}
