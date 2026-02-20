package bitthum.trillion;

import java.text.DecimalFormat;

import bitthum.trillion.exception.CircuitBreakerException;

/*
 * 	서킷 브레이크 -- 시가총액 대비 이상 거래 자동 차단
 */
public class CircuitBreaker implements PaymentValidator {
	private static final double DANGER_RATIO = 0.01;  //시가총액의 1% 초과 시 차단

	@Override
	public void validate(EventReward reward) {
		long totalKrw = reward.getTotalKrw();		// 총 원화 합산 -- 예: 2,000 BTC * 1명 = 1,960억
		long threshold = (long)(EventConfig.COMPANY_MAKKET_CAP * DANGER_RATIO); //임계값 = 8,500억 * 0.01 = 85억원
		
		if (totalKrw > threshold) {		// 1,960억 > 85억원 --> 차단!
			DecimalFormat df = new DecimalFormat("#,###");	// 숫자를 천 단위 콤마로 포맷
			double ratio = totalKrw / EventConfig.COMPANY_MAKKET_CAP;   // 시가총액 대비 배수 -- 1,960억 / 8,500억 = 0.23 배
			throw new CircuitBreakerException(String.format(
					"총 지급액 %s원이 시가총액(%s원)의 %.1f배! (임계값: %.1f%%)", 
					df.format(totalKrw), df.format(EventConfig.COMPANY_MAKKET_CAP),
					ratio, DANGER_RATIO * 100));
		}
	}

}












