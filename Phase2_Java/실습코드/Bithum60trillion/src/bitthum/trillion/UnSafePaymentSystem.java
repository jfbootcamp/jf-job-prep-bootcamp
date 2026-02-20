package bitthum.trillion;

import java.text.DecimalFormat;

/*
 * 	세이프가드 없는 시스템 - 실제 사고 재현
 */
public class UnSafePaymentSystem {
	
	public void processPayment(EventReward reward) {
		DecimalFormat df = new DecimalFormat("#,###");	// 숫자를 천 단위 콤마로 포맷
		System.out.printf(" 팝업: \"%s %s 지급하시겠습니까? \" -> 운영자 [확인] 클릭%n",
							df.format(reward.getAmount()), reward.getUnit().getDisplayName()); // "2,000 비트코인 지급하시겠습니까? "
		System.out.printf(" 결과: %s원 지급 완료 (약 %s)%n",
							df.format(reward.getTotalKrw()),		// 원화 환산 총액
							EventReward.formatKrwReadable(reward.getTotalKrw()));	// 한글 단위 변환
	}
}
