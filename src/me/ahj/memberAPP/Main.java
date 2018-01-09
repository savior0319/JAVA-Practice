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
* IdCheck.java = 아이디 중복 확인
* InsertDB.java = 가입 버튼 누르면 정보 DB에 삽입
* LoginCheckTest.java = 로그인 성공 여부 확인
* LoginCheckToTable.java = 로그인 할 경우에만 테이블 정보 조회 가능 하게 
* -> admin 아이디만 로그인 가능
* TableGUI.java = 테이블 DB에서 불러와 GUI에 출력
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
	// 메인
	private Container ct = getContentPane();
	private JPanel jp1 = new JPanel();
	private JMenuBar jmb = new JMenuBar();
	private JMenu jm1 = new JMenu("메뉴 (M)");
	private JMenu jm2 = new JMenu("관리 (A)");
	private JLabel jl1 = new JLabel("회원가입 프로그램");
	private JMenuItem jmi = new JMenuItem("종료");
	private JMenuItem jmi0 = new JMenuItem("첫 화면");
	private JMenuItem jmi1 = new JMenuItem("가입");
	private JMenuItem jmi2 = new JMenuItem("로그인");
	private JMenuItem jmi3 = new JMenuItem("테이블 보기");
	private JLabel jl2 = new JLabel("회원가입", JLabel.CENTER);
	private JLabel jl3 = new JLabel("아이디", JLabel.CENTER);
	private JLabel jl4 = new JLabel("비밀번호", JLabel.CENTER);
	private JLabel jl5 = new JLabel("이름", JLabel.CENTER);
	private JLabel jl6 = new JLabel("성별", JLabel.CENTER);
	private JTextField jtf1 = new JTextField();
	private JPasswordField jpf = new JPasswordField();
	private JTextField jtf2 = new JTextField();
	private JRadioButton jrb1 = new JRadioButton("남");
	private JRadioButton jrb2 = new JRadioButton("여");
	private ButtonGroup bg = new ButtonGroup();
	private JButton jbt1 = new JButton("가입");
	private JButton jbt2 = new JButton("중복 확인");
	private Box bx = Box.createHorizontalBox();
	private int gen; // 성별
	private int check = 0;
	private String oldID; // 아이디 비교
	private String id;

	// 서브
	private JLabel jl7 = new JLabel("아이디", JLabel.CENTER);
	private JLabel jl8 = new JLabel("비밀번호", JLabel.CENTER);
	private JTextField jtf3 = new JTextField();
	private JPasswordField jpf1 = new JPasswordField();

	// 첫화면
	private JPanel jp2 = new JPanel();
	private JLabel jl10 = new JLabel("회원가입 프로그램");

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

		jl1.setFont(new Font("맑은고딕", Font.BOLD, 25));
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
		private JButton jbt3 = new JButton("로그인");

		public LoginCheck() {
			setTitle("로그인");
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
					JOptionPane.showMessageDialog(null, "아이디를 입력하세요.", "오류", JOptionPane.ERROR_MESSAGE);
				} else if (!id.equals("") && pw.equals("")) {
					JOptionPane.showMessageDialog(null, "비밀번호를 입력하세요.", "오류", JOptionPane.ERROR_MESSAGE);
				} else if (!id.equals("") && !pw.equals("")) {
					new LoginCheckTest(id, pw);
				}
			}
		}
	}
	
	public class LoginToTable extends JFrame implements ActionListener {

		private Container ct1 = getContentPane();
		private JButton jbt3 = new JButton("로그인");

		public LoginToTable() {
			setTitle("로그인");
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
					JOptionPane.showMessageDialog(null, "아이디를 입력하세요.", "오류", JOptionPane.ERROR_MESSAGE);
				} else if (!id.equals("") && pw.equals("")) {
					JOptionPane.showMessageDialog(null, "비밀번호를 입력하세요.", "오류", JOptionPane.ERROR_MESSAGE);
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
			gen = 1; // 남
		} else if (jrb2.isSelected()) {
			gen = 2; // 여
		}

		if (arg0.getSource() == jbt2) { // 중복 확인 버튼
			if (id.equals("")) { // 아이디가 빈칸인 경우
				JOptionPane.showMessageDialog(null, "아이디를 입력 하세요.", "오류", JOptionPane.ERROR_MESSAGE);
			} else {
				check = 1; // 중복 확인 여부 체크값으로 사용
				oldID = id; // 중복 확인 후 아이디 새로 변경시 기존 아이디와 비교시 사용
				new IdCheck(id); // 아이디 중복 체크 클래스
			}
		}

		if (arg0.getSource() == jmi1) {
			getContentPane().removeAll();
			jl2.setFont(new Font("맑은고딕", Font.BOLD, 20));
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
			if (id.equals("") || pw.equals("") || name.equals("") || (gen != 1 && gen != 2)) { // 모든 항목을 입력 안했을 경우
				JOptionPane.showMessageDialog(null, "항목을 전부 입력 하세요.", "오류", JOptionPane.ERROR_MESSAGE);
			} else if (check == 0) { // 아아디 중복 확인 안했을 경우
				JOptionPane.showMessageDialog(null, "아이디 중복 확인을 하세요.", "오류", JOptionPane.ERROR_MESSAGE);
			} else if (!oldID.equals(id)) { // 아이디 중복 확인 후 아이디 변경 시
				JOptionPane.showMessageDialog(null, "변경 된 아이디 중복 확인을 다시 하세요.", "오류", JOptionPane.ERROR_MESSAGE);
			} else if (JOptionPane.showConfirmDialog(null, "회원가입을 하시겠습니까?", "확인", JOptionPane.YES_NO_OPTION, // 확인창
					JOptionPane.INFORMATION_MESSAGE) != JOptionPane.NO_OPTION) {
				new InsertDB(id, pw, name, gen); // DB insert 클래스
				JOptionPane.showMessageDialog(null, "회원가입이 완료 되었습니다.", "완료", JOptionPane.INFORMATION_MESSAGE); // 확인창
			} else {
				JOptionPane.showMessageDialog(null, "회원가입이 취소 되었습니다.", "취소", JOptionPane.ERROR_MESSAGE); // 확인창
			}
		} else if (arg0.getSource() == jmi0) {
			getContentPane().removeAll();
			jp2.setLayout(new BorderLayout());
			jl10.setFont(new Font("맑은고딕", Font.BOLD, 25));
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
