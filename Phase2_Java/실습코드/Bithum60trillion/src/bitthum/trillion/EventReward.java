package bitthum.trillion;

import java.text.DecimalFormat;

import bitthum.trillion.exception.InvaildAmountException;
import bitthum.trillion.exception.InvaildRewardException;

/*
 * 	이벤트 보상 - 불변 객체 (생성 시 검증)
 */
public class EventReward {
	private final double amount;			// 지급 수량 (예: 2,000) - 단위에 따라 의미가 달라짐 (2,000원 vs 2,000 BTC)
	private final CurrencyUnit unit;		// 통화 단위 (KRW/BTC/ETH)
	private final int recipients;			// 지급 대상 인원수 
	
	// 생성자에서 검증 -- 잘못된 데이터로는 객체가 만들어지지 않음 (방어적 프로그래밍)
	public EventReward(double amount, CurrencyUnit unit, int recipients) {
		//super();
		if(amount < 0) throw new InvaildAmountException("금액은 0 이상이어야 합니다: " + amount); // -1000원 같은 음수 금액 차단
		if(unit == null) throw new InvaildRewardException("통화 단위는 null일 수 없습니다."); // 단위 없이 지급하면 환산 불가
		if(recipients <= 0) throw new InvaildRewardException("인원은 1명 이상이어야 합니다: " + recipients); // 0명에게 지급은 의미 없음
		this.amount = amount;
		this.unit = unit;
		this.recipients = recipients;
	}

	public double getAmount() {
		return amount;
	}

	public CurrencyUnit getUnit() {
		return unit;
	}

	public int getRecipients() {
		return recipients;
	}
	
	// 1인당 원화 환산 - 예) BTC.toKrw(2000) = 2000 * 98,000,000 = 196,000,000,000 (1,960억원)
	public long getKrwPerPerson() {
		return unit.toKrw(amount);
	}
	
	// 전체 원화 총액 - 1인당 금액 * 인원수 - 예) 1,960억원 * 249명 = 48.8조원
	public long getTotalKrw() {
		return getKrwPerPerson() * recipients;
	}
	
	// 원화 금액을 한글 단위로 변환 (예: 196000000000 --> "1,960억원")
	public static String formatKrwReadable(long krw) {
		DecimalFormat df = new DecimalFormat("#,###");	// 숫자를 천 단위 콤마로 포맷 -- 196000000000 --> "196,000,000,000"
		if (krw >= 1_000_000_000_000L) {		  // 1조 이상
			long jo = krw / 1_000_000_000_000L;   // 조 단위 추출 -- 60,760,000,000,000 / 1조 = 60
			long remainEok = (krw % 1_000_000_000_000L) / 100_000_000L;  // 나머지를 억 단위로 -- 7,600 억 / 1억 = 7,600
			return remainEok > 0
					? df.format(jo) +"조 "+ df.format(remainEok) + "억원"
					: df.format(jo) +"조원 ";			
		} else if (krw >= 100_000_000L) {		  // 1억 이상 -- 	196,000,000,000 / 1 억 = "1,960억원"
			return df.format(krw / 100_000_000L) + "억원";
		} else if (krw >= 10_000L) {			  // 1만 이상 -- 50,000 / 1만 = "5만원"	
			return df.format(krw / 10_000L) + "만원";
		}
		return df.format(krw) + "원";			  // 1만 미만 -- 2,000 = "2,000원"	
	}
	
	
}














