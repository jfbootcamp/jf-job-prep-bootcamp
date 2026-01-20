package chap03.changecalc;

import java.util.Scanner;

public class ChangeCalculator {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("--- 거스름돈 계산 ---");
		System.out.print("물건 가격을 입력하세요 (원) : ");
		while(!scanner.hasNextInt()) {
			System.out.print("잘못된 입력입니다. 정수를 입력하세요: ");
			scanner.next();
		}
		int price = scanner.nextInt();
		
		
		System.out.print("지불 금액을 입력하세요 (원) : ");
		while(!scanner.hasNextInt()) {
			System.out.print("잘못된 입력입니다. 정수를 입력하세요: ");
			scanner.next();
		}
		int payment = scanner.nextInt();		
		
		if(payment < price) {
			System.out.println("지불 금액이 부족합니다!");
		} else {
			int change = payment - price;
			System.out.println("거스름돈 : " +change+ "원");
			
			// 동전 계산 (Greedy Algorithm - 탐욕 알고리즘 적용)
			int tempChange = change;				// 거스름돈을 임시 변수에 할당
			int coins1000 = tempChange / 1000;		//	1000원권 개수 계산
			tempChange %= 1000;						// 1000원 처리 후 나머지 (tempChange = tempChange % 1000;)
			
			int coins500 = tempChange / 500;		// 500원 동전 개수 계산
			tempChange = tempChange % 500;			// 500원 처리 후 나머지 
			
			int coins100 = tempChange / 100;		// 100원 동전 개수 계산
			tempChange = tempChange % 100;			// 100원 처리 후 나머지 
			
			int conis50 = tempChange / 50;			// 50원 동전 개수 계산
			tempChange = tempChange % 50;			// 50원 처리 후 나머지 
			
			int coins10 = tempChange / 10;			// 10원 동전 개수 계산
			
			System.out.println("\n 최소 동전/지폐 개수:");
			if(coins1000 > 0) System.out.println("1000원: " + coins1000 + "장");
			if(coins500 > 0) System.out.println("500원: " + coins500 + "개");
			if(coins100 > 0) System.out.println("100원: " + coins100 + "개");
			if(conis50 > 0) System.out.println("50원: " + conis50 + "개");
			if(coins10 > 0) System.out.println("10원: " + coins10 + "개");
			
		}
		
		scanner.close();
	}

}

















