package me.ahj.test;

import java.util.*;

public class RCP {

	private int rannum;
	static int user;

	public RCP(int user) {

		Random ran = new Random();
		
		for (int i = 0; i < 3; i++) {
			rannum = ran.nextInt(3) + 1;
		}

		if (user == 1) {
			System.out.println("USER : ������ �½��ϴ�");
			if (rannum == 2) {
				System.out.println("COM : ������ �½��ϴ�");
				System.out.println("�й�");
				System.out.println();
			} else if (rannum == 1) {
				System.out.println("COM : ������ �½��ϴ�");
				System.out.println("���¹�");
				System.out.println();
			} else if (rannum == 3) {
				System.out.println("COM : ���� �½��ϴ�");
				System.out.println("�¸�");
				System.out.println();
			}

		} else if (user == 2) {
			System.out.println("USER : ������ �½��ϴ�");
			if (rannum == 2) {
				System.out.println("COM : ������ �½��ϴ�");
				System.out.println("���¹�");
				System.out.println();
			} else if (rannum == 1) {
				System.out.println("COM : ������ �½��ϴ�");
				System.out.println("�¸�");
				System.out.println();
			} else if (rannum == 3) {
				System.out.println("COM : ���� �½��ϴ�");
				System.out.println("�й�");
				System.out.println();
			}

		} else if (user == 3) {
			System.out.println("USER : ���� �½��ϴ�");
			if (rannum == 2) {
				System.out.println("COM : ������ �½��ϴ�");
				System.out.println("�¸�");
				System.out.println();
			} else if (rannum == 1) {
				System.out.println("COM : ������ �½��ϴ�");
				System.out.println("�й�");
				System.out.println();
			} else if (rannum == 3) {
				System.out.println("COM : ���� �½��ϴ�");
				System.out.println("���º�");
				System.out.println();
			}

		}

		else {
			if (user != 4)
				System.out.println("1~4���� �Է��ϼ���");
				System.out.println();
		}

	}

	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		boolean start = true;

		System.out.println("-----����������-----");
		while (start) {
			System.out.println("1. ����");
			System.out.println("2. ����");
			System.out.println("3. ��");
			System.out.println("4. ����");
			System.out.println();
			System.out.print("���� : ");
			
			try {
			user = sc.nextInt();
			} catch (Exception e) {
				System.out.println("���ڸ� �Է��ϼ���");
				break;
			}

			System.out.println();

			new RCP(user);

			if (user == 4) {
				System.out.println("���α׷� ����");
				sc.close();
				start = false;
			}

		}
	}
}
