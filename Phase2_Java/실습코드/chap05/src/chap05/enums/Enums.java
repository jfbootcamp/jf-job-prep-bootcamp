package chap05.enums;

public class Enums {
	
	enum Day {	// 요일을 나타내는 열거 타입
		SUNDAY, MONDAY, TUESDAY, WENDSEDAY, THURSDAY, FRIDAY, SATURDAY   //요일 상수 - 각각이 Day 타입의 값 자체
	}
	
	enum Season {		// 계절을 나타내는 열거 타입
		SPRING, SUMMER, FALL, WINTER	//계절 상수 - 각각이 Season 타입의 값 자체
	}
	
	enum Grade {		// 성적 등급을 나타내는 열거 타입	
		A, B, C, D, F	// 등급 상수 - 각각이 Grade 타입의 값 자체 
	}
	
	enum Direction {
		NORTH, SOUTH, EAST, WEST
	}
	
	enum TrafficLight {
		RED, YELLOW, GREEN
	}
	
	enum Hand {
		ROCK, PAGER, SCISSORS
	}

	public static void main(String[] args) {
		// enum 변수 선언과 사용
		Day today = Day.MONDAY;						// Day 타입 변수에 Day.MONDAY 할당
		Season currentSeason = Season.WINTER;		// Season 타입 변수에 Season.WINTER 할당
		Grade myGrade = Grade.A;					// Grade 타입 변수에 Grade.A 할당
		
		System.out.println("오늘: " + today);
		System.out.println("현재 계졀: "+ currentSeason);
		System.out.println("내 성적: "+myGrade);
		
		// values() - 모든 상수 배열로 가져옴. 컴파일러가 자동 생성하는 static 메서드. 선언 순서대로 배열에 담겨 반환함
		Day[] allDays = Day.values();
		for(int i = 0; i < allDays.length; i++) {
			System.out.println(" " + allDays[i]);
		}
		
		// valueOf() - 문자열과 일치하는 enum 상수 반환 (문자열이 정확히 일치해야 함-대소문자 구분)
		// -- 일치하는 상수가 없으면 IllegalArgumentException 발생	
		
		// switch 문과 함께 사용
		Day someday = Day.FRIDAY;
		
		//전통적인 switch
		String dayType;
		switch(someday) {
			case MONDAY:
			case TUESDAY:
			case WENDSEDAY:
			case THURSDAY:
			case FRIDAY:
				dayType = "평일";
				break;
			case SATURDAY:
			case SUNDAY:
				dayType = "주말";
				break;
			default:
				dayType = "알 수 없음";	
		}
		System.out.println(someday +"은(는) "+ dayType + "입니다.");
		
		// switch 표현식(더 간결함)
		String dayType2 = switch(someday) {
			case MONDAY, TUESDAY, WENDSEDAY, THURSDAY, FRIDAY -> "평일";
			case SATURDAY, SUNDAY -> "주말";
		};
		System.out.println(someday +"은(는) "+ dayType2 + "입니다.");
		
		TrafficLight light = TrafficLight.RED;
		// 현재 신호에 따른 동작
		String action = switch(light) {
			case RED -> "정지하세요!";
			case YELLOW -> "주의";
			case GREEN -> "진행";
		};
		System.out.println("현재 신호: " +light+ " - " + action);
		
		System.out.println("\n--- 실습: 가위바위보 ---");
		
		Hand player = Hand.ROCK;			// 플레이어 선택: 바위
		Hand computer = Hand.PAGER;		// 컴퓨터 선택: 가위
		
		System.out.println("플레이어 : " + player);
		System.out.println("컴퓨터 : " + computer);
		
		// 승패 판정
		String result;
		if (player == computer) {			// 같은 Hand를 냈으면
			result = "무승부";				// 무승부 처리
		} else {
			// player=ROCK ==> computer는 SCISSORS 또는 PAGER만 가능
			result = switch(player) {
			case ROCK -> (computer == Hand.SCISSORS) ? "승리" : "패배";
			case PAGER -> (computer == Hand.ROCK) ? "승리" : "패배";
			case SCISSORS -> (computer == Hand.PAGER) ? "승리" : "패배"; 
			};
		}
		
		System.out.println("결과 : " + result);
		
	}
}




















