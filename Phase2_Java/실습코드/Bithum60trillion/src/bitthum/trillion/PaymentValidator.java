package bitthum.trillion;

/*
 *  지급 검증 인터페이스 -- 모든 검증기가 구현
 */
public interface PaymentValidator {
	// 지급 요청을 검증하기
	void validate(EventReward reward);
}
