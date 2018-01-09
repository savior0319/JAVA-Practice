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
			System.out.println("USER : 가위를 냈습니다");
			if (rannum == 2) {
				System.out.println("COM : 바위를 냈습니다");
				System.out.println("패배");
				System.out.println();
			} else if (rannum == 1) {
				System.out.println("COM : 가위를 냈습니다");
				System.out.println("무승무");
				System.out.println();
			} else if (rannum == 3) {
				System.out.println("COM : 보를 냈습니다");
				System.out.println("승리");
				System.out.println();
			}

		} else if (user == 2) {
			System.out.println("USER : 바위를 냈습니다");
			if (rannum == 2) {
				System.out.println("COM : 바위를 냈습니다");
				System.out.println("무승무");
				System.out.println();
			} else if (rannum == 1) {
				System.out.println("COM : 가위를 냈습니다");
				System.out.println("승리");
				System.out.println();
			} else if (rannum == 3) {
				System.out.println("COM : 보를 냈습니다");
				System.out.println("패배");
				System.out.println();
			}

		} else if (user == 3) {
			System.out.println("USER : 보를 냈습니다");
			if (rannum == 2) {
				System.out.println("COM : 바위를 냈습니다");
				System.out.println("승리");
				System.out.println();
			} else if (rannum == 1) {
				System.out.println("COM : 가위를 냈습니다");
				System.out.println("패배");
				System.out.println();
			} else if (rannum == 3) {
				System.out.println("COM : 보를 냈습니다");
				System.out.println("무승부");
				System.out.println();
			}

		}

		else {
			if (user != 4)
				System.out.println("1~4까지 입력하세요");
				System.out.println();
		}

	}

	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		boolean start = true;

		System.out.println("-----가위바위보-----");
		while (start) {
			System.out.println("1. 가위");
			System.out.println("2. 바위");
			System.out.println("3. 보");
			System.out.println("4. 종료");
			System.out.println();
			System.out.print("선택 : ");
			
			try {
			user = sc.nextInt();
			} catch (Exception e) {
				System.out.println("숫자만 입력하세요");
				break;
			}

			System.out.println();

			new RCP(user);

			if (user == 4) {
				System.out.println("프로그램 종료");
				sc.close();
				start = false;
			}

		}
	}
}
