package model;

import java.util.List;

import dao.PostsDAO;

public class GetPostsListLogic {
	public List<Post> execute() {
		PostsDAO dao = new PostsDAO();
		List<Post> postsList = dao.displayPosts();
		return postsList;
	}
}
