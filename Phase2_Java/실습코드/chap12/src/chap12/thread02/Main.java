package chap12.thread02;

public class Main {
	public static void main(String[] args) {
		System.out.println("--------------------------------------");
		System.out.println(" 1. 스레드 생명주기(Thread.State) ");
		System.out.println("--------------------------------------\n");	
		
		// 모든 Java 프로그램은 main() 메서드는 실행하는 "메인 스레드"가 존재
		Thread mainThread = Thread.currentThread();  //현재 실행중인 스레드 = 메인 스레드
		
		// Runnable(작업) 인터페이스를 구현하여 스레드의 "작업"을 정의
		Runnable stateTask = new Runnable() {
			
			@Override
			public void run() {
				// 이 안의 코드가 새 스레드에서 실행됨
				sleep(500);   		// 500ms 동안 sleep -->  이 동안 TIMED_WAITING 상태가 됨
			}
		};
		
		// Runnable(작업)을 Thread(실행)에 전달하여 스레드 생성
		Thread stateThread = new Thread(stateTask, "State-Thread");
		
		System.out.println(" [1] 생성 후 start() 전:  " + stateThread.getState());   // NEW --> 객체만 생성, 아직 OS 스레드 없음
		stateThread.start(); 													  // start() -> OS 스레드 생성 --> run() 실행 시작	
		System.out.println(" [2] start() 직후:  " + stateThread.getState());       // Runnable --> 실행 가능 상태 (CPU 할당 대기 or 실행 중)
		sleep(100);  															  // 100ms 대기 --> 이때 stateThread가 sleep(500) 실행 중!
		System.out.println(" [3] sleep 중  " + stateThread.getState());			// TIMED_WAITING 
		sleep(600);																// 600ms 대기 -> stateThread의 sleep(500)이 끝나고 run()도 종료될 때까지 넉넉히 대기
		System.out.println(" [4] run() 종류 후  " + stateThread.getState());		// TERMINATED -> run() 메서드 끝 -> 스레드 종료, 재시작 불가!
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
