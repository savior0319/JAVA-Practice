package me.ahj.test;

import java.util.*;

public class LCM_GCD {

	private int temp;

	public LCM_GCD(int num1, int num2) {

		temp = num1 * num2;

		if (num1 > num2) {
			for (int i = num1; i <= temp; i++) {
				if ((i % num1 == 0) && (i % num2) == 0) {
					System.out.println("�ּҰ���� : " + i);
					break;
				}
			}
			for (int i = num1; i >= 1; i--) {
				if ((num1 % i == 0) && (num2 % i == 0)) {
					System.out.println("�ִ����� : " + i);
					System.out.println("---------------------------------------------");
					break;
				}
			}
		}

		else if (num1 < num2) {
			for (int i = num2; i <= temp; i++) {
				if ((i % num1 == 0) && (i % num2) == 0) {
					System.out.println("�ּҰ���� : " + i);
					break;
				}
			}
			for (int i = num2; i >= 1; i--) {
				if ((num1 % i == 0) && (num2 % i == 0)) {
					System.out.println("�ִ����� : " + i);
					System.out.println("---------------------------------------------");
					break;
				}
			}
		}

		else if (num1 == 0 && num2 == 0) {
			System.out.println("���α׷��� �����մϴ�.");
			System.out.println("---------------------------------------------");
		} else if ((num1 == num2) && (num1 != 0) && (num2 != 0)) {
			System.out.println("�ּҰ���� : " + num1);
			System.out.println("�ִ����� : " + num1);
			System.out.println("---------------------------------------------");
		}
	}

	public static void main(String[] args) {

		boolean start = true;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("------------�ּ� ����� & �ִ����� ���ϱ�------------");

		while (start) {
			System.out.println("�� ������ �Է��ϼ���. (0, 0 �Է� �� ���α׷� ����)");
			System.out.print("ù ��° ���� : ");
			int num1 = sc.nextInt();
			System.out.print("�� ��° ���� : ");
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
