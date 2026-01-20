package chap03.changecalc;

import java.util.Scanner;

/*
 *  거스름돈 계산기 (개선된 설계 버전)
 *  	- 배열
 *  	- 메서드 
 *  	- 상수
 *  	- for 
 *  
 *  * 순수 함수(pure function) - 입력만으로 출력 검정, 외부 상태 변경 없음
 *  * 배열을 활용한 반복 처리 - 코드 중복 최소화, 확장 용이 
 *  * 관심사 분리 (Separation of Concerns) - 계산 분리과 출력 로직 분리
 *  	
 */
public class ChangeCalculatorBetter {

	// 상수: 화폐 단위 (큰 단위부터 정렬)
	private static final int[] CURRENCY_UNIT = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
	private static final String[] CURRENCY_NAME = {"50000원권", "10000원권", "5000원권", "1000원권", "500원권", "100원권", "50원권", "10원권"};
	private static final String[] CURRENCY_COUNTERS = {"장", "장", "장", "장", "개", "개", "개", "개"};
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("=== 거스름돈 계산기 (개선된 설계) ===");
		
		// 입력 받기
		int price = readInt(scanner, "물건 가격을 입력하세요 (원): ");
		int payment = readInt(scanner, "지불 금액을 입력하세요 (원): ");
		
		if(payment < price) {
			System.out.println("지불 금액이 부족합니다!");
		} else {
			int change = payment - price;
			System.out.println("\n거스름돈: " +change+ "원");
			
			// 계산 (순수함수)
			int[] counts = calculateChange(change);
			
			// 출력 (계산 결과를 받아서 출력만 담당)
			printChangeResult(counts);
			
		}
		
		scanner.close();
		System.out.println("\n프로그램을 종료합니다.");
	}

	private static void printChangeResult(int[] counts) {
		System.out.println("\n=== 거스름돈 구성 (최소 개수)===");
		
		int totalCount = 0;
		
		for(int i = 0; i < counts.length; i++) {
			if(counts[i] > 0) {
				System.out.println(CURRENCY_NAME[i] +" : "+ counts[i] + CURRENCY_COUNTERS[i]);
				totalCount += counts[i];
			}
		}
		
		System.out.println("=======================================");
		System.out.println("총 " +totalCount+ "개의 지폐/동전");
	}

	/*
	 * 거스름돈을 각 화폐 단위별 개수로 계산하는 순수 함수
	 */
	private static int[] calculateChange(int change) {
		int[] counts = new int[CURRENCY_UNIT.length];
		int remaining = change;		// 지역변수로 상태관리
		
		for(int i=0; i < CURRENCY_UNIT.length; i++) {
			counts[i] = remaining / CURRENCY_UNIT[i];
			remaining = remaining % CURRENCY_UNIT[i];
		}
		
		return counts;			// 계산 결과만 반환, 외부 상태 변경 없음 
	}

	/*
	 * 정수 입력을 받는 메서드 (입력 검증 포함)
	 */
	private static int readInt(Scanner scanner, String prompt) {
		System.out.print(prompt);
		while(!scanner.hasNextInt()) {
			System.out.print("잘못된 입력입니다. 정수를 입력하세요: ");
			scanner.next();
		}
		return scanner.nextInt();
	}
}
























