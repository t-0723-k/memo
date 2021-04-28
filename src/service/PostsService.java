package service;

import java.sql.SQLException;

import dao.PostsDAO;
import model.Post;

public class PostsService {
	
	public Post showPost(int id) throws SQLException{
		PostsDAO dao = new PostsDAO();
		String sql = "SELECT * FROM POSTS WHERE ID = ?";
		dao.getpStmt().setInt(1, id);
		Post p = dao.selectPost(sql);
		return p;
	}
	
}
