package bitthum.trillion;

/*
 * 이벤트 설정 - 비스니스 규칙을 한 곳에서 처리
 */
public class EventConfig {
	public static final long COMPANY_MAKKET_CAP = 850_000_000_000L;  // 빗썸 시가총액 약 8,500억원
	
	private final String eventName;
	private final long maxPerPersonKrw;		// 1건당 최대 지급액 -- 이 금액을 넘으면 SafegaurdValidator가 차단
	private final long totalBudgetKrw;		// 이벤트 전체 예산 -- 총 지급액이 이 예산을 넘으면 차단
	
	public EventConfig(String eventName, long maxPerPersonKrw, long totalBudgetKrw) {
		//super();
		this.eventName = eventName;
		this.maxPerPersonKrw = maxPerPersonKrw;
		this.totalBudgetKrw = totalBudgetKrw;
	}

	public static long getCompanyMakketCap() {
		return COMPANY_MAKKET_CAP;
	}

	public String getEventName() {
		return eventName;
	}

	public long getMaxPerPersonKrw() {
		return maxPerPersonKrw;
	}

	public long getTotalBudgetKrw() {
		return totalBudgetKrw;
	}
	
	
}
















