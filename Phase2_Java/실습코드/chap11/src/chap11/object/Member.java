package chap11.object;

/*
 * hashCode() 재정의를 하지 않은 Member 클래스
 */
public class Member {

	private String id;
	private String name;
	private int age;
	
	public Member(String id, String name, int age) {
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
		Member other = (Member)obj;
		return this.id != null && this.id.equals(other.id);  // id 값이 같으면 같은 회원으로 판단
	}

	@Override
	public String toString() {
		return String.format("Member{id= '%s', name = '%s', age=%d}", id, name, age);
	}
	
	
	
}












