package chap04.conditional;

public class IfLab {

	public static void main(String[] args) {
		
		// 1. null 안전한 문자열 비교
		System.out.println("[1. null 안전한 문자열 비교]");
		
		String userInput = null;
		
		// 방법1: 상수를 앞에
		if("admin".equals(userInput)) {
			System.out.println("관리자 계정입니다.");
		} else {
			System.out.println("일반 사용자입니다.");
		}
		
		// 방법2: null 체크 먼저
		if(userInput != null && userInput.equals("admin")) {
			System.out.println("관리자 계정입니다.");
		} else {
			System.out.println("일반 사용자입니다.");
		}
		
		System.out.println();
		
		// 2. Early Return 패턴 
		System.out.println("[2. Early Return 패턴]");	
		
		String result1 = validateUsername("admin123");
		String result2 = validateUsername("");
		String result3 = validateUsername(null);
		String result4 = validateUsername("ab");
		
		System.out.println("admin123: " + result1);
		System.out.println("빈문자열: " + result2);
		System.out.println("null: " + result3);
		System.out.println("ab: " + result4);
		
	}

	private static String validateUsername(String username) {
		//  Early Return 패턴
		if(username == null) {
			return "사용자명이 null입니다.";
		}
		if(username.isEmpty()) {
			return "사용자명을 입력해주세요.";
		}
		if(username.length() < 3) {
			return "사용자명은 3자 이상이어야 합니다.";
		}
		
		
		return "유효한 사용자명입니다.";
	}
}



















