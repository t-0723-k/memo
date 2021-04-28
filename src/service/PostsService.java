package service;

import java.sql.SQLException;
import java.util.List;

import dao.PostsDAO;
import model.Post;

public class PostsService {
	
	private PostsDAO dao;
	
	public PostsService() {
		dao = new PostsDAO();
	}
	
	public List<Post> allPost() throws SQLException{
		String sql = "SELECT * FROM POSTS WHERE used ISNULL ORDER BY ID";
		List<Post> lp = dao.selectList(sql);
		return lp;
	}

	public Post showPost(int id) throws SQLException{
		String sql =  "SELECT * FROM POSTS WHERE ID = " + id;
		Post p = dao.selectPost(sql);
		return p;
	}

	public void updatePost(int id, String editTitle, String editContent) throws SQLException{
		String sql =  "UPDATE POSTS SET TITLE='" + editTitle + "', CONTENT='" + editContent + "' WHERE ID = " + id;
		dao.update(sql);
	}

	public void deletePost(int id) throws SQLException{
		String sql =  "UPDATE posts SET used = 1 WHERE id = " + id;
		dao.update(sql);
	}

	public void createPost(String createTitle, String createContent) throws SQLException{
		String sql = "INSERT INTO POSTS (TITLE, CONTENT) VALUES('" + createTitle + "','" + createContent + "')";
		dao.update(sql);
	}
	
}
