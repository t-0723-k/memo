package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Post;

public class PostsDAO {
	private final String JDBC_URL = "jdbc:postgresql://localhost:5432/memo";
	private final String DB_USER = "postgres";
	private final String DB_PASS = "2020";

//	メモ一覧の表示
	public ArrayList<Post> displayPosts() {
//		複数のPostのデータを入れるためのリスト
		ArrayList<Post> postsList = new ArrayList<>();;

//		DB接続
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
//			SQL文の準備
			String sql = "SELECT * FROM POSTS";
			PreparedStatement pStmt = conn.prepareStatement(sql);

//			SELECT文の実行
			ResultSet rs = pStmt.executeQuery();

			while(rs.next()) {
//				一つの投稿を表すpostをnewして、DBから取り出したid,title,contentを入れてく
				Post pt = new Post();
				pt.setId(rs.getInt("id"));
				pt.setTitle(rs.getString("title"));
				pt.setContent(rs.getString("content"));
//				postをリストに追加
				postsList.add(pt);
			}


		} catch(Exception e) {
//			request.setAttribute("message", "Exception:" + e.getMessage());
			e.printStackTrace();
			return null;
		}

		return postsList;
	}
}
