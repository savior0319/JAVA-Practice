package me.ahj.memberAPP;

import java.sql.*;
import javax.swing.*;

public class LoginCheckToTable {

	private String DB_URL = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
	private String DB_USER = "test";
	private String DB_PASSWORD = "test";
	private Connection conn = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	private String getpw;

	public LoginCheckToTable(String id, String pw) {
		// 아이디 비밀번호 검색 쿼리
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
				getpw = rs.getString(2);
			}
			if (id.equals("admin") && pw.equals(getpw)) {
				JOptionPane.showMessageDialog(null, "로그인 성공", "성공", JOptionPane.INFORMATION_MESSAGE);
				 new TableGUI();
			} else {
				JOptionPane.showMessageDialog(null, "아이디 또는 비밀번호를 확인하세요.", "실패", JOptionPane.ERROR_MESSAGE);
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