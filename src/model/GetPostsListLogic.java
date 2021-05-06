package model;

import java.sql.SQLException;
import java.util.List;

import service.PostsService;

public class GetPostsListLogic {
	public List<Post> execute() throws SQLException {
		PostsService ps = new PostsService();
		List<Post> lp = ps.allPost();
		return lp;
	}
}
