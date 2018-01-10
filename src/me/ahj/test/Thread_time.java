package me.ahj.test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Thread_time implements Runnable {

	private Thread t;

	public Thread_time() {
		t = new Thread(this);
		t.start();
	}

	public static void main(String[] args) {
		new Thread_time();
	}

	public void run() {

		while (true) {
			try {
				SimpleDateFormat sdf = new SimpleDateFormat("Y-MM-DD hh:mm:ss");
				Date date = new Date();
				String time = sdf.format(date);
				System.out.println(time);
				Thread.sleep(1000);
			} catch (Exception e) {
				System.out.println("Thread.Error");
			}
		}
	}
}
