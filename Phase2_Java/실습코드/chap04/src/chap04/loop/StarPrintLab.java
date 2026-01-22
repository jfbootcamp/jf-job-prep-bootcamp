package chap04.loop;

import java.util.Scanner;

/*
 * 	1. 직각삼각형 
 * 
 * 		- 출력 결과 (height = 7)
 * 		
 * 		*
 * 		**
 * 		***
 * 		****
 * 		*****
 * 		******
 * 		*******	
 */

public class StarPrintLab {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("=== 별 찍기: 다양한 구현 방법 비교 ===\n");
		
		System.out.print("높이를 입력하세요: ");
		while(!scanner.hasNextInt()) {
			System.out.println("잘못된 입력입니다. 정수를 입력하세요: ");
			scanner.next();
		}
		int height = scanner.nextInt();		
		
		System.out.println("\n--- 방법 1: 기본 중첩 for문 ---");
		for(int i = 1; i <= height; i++) {		// i = 현재 행 번호 (1행, 2행,...)
			for(int j = 1; j <= i; j++) {		// 각 행마다 i개의 별 출력 (1행=1개, 2행=2개,...)
				System.out.print("*");
			}
			System.out.println(); 				// 한 행 출력 후 줄바꿈
		}
		
		
		System.out.println("\n--- 방법 2: 0부터 시작하는 인덱스 ---");
		for(int i = 0; i < height; i++) {		// i = 0, 1, 2, ....
			for(int j = 0; j <= i; j++) {		// j가 0부터 i까지 --> i + 1까지 출력
				System.out.print("*");
			}
			System.out.println(); 				// 한 행 출력 후 줄바꿈
		}
				
		
		// 방법 3: String의 repeat() 메서드 사용 (Java 11+)
		System.out.println("\n--- 방법 3: repeat() 메서드 사용 (Java 11+) ---");
		for(int i = 1; i <= height; i++) {
			System.out.println("*".repeat(i));
		}
		
		// 방법 4: StringBuilder 사용 (가장 효율적)
		System.out.println("\n--- 방법 4: StringBuilder 사용 (가장 효율적) ---");
		StringBuilder sb = new StringBuilder();	   // sb = "" (빈 문자열)
		for(int i = 1; i <= height; i++) {
			sb.append("*");		// 기존 문자열에 "*" 추가 (누적, 지우지 않음)
			System.out.println(sb);   // 누적된 전체 출력 
		}
		
		// 방법 5: while문 사용
		System.out.println("\n--- 방법 5: while문 사용 ---");
		
		scanner.close();
	}
}

















