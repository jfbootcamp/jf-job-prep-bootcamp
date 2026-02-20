package bitthum.trillion;

import java.text.DecimalFormat;
import java.util.Scanner;

/*
 * 	 확인 화면 -- 원화 환산 + 위험도 바 표시 후 최종 승인
 */
public class ConfirmationScreen {

	public boolean showAndConfirm(EventReward reward, Scanner scanner) {
		DecimalFormat df = new DecimalFormat("#,###");	// 숫자를 천 단위 콤마로 포맷
		long krwPerPerson = reward.getKrwPerPerson();		// 1인당 원화 환산액
		long totalKrw = reward.getTotalKrw();			// 전체 원화 총액 -- 위험도 바 계산에 사용
		double marketCapRatio = totalKrw / EventConfig.COMPANY_MAKKET_CAP;  // 시가총액 대비 비율 - 예: 1,960억 / 8,500억원 = 0.23 --> 위험도 바 등급 결정에 사용
		
		// 총액을 한글 단위로 평가 -- "196,000,000,000원"만으로는 자릿수 파악이 어려우므로 조/억 단위 추가
		if (totalKrw >= 1_000_000_000_000L) {		// 1조 이상 --> "약 60조원"
			System.out.printf(" (약 %s조원)", df.format(totalKrw / 1_000_000_000_000L));
		} else if (totalKrw >= 1_000_000_000L) {    // 1억 이상 --> "약 1,960억원"
			System.out.printf(" (약 %s억원)", df.format(totalKrw / 1_000_000_000L));
		}
		System.out.println();
		
		System.out.printf(" | 시가총액 대비: %.1f%% ", marketCapRatio * 100); //비율을 %로 변환 -- 예: 0.23 * 100 = 23.0% --> "시가총액 대비: 23.0%"
		if (marketCapRatio > 1.0) {
			System.out.println("위험: ██████████ 극심");
		} else if (marketCapRatio > 0.001) {
			System.out.println("위험: ████████░░ 높음");
		} else if (marketCapRatio > 0.00001) {
			System.out.println("위험: █████░░░░░ 보통");
		} else {
			System.out.println("위험: ██░░░░░░░░ 낮음");
		}
		
		System.out.print(" 지급하시겠습니까? (yes/no)");
		
		String input = scanner.nextLine().trim().toLowerCase();
		return "yes".equals(input) || "y".equals(input);
		
	}
}















