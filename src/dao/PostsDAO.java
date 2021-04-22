package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Post;

public class PostsDAO {
	private final String JDBC_URL = "jdbc:postgresql://localhost:5432/memo";
	private final String DB_USER = "postgres";
	private final String DB_PASS = "2020";

//	private Connection conn;
//	private PreparedStatement ps = null;
//	private ResultSet rs = null;


//	メモ一覧の表示
	public List<Post> displayPosts() {
//		複数のPostのデータを入れるためのリスト
		List<Post> postsList = new ArrayList<>();

//		DB接続
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
//			SQL文の準備
			String sql = "SELECT * FROM POSTS WHERE used ISNULL ORDER BY ID";
			PreparedStatement pStmt = conn.prepareStatement(sql);

//			SELECT文の実行
			ResultSet rs = pStmt.executeQuery();

			while(rs.next()) {
//				一つの投稿を表すpostをnewして、DBから取り出したid,title,contentを入れてく

//				int id = rs.getInt("ID");
//				String title = rs.getString("TITLE");
//				String content = rs.getString("CONTENT");
//				Post pt = new Post();
//				pt.setId(id);
//				pt.setTitle(title);
//				pt.setContent(content);

				Post pt = new Post();
				pt.setId(rs.getInt("ID"));
				pt.setTitle(rs.getString("TITLE"));
				pt.setContent(rs.getString("CONTENT"));

//				postをリストに追加
				postsList.add(pt);
			}

			return postsList;

		} catch(Exception e) {
//			request.setAttribute("message", "Exception:" + e.getMessage());
			e.printStackTrace();
			return null;
		}

	}

	public Post showPost(int id) {
//		表示するPostのデータを入れるための変数
		Post showPost = new Post();

//		DB接続
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
//			SQL文の準備
			String sql = "SELECT * FROM POSTS WHERE ID = " + id;
			PreparedStatement pStmt = conn.prepareStatement(sql);

//			SELECT文の実行
			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {
				showPost.setId(rs.getInt("ID"));
				showPost.setTitle(rs.getString("TITLE"));
				showPost.setContent(rs.getString("CONTENT"));
			}

			return showPost;

		} catch(Exception e) {
//			request.setAttribute("message", "Exception:" + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	public void updatePost(int id, String editTitle, String editContent) {
//		DB接続
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
//			自動コミットを禁止
			conn.setAutoCommit(false);

//			SQL文の準備
			String sql = "UPDATE POSTS SET TITLE='" + editTitle + "', CONTENT='" + editContent + "' WHERE ID = " + id;
			PreparedStatement pStmt = conn.prepareStatement(sql);

//			UPDATE文の実行
			pStmt.executeUpdate();

			conn.commit();


		} catch(Exception e) {
//			request.setAttribute("message", "Exception:" + e.getMessage());
			e.printStackTrace();
//		} finally {
//			try {
//				pStmt1.close();
//				conn.close();
//			} catch (Exception ex) {
//			//	logger.error(" 쳣" + ex.getMessage() + "    .");
//				ex.printStackTrace();
//			}
		}

	}

	public void createPost(String createTitle, String createContent) {
//		DB接続
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
//			自動コミットを禁止
			conn.setAutoCommit(false);

//			SQL文の準備
			String sql = "INSERT INTO POSTS (TITLE, CONTENT) VALUES('" + createTitle + "','" + createContent + "')";
			PreparedStatement pStmt = conn.prepareStatement(sql);

//			UPDATE文の実行
			pStmt.executeUpdate();

			conn.commit();

		} catch(Exception e) {
//			request.setAttribute("message", "Exception:" + e.getMessage());
			e.printStackTrace();
		}

	}

	public void deletePost(int id) {
//		DB接続
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
//			自動コミットを禁止
			conn.setAutoCommit(false);

//			SQL文の準備
			String sql = "UPDATE posts SET used = 1 WHERE id = " + id;
			PreparedStatement pStmt = conn.prepareStatement(sql);

//			UPDATE文の実行
			pStmt.executeUpdate();

			conn.commit();

		} catch(Exception e) {
//			request.setAttribute("message", "Exception:" + e.getMessage());
			e.printStackTrace();
		}
	}

}
