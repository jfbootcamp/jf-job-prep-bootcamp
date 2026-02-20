package bitthum.trillion;

// 비즈니스 규칙 검증 - 통화단위, 건당 상한, 총 예산
public class SafeguardValidator implements PaymentValidator {
	private final EventConfig config;
	
	public SafeguardValidator(EventConfig config) {
		//super();
		this.config = config;
	}



	@Override
	public void validate(EventReward reward) {
		// TODO Auto-generated method stub
		
	}

}
