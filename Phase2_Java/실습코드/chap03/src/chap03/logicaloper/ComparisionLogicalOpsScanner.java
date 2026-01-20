package chap03.logicaloper;

import java.util.Scanner;

public class ComparisionLogicalOpsScanner {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("=== 비교/논리 연산자 연습 ===");
		
		System.out.println("---기본 비교 연산---");
		System.out.print("첫 번째 정수 : ");
		while(!scanner.hasNextInt()) {
			System.out.print("잘못된 입력입니다. 정수를 입력하세요: ");
			scanner.next();
		}
		int a = scanner.nextInt();
		
		System.out.print("두 번째 정수 : ");
		while(!scanner.hasNextInt()) {
			System.out.print("잘못된 입력입니다. 정수를 입력하세요: ");
			scanner.next();
		}
		int b = scanner.nextInt();	
		
		// 삼항 연산자로 둘 중 큰값/작은값 구하기
		int bigger = (a > b) ? a : b;
		int smaller = (a < b) ? a : b;
		System.out.println("\n둘 중 큰 값: " + bigger);
		System.out.println("둘 중 작은 값: " + smaller);
		
		// 1. 짝수/홀수 판별기 
		System.out.println("---짝수/홀수 판별기---");
		System.out.print("숫자를 입력하세요 : ");
		while(!scanner.hasNextInt()) {
			System.out.print("잘못된 입력입니다. 정수를 입력하세요: ");
			scanner.next();
		}
		int number = scanner.nextInt();		
		
		String result = (number % 2 == 0) ? "짝수" : "홀수";
		System.out.println(number +"은(는) "+ result + "입니다.");
		
		// 2. 윤년 판별기 
		System.out.println("---윤년 판별기---");
		System.out.print("숫자를 입력하세요 : ");
		while(!scanner.hasNextInt()) {
			System.out.print("잘못된 입력입니다. 정수를 입력하세요: ");
			scanner.next();
		}	
		
		int year = scanner.nextInt();
		
		/*
		 * 윤년 조건 : (4의 배수 and 100의 배수 아님) or 400의 배수
		 */
		boolean isLeafYear = ((year % 4 ==0) && (year % 100 != 0)) || (year % 400 == 0); 
		System.out.println(year +"년은 윤년인가? "+ (isLeafYear ? "예" : "아니오"));
		
		if(isLeafYear) {
			System.out.println("-> " +year+ "년 2월은 29일까지 있습니다.");
		} else {
			System.out.println("-> " +year+ "년 2월은 28일까지 있습니다.");
		}
		
		// 3. 운전 자격 판단
		System.out.println("---운전 자격 판단---");
		System.out.print("나이를 입력하세요 : ");
		while(!scanner.hasNextInt()) {
			System.out.print("잘못된 입력입니다. 정수를 입력하세요: ");
			scanner.next();
		}	
		
		int age = scanner.nextInt();
		
		System.out.print("면허증은 있나요? (true/false): ");
		while(!scanner.hasNextBoolean()) {
			System.out.print("잘못된 입력입니다. true 또는 false를 입력하세요: ");
			scanner.next();
		}
		boolean hasLicense = scanner.nextBoolean();
		
		/*
		 * 복합 조건 : 논리자 AND (&&)로 3개 조건을 모두 만족해야 true
		 */
		boolean canDrive = (age >= 18) && (age < 80) && hasLicense;
		System.out.println("운전 가능 여부: " + (canDrive ? "가능" : "불가능"));
		
		if(!canDrive) {
			if(age < 18) {
				System.out.println("-> 이유 : 18세 미만입니다.");
			}
			if(age >= 80) {
				System.out.println("-> 이유 : 80세 이상입니다.(가상의 고령 제한)");
			}
			if(!hasLicense) {
				System.out.println("-> 이유 : 면허증이 없습니다.");
			}
		}
		
		// 4. 로그인 시스템 시뮬레이션
		/*
		 * 	문자열 비교 : equals() 메서드 사용
		 * 
		 * 		- == : 주소(참조) 비교 --> 같은 객체인지 확인
		 *        equals() : 내용(값) 비교 --> 문자열이 같은지 확인 
		 * 
		 */
		scanner.nextLine();		//버퍼 비우기 
		
		System.out.println("\n---로그인 시스템---");
		System.out.println("올바른 아이디: admin, 비밀번호: 1234");
		
		System.out.print("\n아이디를 입력하세요: ");
		String inputId = scanner.nextLine();			// 문자열 한 줄 입력받기
		System.out.print("\n비밀번호를 입력하세요: ");
		String inputPw = scanner.nextLine();			// 비밀번호 입력받기
		
		String correctId = "admin";
		String correntPw = "1234";
		
		boolean isMatch = inputId.equals(correctId);
		boolean pwMatch = inputPw.equals(correntPw);
		
		boolean loginSuccess = isMatch && pwMatch;
		
		System.out.println("\n 로그인 결과: " +(loginSuccess ? "성공!" : "실패"));
		if(!loginSuccess) {
			if(!isMatch) System.out.println("-> 아이디가 일치하지 않습니다.");
			if(!pwMatch) System.out.println("-> 패스워드가 일치하지 않습니다.");
		}
		
		
		scanner.close();
	}
}











