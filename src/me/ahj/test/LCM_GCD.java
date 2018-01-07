package me.ahj.test;

import java.util.*;

public class LCM_GCD {

	private int temp;

	public LCM_GCD(int num1, int num2) {

		temp = num1 * num2;

		if (num1 > num2) {
			for (int i = num1; i <= temp; i++) {
				if ((i % num1 == 0) && (i % num2) == 0) {
					System.out.println("최소공배수 : " + i);
					break;
				}
			}
			for (int i = num1; i >= 1; i--) {
				if ((num1 % i == 0) && (num2 % i == 0)) {
					System.out.println("최대공약수 : " + i);
					System.out.println("---------------------------------------------");
					break;
				}
			}
		}

		else if (num1 < num2) {
			for (int i = num2; i <= temp; i++) {
				if ((i % num1 == 0) && (i % num2) == 0) {
					System.out.println("최소공배수 : " + i);
					break;
				}
			}
			for (int i = num2; i >= 1; i--) {
				if ((num1 % i == 0) && (num2 % i == 0)) {
					System.out.println("최대공약수 : " + i);
					System.out.println("---------------------------------------------");
					break;
				}
			}
		}

		else if (num1 == 0 && num2 == 0) {
			System.out.println("프로그램을 종료합니다.");
			System.out.println("---------------------------------------------");
		} else if ((num1 == num2) && (num1 != 0) && (num2 != 0)) {
			System.out.println("최소공배수 : " + num1);
			System.out.println("최대공약수 : " + num1);
			System.out.println("---------------------------------------------");
		}
	}

	public static void main(String[] args) {

		boolean start = true;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("------------최소 공배수 & 최대공약수 구하기------------");

		while (start) {
			System.out.println("두 정수를 입력하세요. (0, 0 입력 시 프로그램 종료)");
			System.out.print("첫 번째 정수 : ");
			int num1 = sc.nextInt();
			System.out.print("두 번째 정수 : ");
			int num2 = sc.nextInt();

			new LCM_GCD(num1, num2);
			System.out.println();
			System.out.println();

			if ((num1 == 0) && (num2 == 0)) {
				start = false;
				sc.close();

			}
		}
	}
}
