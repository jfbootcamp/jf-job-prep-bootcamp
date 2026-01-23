package chap05.array;

import java.util.Scanner;

public class ArraysScannerLab {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("=== 배열 실습 (Scanner 버전) ===\n");
		
		// 1. 배열 생성 및 값 입력
		System.out.println("--- 1. 배열 생성 및 값 입력 ---");
		int size;
		while(true) {
			System.out.print("배열의 크기를 입력하세요: ");
			while(!scanner.hasNextInt()) {
				System.out.println("잘못된 입력입니다. 정수를 입력하세요: ");
				scanner.next();
			}
			size = scanner.nextInt();		
			
			if (size > 0) {
				break;		// 유효한 값이면 반복 종료
			}
			System.out.println("배열 크기는 1 이상이어야 합니다.");
		}
		
		int[] numbers = new int[size];
		
		System.out.println(size +"개의 정수를 입력하세요:");
		for(int i = 0; i < size; i++) {
			System.out.print("numbers[" +i+ "] = ");
			while(!scanner.hasNextInt()) {
				System.out.println("잘못된 입력입니다. 정수를 입력하세요: ");
				scanner.next();
			}
			numbers[i] = scanner.nextInt();
		}
		
		// 입력된 배열 출력
		System.out.print("\n입력된 배열 : ");
		for(int num : numbers) {
			System.out.print(num + " ");
		}
		System.out.println();
		
		// 2. 합계와 평균 계산
		System.out.println("\n--- 2. 합계와 평균 계산 ---");
		int sum = 0;
		
		for(int score : numbers) {
			sum += score;
		}
		
		double average = (double)sum / numbers.length;
		
		System.out.println("합계: " + sum);
		System.out.printf("평균: %.2f%n", average);		
		
		// 3. 최대값과 최소값 찾기
		System.out.println("\n--- 3. 최대값과 최소값 찾기 ---");
		
		int max = numbers[0];			// 현재까지 발견된 최대값
		int min = numbers[0];			// 현재까지 발견된 최소값
		int maxIndex = 0;				// 최대값이 위치한 인덱스
		int minIndex = 0;				// 최소값이 위치한 인덱스
		
		for(int i = 1; i < numbers.length; i++) {
			if(numbers[i] > max) {		// 최대값 갱신 (현재 요소가 기존 최대값보다 큰 경우)
				max = numbers[i];
				maxIndex = i;
			}
			
			if(numbers[i] < min) {		// 최소값 갱신 (현재 요소가 기존 최소값보다 작은 경우)
				min = numbers[i];
				minIndex = i;
			}
		}		
		
		System.out.println("최대값: " +max+ " (인덱스: " +maxIndex+ ")");
		System.out.println("최소값: " +min+ " (인덱스: " +minIndex+ ")");		
		
		scanner.close();
	}
}
















