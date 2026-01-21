package chap03.logicaloper;

import java.util.Scanner;

public class LoginSystemWithRetry {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("=== 로그인 시스템 (재시도 버전) ===\n");

		// 올라른 인증 정보 (실제로 DB에서 가져옴)
		String correctId = "admin";
		String correctPw = "1234";
		
		final int MAX_ATTEMPTS = 3;			// 최대 시도 횟수 (상수)
		int attemptCount = 0;				// 현재 시도 횟수 
		boolean loginSuccess = false;		// 로그인 성공 여부 
		
		System.out.println("※ 로그인 시도는 최대 " +MAX_ATTEMPTS+ "회까지 가능합니다.");
		System.out.println("※ 테스트용 계정 - 아이디: admin, 비밀번호: 1234\n");
		
		while(!loginSuccess && (attemptCount < MAX_ATTEMPTS)) {
			attemptCount++;					// 시도 횟수 증가
			System.out.println("--- " +attemptCount+ "번째 시도 ---");
			
			// 아이디 입력
			System.out.print("아이디: ");
			String inputId = scanner.nextLine();
			
			// 비밀번호 입력
			System.out.print("비밀번호: ");
			String inputPw = scanner.nextLine();
			
			boolean idMatch = inputId.equals(correctId);
			boolean pwMatch = inputPw.equals(correctPw);
			
			loginSuccess = idMatch && pwMatch;
			
			if(loginSuccess) {						// 로그인 성공
				System.out.println("\n 로그인 성공! 환영합니다. " +inputId+ "님!");
			} else {								// 로그인 실패
				System.out.println("\n 로그인 실패!");
				
				System.out.println(" -> 아이디 또는 비밀번호가 일치하지 않습니다.");
				
//				if(!idMatch) {
//					System.out.println(" -> 아이디가 일치하지 않습니다.");
//				}
//
//				if(!pwMatch) {
//					System.out.println(" -> 패스워드가 일치하지 않습니다.");
//				}	
				
				//남은 횟수 안내
				int remaingAttemps = MAX_ATTEMPTS - attemptCount;
				if(remaingAttemps > 0) {
					System.out.println(" -> 남은 시도 횟수: " +remaingAttemps+ "회\n");
				}
			}
		}
		
		if(!loginSuccess) {
			System.out.println("\n==============================");
			System.out.println("|| 🍙 로그인 시도 횟수를 초과했습니다.");
			System.out.println("|| 계정이 일시적으로 잠겼습니다.");
			System.out.println("|| 관리자에게 문의하세요.");
			System.out.println("||==============================");
		}
		
		scanner.close();
	}
}

















