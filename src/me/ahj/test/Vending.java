package me.ahj.test;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Vending extends JFrame implements ActionListener {
	
	private Container ct = getContentPane();
	private JPanel jp = new JPanel();
	private JPanel jp1 = new JPanel();
	private JLabel jl = new JLabel("투입 금액", JLabel.CENTER);
	private JTextField jtf = new JTextField("");
	private ImageIcon img1 = new ImageIcon("img\\1.jpg");
	private JLabel jl_img1 = new JLabel(img1);

	public Vending() {
	setTitle("Vending");
	setSize(500, 500);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setLocationRelativeTo(null);
	
	ct.setLayout(new BorderLayout());
	jp.setLayout(new BorderLayout());
	jp.add(jl, BorderLayout.WEST);
	jp.add(jtf, BorderLayout.CENTER);
	
	jp1.add(jl_img1);

	ct.add(jp, BorderLayout.NORTH);
	ct.add(jp1, BorderLayout.CENTER);
	}

	public static void main(String[] args) {
		new Vending().setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		
	}
}
