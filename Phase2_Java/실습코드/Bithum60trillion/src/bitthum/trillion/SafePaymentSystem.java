package bitthum.trillion;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import bitthum.trillion.exception.PaymentException;

/*
 *  세이프가드가 적용된 안전한 시스템
 */
public class SafePaymentSystem {
	private final List<PaymentValidator> validators = new ArrayList<>();  // 인터페이스 타입 리스트
	private final ConfirmationScreen confirmationScreen;		// 검증 통과 후 운영자에게 보여주는 최종 확인 화면(yes/no)
	
	// 생성자 - 검증 파이프라인 조립 - 어떤 검증기를, 어떤 순서로 실행할지 여기서 결정
	public SafePaymentSystem(EventConfig config) {
		validators.add(new CircuitBreaker());		// 검증 1 : 서킷 브레이크 -- 시가총액 1% 초과하면 자동 차단 (화재경보기)
		validators.add(new SafeguardValidator(config));		// 검증 2: 비즈니스 규칙 -- 통화단위,건당상환,총예산 검증 (경비원)
		this.confirmationScreen = new ConfirmationScreen();  // 검증 3: 맥락 확인 -- 위험도 바 + yes/no 최종 승인 (관리자)
	}
	
	public void processPayment(EventReward reward, Scanner scanner) {
		DecimalFormat df = new DecimalFormat("#,###");	// 숫자를 천 단위 콤마로 포맷
		
		System.out.printf(" | 빗썸 시가총액: %s원 (약 8,500억원)%n", 
								df.format(EventConfig.COMPANY_MAKKET_CAP));
		System.out.printf(" | 서킷 브레이커 임계값: 시가총액의 1%% = %s (약 85억원)%n",
								df.format((long)(EventConfig.COMPANY_MAKKET_CAP * 0.01)));
		System.out.printf(" | -> 총 지급액이 85억원을 넘으면 자동 차단!");
		
		for (int i = 0; i < validators.size(); i++) {
			try {
				validators.get(i).validate(reward);
				System.out.printf(" [검증 %d] %s ->  통과%n",
									i + 1, validators.get(i).getClass().getSimpleName()); // "CircuitBreaker" 또는 "SafeguardValidator
				
			} catch (PaymentException e) {
				System.out.printf(" [검증 %d] %s ->  [차단] %s%n",
									i + 1, validators.get(i).getClass().getSimpleName(), e.getMessage()); 
				System.out.println(" 결과: 지급 차단됨.");
				return;
			}
		}
		
		// 검증 3 : 맥락 있는 확인 화면
		System.out.println(" [검증 3] 맥락 확인 화면");
		boolean approved = confirmationScreen.showAndConfirm(reward, scanner);
		if (!approved) {
			System.out.println(" 결과: 운영자가 지급을 취소했습니다.");
			return;
		}
		
		System.out.printf(" 결과 : 안전하게 지급 완료! (%s원 x %d명 = %s원)%n",
						df.format(reward.getKrwPerPerson()),	// 1인당 원화 - 예: "2000"	
						reward.getRecipients(),					// 인원수 - 예: 249
						df.format(reward.getTotalKrw()));		// 총액 - 예: "498,000" -> "2,000원 x 249명 = 498,000원"
		
	}
}
















