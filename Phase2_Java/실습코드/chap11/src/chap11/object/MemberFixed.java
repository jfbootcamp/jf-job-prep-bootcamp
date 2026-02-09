package chap11.object;

import java.util.Objects;

/*
 * hashCode() 올바르게 재정의한 않은 Member 클래스
 * 	- equals()를 재정의 (id 기반 비교)
 *  - hashCode()도 같은 필드(id)로 재정의
 *  - 규칙 : equals()가 true -> hashCode()도 같아야 함 
 * 
 */
public class MemberFixed {

	private String id;
	private String name;
	private int age;
	
	public MemberFixed(String id, String name, int age) {
		//super();
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	// equals()만 재정의 - id가 같으면 같은 회원
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;			// 같은 참조(주소)면 무조건 같음
		if (obj == null || getClass() != obj.getClass()) return false;		// null이거나 타입이 다르면 다름
		MemberFixed other = (MemberFixed)obj;
		return this.id != null && this.id.equals(other.id);  // id 값이 같으면 같은 회원으로 판단
	}
	
	/*
	 * 	hashCode() 재정의 - equals()에서 사용한 필드(id)로 생성
	 * --> 이렇게 하면 id가 같은 객체끼리 같은 hashCode를 가짐.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public String toString() {
		return String.format("Member{id= '%s', name = '%s', age=%d}", id, name, age);
	}
	
	
	
}












