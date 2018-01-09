package me.ahj.memberAPP;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class IdCheck {

	private String DB_URL = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
	private String DB_USER = "test";
	private String DB_PASSWORD = "test";
	private Connection conn = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	private String result = "";

	public IdCheck(String id) {
		// 아이디 검색 쿼리
		String query = "select * from member where id = '" + id + "'";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC 드라이버 오류");
		}

		try {
			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				result = rs.getString(1);

				if (result.equals(id)) {
					JOptionPane.showMessageDialog(null, "중복된 아이디가 있습니다.", "경고", JOptionPane.ERROR_MESSAGE);
				}
			}
			if (result.equals("")) {
				JOptionPane.showMessageDialog(null, "사용가능한 아이디 입니다.", "완료", JOptionPane.INFORMATION_MESSAGE);
			}
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
