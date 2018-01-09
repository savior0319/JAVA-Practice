package me.ahj.study;

import java.util.Scanner;

public class Main {

	public Main() {
		
		Scanner sc = new Scanner(System.in);
		Object ob1 = new Object();
		Object ob2 = new Object();

		while (ob1.start) {
			System.out.print("첫 번째 숫자를 입력하세요: ");
			ob1.num = sc.nextInt();
			System.out.print("두 번째 숫자를 입력하세요 : ");
			ob2.num = sc.nextInt();

			ob1.result = ob1.num + ob2.num;
			System.out.println("결과 : " + ob1.result);

		}
		sc.close();
	}

	public static void main(String[] args) {
		new Main();
	}
}
