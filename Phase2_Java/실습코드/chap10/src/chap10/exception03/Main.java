package chap10.exception03;

/*
 *  핵심 개념
 *  	- throw : 예외 객체를 직접 만들어서 발생시키기 (메소드 내부)
 *  	- throws : "이 메소드는 이런 예외를 던질 수 있다"고 선언 (메소드 시그니처)
 *  	- Checked 예외 : 컴파일러가 처리를 강제 (extends Exception)
 *  	- Unchecked 예외 : 처리를 강제하지 않음 (extends RuntimeException)
 *  	- 커스텀 예외 : 비즈니스 의미가 담긴 예외 (추가 정보 포함 가능)
 */
public class Main {
	public static void main(String[] args) {
		//1. 정상 흐름
		System.out.println("===== 1. 정상 흐름 =====");
		
		BankAccount account = new BankAccount("123-456", "이순신");
		System.out.println(" 계좌 생성: " + account);
		
		account.deposit(100000);		// 10만원 입금
		account.deposit(50000); 		// 5만원 입금
		System.out.println(" 현재 상태: " + account);
		
		try {
			account.withdraw(30000);		// 3만원 출금 
		} catch (InsufficientBalanceException e) {
			System.out.println(" 출금 실패 :" + e.getMessage());
		}
		System.out.println(" 현재 상태: " + account);
		System.out.println();
		
		//2. 잔액 부족 (Checked 예외)
		System.out.println("===== 2. 잔액 부족 (Checked 예외) =====");
		
		try {
			account.withdraw(200000); 			// 20만원 출금 --> 잔액 부족
		} catch (InsufficientBalanceException e) {
			// 컴스텀 예외의 장점: 추가 정보 조회 가능
			// e.printStackTrace();
			System.out.println(" 출금 실패: " + e.getMessage());
			System.out.printf(" 현재 잔액: %,d원%n", e.getBalance());
			System.out.printf(" 요청 금액: %,d원%n", e.getAmount());
			System.out.printf(" 부족 잔액: %,d원%n", e.getShortfall());			
		}
		System.out.println(" 현재 상태: " + account);
		System.out.println();		
		
		//3. 잘못된 계좌번호 (Unchecked 예외)
		System.out.println("===== 3. 잘못된 계좌번호 (Unchecked 예외) =====");
		//3-1. 빈 계좌번호
		try {
			BankAccount bad1 = new BankAccount("", "신사임당");
		} catch (InvalidAccountException e) {
			System.out.println(" 생성 실패: " + e.getMessage());
		}
		
		//3-2. 잘못된 형식
		try {
			BankAccount bad2 = new BankAccount("1234567", "이도");
		} catch (InvalidAccountException e) {
			System.out.println(" 생성 실패: " + e.getMessage());
		}
		
		//3-3. null 소유자
		try {
			BankAccount bad3 = new BankAccount("123-456", null);
		} catch (InvalidAccountException e) {
			System.out.println(" 생성 실패: " + e.getMessage());
		}
		
		//3-4. 음수 입금
		try {
			account.deposit(-5000);
		} catch (IllegalArgumentException e) {
			System.out.println(" 입금 실패: " + e.getMessage());
		}
		System.out.println();
		
		// 4. 계좌 이체 
		System.out.println("===== 4. 계좌 이체 =====");
		
		BankAccount sender = new BankAccount("111-222", "송금자");
		BankAccount receiver = new BankAccount("333-444", "수취인");
		
		sender.deposit(200000); 		// 20만원 입금
		
		try {
			sender.transfer(receiver, 80000);     // 8만원 이체 --> 성공
		} catch (InsufficientBalanceException e) {
			System.out.println(" 이체 실패: " + e.getMessage());
			System.out.printf( "부족 금액: %,d%원n", e.getShortfall());
			//e.printStackTrace();
		}		
		
		System.out.println("  송금자 : " + sender);
		System.out.println("  수취인 : " + receiver);
		System.out.println();
		
		
		// 잔액 부족 이체
		try {
			sender.transfer(receiver, 500000);		// 50만원 이체 -> 잔액 부족!
		} catch (InsufficientBalanceException e) {
			System.out.println(" 이체 실패: " + e.getMessage());
			System.out.printf( "부족 금액: %,d원%n", e.getShortfall());
			// e.printStackTrace();
		}
		
		// 이체 실패해도 잔액은 변하지 않음 (출금 단계에서 예외 발생했으므로)
		System.out.println(" 송금자 잔액 (변동 없음): " + sender);
		System.out.println(" 수취인 잔액 (변동 없음): " + receiver);
	}
}















