package chap12.thread03;

public class Main {
	public static void main(String[] args) {
		System.out.println("--------------------------------------");
		System.out.println(" 1. Runnable 구현 방식(실무 권장) ");
		System.out.println("--------------------------------------\n");	
		
		// 모든 Java 프로그램은 main() 메서드는 실행하는 "메인 스레드"가 존재
		Thread mainThread = Thread.currentThread();  //현재 실행중인 스레드 = 메인 스레드	
		
		// Runnable을 implements한 객체를 Thread 생성자에 전달 
		CountTask countTask = new CountTask(5);			// 작업(What to do) - Runnable 구현 객체
		Thread countThread = new Thread(countTask, "Count-Thread");   // 실행(how to run) - Thread(Runnable, 이름)
		countThread.start(); 							// start() --> OS 스레드 생성 --> run() 실행
		
		// 메인 스레드에서 동시 작업 (countThread와 병렬 실행됨)
		for(int i = 0; i < 5; i++) {					// 메인 스레드의 반복문
			System.out.println(" [메인 스레드] 병렬 작업 " +(i + 1));  // currentThread.run()과 동시에 출력됨
			sleep(80); 									// 80ms 대기 ( Count-Thread는 100ms --> 출력 순서가 섞임)
		}
		sleep(500); 		// countTask.run()이 끝날때까지 여유있게 대기
		System.out.println();
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
