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
	private PreparedStatement ps = null;
	private ResultSet rs = null;

	public ResultSet getResultSet(String sql) {
		
		try {
			
			conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;	
	}

	public void update(String sql) {
		
		try {
			
			conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
			ps = conn.prepareStatement(sql);
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

}