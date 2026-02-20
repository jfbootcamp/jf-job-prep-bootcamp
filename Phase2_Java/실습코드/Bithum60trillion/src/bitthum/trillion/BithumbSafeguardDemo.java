package bitthum.trillion;

import java.text.DecimalFormat;
import java.util.Scanner;

/*
 * 	빗썸 60조원 오지급 사태 시뮬레이션
 * 		- 빗썸 랜덤박스 이벤트
 * 			- 원래: 249명에게 총 62만원 지급 예정
 * 			- 사고: KRW 대신 BTC로 입력 --> 62만 BTC (=60.8조) 오지급
 */
public class BithumbSafeguardDemo {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("#,###");	// 숫자를 천 단위 콤마로 포맷
		
		System.out.println("\n 빗썸 60조원 오지급 사태 시뮬레이션");
		System.out.println("----------------------------------------");
		
		System.out.print(" [Enter를 눌러 시뮬레이션 시작] ");
		scanner.nextLine();
		
		EventConfig config = new EventConfig("랜덤박스 이벤트", 100_000, 50_000_000);
		
		// 1단계: 사고 재현 
		System.out.println("\n [1단계]: 사고 재현 - 세이프가드 없는 시스템 \n ");
		
		UnSafePaymentSystem unSafePaymentSystem = new UnSafePaymentSystem();
		EventReward dangerousReward = new EventReward(2_000, CurrencyUnit.BTC, 1); // 사고 재현 : 2,000원(KRW)을 입력해야 했는데, 2,000 BTC로 입력 --> 2,000 *  9,800만 = 1,960억원
		
		System.out.println(" 의도 :  2,000 KRW(원) --> 실제 입력: 2,000 BTC(비트코인)");
		unSafePaymentSystem.processPayment(dangerousReward);
		
		pauseForUser(scanner);
		
		// 2단계 : 세이프가드 차단 체험
		SafePaymentSystem safePaymentSystem = new SafePaymentSystem(config);
		System.out.println("----------------------------------------");
		System.out.println("\n [2단계]: 세이프가드 차단 체험 (추천: 2000 / BTC / 1)\n ");
		
		EventReward stage2 = getUserInput(scanner, "2000", "2:BTC", "1");
		if (stage2 != null) safePaymentSystem.processPayment(stage2, scanner);
		
		pauseForUser(scanner);
		
		
		scanner.close();
	}

	// 사용자 입력을 받아 EventReward 생성 -- 추천값을 힌트로 표시, null이면 자유 입력
	private static EventReward getUserInput(Scanner scanner, 
			String sugAmt, String sugUnit, String sugRec) {
		
		// 삼항 연산자: sugAmt가 있으면 "금액: (추천: 2000)", 없으면 금액: "" 출력 
		System.out.printf(" 금액%s: ", sugAmt != null ? " (추천: " +sugAmt+ ")" : "");
		double amount;
		try {
			amount = Double.parseDouble(scanner.nextLine().trim());
		} catch (NumberFormatException e) {
			System.out.println(" -> 숫자를 입력해 주세요.");
			return null;
		}
		
		if (amount == 0) return null;
		if (amount < 0) {
			System.out.println(" -> 금액은 0보다 커야 합니다.");
			return null;
		}
		
		System.out.printf(" 단위 (1:KRW 2:BTC 3:ETH)%s: ", sugUnit != null ? " [추천: " +sugUnit+ "]" : "");
		CurrencyUnit unit;
		switch(scanner.nextLine().trim()) {
			case "1": unit = CurrencyUnit.KRW; break;		// 정상 지급 시 선택
			case "2": unit = CurrencyUnit.BTC; break;		// 사고 재현 시, 이걸 고르면 금액이 9,800만배
			case "3": unit = CurrencyUnit.ETH; break;
			default: System.out.println(" -> 1, 2, 3 중 선택해 주세요.");
			return null;
		}
		
		System.out.printf(" 인원%s: ", sugRec != null ? " (추천: " +sugRec+ ")" : "");  //인원수 입력 
		int recipients;
		try {
			recipients = Integer.parseInt(scanner.nextLine().trim());
		} catch (NumberFormatException e) {
			System.out.println(" -> 숫자를 입력해 주세요.");
			return null;			
		}
		if (recipients <= 0) {
			System.out.println(" -> 1명 이상이어야 합니다.");
			return null;
		}
		
		return new EventReward(amount, unit, recipients);  // 3개 입력값으로 불변 객체 생성
	}

	private static void pauseForUser(Scanner scanner) {		// 단계 사이에 일시정지
		System.out.println("\n [Enter] ");
		scanner.nextLine();			// Enter 키 입력을 기다림 -- 입력 내용은 버리고, "대기" 용도로만 사용
	}
}
















