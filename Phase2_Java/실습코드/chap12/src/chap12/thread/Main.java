package chap12.thread;

public class Main {

	public static void main(String[] args) {
		System.out.println("--------------------------------------");
		System.out.println(" 1. 스레드 기초 : 생성과 실행 ");
		System.out.println("--------------------------------------\n");	
		
		Thread mainThread = Thread.currentThread();   // 현재 실행 중인 스레드 = 메인 스레드
		System.out.println(" 현재 스레드 이름: " + mainThread.getName());
		System.out.println(" 스레드 ID : " + mainThread.getId());
		System.out.println(" 스레드 우선순위 : " + mainThread.getPriority());
		System.out.println(" 데몬 스레드 여부 : " + mainThread.isDaemon());
		
		// 2. 방법1 - Thread 클래스 상속
		System.out.println(" 2. 방법1 - Thread 클래스 상속 ");
		System.out.println("--------------------------------------\n");	
		
		PrintThread printThread = new PrintThread("★");
		printThread.setName("Print-Thread"); 				// 스레드 이름 설정 (디버깅용)
		printThread.start(); 								// start() 호출 --> 새 스레드에서 run() 실행
		
		// 메인 스레드에서 동시에 다른 작업 수행
		for(int i = 0; i < 5; i++) {
			System.out.println(" [메인 스레드] 작업 " + (i + 1));
			sleep(80);
		}
		sleep(500);
	}

	private static void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			Thread.currentThread().interrupt();
		}
		
	}
}










