package chap05.enums;

import java.util.Scanner;

public class EnumScannerLab {

	enum Day {	// 요일을 나타내는 열거 타입
		SUNDAY, MONDAY, TUESDAY, WENDSEDAY, THURSDAY, FRIDAY, SATURDAY   //요일 상수 - 각각이 Day 타입의 값 자체
	}
	
	enum MenuOption {
		VIEW_DAYS,			// 요일 정보 보기
		EXIT				// 종료
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("=== 열거형 기초 (Scanner 버전) ===");
		
		boolean running = true;		// 프로그램 실행 상태 플래그 
		while(running) {
			printMenu();
			System.out.print("선택: ");
			
			//입력 검증 (숫자가 아닌 입력 처리)
			while(!scanner.hasNextInt()) {
				System.out.print("잘못된 입력입니다. 숫자를 입력하세요: ");
				scanner.next();		// 잘못된 입력 버퍼 비우기
			}
			int choice = scanner.nextInt();
			
			MenuOption selected = getMenuFromChoice(choice);
			
			if(selected == null) {
				System.out.println("잘못된 선택입니다. 0~1 사이의 숫자를 입력하세요.\n");
				continue;		// 메뉴 다시 출력
			}
			
			switch(selected) {
				case VIEW_DAYS -> viewDaysInfo(scanner);		// 요일 정보 조회
				case EXIT -> {
					running = false;			// 루프 종료 조건
					System.out.println("프로그램을 종료합니다.");
				}
			}
			
		}
		
		scanner.close();
	}

	private static void viewDaysInfo(Scanner scanner) {
		System.out.println("---요일 정보---");
		
		String[] businessHours = { "휴무", "09:00-18:00","09:00-18:00","09:00-18:00","09:00-18:00",
									"09:00-18:00", "10:00-15:00" };
		System.out.println("\n[영업시간 안내]");
		Day[] allDays = Day.values();		// 모든 요일을 배열로 가져옴
		for(int i = 0; i < allDays.length; i++) {
			//switch로 평일/주말 구분
			String type = switch(allDays[i]) {
				case SATURDAY, SUNDAY -> "(주말)"; 		// 다중 case
				default -> "(평일)";						// 나머지 모든 요일 
			};
			
			System.out.printf("   %s %s: %s%n", allDays[i].name(), type, businessHours[i]);
		}
		
		// 사용자 입력 받기 -- 올바른 요일을 입력될 때까지 반복
		Day day = null;
		while(day == null) {
			System.out.print("\n요일을 입력하세요 (예: MONDAY): ");
			String input = scanner.next().toUpperCase();		// 소문자 입력도 허용하기 위해 대문자 변환
			
			try {
				day = Day.valueOf(input);			// 문자열 --> Enum 변환 ("MONDAY" --> Day.MONDAY)
			}catch(IllegalArgumentException e) {
				System.out.println("잘못된 요일입니다. 영문 요일명을 정확히 입력하세요.");
				System.out.println("예: SUNDAY, MONDAY, TUESDAY, WENDSEDAY, THURSDAY, FRIDAY, SATURDAY ");
			}	
		}
		System.out.println("입력한 요일 : " + day);
		
		Day[] days = Day.values();
		int nextIndex = (day.ordinal() + 1) % days.length; 			// 일요일 다음은 월요일
		Day nextDay = days[nextIndex];
		System.out.println("다음 요일 : " + nextDay);
		
		String dayType = switch(day) {
			case SATURDAY, SUNDAY -> "주말";
			default -> "평일";
		};
		System.out.println("유형 : " + dayType);
	}

	private static MenuOption getMenuFromChoice(int choice) {
		//switch 표현식으로 숫자를 Enum으로 매핑
		
		return switch(choice) {
			case 0 -> MenuOption.EXIT;				// 종료
			case 1 -> MenuOption.VIEW_DAYS;			// 요일 정보
			default -> null;		// 유효하지 않은 선택 -> null 반환
		};
	}

	private static void printMenu() {
		System.out.println("\n======== 메뉴 ========");
		System.out.println("1. 요일 정보 보기");
		System.out.println("0. 종료");
	}
}

























