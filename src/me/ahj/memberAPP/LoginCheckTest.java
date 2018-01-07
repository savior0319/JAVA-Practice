package me.ahj.memberAPP;

import java.sql.*;
import javax.swing.*;

public class LoginCheckTest {

	private String DB_URL = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
	private String DB_USER = "test";
	private String DB_PASSWORD = "test";
	private Connection conn = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	private String getid;
	private String getpw;

	public LoginCheckTest(String id, String pw) {
		// ���̵� ��й�ȣ �˻� ����
		String query = "select * from member where id = '" + id + "'";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC ����̹� ����");
		}

		try {
			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				getid = rs.getString(1);
				getpw = rs.getString(2);
			}
			if (id.equals(getid) && pw.equals(getpw)) {
				JOptionPane.showMessageDialog(null, "�α��� ����", "����", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "���̵� �Ǵ� ��й�ȣ�� Ȯ���ϼ���.", "����", JOptionPane.ERROR_MESSAGE);
			}

		} catch (Exception e) {
			System.out.print("SQL ����");
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				System.out.println("CLOSE ����");
			}
		}
	}
}