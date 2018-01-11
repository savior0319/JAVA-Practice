package me.ahj.test;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class GUI extends JFrame implements ActionListener {
	
	private Container ct = getContentPane();
	private JButton jbt = new JButton("버튼입니다");
	
	
	public GUI() {
		setTitle("GUI TEST");
		setSize(300, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		
		ct.setLayout(new BorderLayout());
		ct.add(jbt, BorderLayout.CENTER);
		
		jbt.addActionListener(this);
		
	}

	public static void main(String[] args) {
		new GUI().setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand()=="버튼입니다") {
			JOptionPane.showMessageDialog(null, "버튼을 눌렀습니다");
		}
	}

}
