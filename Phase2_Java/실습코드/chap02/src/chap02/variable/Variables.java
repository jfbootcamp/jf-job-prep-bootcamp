package chap02.variable;

public class Variables {

	public static void main(String[] args) {
		
		// 기본 타입 
		primitiveTypes();
		
		// 참조 타입 
		referenceTypes();
		
		// 형 변환
		typeCasting();
		
		// 상수
		constants();
	}

	private static void constants() {
		System.out.println("4. 상수");
		
		// final 상수 - 한 번 할당하면 변경 불가
		final double PI = 3.14159;
		final int MAX_SIZE = 100;
		final String APP_NAME = "MyApp";
		
		// PI = 3.111;		// 컴파일 오류: final 변수는 재할당 불가
		
		// Java 표준 라이브러리 상수 활용
		System.out.println("int 최대값: " + Integer.MAX_VALUE);
		System.out.println("int 최소값: " + Integer.MIN_VALUE);
		System.out.println("Math.PI: " + Math.PI);
		
	}

	/*
	 * 	1. 자동 형변환 (Widening)
	 * 		1) 작은 타입 -> 큰 타입으로 자동 변환
	 *      2) 데이터 손실 없음
	 *      
	 *  2. 강제 형변환 (Narrowing)
	 *  	1) 큰 타입 -> 작은 타입으로 변환
	 *  	2) (타입) 연산자 사용 필수 
	 *      3) 데이터 손실 가능성 있음!
	 *      
	 *  3. 문자열 <---> 숫자 변환 API
	 *  	1) 변환 방향 					사용 API
	 *        ----------------------------------
	 *          String --> int           Integer.parseInt(str)
	 *          String --> double        Double.parseDouble(str)
	 *          String --> long          Long.parseLong(str)
	 *          
	 *          int/double --> String    String.valueOf(num)
	 *          int --> String           Integer.toString(num)
	 *          간단한 방법                 "" + num (연결 연산)
	 *          
	 */
	private static void typeCasting() {
		System.out.println("3. 형 변환");
		
		//자동 형변환 
		int intValue = 100;
		long longValue = intValue;		 // int(4byte) --> long(8byte) 자동 변환
		double doubleValue = longValue;  // long(8byte) --> double(8byte) 자동 변환
		
		System.out.println("자동 형변환 : " +intValue+ " -> " +longValue+ " -> " + doubleValue);
		
		double d = 3.99;
		int i = (int)d;			// 소수점 버림! (반올림 아님)
		
		System.out.println("강제 형변환 : " +d+ " -> " + i);
		
		// 문자열 -> 숫자 변환 (파싱)
		String numStr = "123";
		int parsed = Integer.parseInt(numStr);		// String -> int
		double parsedDouble = Double.parseDouble("3.14");   // String -> double
		
		System.out.println("문자열 -> 정수 : " + parsed);
		System.out.println("문자열 -> 실수 : " + parsedDouble);
		
		// 숫자 -> 문자열 변환
		int num = 456;
		String str1 = String.valueOf(num);
		String str2 = Integer.toString(num);
		String str3 = "" + num;
		
		System.out.println("정수 -> 문자열: " + str1);
		
		
	}

	private static void referenceTypes() {
		System.out.println("2. 참조 타입");
		
		// String - 리터럴 방식 (String pool 사용) 
		String str1 = "Hello, Java!";
		// new 방식 (힙에 새 객체 생성)
		String str2 = new String("Hello, Java!");
		
		System.out.println("String : " + str1);
		System.out.println("String length: " + str1.length());
		
		// 배열 - 같은 타입의 데이터를 연속 저장
		int[] numbers = {1, 2, 3, 4, 5};		// 배열 초기화
		
		System.out.println("배열 첫 번째: " + numbers[0]);
		System.out.println("배열 길이 : " + numbers.length);
		
		Integer intObj = 100;
		Double doubleObj = 3.14;
		
		System.out.println("Integer 객체 : " + intObj);
		
		// var (타입 추론 - 컴파일러가 타입 자동 결정)
		var name = "이순신";			// String 으로 추론 
		var age = 25;				// int로 추론
		var price = 19.99;			// double로 추론
		
		
	}

	private static void primitiveTypes() {
		System.out.println("1. 기본 타입");
		
		// 정수형 -- 크기에 따라 4가지 타입
		byte b = 127;				// 1byte: -128 ~ 127
		short s = 32767;			// 2bytes: -32768 ~ 32767
		int i = 2147483647;		    // 4bytes: -2,147,483,648 ~ 2,147,483,647
		long l = 923345678654433444L;  // 8bytes: L 접미사 필수!
		
		// 실수형 - float은 f 접미사 필수, double은 기본 타입 
		float f = 3.14159f;			// 4 bytes 
		double d = 3.141582435333;  // 8 bytes 
		
		// 문자형 = 유니코드 2바이트, 숫자로도 표현 가능
		char c1 = 'A';				// 문자 리터럴 
		char c2 = '가';				// 유니코드 한글
		char c3 = 65;				// 숫자 65 = 'A' (유니코드 값)
		
		System.out.println("char : " +c1+ ", " +c2+ ", " +c3);
		
		// 논리형
		boolean isJavaFun = true;
		boolean isPythonFun = true;
		
	}
}






















