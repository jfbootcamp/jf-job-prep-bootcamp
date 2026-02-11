package chap12.thread04;

public class Main {
	public static void main(String[] args) {
		System.out.println("--------------------------------------");
		System.out.println(" 1. 익명 객체 (실무 사용) ");
		System.out.println("--------------------------------------\n");	
		
		// 모든 Java 프로그램은 main() 메서드는 실행하는 "메인 스레드"가 존재
		Thread mainThread = Thread.currentThread();  //현재 실행중인 스레드 = 메인 스레드	
		
		// 방법 3: 익명 구현 객체 방식 (Runnable 인터페이스를 즉석에서 구현)
		Thread anonymousThread = new Thread(new Runnable() {	// Runnable 익명 구현 객체를 Thread 생성자에 직접 전달
			
			@Override
			public void run() {							// 새 스레드에서 실행될 작업 정의 (start() 호출 시 OS가 이 메서드 실행)
				for (int i = 0; i < 3; i++) {			// 3번 반복하며 작업 수행
					System.out.println(" [익명 Runnable] 작업 " + (i + 1) 
							+ "(스레드: " +Thread.currentThread().getName() + ")");  // 실행 중인 스레드 이름 확인
					sleep(100);
				}
				
			}
		}, "Anonymous-Thread");			// 두번째 인자: 스레드 이름 지정 (디버깅, 로그 추적용)
		anonymousThread.start(); 		// start() --> JVM이 OS 스레드 생성 --> run() 실행 (메인 스레드와 병렬)
		
		sleep(500); 					// 500ms 대기 --> anonymousThread 완료될때까지 여유있게 대기
		System.out.println();
		
		// 방법 3: 익명 객체 + 람다식  
		System.out.println(" 2. 람다식 (실무 최다 사용) ");
		System.out.println("--------------------------------------\n");	
		
		Thread lambdaThread = new Thread(() -> {
			for(int i = 0; i < 3; i++) {
				System.out.println(" [람다 Runnable] 작업 " + (i + 1) 
						+ "(스레드: " +Thread.currentThread().getName() + ")");  // 실행 중인 스레드 이름 확인
				sleep(100);				
			}
		}, "Lambda-Thread");
		lambdaThread.start();
		
		sleep(500);
		System.out.println();
		
		// 데몬 스레드 
		System.out.println(" 데몬 스레드 ");
		System.out.println("--------------------------------------\n");		
		
		Thread daemonThread = new Thread(() -> {
			int count = 0;					// 자동 저장 횟수를 추적하는 카운트
			while(true) {					// 무한 루프 --> 메인 스레드 종료 시 JVM이 강제 종료시킴 (데몬이므로)
				count++;					// 저장 횟수 1 증가
				System.out.println(" [데몬] 자동 저장 #" +count+ " (매 200ms 실행)");  // 현재 저장 횟수 출력
				sleep(200);					// 200ms 간격으로 반복 실행 (자동 저장 주기)
			}
			
		}, "Auto-Daemon");
		
		daemonThread.setDaemon(true);			// 반드시 start() 전에 setDaemon(true) 호출
		daemonThread.start(); 					// start() --> OS 스레드 생성 --> 백그라운에서 무한 루프 실행 시작
		
		System.out.println("  데몬 스레드 여부 : " +daemonThread.isDaemon());   //true
		System.out.println("  메인 스레드가 1초 후 종료되면 데몬도 같이 종료합니다.");
		sleep(1000); //1초 대기 
		
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







