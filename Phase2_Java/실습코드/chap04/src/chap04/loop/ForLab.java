package chap04.loop;

import java.util.Scanner;

public class ForLab {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("---1. 1부터 N까지 출력---");
		System.out.print("N 값을 입력하세요: ");
		while(!scanner.hasNextInt()) {
			System.out.println("잘못된 입력입니다. 정수를 입력하세요: ");
			scanner.next();
		}
		int n = scanner.nextInt();
		for(int i = 1; i <= n; i++) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		System.out.println("---2. 합계 계산---");
		System.out.print("합계를 구할 범위 시작값: ");
		while(!scanner.hasNextInt()) {
			System.out.println("잘못된 입력입니다. 정수를 입력하세요: ");
			scanner.next();
		}
		int start = scanner.nextInt();
		
		System.out.print("합계를 구할 범위 끝값: ");
		while(!scanner.hasNextInt()) {
			System.out.println("잘못된 입력입니다. 정수를 입력하세요: ");
			scanner.next();
		}
		int end = scanner.nextInt();
		
		int sum = 0;
		for(int i = start; i <= end; i++) {
			sum += i;
		}
		
		System.out.println(start +"부터 "+end+ "까지의 합: " + sum);
		
		// 3. 구구단 출력
		System.out.println("\n--- 3. 구구단 출력 ---");
		System.out.print("몇 단을 출력할까요? (2-9): ");
		while(!scanner.hasNextInt()) {
			System.out.println("잘못된 입력입니다. 정수를 입력하세요: ");
			scanner.next();
		}	
		int dan = scanner.nextInt();
		
		if(dan >= 2 && dan <= 9) {		// 2-9 범위인지 검사
			System.out.println("\n=== " +dan+ "단 ===");
			for(int i = 1; i <= 9; i++) {
				System.out.printf("%d * %d = %2d%n", dan, i, dan*i);
			}
			
		} else {
			System.out.println("2에서 9 사이의 숫자를 입력하세요.");
		}
		
		
		
		// 3-1. 구구단 출력
		System.out.println("\n--- 3-1. 구구단 출력 (재입력 버전) ---");	
		int dan2;
		while(true) {
			System.out.print("몇 단을 출력할까요? (2-9): ");
			while(!scanner.hasNextInt()) {
				System.out.println("잘못된 입력입니다. 정수를 입력하세요: ");
				scanner.next();
			}
			dan2 = scanner.nextInt();
			
			if (dan2 >= 2 && dan2 <= 9) {		// 2-9 범위인지 검사
				break;		// 유효한 값(2~9)이면 while(true) 무한 루프 탈출
			}
			
			System.out.println("2에서 9 사이의 숫자를 입력하세요.");		
		}
		
		System.out.println("\n=== " +dan2+ "단 ===");
		for(int i = 1; i <= 9; i++) {
			System.out.printf("%d * %d = %2d%n", dan2, i, dan2*i);
		}		
		
		
		/*
		 * 4. 팩토리얼(Factorial) 계산 
		 * 	   1) n! = n * (n-1) * (n-2) * 2 * 1	
		 * 	   2) 활용 사례
		 * 			- 추천 알고리즘 : 사용자에게 보여줄 상품 조합 계산 
		 * 			- 게임 개발 : 아이템 조합, 캐릭터 스킬 배치 경우의 수 
		 * 			- 통계/데이터 분석 : 확률 계산
		 * 			- 암호학 : 비밀번호 경우의 수		
		 */
		
		System.out.println("\n---4. 팩토리얼(Factorial) 계산 ---");
		System.out.print("팩토리얼을 계산할 숫자 (0-20): ");
		while(!scanner.hasNextInt()) {
			System.out.print("잘못된 입력입니다. 정수를 입력하세요: ");
			scanner.next();
		}
		
		int num = scanner.nextInt();
		
		if(num >= 0 && num <= 20) {		// 0-20 범위인지 검사 (long 오버플로우 방지)
			long factorial = 1;
			for(int i = 1; i <= num; i++) {
				factorial *= i;			// 1 * 2 * .... * num
			}
			System.out.println(num + "! = " + factorial);
		} else {
			System.out.println("0에서 20 사이의 숫자를 입력하세요.");
		}
		
		// 4-1. 팩토리얼(Factorial) 계산 (올바른 값 입력까지 반복)
		System.out.println("\n---4-1. 팩토리얼 계산 (재입력 버전) ---");
		
		scanner.close();
	}

}












