package me.ahj.test;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Thread_time extends JFrame implements Runnable {

	private Container ct = getContentPane();
	private JLabel jl = new JLabel("test", JLabel.CENTER);
	private Thread t;

	public Thread_time() {
		
		setTitle("≈∏¿Ã∏”");
		setResizable(false);
		setSize(250, 100);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ct.setLayout(new BorderLayout());
		jl.setFont(new Font("∏º¿∫∞ÌµÒ", Font.BOLD, 20));
		ct.add(jl, BorderLayout.CENTER);
		
		
		
		t = new Thread(this);
		t.start();
	}

	public static void main(String[] args) {
		new Thread_time().setVisible(true);
	}

	public void run() {

		while (true) {
			try {
				SimpleDateFormat sdf = new SimpleDateFormat("Y-MM-DD hh:mm:ss");
				Date date = new Date();
				String time = sdf.format(date);
				jl.setText(time);
				Thread.sleep(1000);
			} catch (Exception e) {
				System.out.println("Thread.Error");
			}
		}
	}
}
