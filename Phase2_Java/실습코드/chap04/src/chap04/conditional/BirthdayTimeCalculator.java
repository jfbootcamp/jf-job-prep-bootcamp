package chap04.conditional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

/*
 * 	생일 기반 시간 계산기 (정확한 버전)
 * 
 * 		- java.time.LocalDate : 날짜 표현
 * 		- java.time.Period : 년/월/일 단위의 기간
 * 			- Period.between(startDate, endDate);
 * 				- 두 날짜 사이의 기간을 년, 월, 일로 정확하게 계산함 
 * 					- 윤년 자동 반영
 * 					- 월별 일수 (28~31일) 자동 반영 
 * 		- java.time.temporal.ChronoUnit : 다양한 시간 단위로 차이 계산 
 * 				- ChronoUnit.XXXX.between(startDate, endDate)
 * 					- 특정 단위로 두 날짜/시간의 차이를 계산 
 * 					- 다양한 단위 지원
 * 					- 모든 계산에서 윤년과 월별 일수를 정확하게 반영 
 * 
 *   LocalDate 클래스
 *   	- Java 8에서 도입
 *   		- 기존 Date, Calendar 클래스의 문제점을 해결한 현대적인 API
 *   	- 시간 정보 없이 날짜(년/월/일)만 표현
 *   	- immutable (불변) 객체: 한 번 생성되면 값이 변하지 않음
 *   	- 시간대(timezone) 정보 없음 (순수한 날짜만)
 *   	- LocalDate.now() : 오늘 날짜 반환
 *   	- LocalDate.of(int year, int month, int dayOfMonth) : 특정 날짜 생성
 *   	- getYear(), getMonthValue(), getDayOfMonth()
 *   	- isAfter(), isBefore() : 날짜 비교
 *   	- isLeapYear() : 윤년 여부 확인
 * 
 * 
 * 출력 예시
 * 		- 정확히 11년 6개월 4일
 * 		- 11년
 * 		- 개월
 * 		- 주
 * 		- 일
 * 		- 시간
 * 		- 분
 * 		- 초 
 * 
 * 
 * 		- 통계
 * 		- 예상 심장 박동 수 :
 * 		- 예상 호흡 횟수 :
 * 		- 예상 수면 시간 : 
 * 		- 예상 식사 횟수 : 
 * 
 * 		- 살아온 기간 동안의 윤년 수
 * 		- 윤년 목록	
 * 	
 */
public class BirthdayTimeCalculator {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("=== 생일 기반 시간 계산기 ===");
		System.out.println("java.time 패키지를 사용하여 정확한 계산을 수행합니다.\n");
		
		System.out.println("--- 생일을 입력해주세요 ---");
		
		//연도입력
		System.out.print("태어난 연도 (예: 1995): ");
		while(!scanner.hasNextInt()) {
			System.out.print("잘못된 입력입니다. 연도를 입력하세요: ");
			scanner.next();
		}
		int birthYear = scanner.nextInt();
		
		//월 입력
		System.out.print("태어난 월 (1-12): ");
		while(!scanner.hasNextInt()) {
			System.out.print("잘못된 입력입니다. 월을 입력하세요: ");
			scanner.next();
		}
		int birthMonth = scanner.nextInt();
		
		//일 입력
		System.out.print("태어난 일 (1-31): ");
		while(!scanner.hasNextInt()) {
			System.out.print("잘못된 입력입니다. 일를 입력하세요: ");
			scanner.next();
		}
		int birthDay = scanner.nextInt();
		
		LocalDate birthDate;
		
		try {
			birthDate = LocalDate.of(birthYear, birthMonth, birthDay);		// 생일		
		} catch (Exception e) {
			System.out.println("\n 잘못된 날짜입니다. (예: 2월 30일은 존재하지 않음)");
			scanner.close();
			return;
		}
		
		
		LocalDate today = LocalDate.now();				//오늘 날짜 (시간 정보 없음)
		LocalDateTime now = LocalDateTime.now();		// 현재 날짜 + 시간 (시/분/초 포함)
		
		if(birthDate.isAfter(today)) {		// 생일이 오늘보다 미래인지 확인
			System.out.println("\n 아직 태어나지 않은 날짜입니다.");
			scanner.close();
			return;
		}
		
		Period period = Period.between(birthDate, today);
		
		int years = period.getYears();			// 만 나이 (년 단위)
		int months = period.getMonths();		// 월 (0~11)
		int days = period.getDays();			// 일 (0~30)
		
		long totalYears = ChronoUnit.YEARS.between(birthDate, today); // 년 단위로 두 날짜 사이의 차이 계산
		long totalMonths = ChronoUnit.MONTHS.between(birthDate, today); // 월 단위로 두 날짜 사이의 차이 계산
		long totalWeeks = ChronoUnit.WEEKS.between(birthDate, today); // 주 단위로 두 날짜 사이의 차이 계산
		long totalDays = ChronoUnit.DAYS.between(birthDate, today); // 일 단위로 두 날짜 사이의 차이 계산
		
		LocalDateTime birthDateTime = birthDate.atStartOfDay();  // 해당 날짜의 시작 시각(00:00:00)으로 LocalDateTime 생성
		long totalHours = ChronoUnit.HOURS.between(birthDateTime, now);
		long totalMinutes = ChronoUnit.MINUTES.between(birthDateTime, now);
		long totalSeconds = ChronoUnit.SECONDS.between(birthDateTime, now);
		
		

		System.out.printf("총 %,d년    %n", totalYears);
		System.out.printf("총 %,d개월    %n", totalMonths);
		System.out.printf("총 %,d주    %n", totalWeeks);
		System.out.printf("총 %,d일    %n", totalDays);
		System.out.printf("총 %,d시간    %n", totalHours);
		System.out.printf("총 %,d분    %n", totalMinutes);
		System.out.printf("총 %,d초    %n", totalSeconds);
		
		System.out.println("\n --- 재밌는 통계 ---");
		
		// 심장 박동 수 (평균 분당 70회)
		long heartbeats = totalMinutes * 70;
		System.out.printf("예상 심장 박동 수: 약 %,d회 (분당 70회 기준)%n", heartbeats);
		
		// 호흡 횟수 (평균 분당 15회)
		long breaths = totalMinutes * 15;
		System.out.printf("예상 호흡 횟수: 약 %,d회 (분당 15회 기준)%n", breaths);
		
		// 수면 시간 (하루 평균 8시간 가정)
		long sleepHours = totalDays * 8;			// 총 일수 * 하루 8시간 = 총 수면 시간
		long sleepYears = sleepHours / (365 * 24);  // 총 수면 시간 / (1년의 시간) = 수면으로 보낸 년수
		System.out.printf("예상 수면 시간: 약 %,d시간 (약 %,d년, 하루 8시간 기준)%n", sleepHours, sleepYears);
		
		// 식사 횟수 (하루 3끼)
		long meals = totalDays * 3;
		System.out.printf("예상 식사 횟수: 약 %,d회 (하루 3끼 기준)%n", meals);
		
		System.out.println("\n --- 윤년 정보 --- ");
		int leapYearCount = 0;							// 윤년 개수를 저장할 변수
		StringBuilder leapYears = new StringBuilder();  // 윤년 목록을 문자열로 저장할 객체변수 (동적으로 문자열을 이어붙이기 위해)
		
		for(int year = birthYear; year <= today.getYear(); year++) {  // 태어난 해부터 현재 연도까지 반복
			if(isLeapYear(year)) {		// 해당 연도가 윤년인지 확인
				leapYearCount++;		// 윤년 개수가 1증가
				if(leapYears.length()>0) {   // 첫번째 윤년이 아니면 (목록에 내용이 있으면)
					leapYears.append(", ");
				}
				leapYears.append(year);		// 윤년 연도를 목록에 추가 
			}
		}
		
		System.out.printf("살아온 기간 동안의 윤년 수: %d개%n", leapYearCount); 	// 총 윤년 개수 출력
		if(leapYearCount > 0 && leapYearCount <= 10) {		// 윤년이 1-10개 사이면
			System.out.println("윤년 목록 : " + leapYears);   // 윤년 목록 전체 출력
		} else if(leapYearCount > 10) {						// 윤년이 10개 초과면
			System.out.println("(윤년이 많아 목록 생략)");  		// 목록이 너무 길어서 생략 메시지 출력	
		}
				
		scanner.close();
	}

	// 윤년 여부 판단 메서드
	/*
	 * 윤년 규칙
	 * 	- 4로 나누어 떨어지면 윤년
	 *  - 단, 100으로 나누어 떨어지면 평년
	 *  - 단, 400으로 나누어 떨어지면 윤년
	 */
	private static boolean isLeapYear(int year) {
		// 400으로 나누어 떨어지면 윤년
		if(year % 400 == 0) return true;
		// 100으로 나누어 떨어지면 평년
		if(year % 100 == 0) return false;
		// 4로 나누어 떨어지면 윤년
		return year % 4 == 0;
	}
}



























