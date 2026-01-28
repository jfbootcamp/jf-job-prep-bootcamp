package chap06.overload;

import java.util.Arrays;

class Printer {
	void print(int value) {
		System.out.println("정수 : " + value);
	}
	
	void print(double value) {
		System.out.println("실수 : " + value);
	}
	
	void print(String value) {
		System.out.println("문자열 : " + value);
	}
	
	void print(boolean value) {
		System.out.println("불리언 : " + value);
	}	
	
	void print(String value, int times) {
		for(int i = 0; i < times; i++) {
			System.out.println(value);
		}
	}	
	
	// 정수 배열 출력  - Arrays.toString()과 유사한 출력 형식
	void print(int[] values) {
		System.out.print("배열: [");
		for(int i = 0; i < values.length; i++) {
			System.out.print(values[i]);		// 현재 요소 출력
			if(i < values.length - 1) {			// 마지막 요소가 아니라면
				System.out.print(", ");
			}
		}
		System.out.println("]");
		
	}
	
}

/*
 *  오버로딩 없이 								오버로딩 사용		
 *  	- addTwoInts(1,2)						- add(1, 2)
 *  	- addThreeInts(1,2,3)					- add(1, 2, 3)
 *  	- addDoubles(1.5, 2.5)					- add(1.5, 2.5)
 *  	- addArray(arr)							- add(1,2,3,4,5)
 *  	
 */
class AdvancedCalculator {
	int add(int a, int b) {
		return a + b;
	}
	
	int add(int a, int b, int c) {
		return a + b + c;
	}
	
	double add(double a, double b) {
		return a + b;
	}	
	
	int add(int... numbers) {
		int sum = 0;
		for(int n : numbers) {
			sum += n;
		}
		return sum;
	}
	
	int multiply(int a, int b) {
		return a * b;
	}
	
	double multiply(double a, double b) {
		return a * b;
	}
	
	long multiply(int[] numbers) {
		long result = 1;		// 곱셈의 항등원(초기값)
		for(int n : numbers) {
			result *= n;
		}
		return result;
	}
	
	double average(int a, int b) {
		return (a + b) / 2.0;
	}
	
	double average(int a, int b, int c) {
		return (a + b + c) / 3.0;
	}	
	
	double average(int[] numbers) {
		if(numbers.length == 0) return 0;		// 빈 배열 방어 코드 (0으로 나누기 방지)
		int sum = 0;					// 덧셈의 항등원 (초기값)
		for(int n : numbers) {
			sum += n;					// 누적 덧셈
		}
		return (double)sum / numbers.length;	// 실수 나눗셈을 위해 캐스팅
	}
	
	double average(double... numbers) {
		if(numbers.length == 0) return 0;		// 빈 배열 방어 코드 (0으로 나누기 방지)
		double sum = 0;
		for(double n : numbers) {
			sum += n;
		}
		return sum / numbers.length;
	}
	
}

// 테스트 클래스
public class MethodOverloading {
	
	public static void main(String[] args) {
		
		System.out.println("===================================");
		System.out.println("  	메서드 오버로딩		");
		System.out.println("===================================");
		
		System.out.println("--- 1. Printer 오버로딩 ---\n");
		
		Printer printer = new Printer();
		printer.print(42);
		printer.print(3.14);
		printer.print("Hello, Java!");
		printer.print("반복 출력", 3);
		printer.print(new int[] {1, 2, 3, 4, 5});
		
		int[] arr = {1, 2, 3, 4, 5};
		System.out.println("배열: " + Arrays.toString(arr));
		
		System.out.println("--- 2. Calculator 오버로딩 ---\n");	
		AdvancedCalculator calc = new AdvancedCalculator();
		
		System.out.println("calc.add(1, 2) = " + calc.add(1, 2));
		System.out.println("calc.add(1, 2, 3) = " + calc.add(1, 2, 3));
		System.out.println("calc.add(1.5, 2.5) = " + calc.add(1.5, 2.5));
		System.out.println("calc.add(1, 2, 3, 4, 5) = " + calc.add(1, 2, 3, 4, 5));  // 가변인자
		System.out.println();
		
		System.out.println("calc.multiply(3, 4) = " + calc.multiply(3, 4));
		System.out.println("calc.multiply(2.5, 4.0) = " + calc.multiply(2.5, 4.0));
		System.out.println("calc.multiply(new int[] {2, 3, 4}) = " + calc.multiply(new int[] {2, 3, 4}));
		System.out.println();
		
		System.out.println("calc.average(80, 90) = "+ calc.average(80, 90));
		System.out.println("calc.average(70, 80, 90) = "+ calc.average(70, 80, 90));
		System.out.println("calc.average([85, 90, 78, 92]) = "+ calc.average(new int[] {85, 90, 78, 92}));
		System.out.println("calc.average(85.5, 90.0, 78.5, 92.0) = "+ calc.average(85.5, 90.0, 78.5, 92.0));
		
	}

}






















