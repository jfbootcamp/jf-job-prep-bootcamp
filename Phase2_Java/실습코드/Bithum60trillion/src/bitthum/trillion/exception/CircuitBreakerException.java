package bitthum.trillion.exception;

// 서킷 브레이커가 이상 거래를 차단했을 때
public class CircuitBreakerException extends PaymentException {

	public CircuitBreakerException(String message) {
		super(message);
	}

}
