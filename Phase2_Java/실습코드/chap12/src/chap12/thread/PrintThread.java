package chap12.thread;

/*
 * 	실무 포인트
 * 		- Thread를 직접 상속하는 방식은 단순하지만 단일 상속 제약이 있어 실무에서 잘 안 씀
 */
public class PrintThread extends Thread {
	private final String symbol;		// 출력할 문자

	public PrintThread(String symbol) {
		//super();
		this.symbol = symbol;
	}

	/*
	 * start()를 호출하면 JVM이 새 스레드를 만들고 이 run()을 실행
	 * 	- run()을 직접 호출하면 새 스레드가 아닌 호출한 스레드에서 실행됨
	 * 
	 * InterruptedException이 발생하면 JVM이 자동으로 인터럽트 플래그를 false로 리셋함.
	 * 	- 즉, catch 블록 안에서는 isInterrupted() == false 상태
	 *  - 이대로 두면 이 메서드를 호출한 코드가 "이 스레드에 인터럽트가 걸렸었다"는 사실을 알수 없게 됨.
	 */
	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println(" [" +getName()+ "] " + symbol.repeat(i + 1));
			
			try {
				Thread.sleep(100);       // 0.1 초 대기 (다른 스레드에게 실행 기회 제공)
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();		// 인터렙트 플래그를 다시 true로!
				return;			// 안전하게 종료
				//e.printStackTrace();
			}	
		}
		System.out.println(" [" +getName()+ "] 작업 완료! ");
	}
	
	
}






