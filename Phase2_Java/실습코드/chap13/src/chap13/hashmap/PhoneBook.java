package chap13.hashmap;

import java.util.HashMap;
import java.util.Map;

/*
 * 	HashMap으로 전화번호부 관리
 * 		- HashMap<String, Contact>를 사용하여 이름으로 빠르게 검색함 
 */
public class PhoneBook {
	private HashMap<String, Contact> contacts;		// 이름(키) --> 연락처(값) 저장 

	public PhoneBook() {
		//super();
		this.contacts = new HashMap<>();    // 비어있는 HashMap 객체를 생성하여 contacts 필드에 할당
	}

	// 연락처 추가
	public void add(Contact contact) {
		/*
		 * put(키, 갑)의 반환값
		 * 	- 키가 처음 등록될 때 --> null 반환 (이전에 저장된 값이 없으므로)
		 *    키가 이미 존재할 때 --> 덮어쓰기 전의 "이전 값(old value)"을 반환
		 */
		Contact previous = contacts.put(contact.getName(), contact);
		if(previous != null) { // 같은 이름(키)이 이미 있었음 = 기존 연락처가 새 값으로 교채된 것
			System.out.println("  ~ "+contact.getName()+ " 정보 업데이트 됨");
		} else {
			System.out.println("  ~ "+contact.getName()+ " 추가됨");
		}
	}
	
	// 전체 출력
	public void showAll() {
		System.out.println("\n === 전화번호부 ===");
		System.out.println(" 이름   | 전화번호     | 그룹");
		System.out.println("-----------------------------");	
		for(Map.Entry<String, Contact> entry : contacts.entrySet() ) {
			System.out.println("  " + entry.getValue());   // entry.getValue() = 각 항목의 Contact 객체 (toString()으로 출력)
		}
		System.out.println("  총 " + contacts.size() +"명");  // 전체 연락처 수 출력
	}
	
	// 연락처 검색
	/*
	 * get(키)의 반환값
	 * 	- 키가 존재할 때 --> 해당 키에 매핑된 값(Contact 객체)을 반환
	 *  - 키가 존재하지 않을 때 ->  null 반환
	 */
	public Contact find(String name) {
		return contacts.get(name);
	}
	
	// 연락처 삭제
	public void remove(String name) {
		Contact removed = contacts.remove(name);	// 삭제하고 삭제된 값 반환
		if (removed != null) {
			System.out.println(" - " +name+ "삭제됨");
		} else {	// 해당 이름이 없는 경우
			System.out.println(" X " +name+ "을(를) 찾을 수 없습니다.");
		}
	}
	
	
}
























