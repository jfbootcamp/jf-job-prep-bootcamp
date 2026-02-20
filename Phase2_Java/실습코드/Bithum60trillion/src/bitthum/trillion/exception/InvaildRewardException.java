package bitthum.trillion.exception;

//   보상 데이터가 유효하지 않을 때 (null 단위, 인원 0 등)
public class InvaildRewardException extends PaymentException {

	public InvaildRewardException(String message) {
		super(message);
	}

}
