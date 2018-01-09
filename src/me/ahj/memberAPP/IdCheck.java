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
		// ���̵� �˻� ����
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
				result = rs.getString(1);

				if (result.equals(id)) {
					JOptionPane.showMessageDialog(null, "�ߺ��� ���̵� �ֽ��ϴ�.", "���", JOptionPane.ERROR_MESSAGE);
				}
			}
			if (result.equals("")) {
				JOptionPane.showMessageDialog(null, "��밡���� ���̵� �Դϴ�.", "�Ϸ�", JOptionPane.INFORMATION_MESSAGE);
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
