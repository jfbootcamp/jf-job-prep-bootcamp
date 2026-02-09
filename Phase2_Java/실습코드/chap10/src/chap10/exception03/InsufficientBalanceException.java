package chap10.exception03;

/*
 *   잔액 부족 커스텀 예외 (Checked Exception)
 *   	- extends Exception --> Checked Exception
 *   		- 이 예외를 던지는 메소드는 반드시 throws 선언하거나 try-catch로 감싸야 함
 *   		- 컴파일러가 강제로 처리하게 만듦 ("이 상황은 반드시 대비해")
 *   
 *   	- 참고) extends RuntimeException으로 Unchecked가 됨 --> 처리 강제하지 않음(선택적)
 *   
 *   커스텀 예외를 만드는 이유
 *   	- 비즈니스 로직에 맞는 의미 있는 예외명 (IllegalArgumentException보다 명확)
 *   	- 추가 정보를 예외에 담을 수 있음 (잔액, 요청금액, 부족 금액 등)
 *   	- catch할 때 특정 비즈니스 예외만 잡을 수 있음 
 */
public class InsufficientBalanceException extends Exception {
	// 현재 잔액 - 예외 발생 시점의 계좌 잔액
	private final int balance;
	// 요금 금액 - 출금하려고 했던 금액
	private final int amount;
	
	// 생성자1 : 메시지만 받는 기본 생성자
	public InsufficientBalanceException(String message) {
		super(message);		// Exception의 생성자 호출 --> getMessage()로 조회 가능
		this.balance = 0;
		this.amount = 0;
	}
	
	// 생성자2: 잔액과 요청 금액을 받는 상세 생성자
	public InsufficientBalanceException(int balance, int amount) {
		super(String.format("잔액 부족: 현재 잔액 %,d원, 요청 금액 %,d원", balance, amount));
		this.balance = balance;
		this.amount = amount;
	}

	public int getBalance() {
		return balance;
	}

	public int getAmount() {
		return amount;
	}
	
	// 부족 금액 계산
	public int getShortfall() {
		return amount - balance;
	}
}
















