/*
 * --------------------------------------------------------------------------
 * DESC MEMBER
 * --------------------------------------------------------------------------
 * ID(PK)                  PASSWORD             NAME               GENDER
 * --------------------------------------------------------------------------
 * VARCHAR2(20) NOT NULL   VARCHAR2(10)         VARCHAR2(10)       NUMBER(2)
 * --------------------------------------------------------------------------
*/
package me.ahj.memberAPP;
/* 
* IdCheck.java = ���̵� �ߺ� Ȯ��
* InsertDB.java = ���� ��ư ������ ���� DB�� ����
* LoginCheckTest.java = �α��� ���� ���� Ȯ��
* LoginCheckToTable.java = �α��� �� ��쿡�� ���̺� ���� ��ȸ ���� �ϰ� 
* -> admin ���̵� �α��� ����
* TableGUI.java = ���̺� DB���� �ҷ��� GUI�� ���
*/
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

public class Main extends JFrame implements ActionListener {
	// ����
	private Container ct = getContentPane();
	private JPanel jp1 = new JPanel();
	private JMenuBar jmb = new JMenuBar();
	private JMenu jm1 = new JMenu("�޴� (M)");
	private JMenu jm2 = new JMenu("���� (A)");
	private JLabel jl1 = new JLabel("ȸ������ ���α׷�");
	private JMenuItem jmi = new JMenuItem("����");
	private JMenuItem jmi0 = new JMenuItem("ù ȭ��");
	private JMenuItem jmi1 = new JMenuItem("����");
	private JMenuItem jmi2 = new JMenuItem("�α���");
	private JMenuItem jmi3 = new JMenuItem("���̺� ����");
	private JLabel jl2 = new JLabel("ȸ������", JLabel.CENTER);
	private JLabel jl3 = new JLabel("���̵�", JLabel.CENTER);
	private JLabel jl4 = new JLabel("��й�ȣ", JLabel.CENTER);
	private JLabel jl5 = new JLabel("�̸�", JLabel.CENTER);
	private JLabel jl6 = new JLabel("����", JLabel.CENTER);
	private JTextField jtf1 = new JTextField();
	private JPasswordField jpf = new JPasswordField();
	private JTextField jtf2 = new JTextField();
	private JRadioButton jrb1 = new JRadioButton("��");
	private JRadioButton jrb2 = new JRadioButton("��");
	private ButtonGroup bg = new ButtonGroup();
	private JButton jbt1 = new JButton("����");
	private JButton jbt2 = new JButton("�ߺ� Ȯ��");
	private Box bx = Box.createHorizontalBox();
	private int gen; // ����
	private int check = 0;
	private String oldID; // ���̵� ��
	private String id;

	// ����
	private JLabel jl7 = new JLabel("���̵�", JLabel.CENTER);
	private JLabel jl8 = new JLabel("��й�ȣ", JLabel.CENTER);
	private JTextField jtf3 = new JTextField();
	private JPasswordField jpf1 = new JPasswordField();

	// ùȭ��
	private JPanel jp2 = new JPanel();
	private JLabel jl10 = new JLabel("ȸ������ ���α׷�");

	public Main() {
		setTitle("-Members-");
		setSize(300, 300);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		ct.setLayout(new BorderLayout());

		jmb.add(jm1);
		jm1.setMnemonic(KeyEvent.VK_M);
		jm1.add(jmi0);
		jmi0.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		jm1.addSeparator();
		jm1.add(jmi1);
		jmi1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_J, ActionEvent.CTRL_MASK));
		jm1.add(jmi2);
		jmi2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));
		jm1.addSeparator();
		jm1.add(jmi);
		jmi.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
		jmi0.addActionListener(this);
		jmi1.addActionListener(this);
		jmi2.addActionListener(this);
		jmi.addActionListener(this);
		jm2.add(jmi3);
		jmi3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
		jmb.add(jm2);
		jm2.setMnemonic(KeyEvent.VK_A);
		jmi3.addActionListener(this);

		setJMenuBar(jmb);

		jl1.setFont(new Font("�������", Font.BOLD, 25));
		jl1.setHorizontalAlignment(JLabel.CENTER);

		bg.add(jrb1);
		bg.add(jrb2);

		bx.add(jrb1);
		bx.add(jrb2);

		ct.add(jl1, BorderLayout.CENTER);

		jbt1.addActionListener(this);
		jbt2.addActionListener(this);
	}

	public class LoginCheck extends JFrame implements ActionListener {

		private Container ct1 = getContentPane();
		private JButton jbt3 = new JButton("�α���");

		public LoginCheck() {
			setTitle("�α���");
			setSize(280, 130);
			setResizable(false);
			setLocationRelativeTo(null);
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setVisible(true);

			ct1.setLayout(null);

			jl7.setBounds(20, 10, 50, 30);
			jtf3.setBounds(70, 10, 105, 30);
			jl8.setBounds(5, 50, 60, 30);
			jpf1.setBounds(70, 50, 105, 30);
			jbt3.setBounds(180, 10, 75, 70);

			ct1.add(jl7);
			ct1.add(jtf3);
			ct1.add(jl8);
			ct1.add(jpf1);
			ct1.add(jbt3);

			jbt3.addActionListener(this);
		}

		public void actionPerformed(ActionEvent arg0) {

			String id = jtf3.getText();
			char[] charPW = jpf1.getPassword();
			String pw = new String(charPW);

			if (arg0.getSource() == jbt3) {
				if (id.equals("")) {
					JOptionPane.showMessageDialog(null, "���̵� �Է��ϼ���.", "����", JOptionPane.ERROR_MESSAGE);
				} else if (!id.equals("") && pw.equals("")) {
					JOptionPane.showMessageDialog(null, "��й�ȣ�� �Է��ϼ���.", "����", JOptionPane.ERROR_MESSAGE);
				} else if (!id.equals("") && !pw.equals("")) {
					new LoginCheckTest(id, pw);
				}
			}
		}
	}
	
	public class LoginToTable extends JFrame implements ActionListener {

		private Container ct1 = getContentPane();
		private JButton jbt3 = new JButton("�α���");

		public LoginToTable() {
			setTitle("�α���");
			setSize(280, 130);
			setResizable(false);
			setLocationRelativeTo(null);
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setVisible(true);

			ct1.setLayout(null);

			jl7.setBounds(20, 10, 50, 30);
			jtf3.setBounds(70, 10, 105, 30);
			jl8.setBounds(5, 50, 60, 30);
			jpf1.setBounds(70, 50, 105, 30);
			jbt3.setBounds(180, 10, 75, 70);

			ct1.add(jl7);
			ct1.add(jtf3);
			ct1.add(jl8);
			ct1.add(jpf1);
			ct1.add(jbt3);

			jbt3.addActionListener(this);
		}

		public void actionPerformed(ActionEvent arg0) {

			String id = jtf3.getText();
			char[] charPW = jpf1.getPassword();
			String pw = new String(charPW);

			if (arg0.getSource() == jbt3) {
				if (id.equals("")) {
					JOptionPane.showMessageDialog(null, "���̵� �Է��ϼ���.", "����", JOptionPane.ERROR_MESSAGE);
				} else if (!id.equals("") && pw.equals("")) {
					JOptionPane.showMessageDialog(null, "��й�ȣ�� �Է��ϼ���.", "����", JOptionPane.ERROR_MESSAGE);
				} else if (!id.equals("") && !pw.equals("")) {
					new LoginCheckToTable(id, pw);
				}
			}
		}
	}

	public static void main(String[] args) {
		new Main().setVisible(true);
	}

	public void actionPerformed(ActionEvent arg0) {

		id = jtf1.getText();
		char[] charPW = jpf.getPassword();
		String pw = new String(charPW);
		String name = jtf2.getText();

		if (jrb1.isSelected()) {
			gen = 1; // ��
		} else if (jrb2.isSelected()) {
			gen = 2; // ��
		}

		if (arg0.getSource() == jbt2) { // �ߺ� Ȯ�� ��ư
			if (id.equals("")) { // ���̵� ��ĭ�� ���
				JOptionPane.showMessageDialog(null, "���̵� �Է� �ϼ���.", "����", JOptionPane.ERROR_MESSAGE);
			} else {
				check = 1; // �ߺ� Ȯ�� ���� üũ������ ���
				oldID = id; // �ߺ� Ȯ�� �� ���̵� ���� ����� ���� ���̵�� �񱳽� ���
				new IdCheck(id); // ���̵� �ߺ� üũ Ŭ����
			}
		}

		if (arg0.getSource() == jmi1) {
			getContentPane().removeAll();
			jl2.setFont(new Font("�������", Font.BOLD, 20));
			ct.add(jl2, BorderLayout.NORTH);
			jp1.setLayout(null);
			jl3.setBounds(10, 10, 50, 30);
			jtf1.setBounds(70, 10, 100, 30);
			jbt2.setBounds(175, 10, 100, 30);
			jl4.setBounds(0, 50, 60, 30);
			jpf.setBounds(70, 50, 150, 30);
			jl5.setBounds(13, 90, 50, 30);
			jtf2.setBounds(70, 90, 150, 30);
			jl6.setBounds(13, 130, 50, 30);
			bx.setBounds(90, 130, 100, 30);
			jbt1.setBounds(95, 170, 100, 30);

			jp1.add(jl3);
			jp1.add(jtf1);
			jp1.add(jbt2);
			jp1.add(jl4);
			jp1.add(jpf);
			jp1.add(jl5);
			jp1.add(jtf2);
			jp1.add(jl6);
			jp1.add(bx);
			jp1.add(jbt1);
			ct.add(jp1);
			validate();
			repaint();
		} else if (arg0.getSource() == jbt1) {
			if (id.equals("") || pw.equals("") || name.equals("") || (gen != 1 && gen != 2)) { // ��� �׸��� �Է� ������ ���
				JOptionPane.showMessageDialog(null, "�׸��� ���� �Է� �ϼ���.", "����", JOptionPane.ERROR_MESSAGE);
			} else if (check == 0) { // �ƾƵ� �ߺ� Ȯ�� ������ ���
				JOptionPane.showMessageDialog(null, "���̵� �ߺ� Ȯ���� �ϼ���.", "����", JOptionPane.ERROR_MESSAGE);
			} else if (!oldID.equals(id)) { // ���̵� �ߺ� Ȯ�� �� ���̵� ���� ��
				JOptionPane.showMessageDialog(null, "���� �� ���̵� �ߺ� Ȯ���� �ٽ� �ϼ���.", "����", JOptionPane.ERROR_MESSAGE);
			} else if (JOptionPane.showConfirmDialog(null, "ȸ�������� �Ͻðڽ��ϱ�?", "Ȯ��", JOptionPane.YES_NO_OPTION, // Ȯ��â
					JOptionPane.INFORMATION_MESSAGE) != JOptionPane.NO_OPTION) {
				new InsertDB(id, pw, name, gen); // DB insert Ŭ����
				JOptionPane.showMessageDialog(null, "ȸ�������� �Ϸ� �Ǿ����ϴ�.", "�Ϸ�", JOptionPane.INFORMATION_MESSAGE); // Ȯ��â
			} else {
				JOptionPane.showMessageDialog(null, "ȸ�������� ��� �Ǿ����ϴ�.", "���", JOptionPane.ERROR_MESSAGE); // Ȯ��â
			}
		} else if (arg0.getSource() == jmi0) {
			getContentPane().removeAll();
			jp2.setLayout(new BorderLayout());
			jl10.setFont(new Font("�������", Font.BOLD, 25));
			jl10.setHorizontalAlignment(JLabel.CENTER);
			jp2.add(jl10, BorderLayout.CENTER);
			ct.add(jp2);
			validate();
			repaint();

		} else if (arg0.getSource() == jmi2) {
			new LoginCheck();
		} else if (arg0.getSource() == jmi3) {
			new LoginToTable();
		} else if (arg0.getSource() == jmi) {
			System.exit(0);
		}
	}
}
