package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Post;

public class PostsDAO extends DAO{

	public List<Post> selectList(String sql) throws SQLException{
		
		List<Post> lp = new ArrayList<Post>();
		
		ResultSet rs = super.getResultSet(sql);
		
		try {
			while(rs.next()) {				
				Post p = new Post();
				p.setId(rs.getInt("ID"));
				p.setTitle(rs.getString("TITLE"));
				p.setContent(rs.getString("CONTENT"));
				lp.add(p);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return lp;
	}


	public Post selectPost(String sql) throws SQLException{
		
		Post p = new Post();
		
		ResultSet rs = super.getResultSet(sql);
		
		
		while (rs.next()) {
			p.setId(rs.getInt("ID"));
			p.setTitle(rs.getString("TITLE"));
			p.setContent(rs.getString("CONTENT"));
		}
		return p;
	}
}