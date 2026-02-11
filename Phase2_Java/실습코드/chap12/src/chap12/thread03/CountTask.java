package chap12.thread03;
/*
 * Runnable 구현 방식
 * 	- Runnable 인터페이스는 run() 메서드 하나만 있는 함수형 인터페이스 
 *  - 다른 클래스 상속 가능 
 *  - 작업(what to do)과 실행(how to run)을 분리하는 패턴 --> OOP원칙 
 *  	- "작업"
 *  		- run() 메서드 안의 로직 
 *  		- 스레드가 어떻게 실행되는지는 전혀 모름! 
 *  	- "실행"
 *  		- OS 스레드 생성, 스케쥴링
 *  		- 어떤 작업을 실행하는지는 전혀 모름!
 *  	- 결합
 *  		- new Thread(countTask).start();
 *            ---------- ---------
 *              실행기      작업
 *	- 비유
 *		- 택배 시스템
 *		- Runnable(작업) = 택배 상자 (배송할 물건이 뭔지 정의)
 *		- Thread(실행) = 택배 기사 (어떤 상자든 배달할 수 있음)	
 *		- 같은 상자를 다른 기사에게 줄 수도 있고,
 *        같은 기사가 다른 상자를 배달할 수 있음 --> 유연성!	                
 */
public class CountTask implements Runnable {
	private final int MAXCOUNT;			// 최대 카운트 횟수
	
	public CountTask(int maxCount) {
		this.MAXCOUNT = maxCount;			// 외부에서 받은 값을  final 필드에 저장 (불변 보장)
	}
	
	/*
	 * Runnable.run() 구현
	 * 	- Thread에 전달되어 새 스레드에서 실행되는 작업
	 */
	@Override
	public void run() {
		String threadName = Thread.currentThread().getName();		// 이 코드를 실행하는 스레드의 이름
		
		for(int i = 1; i <= MAXCOUNT; i++) {
			System.out.println(" [" +threadName+ "]  카운트: " +i+ "/" + MAXCOUNT);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				//e.printStackTrace();
				System.out.println(" [" +threadName+ "] 인터럽트 발생! 작업중단." );
				Thread.currentThread().interrupt();
				return;
			}
			System.out.println(" [" +threadName+ "]  카운트 완료!");
		}
		
	}

}















