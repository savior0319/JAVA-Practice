package me.ahj.study;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Swing extends JFrame implements ActionListener {
	
	private Container ct = new Container();
	private JButton jb = new JButton("asdasd");
	private JLabel jl = new JLabel("Label");
	
	public Swing() {
		setTitle("½ºÀ®Å×½ºÆ®");
		setSize(300,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		
		ct.setLayout(new BorderLayout());
		ct.add(jl, BorderLayout.NORTH);
		ct.add(jb, BorderLayout.CENTER);
		
	}

	public static void main(String[] args) {
		new Swing().setVisible(true);
	}

	public void actionPerformed(ActionEvent arg0) {
		
	}

}