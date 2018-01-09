package me.ahj.memberAPP;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertDB {

	private String DB_URL = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
	private String DB_USER = "test";
	private String DB_PASSWORD = "test";
	private Connection conn = null;
	private Statement stmt = null;
	private ResultSet rs = null;

	public InsertDB(String id, String pw, String name, int gen) {
		// 데이터 insert 쿼리
		String query = "insert into member values('" + id + "','" + pw + "','" + name + "'," + gen + ")";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC 드라이버 오류");
		}

		try {
			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
		} catch (Exception e) {
			System.out.print("SQL 오류");
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				System.out.println("CLOSE 오류");
			}
		}
	}
}
