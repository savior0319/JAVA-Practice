package me.ahj.study;

import java.util.Scanner;

public class Main {

	public Main() {
		
		Scanner sc = new Scanner(System.in);
		Object ob1 = new Object();
		Object ob2 = new Object();

		while (ob1.start) {
			System.out.print("ù ��° ���ڸ� �Է��ϼ���: ");
			ob1.num = sc.nextInt();
			System.out.print("�� ��° ���ڸ� �Է��ϼ��� : ");
			ob2.num = sc.nextInt();

			ob1.result = ob1.num + ob2.num;
			System.out.println("��� : " + ob1.result);

		}
		sc.close();
	}

	public static void main(String[] args) {
		new Main();
	}
}
