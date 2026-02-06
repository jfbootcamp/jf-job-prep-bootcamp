package chap10.exception;
/*
 * 	 핵심 개념
 * 		1) try-catch : 예외가 발생해도 프로그램이 죽지 않게 하는 안전장치
 * 		2) finally : 예외 발생 여부와 상관없이 반드시 실행되는 코드
 * 		3) 멀티 캐치 : 여러 예외를 한 번에 처리 
 * 		4) try-with-resouces : 리소스 자동 해제 
 */
public class Main {
	public static void main(String[] args) {
		
		// 1. 예외 없이 실행
		System.out.println("==== 1. 예외 없이 실행 ====");
		// 예외가 없는 정상 흐름
		try {
			System.out.println("[try] 시작");
			int result = 10 / 2;   // (예외 없음)
			System.out.println("[try]결과" +result);
			System.out.println("[try] 끝");
		} catch(ArithmeticException e) {
			System.out.println("[catch] 여기는 실행 안 됨");
		} finally {
			System.out.println("[finally] 항상 실행됨!");
		}
		System.out.println(" 프로그램 계속 실행\n");
		
		
		
		// 2. 예외 발생
		/*
		 * 예외 발생하면 
		 * 	- try에서 예외 발생 지점 이후의 코드는 실행되지 않음
		 *  - 해당 예외는 잡는 catch 블록으로 점프
		 *  - finally 실행
		 */
		System.out.println("==== 2. 예외 발생 ====");		
		
		try {
			System.out.println("[try] 시작");
			int result = 10 / 0;   // ArithmeticException 발생!
			System.out.println("[try]결과" +result);
			System.out.println("[try] 끝");
		} catch(ArithmeticException e) {
			System.out.println("[catch] 예외가 발생했으므로 이 블록이 실행됨");
			System.out.println("[catch] 예외 발생 : " + e.getMessage());
			
		} finally {
			System.out.println("[finally] 항상 실행됨!");
		}
		System.out.println(" 프로그램 계속 실행(죽지 않음!)\n");		
		
		// 3. 여러 예외 처리
		/*
		 * 규칙 : 구체적인 예외 --> 일반적인 예외 순서로 catch
		 * 이유
		 * 	- catch는 위에서 아래로 매칭됨
		 *  - Exception을 먼저 쓰면 모든 예외를 다 잡아버려서 아래 catch가 의미 없어짐 (컴파일 에러)
		 */
		System.out.println("==== 3. 여러 예외 처리 ====");	
		
		String[] data = {"10", "abc", null}; 
		
		for (int i = 0; i <data.length; i++) {
			try {
				System.out.println(data[i]);
				
				//int len = data[i].length();			// null 이면 .length()에서 NullPointerException
				
				int number = Integer.parseInt(data[i]);
				System.out.println("--> 변환 성공: " + number);
				
			} catch (NullPointerException e) {			// 가장 구체적인 예외 먼저
				System.out.println(" --> null 값입니다.");
			} catch (NumberFormatException e) {
				System.out.println(" 숫자로 변환 불가 : " + e.getMessage());
			} catch (Exception e) {						// 나머지 모든 예외 (이 catch는 위에서 못잡은 예외만 잡음)
				System.out.println(" 기타 오류 : " + e.getMessage());
			}
		}
		System.out.println();
		
		// 4. 멀티 캐치
		/*
		 *  같은 방식으로 처리할 예외들을 |(파이프)로 묶음 
		 *  장점: 중복 코드 제거
		 */
		System.out.println("==== 4. 멀티 캐치 ====");	
		String[] testValues = {"100", "hello", null, "999999999" };
		
		for(String value : testValues) {
			try {
				int number = Integer.parseInt(value);		// "hello", null -> NFE 
			} catch(NumberFormatException | NullPointerException e) {
				System.out.println(" --> 변환 실패 (" +e.getClass().getSimpleName()+ ")");
			}
		}
		System.out.println();
		
	}
}















