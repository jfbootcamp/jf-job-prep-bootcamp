package chap02.output;

public class PrintLab {

	public static void main(String[] args) {
		System.out.println("====기본 출력 방법들====");
		
		basicOutput();
		formattedOutput();
	}

	private static void formattedOutput() {
		System.out.println("포맷 출력");
		
		String name = "이순신";
		int age = 25;
		double score = 95.5;
		
		// printf 형식 지정자 
		System.out.printf("이름: %s%n", name);
		System.out.printf("나이: %d세%n", age);
		System.out.printf("점수: %.1f점%n", score);  // 95.5점 
		
		// 정렬 - 숫자는 너비 지정, 부호는 정렬 방향
		System.out.printf("오른쪽 정렬: %10s%n", name);
		System.out.printf("왼쪽 정렬: %-10s|%n", name);
		
		// 숫자 형식 - 천단위 구분, 진법 변환 
		int number = 1234567;
		System.out.printf("천 단위 구분: %,d%n", number);
		System.out.printf("16진수: %x%n", 255);
		System.out.printf("8진수: %o%n", 64);
		
		String message = String.format("%s님은 %d세 입니다.", name, age);
		System.out.println(message);
		
	}

	private static void basicOutput() {
		System.out.printf("숫자: %d, 실수: %.2f, 문자열: %s%n", 42, 3.14159, "Java");
		System.out.println();
	}
}



















