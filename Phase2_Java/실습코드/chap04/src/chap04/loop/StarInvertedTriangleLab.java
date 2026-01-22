package chap04.loop;

import java.util.Scanner;

/*
 * 	2. 별 찍기 (역삼각형) 
 * 
 * 		- 출력 결과 (height = 7)
 * 
 * 		*******
 * 		******
 * 		*****
 * 		****
 * 		***
 * 		**
 * 		*
 * 
 * 		- 직각삼각형 vs 역삼각형 비교
 * 			- 직각삼각형 : i가 1부터 height까지 증가 --> 별 개수도 1개부터 증가
 * 			- 역삼각형 : i가 height부터 1까지 감소 --> 별 갯도 height개부터 감소 
 * 			- 핵심 차이 : for문의 초기값, 조건, 증감식
 * 				- 직각삼각형 : for(int i = 1; i <= height; i++)
 * 				- 역삼각형 : for(int i = height ; i >= 1; i--)	
 * 	
 * 			
 */
public class StarInvertedTriangleLab {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("=== 별 찍기: 다양한 구현 방법 비교 ===\n");
		
		System.out.print("높이를 입력하세요: ");
		while(!scanner.hasNextInt()) {
			System.out.println("잘못된 입력입니다. 정수를 입력하세요: ");
			scanner.next();
		}
		int height = scanner.nextInt();	
		
		System.out.println("\n--- 방법 1: 기본 중첩 for문 (i 감소) ---");
		for(int i = height; i >= 1; i--) {  // i=heigt부터 1까지 감소
			for(int j = 1; j <= i; j++) {   // 각 행마다 i개의 별 출력 
				System.out.print("*");
			}
			System.out.println();           // 한 행 출력 후 줄바꿈 
		}
		
		/*
		 * 동작 원리 (height = 4 예시)
		 * i = 4: j가 i=4 반복 --> **** 출력
		 * i = 3: j가 i=3 반복 --> *** 출력
		 * i = 2: j가 i=2 반복 --> ** 출력
		 * i = 1: j가 i=1 반복 --> * 출력
		 */
		
		
		// 방법 2: i는 증가, 별 개수를 (height - i + 1)로 계산
		System.out.println("\n--- 방법 2: i 증가, 별 개수 계산 ---");
		for(int i = 1; i <= height; i++) {		// i = 1부터 height까지 증가
			for(int j = 1; j <= height - i + 1; j++) {  // 별 개수 = height - i + 1
				System.out.print("*");
			}
			System.out.println();
		}
		
		/*
		 * 동작 원리 (height = 4 예시)
		 * i = 1:  별 개수 = 4 - 1 + 1 --> **** 출력
		 * i = 2:  별 개수 = 4 - 2 + 1 --> *** 출력
		 * i = 3:  별 개수 = 4 - 3 + 1 --> ** 출력
		 * i = 4:  별 개수 = 4 - 4 + 1 --> * 출력
		 */		
		
		// 방법 3: String의 repeat() 메서드 사용 (Java 11+)
		System.out.println("\n--- 방법 3:  repeat() 메서드 사용 (Java 11+) ---");
		for(int i = height; i >= 1; i--) {
			System.out.println("*".repeat(i));
		}
		
		// 방법 4: StringBuilder 사용 (역순 출력)
		System.out.println("\n--- 방법 4: StringBuilder 사용 (가장 효율적) ---");
		StringBuilder sb = new StringBuilder("*".repeat(height)); 
		for(int i = height; i >= 1; i--) {
			System.out.println(sb); 		// 현재 상태 출력
			if(sb.length()>0) {
				sb.deleteCharAt(sb.length()-1);	// 마지막 문자 삭제
			}
		}
		
		/*
		 * StringBuilder로 역삼각형 만들기
		 *  1. 먼저 height개의 별로 시작
		 *  2. 매 반복마다 마지막 문자 삭제(deleteCharAt)
		 * 
		 * 동작 원리 (height = 4 예시)
		 * 초기 :  sb = "****"  -->  출력 : ****
		 * i = 1:  sb = "***"  -->  출력 : ***
		 * i = 2:  sb = "**"  -->  출력 : **
		 * i = 3:  sb = "*"  -->  출력 : *
		 */			
		
		// 방법 5: while문 사용
		System.out.println("\n--- 방법 5: while문 사용 ---");
		int i = height;
		while(i >= 1) {		// i가 1 이상인 동안 반복
			int j = 1;
			while(j <= i) {		// j가 i 이하인 동안 별 출력
				System.out.print("*");
				j++;
			}
			System.out.println();
			i--;		// i 감소 (역순)
		}
		
		
		scanner.close();
	}
}











