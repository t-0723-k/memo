package model;

import java.util.ArrayList;

import dao.PostsDAO;

public class GetPostsListLogic {
	public ArrayList<Post> execute() {
		PostsDAO dao = new PostsDAO();
		ArrayList<Post> postsList = dao.displayPosts();
		return postsList;
	}
}
