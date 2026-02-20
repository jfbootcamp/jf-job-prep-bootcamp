package bitthum.trillion;

/*
 * 	통화 단위 - enum은 필드 + 생성자 + 메서드를 가진 특수한 클래스 
 * 	 enum의 각 상수(KRW, BTC, ETH)는 객체임.
 *   	- 컴파일러가 내부적으로 이렇게 변환을 함
 *   		- KRW("원", 1) ==> public static final CurrencyUnit 	KRW = new CurrencyUnit("원", 1);
 *   	      BTC("비트코인", 98_000_000)  ==> public static final CurrencyUnit BTC = new CurrencyUnit("비트코인", 98_000_000);
 * 		
 */
public enum CurrencyUnit {
	KRW("원", 1),
	BTC("비트코인", 98_000_000),
	ETH("이더리움", 3_800_000);
	
	private final String displayName;		// 한글 표시명
	private final long krwRate;				// 원화 환산 비율
	
	private CurrencyUnit(String displayName, long krwRate) {
		this.displayName = displayName;
		this.krwRate = krwRate;
	}

	public String getDisplayName() {
		return displayName;
	}

	public long getKrwRate() {
		return krwRate;
	}
	
	public long toKrw(double amount) {			// 수량 * 환율 --> 원화 
		return (long) (amount * krwRate);		// (long) 캐스팅 : 소수점 이하 버림 --> 원화는 정수 단위로 처리
	}
	
}











