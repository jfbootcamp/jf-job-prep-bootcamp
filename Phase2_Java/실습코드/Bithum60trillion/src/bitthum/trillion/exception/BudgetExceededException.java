package bitthum.trillion.exception;

// 건당 상황 또는 총 예산을 초과했을 때
public class BudgetExceededException extends PaymentException {

	public BudgetExceededException(String message) {
		super(message);
	}

}
