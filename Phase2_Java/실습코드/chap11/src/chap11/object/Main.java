package chap11.object;

public class Main {

	public static void main(String[] args) {
		// 1. 평소처럼 객체 생성하기
		Member m1 = new Member("A0001", "이순신", 25);
		Member m2 = new Member("B0002", "신사임당", 30);
		
		System.out.println(m1);
		System.out.println(m2);
		
		System.out.println();
		
		System.out.println(m1.hashCode());
		System.out.println(m2.hashCode());
		System.out.println();
		
		// 같은 id, 같은 이름, 같은 나이로 2개 객체 생성
		Member twin1 = new Member("A001", "이방원", 26);
		Member twin2 = new Member("A001", "이방원", 26);
		
		System.out.println(twin1);
		System.out.println(twin2);
		
		System.out.println(twin1.equals(twin2));
		System.out.println(twin1.hashCode());
		System.out.println(twin2.hashCode());	
		System.out.println();
		
		/*
		 * 	이미 가입한 회원인데, 또 가입이 됨 
		 */
				
		// 정리 
		// Before 
		Member bm1 = new Member("A001", "황희", 25);
		Member bm2 = new Member("A001", "황희", 25);
		boolean beforeSameHash = bm1.hashCode() == bm2.hashCode();
		System.out.println("  | 재정의 X    | 메모리 주소  |  "
				 + (beforeSameHash ? "equals호출됨 " : "equals호출 안됨") + " " );
		
		// After 
		MemberFixed am1 = new MemberFixed("A001", "정도전", 25);
		MemberFixed am2 = new MemberFixed("A001", "정도전", 25);
		boolean afterSameHash = am1.hashCode() == am2.hashCode();
		System.out.println("  | 재정의 O    | 메모리 주소  |  "
				 + (afterSameHash ? "equals호출됨 " : "equals호출 안됨") + " " );		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
