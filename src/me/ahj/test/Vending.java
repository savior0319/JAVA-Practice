package me.ahj.test;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Vending extends JFrame implements ActionListener {

	private Container ct = getContentPane();
	private JPanel jp1 = new JPanel();
	private JPanel jp2 = new JPanel();
	private JPanel jp_img = new JPanel();
	private JPanel jp_vending = new JPanel();
	private JPanel jp_button = new JPanel();
	private JLabel jl = new JLabel("투입 금액", JLabel.CENTER);
	private JTextField jtf = new JTextField();
	private ImageIcon img1 = new ImageIcon("img\\1.jpg");
	private ImageIcon img2 = new ImageIcon("img\\2.jpg");
	private ImageIcon img3 = new ImageIcon("img\\3.jpg");
	private ImageIcon img4 = new ImageIcon("img\\4.jpg");

	private JLabel jl_img1 = new JLabel(img1);
	private JLabel jl_img2 = new JLabel(img2);
	private JLabel jl_img3 = new JLabel(img3);
	private JLabel jl_img4 = new JLabel(img4);

	private JButton jbt1 = new JButton("사이다 (800원)");
	private JButton jbt2 = new JButton("콜라 (1000원)");
	private JButton jbt3 = new JButton("밀키스 (700원)");
	private JButton jbt4 = new JButton("포카리 (800원)");
	private JButton jbt5 = new JButton("구매");

	private JLabel jl1 = new JLabel("거스름돈 : ");
	private JLabel jl2 = new JLabel("");

	private int input, output, price = 0;
	private int count1, count2, count3, count4 = 0;

	public Vending() {
		setTitle("Vending");
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);

		ct.setLayout(new BorderLayout());
		jp1.setLayout(new BorderLayout());
		jp1.add(jl, BorderLayout.WEST);
		jp1.add(jtf, BorderLayout.CENTER);
		jp_vending.setLayout(new BorderLayout());
		jp_img.setLayout(new GridLayout(1, 4));
		jp_button.setLayout(new GridLayout(1, 4));
		jp_img.add(jl_img1);
		jp_img.add(jl_img2);
		jp_img.add(jl_img3);
		jp_img.add(jl_img4);
		jp_button.add(jbt1);
		jp_button.add(jbt2);
		jp_button.add(jbt3);
		jp_button.add(jbt4);
		jp_vending.add(jp_img, BorderLayout.NORTH);
		jp_vending.add(jp_button, BorderLayout.CENTER);
		jp_vending.add(jbt5, BorderLayout.SOUTH);
		jp2.setLayout(new BorderLayout());
		jp2.add(jl1, BorderLayout.WEST);
		jp2.add(jl2, BorderLayout.CENTER);

		ct.add(jp1, BorderLayout.NORTH);
		ct.add(jp_vending, BorderLayout.CENTER);
		ct.add(jp2, BorderLayout.SOUTH);

		jbt1.addActionListener(this);
		jbt2.addActionListener(this);
		jbt3.addActionListener(this);
		jbt4.addActionListener(this);
		jbt5.addActionListener(this);
	}

	public static void main(String[] args) {
		new Vending().setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == jbt1) {
			price += 800;
			count1++;
			//System.out.println("사이다");

		} else if (e.getSource() == jbt2) {
			price += 1000;
			count2++;
			//System.out.println("콜라");

		} else if (e.getSource() == jbt3) {
			price += 700;
			count3++;
			//System.out.println("밀키스");

		} else if (e.getSource() == jbt4) {
			price += 800;
			count4++;
			//System.out.println("포카리");

		} else if (e.getSource() == jbt5) {
			input = Integer.parseInt(jtf.getText());
			output = input - price;
			String output_str = String.valueOf(output);
			String count1_str = String.valueOf(count1);
			String count2_str = String.valueOf(count2);
			String count3_str = String.valueOf(count3);
			String count4_str = String.valueOf(count4);
			if (output >= 0) {
				jl2.setText(output_str + "원  / " + "사이다 : " + count1_str + "개 / " + "콜라 : " + count2_str + "개 / "
						+ "밀키스 : " + count3_str + "개 / " + "포카리 : " + count4_str + "개 / ");
			} else
				jl2.setText("잔액이 부족합니다 ");

		}

	}
}
