package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class DAO {
	private final String JDBC_URL = "jdbc:postgresql://localhost:5432/memo";
	private final String DB_USER = "postgres";
	private final String DB_PASS = "2020";
	private Connection conn = null;
	private PreparedStatement pStmt = null;
	private ResultSet rs = null;

	protected final ResultSet getConnection(String sql) {
		try {
			conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
			pStmt = conn.prepareStatement(sql);
			rs = pStmt.executeQuery();
			while (rs.next()) {
				setPost(rs.getPost("post"));
//				showPost.setTitle(rs.getString("TITLE"));
//				showPost.setContent(rs.getString("CONTENT"));
			}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return this.rs;
	}

//	final void setConnection(Connection conn) {
//		this.conn = conn;
//	}

	final public ResultSet getpStmt1(String sql) {
		conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
		pStmt = conn.prepareStatement(sql);
		rs = pStmt.executeQuery();
		return rs;
	}

	public void setpStmt1(PreparedStatement pStmt) {
		this.pStmt = pStmt;
	}
	
	public PreparedStatement getpStmt2() {
		return pStmt;
	}
	
	public void setpStmt2(PreparedStatement pStmt) {
		this.pStmt = pStmt;
	}

}
