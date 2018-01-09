package me.ahj.memberAPP;

import java.awt.BorderLayout;
import java.awt.Container;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TableGUI extends JFrame {

	private Container ct = getContentPane();
	private String colNames[] = { "���̵�", "��й�ȣ", "�̸�", "����(1 - ��, 2 - ��)" };
	private DefaultTableModel model = new DefaultTableModel(colNames, 0);
	private JScrollPane jsp;
	private JTable table;
	// DB
	private String DB_URL = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
	private String DB_USER = "test";
	private String DB_PASSWORD = "test";
	private Connection conn = null;
	private Statement stmt = null;
	private ResultSet rs = null;

	public TableGUI() {

		setTitle("���̺�");
		setSize(800, 500);
		setResizable(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);

		ct.setLayout(new BorderLayout());
		table = new JTable(model);
		jsp = new JScrollPane(table);

		ct.add(jsp, BorderLayout.CENTER);

		String query = "select * from member";
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

				model.addRow(new Object[] { rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4) });

			}

		} catch (Exception e) {
			// System.out.print("SQL ����");
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// System.out.println("CLOSE ����");
			}
		}

	}
}
