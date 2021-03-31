package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import model.Post;

public class PostsDAO {
	private final String JDBC_URL = "jdbc:postgresql://localhost:5432/memo";
	private final String DB_USER = "postgres";
	private final String DB_PASS = "2020";

//	メモ一覧の表示
	public Post displayPosts() {
		Post post = null;

//		DB接続
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
//			SQL文の準備
			String sql = "SELECT * FROM POSTS";
			PreparedStatement pStmt = conn.prepareStatement(sql);

//			SELECT文の実行
			ResultSet rs = pStmt.executeQuery();

			ArrayList<HashMap<String, String>> rows = new ArrayList<HashMap<String, String>>();

			while(rs.next()) {
				HashMap<String, String> columns = new HashMap<String, String>();

				String id = rs.getString("id");
				columns.put("id", id);

				String title = rs.getString("title");
				columns.put("title", title);

				String content = rs.getString("content");
				columns.put("content", content);

				rows.add(columns);
			}

//			request.setAttribute("rows", rows);

		} catch(Exception e) {
//			request.setAttribute("message", "Exception:" + e.getMessage());
			e.printStackTrace();
			return null;
		}

		return post;
	}
}
