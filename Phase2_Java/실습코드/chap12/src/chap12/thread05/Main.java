package chap12.thread05;

/*
 * 	- 동기화 없이 발생하는 문제를 확인
 * 	- synchronized 키워드로 문제 해결
 */
public class Main {
	public static void main(String[] args) {
		System.out.println("--------------------------------------");
		System.out.println(" 1. 스레드 동기화 - 공유 객체 보호 ");
		System.out.println("--------------------------------------\n");		
		
		System.out.println(" ▶ 동기화 없는 은행 계좌 (문제 발생!) ");
		System.out.println("--------------------------------------\n");	
		
		// 시나리오 : 잔고 10,000원 계좌에서 두 사람이 동시에 출금 
		BankAccount unsafeAccount = new BankAccount("UNSAFE-001", 10_000);
		
		// 두 스레드가 동시에 같은 계좌에서 출금 시도
		Thread atm1 = new Thread(() -> {		// Runnable을 람다로 전달 -> 스레드가 실행할 작업 정의
			for(int i = 0; i < 5; i++) {		// 5번 반복 출금
				unsafeAccount.unsafeWithdraw(1_000, "ATM-1");		// 동기화 없는 출금 --> Race Condition 발생 가능!
				sleep(10);						// 10ms 대기 --> Context Switch 유도 
			}
		}, "ATM-1");
		
		Thread atm2 = new Thread(() -> {		// 두번째 ATM 스레드 (같은 계좌에 동시 접근!)
			for(int i = 0; i < 5; i++) {
				unsafeAccount.unsafeWithdraw(1_000, "ATM-2");    // atm1과 같은 계좌 + 동시 출금 충돌!
				sleep(10);
			}
		}, "ATM-2");
		
		atm1.start();			// ATM-1 스레드 시작 
		atm2.start();           // ATM-2 스레드 시작 --> 이 시점부터 두 스레드가 동시에 출금 시작 
		
		// 두 스레드가 끝날 때까지 main 스레드 대기 (join)
		// join() 없으면 atm1, atm2가 아직 출금 중인데 잔고를 확인하게 됨.
		joinThread(atm1);    // main이 ATM-1 끝날 때까지 WAITING
		joinThread(atm2);   // main이 ATM-2 끝날 때까지 WAITING
		
		System.out.println(" [결과] 안전하지 않은 잔고 : " + String.format("%,d원", unsafeAccount.getBalance()));
		
		System.out.println();
		
		System.out.println(" ▶ 동기화 적용 : synchronized 메서드 ");
		System.out.println("--------------------------------------\n");	
		
		// 시나리오 : 잔고 10,000원 계좌에서 두 사람이 동시에 출금 
		BankAccount safeAccount = new BankAccount("SAFE-001", 10_000);
		
		// 두 스레드가 동시에 같은 계좌에서 출금 시도
		Thread safe1 = new Thread(() -> {		// Runnable을 람다로 전달 -> 스레드가 실행할 작업 정의
			for(int i = 0; i < 5; i++) {		// 5번 반복 출금
				safeAccount.safeWithdraw(1_000, "ATM-1");		// 동기화 없는 출금 --> Race Condition 발생 가능!
				sleep(10);						// 10ms 대기 --> Context Switch 유도 
			}
		}, "Safe-ATM-1");
		
		Thread safe2 = new Thread(() -> {		// 두번째 ATM 스레드 (같은 계좌에 동시 접근!)
			for(int i = 0; i < 5; i++) {
				safeAccount.safeWithdraw(1_000, "ATM-2");    // atm1과 같은 계좌 + 동시 출금 충돌!
				sleep(10);
			}
		}, "Safe-ATM-2");
		
		safe1.start();			// ATM-1 스레드 시작 
		safe2.start();           // ATM-2 스레드 시작 --> 이 시점부터 두 스레드가 동시에 출금 시작 
		
		// 두 스레드가 끝날 때까지 main 스레드 대기 (join)
		// join() 없으면 atm1, atm2가 아직 출금 중인데 잔고를 확인하게 됨.
		joinThread(safe1);    // main이 ATM-1 끝날 때까지 WAITING
		joinThread(safe2);   // main이 ATM-2 끝날 때까지 WAITING
		
		System.out.println(" [결과] 안전하지 않은 잔고 : " + String.format("%,d원", safeAccount.getBalance()));		
	}
	
	// join() : 특정 스레드의 종료를 기다림 (스레드 간 순서 보장)
	private static void joinThread(Thread thread) {
		try {
			thread.join();		// 해당 스레드가 종료될 때까지 현재 스레드(main) 대기 (WAITING 상태)
		} catch (InterruptedException e) {
			//e.printStackTrace();
			Thread.currentThread().interrupt();
		}
		
	}

	static void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			//e.printStackTrace();
			// InterruptedException catch시 인터럽트 플래그가 false로 초기화됨
			// 상위 코드도 인터럽트 사실을 알수 있도록 플래그를 다시 true로 복원
			Thread.currentThread().interrupt();
		}
	}	
}























