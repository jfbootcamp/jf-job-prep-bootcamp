package chap13.hashset;

import java.util.HashSet;
import java.util.Random;
import java.util.TreeSet;

public class Main {
	public static void main(String[] args) {
		System.out.println("--------------------------------------");
		System.out.println(" 2. HashSet - 로또 번호 생성  ");
		System.out.println("--------------------------------------\n");		
		
		// 1: HashSet 기본 - add와 중복 거부
		System.out.println(">> 1: HashSet 기본 - add와 중복이 안들어 감");
		System.out.println("----------------------------------------");	
		
		HashSet<Integer> lottoNumbers = new HashSet<>();	// 로또 번호 저장용 Set
		System.out.println("----------------------------------------");	
		
		Random random = new Random(34);		// seed 고정으로 재현 가능한 난수 생성
		while(lottoNumbers.size() < 6) {	// 6개가 될 때까지 반복
			int num = random.nextInt(45) + 1;   // nextInt(45) -> 0 ~ 44, +1 --> 1 ~ 45
			boolean added = lottoNumbers.add(num);   // add() : 중복이면 false
			if (!added) {		// 중복이 발생한 경우
				System.out.println("   중복 발생! " +num+ " -> 무시됨");
			}
		}
		
		System.out.println(" 로또 번호: " + new TreeSet<>(lottoNumbers));  // TreeSet으로 정렬해서 출력
		System.out.println(" size: " + lottoNumbers.size()); 
		
		System.out.println("\n -- add 반환값 --");
		HashSet<String> fruits = new HashSet<>();			// 과일 이름 저장용 Set
		System.out.println(fruits.add("사과"));
		System.out.println(fruits.add("바나나"));	
		System.out.println(fruits.add("사과"));		// false: 이미 존재하는 값
		System.out.println(fruits);					// 중복 제거된 결과 출력
		
		System.out.println(">> 2: 조회와 삭제");
		System.out.println(fruits.contains("사과"));
		System.out.println(fruits.contains("포도"));
		
		fruits.add("포도");
		fruits.add("딸기");
		System.out.println(" 추가 후 : " + fruits);
		
		fruits.remove("바나나");
		System.out.println(" 삭제 후 : " + fruits);
		
		
		
	}
}


























