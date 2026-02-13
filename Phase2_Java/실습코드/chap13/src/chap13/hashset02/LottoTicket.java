package chap13.hashset02;
/*
 *  로또 티겟
 *  
 *  	* 로또(Lotto)란?
 *  		- 1 ~ 45 사이의 숫자 중 6개를 선택하여 당첨 번호와 일치하는 개수에 따라 등수가 결정되는 복권이다.
 *  		- 번호의 순서는 의미가 없으며, 동일한 번호 조합은 하나의 티켓으로 취급됨
 *  		- 예) {3, 12, 25, 33, 41, 45}와 {45, 3, 25, 12, 41, 33}은 같은 티겟임
 *  
 *  	* HashSet은 중복 허용하지 않음
 *  		- 중복 판단 기준 : hashCode(), equals()를 오버라이드하여 번호 조합이 같으면 같은 티켓으로 판단함
 *  	* TreeSet : 번호를 오름차순으로 자동 정렬함 
 */

import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class LottoTicket {
	private TreeSet<Integer> numbers;		// 정렬된 번호 조합

	public LottoTicket(Set<Integer> numbers) {
		//super();
		this.numbers = new TreeSet<>(numbers);
	}

	public TreeSet<Integer> getNumbers() {
		return numbers;				// 로또 번호 6개를 꺼내주는 getter 메서드 
	}
	
	// equals / hashCode - 같은 번호 조합이면 같은 티켓
	@Override
	public int hashCode() {
		return Objects.hashCode(numbers);		// numbers 기반 해시코드 생성
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;			// 같은 객체면 true
		if (o == null || getClass() != o.getClass())  return false;	  // null이거나 다른 클래스면 false
		LottoTicket that = (LottoTicket) o;   // 다운캐스팅
		return Objects.equals(numbers, that.numbers);   // 내 로또 번호와 상대 로또 번호가 같은지 비교 		
	}

	@Override
	public String toString() {
		return "로또" + numbers;
	}
	
	
	
	
	
}









