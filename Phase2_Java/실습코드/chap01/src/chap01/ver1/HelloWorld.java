package chap01.ver1;					// 패키지 선언 -- 클래스가 속한 패키지(폴더) 선언

public class HelloWorld {				// 클래스 선언 -- 공개 클래스 선언. 파일명과 동일해야 함 
		// static : 객체 생성 없이 호출 가능, void : 반환값 없음, String[] args : 명령행 인수를 받는 문자열 배열
	public static void main(String[] args) {		// 메인 메소드 -- 프로그램의 시작점 (Entry Point)
		// "Hello, World!"를 출력하시오.
		System.out.println("Hello, World!");		// 출력문 -- 콘솔에 문자열을 출력하고 줄바꿈
		
		// 자신의 이름을 출력하세요.
		System.out.println("이순신");
		
		// 오늘 날짜를 출력하세요.
		System.out.println("2026년 1월 15일");
	}

}

class A {
	
}
