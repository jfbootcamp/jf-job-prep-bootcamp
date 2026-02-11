package chap12.thread05;

/*
 * 	은행 계좌 클래스 - 동기화 문제 시연 및 해결
 * 		- 포인트
 * 			- 공유 객체(여러 스레드가 접근하는 객체)의 데이터 무결성 보장 
 * 			- synchronized 키워드로 임계 영역 보호
 * 			- 실무에서 계좌 이체, 재고 관리 등에서 반드시 필요  
 */
public class BankAccount {
	private final String accountId;			// 계좌 번호 (불변)
	private int balance;					// 잔고 (여러 스레드가 동시에 변경 가능 --> 위험!)
	
	public BankAccount(String accountId, int balance) {
		//super();
		this.accountId = accountId;
		this.balance = balance;
	}
	
	/*
	 * 동기화 없는 출금 메서드 - 데이터 손실 가능!
	 * 	문제 시나리오 (Race Condition)
	 * 		1) 스레드A: balance(10000) >= amount(1000) --> true (조건 통과)
	 * 		2) 스레드B: balance(10000) >= amount(1000) --> true (아직 감소 전)
	 * 		3) 스레드A: balance = 10000 - 1000 = 9000
	 * 		4) 스레드B: balance = 10000 - 1000 = 9000 (스레드A의 결과가 무시됨)
	 * 		--> 2000원이 빠져야 하는데 1000원만 빠진 것
	 */
	public void unsafeWithdraw(int amount, String who) {
		if(balance >= amount) {
			// 출금 시도 
			int beforeBalance = balance;		// 조건 통과 시점의 잔고
			balance -= amount;
			System.out.println(" [" +who+ "] 출금 " + String.format("%,d원", amount) 
					+ " (조건 확인 시 잔고: " +String.format("%,d원", beforeBalance)
					+ " -> 차감 후: " +String.format("%,d원", balance) + ")");
		}else {
			System.out.println(" [" +who+ "] 출금 실패 ! 잔액 부족 (잔고: "
					+ String.format("%,d원", balance) + ", 출금 시도: " + String.format("%,d원", amount) +")");
		}
	}
	
	/*
	 * 	synchronized 메서드 (동기화 적용)
	 * 
	 * 	synchronized 동작 원리
	 * 		1) 스레드 A가 이 메서드에 진입 -> 이 객체의 "모니터 락(Monitor Lock)" 획득  
	 * 		2) 스레드 B가 이 메서드에 진입 시도 -> 락이 없으므로 대기(BLOCKED 상태)
	 * 		3) 스레드 A가 메서드 실행 완료 -> 락 반납
	 * 		4) 스레드 B가 락 획득 -> 메서드 실행
	 * 		--> 한 번에 하나의 스레드만 실행 -> 데이터 무결성 보장!
	 * 
	 *  실무 팁
	 *  	- synchronized는 성능 비용이 있으므로 꼭 필요한 곳에만 사용
	 *  	- 메서드 전체가 아닌 일부만 동기화하려면 synchronized 블록 사용 
	 * 
	 */
	public synchronized boolean safeWithdraw(int amount, String who) {
		if(balance >= amount) {
			// 출금 시도 
			int beforeBalance = balance;		// 조건 통과 시점의 잔고
			balance -= amount;
			System.out.println(" [" +who+ "] 출금 " + String.format("%,d원", amount) 
					+ " (조건 확인 시 잔고: " +String.format("%,d원", beforeBalance)
					+ " -> 차감 후: " +String.format("%,d원", balance) + ")");
			return true;
		}
			
		System.out.println(" [" +who+ "] 출금 실패 ! 잔액 부족 (잔고: "
					+ String.format("%,d원", balance) + ", 출금 시도: " + String.format("%,d원", amount) +")");
		return false;    // 잔액 부족 
		
	}	

	public int getBalance() {
		return balance;
	}
	
	
	
}

















