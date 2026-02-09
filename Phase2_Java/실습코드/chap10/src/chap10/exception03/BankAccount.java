package chap10.exception03;

/*
 * 	은행 계좌 클래스 
 * 		- throw
 * 		- throws
 * 		- Checked Exception
 * 		- Unchecked Exception
 */
public class BankAccount {
	private String accountNumber;		// 계좌번호 (형식: XXX-XXX)
	private String owner;				// 계좌 소유자
	private int balance;				// 잔액 (원)
	
	public BankAccount(String accountNumber, String owner) {
		
		// 입력값 검증 (방어적 프로그래밍)
		// null이거나 빈 문자열이 들어오면 --> 프로그래밍 실수 --> Unchecked 예외
		if (accountNumber == null || accountNumber.isBlank()) {
			// throw : 예외 객체를 생성하여 즉시 발생시킴 --> 이 줄이 실행되면 생성자가 중단되고, catch로 이동
			throw new InvalidAccountException("계좌번호는 필수입니다.");
		}
		/*
		 * 계좌번호 형식 검증 : "XXX-XXX" 형태인지 확인
		 * 	- 정규식 (Regular Expression)으로 문자열 패턴 검증
		 * 	- \\d{3}-\\d{3}
		 * 		- \\d 
		 * 			- 숫자 1개 (0~9)
		 * 			- java에서 \를 표현하려면 \\로 써야 하므로 정규식의 \d가 코드에서는 \\로 써야 함
		 * 		- {3}
		 * 			- 숫자 3개 
		 */
		if (!accountNumber.matches("\\d{3}-\\d{3}")) {
			throw new InvalidAccountException(accountNumber, 
									"형식이 올바르지 않습니다 (올바른 형식: XXX-XXX)");
		}
		
		if (owner == null || owner.isBlank()) {
			throw new InvalidAccountException("소유주 이름은 필수입니다.");
		}
		
		//super();
		this.accountNumber = accountNumber;
		this.owner = owner;
		this.balance = 0;		// 초기 잔액 0원 
	}

	@Override
	public String toString() {
		return String.format("[%s] %s님 - 잔액: %,d", accountNumber, owner, balance);
	}

	public void deposit(int amount) {
		if(amount <= 0) {
			throw new IllegalArgumentException("입금액은 0보다 커야 합니다: " +amount+ "원");
		}
		balance += amount;
		System.out.printf("  [입금] %,d원 입금 완료. 잔액: %,d원%n", amount, balance);
	}

	public void withdraw(int amount) throws InsufficientBalanceException {
		if (amount <= 0) {
			throw new IllegalArgumentException("출금액은 0보다 커야 합니다: " +amount+ "원");
		}
		if (amount > balance) {
			throw new InsufficientBalanceException(balance, amount);
		}
		balance -= amount;
		System.out.printf("  [출금] %,d원 출금 완료. 잔액: %,d원%n", amount, balance);
	}

	/*
	 * 	계좌 이체
	 * 		- 이체 대상 계좌, 이체 금액
	 * 		- throws InsufficientBalanceException  잔액 부족 시
	 */
	public void transfer(BankAccount target, int amount) throws InsufficientBalanceException {
		if (target == null) {
			throw new IllegalArgumentException("이체 대상 계좌가 null입니다.");
		}
		
		System.out.printf(" [이체] %s -> %s: %,d원%n", this.owner, target.owner, amount);
		this.withdraw(amount);    		// 내 계좌에서 출금 (잔액 부족 시 예외)	
		target.deposit(amount); 		// 상대 계좌에 입금
		System.out.println(" [이체] 이체 완료!");
	}
	
	

}





















