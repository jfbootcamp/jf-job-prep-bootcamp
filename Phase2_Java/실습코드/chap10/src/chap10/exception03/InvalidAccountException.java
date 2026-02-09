package chap10.exception03;

/*
 * 	유효하지 않은 계좌 컴스텀 예외 
 */
public class InvalidAccountException extends RuntimeException {
	// 문제가 된 계좌번호
	private final String accountNumber;

	// 생성자1: 메시지만 받는 생성자
	public InvalidAccountException(String message) {
		super(message);
		this.accountNumber = null;
	}
	
	// 생성자2: 메시지 + 원인 예외 
	public InvalidAccountException(String message, Throwable cause) {
		super(message, cause);		// 원인 예외도 함께 저장
		this.accountNumber = null;
	}
	
	// 생성자3: 계좌번호 + 상세 메시지 
	public InvalidAccountException(String accountNumber, String message) {
		super(String.format("계좌번호 '%s' : %s", accountNumber, message));
		this.accountNumber = accountNumber;
		
	}
	
	
	
}














