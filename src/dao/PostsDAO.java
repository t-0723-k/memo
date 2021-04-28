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

//	public void updatePost(String sql){
//
//		super.update(sql);
//		
//	}

	
	
	
//	
//	public void update(String sql) throws SQLException {
////		DB接続
//		conn = super.getConnection();
//		PreparedStatement pStmt = conn.prepareStatement(sql);
////		自動コミットを禁止
//		conn.setAutoCommit(false);
////		UPDATE文の実行
//		pStmt.executeUpdate();
////		コミット
//		conn.commit();
//	}
//



//	public List<Post> listDao(String sql)throws SQLException{
//		List<Post> postsList = new ArrayList<>();
////		DB接続
////		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
//			PreparedStatement pStmt = conn.prepareStatement(sql);
//
////			SELECT文の実行
//			ResultSet rs = pStmt.executeQuery();
//
//			while(rs.next()) {
//
//				Post pt = new Post();
//				pt.setId(rs.getInt("ID"));
//				pt.setTitle(rs.getString("TITLE"));
//				pt.setContent(rs.getString("CONTENT"));
//
////				postをリストに追加
//				postsList.add(pt);
//			}
//
//			return postsList;

//		} catch(Exception e) {
////			request.setAttribute("message", "Exception:" + e.getMessage());
//			e.printStackTrace();
//			return null;
//		}

	}

//	public Post postDao() {
//
//	}
//
//	public void updateDao() {
//
//	}


////	メモ一覧の表示
//	public List<Post> displayPosts() {
////		複数のPostのデータを入れるためのリスト
//		List<Post> postsList = new ArrayList<>();
//
////		DB接続
//		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
////			SQL文の準備
//			String sql = "SELECT * FROM POSTS WHERE used ISNULL ORDER BY ID";
//			PreparedStatement pStmt = conn.prepareStatement(sql);
//
////			SELECT文の実行
//			ResultSet rs = pStmt.executeQuery();
//
//			while(rs.next()) {
////				一つの投稿を表すpostをnewして、DBから取り出したid,title,contentを入れてく
//
////				int id = rs.getInt("ID");
////				String title = rs.getString("TITLE");
////				String content = rs.getString("CONTENT");
////				Post pt = new Post();
////				pt.setId(id);
////				pt.setTitle(title);
////				pt.setContent(content);
//
//				Post pt = new Post();
//				pt.setId(rs.getInt("ID"));
//				pt.setTitle(rs.getString("TITLE"));
//				pt.setContent(rs.getString("CONTENT"));
//
////				postをリストに追加
//				postsList.add(pt);
//			}
//
//			return postsList;
//
//		} catch(Exception e) {
////			request.setAttribute("message", "Exception:" + e.getMessage());
//			e.printStackTrace();
//			return null;
//		}
//
//	}
//
//	public Post showPost(int id) {
////		表示するPostのデータを入れるための変数
//		Post showPost = new Post();
//
////		DB接続
//		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
////			SQL文の準備
//			String sql = "SELECT * FROM POSTS WHERE ID = " + id;
//			PreparedStatement pStmt = conn.prepareStatement(sql);
//
////			SELECT文の実行
//			ResultSet rs = pStmt.executeQuery();
//
//			while (rs.next()) {
//				showPost.setId(rs.getInt("ID"));
//				showPost.setTitle(rs.getString("TITLE"));
//				showPost.setContent(rs.getString("CONTENT"));
//			}
//
//			return showPost;
//
//		} catch(Exception e) {
////			request.setAttribute("message", "Exception:" + e.getMessage());
//			e.printStackTrace();
//			return null;
//		}
//	}
//
//	public void updatePost(int id, String editTitle, String editContent) {
////		DB接続
//		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
////			自動コミットを禁止
//			conn.setAutoCommit(false);
//
////			SQL文の準備
//			String sql = "UPDATE POSTS SET TITLE='" + editTitle + "', CONTENT='" + editContent + "' WHERE ID = " + id;
//			PreparedStatement pStmt = conn.prepareStatement(sql);
//
////			UPDATE文の実行
//			pStmt.executeUpdate();
//
//			conn.commit();
//
//
//		} catch(Exception e) {
////			request.setAttribute("message", "Exception:" + e.getMessage());
//			e.printStackTrace();
////		} finally {
////			try {
////				pStmt1.close();
////				conn.close();
////			} catch (Exception ex) {
////			//	logger.error(" 쳣" + ex.getMessage() + "    .");
////				ex.printStackTrace();
////			}
//		}
//
//	}
//
//	public void createPost(String createTitle, String createContent) {
////		DB接続
//		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
////			自動コミットを禁止
//			conn.setAutoCommit(false);
//
////			SQL文の準備
//			String sql = "INSERT INTO POSTS (TITLE, CONTENT) VALUES('" + createTitle + "','" + createContent + "')";
//			PreparedStatement pStmt = conn.prepareStatement(sql);
//
////			UPDATE文の実行
//			pStmt.executeUpdate();
//
//			conn.commit();
//
//		} catch(Exception e) {
////			request.setAttribute("message", "Exception:" + e.getMessage());
//			e.printStackTrace();
//		}
//
//	}
//
//	public void deletePost(int id) {
////		DB接続
//		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
////			自動コミットを禁止
//			conn.setAutoCommit(false);
//
////			SQL文の準備
//			String sql = "UPDATE posts SET used = 1 WHERE id = " + id;
//			PreparedStatement pStmt = conn.prepareStatement(sql);
//
////			UPDATE文の実行
//			pStmt.executeUpdate();
//
//			conn.commit();
//
//		} catch(Exception e) {
////			request.setAttribute("message", "Exception:" + e.getMessage());
//			e.printStackTrace();
//		}
//	}
//
//}
