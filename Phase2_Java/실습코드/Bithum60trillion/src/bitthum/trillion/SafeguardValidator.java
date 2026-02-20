package bitthum.trillion;

import java.text.DecimalFormat;

import bitthum.trillion.exception.BudgetExceededException;

// 비즈니스 규칙 검증 - 통화단위, 건당 상한, 총 예산
public class SafeguardValidator implements PaymentValidator {
	private final EventConfig config;
	
	public SafeguardValidator(EventConfig config) {
		//super();
		this.config = config;
	}



	@Override
	public void validate(EventReward reward) {
		DecimalFormat df = new DecimalFormat("#,###");	// 숫자를 천 단위 콤마로 포맷
		long krwPerPerson = reward.getKrwPerPerson();	// 1인당 원화 -- 예: 2,000 BTC --> 1,980억원, 2,000 KRW --> 2,000원
		long totalKrw = reward.getTotalKrw();			// 전체 원화 총액 -- 1인당 * 인원수 
		
		// 1. 통화 단위 검증 -- 사고의 근본 원인: BTC를 KRW로 착각하면 금액이 9,800만배 뻥뛰기됨
		if (reward.getUnit() != CurrencyUnit.KRW) {
			throw new BudgetExceededException(String.format(
					"지급 단위가 '%s'입니다! 원화(KRW)만 허용됩니다.", 
					reward.getUnit().getDisplayName()));  // "비트코인(BTC)" 같은 한글명
		}
		
		// 2. 건당 상한 검증 -- 1인당 지급액이 설정된 최대치를 넘는지 확인 (예: 1,960억원 > 10만원 --> 차단)
		// 통화 단위 검증(1단계)을 통과했더라도, 금액 자체가 비정상적으로 클 수 있으므로 건당 상환으로 한 번 더 걸러내는 2중 방어
		if (krwPerPerson > config.getMaxPerPersonKrw()) {
			throw new BudgetExceededException(String.format(
					"건당 %s원 > 상한 %s원 초과!", 
					df.format(krwPerPerson), df.format(config.getMaxPerPersonKrw()))); // 예: "건당 196,000,000,000원 > 상한 100,000원 초과"  		
		}
		
		// 3. 총 예산 검증 -- 1인당은 통과해도 인원수를 곱하면 예산을 초과할 수 있음 (예: 2,000원 * 30,000명 = 6,000만원 > 예산 5,000 만원)
		// 2단계(건단 상한)를 통과했더라도 인원수에 따라 총액이 예산을 넘을 수 있으므로 별로도 필요한 3중 방어
		if (totalKrw > config.getTotalBudgetKrw()) {
			throw new BudgetExceededException(String.format(
					"총액 %s원 > 예산 %s원 초과!", 
					df.format(totalKrw), df.format(config.getTotalBudgetKrw())));  // 예: "총액 196,000,000,000원 > 예산 50,000,000원 초과" 
			
		}
	}

}















