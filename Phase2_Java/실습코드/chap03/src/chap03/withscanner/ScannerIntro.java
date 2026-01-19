package chap03.withscanner;

import java.util.Scanner;

public class ScannerIntro {

	public static void main(String[] args) {
		
		// 1. Scanner 객체 생성
		// System.in : 표준 입력(키보드)을 의미 
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("=== Scanner 기본 사용법 ===");
		
		// 2. 문자열 입력 받기
		System.out.print("이름을 입력하세요: ");
		String name = scanner.nextLine();
		System.out.println("안녕하세요, " + name + "님!\n");
		
		// 3. 정수 입력받기 (입력 검증 포함)
		System.out.print("나이를 입력하세요: ");
		/*
		 * hasNextInt() : 입력 버퍼에 있는 다음 토큰이 정수로 변환 가능한지 확인
		 * 				  정수면 true, 아니면 false 반환
		 * 				  실제로 값을 읽지 않고 "미리 확인"만 함 (peek 동작)
		 * 
		 * while() 루프 동작 원리
		 * 	 1) hasNextInt()가 false면 --> 정수가 아님 --> 루프 진입
		 * 	 2) 에러 메시지 출력
		 *   3) scanner.next()로 잘못된 입력을 버퍼에서 제거
		 *   4) 다시 hasNextInt() 검사 반복
		 *   5) hasNextInt()가 true면 --> 정수임 --> 	루프 종료
		 */
		while(!scanner.hasNextInt()) {
			System.out.print("잘못된 입력입니다. 정수를 입력하세요: ");
			scanner.next();			// 잘못된 입력이 버퍼에 그대로 남아있으면 무한루프 발생, 해당 토큰을 소비(제거,버리기) 
		}
		int age = scanner.nextInt();
		System.out.println("입력한 나이 : " + age + "살\n");
		
		// 4. 실수 입력받기 (입력 검증 포함)
		System.out.print("키를 입력하세요 (cm): ");
		
		/*
		 * 	hasNextInt()와 hasNextDouble() 차이점
		 * 		hasNextInt(): "25" -> true, "25.5" -> false,  "abc" -> false
		 * 		hasNextDouble() : "25" -> true, "25.5" -> true,  "abc" -> false
		 */
		while(!scanner.hasNextDouble()) {
			System.out.print("잘못된 입력입니다. 숫자를 입력하세요: ");
			scanner.next();			// 잘못된 입력 제거
		}
		double height = scanner.nextDouble();
		System.out.println("입력한 키: " +height+ "cm\n");
		
		// 5. 여러 값 한 번에 입력받기 (입력 검증 포함)
		System.out.println("=== 여러 값 입력받기 ===");
		System.out.print("두 정수를 공백으로 구분하여 입력하세요: ");
		
		// 첫번째 정수 검증
		while(!scanner.hasNextInt()) {
			System.out.print("잘못된 입력입니다. 정수를 입력하세요: ");
			scanner.next();
		}
		int num1 = scanner.nextInt();
		
		// 두번째 정수 검증
		while(!scanner.hasNextInt()) {
			System.out.print("두 번째 정수를 입력하세요: ");
			scanner.next();
		}
		int num2 = scanner.nextInt();	
		
		System.out.println("입력된 값: " +num1+ ", " +num2);
		System.out.println("합계: " +(num1+num2)+ "\n");
		
		// 6. nextLine()
		// nextInt(), nextDouble() 후에 nextLine()을 사용할 때 --> 버퍼에 남은 엔터키를 처리해야 함 
		scanner.nextLine();		// 버퍼 비우기 (이전 nextInt()의 엔터키 소비)
		
		System.out.println("=== nextLine() 버퍼 처리 ===");
		System.out.print("좋아하는 음식을 입력하세요:");
		String food = scanner.nextLine();
		System.out.println("좋아하는 음식: " +food+ "\n");
		
		/*
		 *     while  vs do~while문
		 *     
		 *    while문:     		do~while문	
		 *    	조건 검사				블록 실행    <----- 무조건 1번 실행
		 *    	   |                   |
		 *    	  \|/                 \|/
		 *      블록 실행	            조건 검사    <------ 실행 후 검사 
		 *      	
		 *    문법 구조 
		 *    	do {
		 *    
		 *      } while(조건);
		 *      
		 *    do~while 언제 사용하나?   
		 *    	1) 사용자 입력을 최소 1번은 받아야 할때 
		 *    	2) 메뉴 선택 (일단 보여주고 --> 선택 검증)
		 *      3) 게임 루프 (일단 실행 --> 종료 조건 확인)
		 *      4) 입력값 범위 검증 (일단 받고 --> 유효한지 확인)
		 *    
		 */
		
		// 7. 자기소개 프로그램 (입력 검증 포함)
		System.out.println("=== 자기소개 프로그램 ===");
		System.out.println("정보를 입력해주세요");
		
		System.out.print("학번: ");
		String studentId = scanner.nextLine();
		
		System.out.print("학과: ");
		String major = scanner.nextLine();
		
		System.out.print("학년 (1~4): ");
		int grade;
		
		do {
			while(!scanner.hasNextInt()) {
				System.out.print("잘못된 입력입니다. 정수를 입력해세요: ");
				scanner.next();
			}
			grade = scanner.nextInt();
			if(grade < 1 || grade > 4) {
				System.out.print("1~4 사이의 값을 입력하세요: ");
			}
		} while(grade < 1 || grade > 4);
		
		
		
		System.out.print("학점 (0.0~4.5): ");
		double gpa;
		
		do {
			while(!scanner.hasNextDouble()) {
				System.out.print("잘못된 입력입니다. 숫자를 입력해세요: ");
				scanner.next();
			}
			gpa = scanner.nextDouble();
			if(gpa < 0.0 || gpa > 4.5) {
				System.out.print("0.0~4.5 사이의 값을 입력하세요: ");
			}
		} while(gpa < 0.0 || gpa > 4.5);		
		
		System.out.println("--- 입력한 부분 ---");
		System.out.println("이름 : " + name);
		System.out.println("학번 : " + studentId);
		System.out.println("학과 : " + major);
		System.out.println("학년 : " + grade + "학년");
		System.out.printf("학점: %.2f\n", gpa);
		
		scanner.close();	// 사용이 끝난 Scanner는 close()로 닫아주는 것이 좋은 습관 (자원 해제)
		
	}
}










