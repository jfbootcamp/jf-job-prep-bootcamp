package chap13.hashset02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		System.out.println(">> 1: List vs Set - 같은 데이터 넣어보기");
		System.out.println("------------------------------------");
		
		String[] data = {"Java", "Python", "Java", "JavaScript", "Python", "Java", "Go"};
		
		List<String> list = new ArrayList<>();   // List: 중복 허용, 순서 유지
		for (String s : data) list.add(s);		// 모든 데이터를 List에 추가
		
		Set<String> set = new HashSet<>();       // Set: 중복 제거, 순서 보장 안됨
		for (String s : data) set.add(s);		// 모든 데이터를 Set에 추가 
		
		System.out.println(" 원본 데이터: " + Arrays.toString(data));
		System.out.println(" List : " +list+ " (size: " +list.size()+ ")");
		System.out.println(" Set : " +set+ " (size: " +set.size()+ ")");
		
		// 커스텀 객체 - hashCode/equals
		// 주문, 상품, 회원
		System.out.println(">> 2: hashCode/equals - 커스텀 객체의 중복 판단");
		System.out.println("------------------------------------------");
		
		Set<LottoTicket> tickets = new HashSet<>();		// 로또 티켓 저장용 Set
		
		LottoTicket ticket1 = new LottoTicket(Set.of(1, 7, 13, 25, 33, 45));  // 로또 번호 6개를 Set.of()를 만들어 LottoTicket 객체 생성함
		LottoTicket ticket2 = new LottoTicket(Set.of(3, 11, 22, 30, 38, 42));  // ticket1과 다른 번호로 두 번째 LottoTicket 객체 생성함
		LottoTicket ticket3 = new LottoTicket(Set.of(1, 7, 13, 25, 33, 45)); // ticket1과 동일한 번호로 세 번째 LottoTicket 객체 생성함 (중복 테스트용)
		
		tickets.add(ticket1);		// 첫 번째 티켓 추가
		tickets.add(ticket2);		// 두 번째 티켓 추가
		boolean added = tickets.add(ticket3);
		
		System.out.println(" ticket1 : "+ticket1);
		System.out.println(" ticket2 : "+ticket2);
		System.out.println(" ticket3 : "+ticket3);
		System.out.println(" ticket3 추가 성공? " + added);
		System.out.println(" tickets.size() : " + tickets.size());
	}
}
















