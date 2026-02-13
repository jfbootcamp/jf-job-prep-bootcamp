package chap13.hashmap;

import java.util.HashMap;
import java.util.Map;

/*
 * 	- HashMap 기본 메서드 (put, get, remove, containsKey, size)
 *  - null 처리와 안전한 접근 (getOrDefault, putIfAbsent)
 *  - Map 순회하는 방법
 *  
 */
public class Main {
	public static void main(String[] args) {
		System.out.println("------------------------------------");		
		System.out.println(" HashMap - 전화번호부");
		System.out.println("------------------------------------");		
		
		// Map 실무 활용 : 설정값 저장/조회, 사용자 정보 업데이트 
		System.out.println(">> 1: HashMap 기본 - put과 get");
		System.out.println("------------------------------------");	
		
		HashMap<String, String> phoneMap = new HashMap<>();   // Key : 이름, Value : 전화번호
		
		phoneMap.put("김철수", "010-1111-1111");		// put: 키-값 쌍 추가
		phoneMap.put("이영희", "010-2222-2222");		// put: 키-값 쌍 추가
		phoneMap.put("박민수", "010-3333-3333");		// put: 키-값 쌍 추가
		
		System.out.println(" phoneMap : "+phoneMap);   // 전체 Map 출력
		System.out.println(" size : "+phoneMap.size());   // 저장된 항목 수
		
		System.out.println(" get(\"김철수\") : "+ phoneMap.get("김철수"));  // get: 키로 값 조회
		System.out.println(" get(\"홍길동\") : "+ phoneMap.get("홍길동"));  // null: 없는 키
		
		phoneMap.put("김철수", "010-9999-9999");	 // 같은 키로 put하면 값 덮어쓰기 
		System.out.println("김철수 번호 변경 후 : "+ phoneMap.get("김철수"));   // 변경된 값 확인
		
		System.out.println(">> 2: 조회, 삭제, 안전한 접근");
		System.out.println("------------------------------------");	
		
		System.out.println(" containsKey(\"이영희\") : "+phoneMap.containsKey("이영희"));   // 키 존재
		System.out.println(" containsKey(\"홍길동\") : "+phoneMap.containsKey("홍길동"));   
		
		phoneMap.remove("박민수");		// remove : 키로 항목 삭제
		System.out.println(" remove(\"박민수\") 후 : "+phoneMap);   // 삭제 결과 확인
		
		phoneMap.putIfAbsent("김철수", "010-0000-0000");  // "김철수" 키가 이미 있으므로 기존 값 유지하고 새값은 무시
		phoneMap.putIfAbsent("한지민", "010-5555-5555");  // "한지민" 키가 없으므로 새로 추가 (put과 동일하게 동작)
		
		System.out.println(" putIfAbsent 후 : "+phoneMap);   // 결과 확인
		
		System.out.println(">> 3: Map 순회 방법");
		System.out.println("------------------------------------");	
		
		phoneMap.put("박민수", "010-3333-3333");
		phoneMap.put("정수진", "010-4444-4444");
		
		// 방법 1 : keySet - 키만 순회 
		System.out.println("  방법 1 : keySet ");
		
		for(String name : phoneMap.keySet()) {  // keySet() --> {"김철수", "이영희", "한지민", "박민수", "정수진"}
			System.out.println("    " +name+ " -> " + phoneMap.get(name));
		}
		// 출력 의미 : HashMap은 저장 순서를 보장하지 않으므로, 출력 순서는 put한 순서와 다를 수 있음
		
		// 방법 2 :  values - 값만 순회 
		System.out.println("  방법 2 :  values ");
		for (String p : phoneMap.values()) {
			System.out.println("   " + p);
		}
		
		// 방법 3 : entrySet -  키-값 함께 순회 (가장 효율적)
		System.out.println("  방법 3 : entrySet ");
		for (Map.Entry<String, String> entry : phoneMap.entrySet()) {  // entrySet(): 키-값 쌍을 Set으로 반환
			System.out.println("    " +entry.getKey()+ " = " + entry.getValue());
		}
		
		// 방법 4 : forEach (Java 8+)
		phoneMap.forEach((name, p) -> {    // forEach: 람다식으로 간결하게 순회 
			System.out.println("    " +name+ " : " + p);
		});
		
		// HashMap<String, Contact> - 커스텀 객체
		// 실무 활용 : DAO/Service 계층에서 Map으로 엔티티를 관리하는 구조 
		System.out.println(">> 4: 커스텀 객체 - 전화번호부");
		System.out.println("------------------------------------");	
		
		PhoneBook book = new PhoneBook();		// 전화번호부 객체 생성
		book.add(new Contact("김철수", "010-1111-1111", "친구"));	  // 연락처 추가
		book.add(new Contact("이영희", "010-2222-2222", "직장"));	  // 연락처 추가
		book.add(new Contact("박민수", "010-3333-3333", "친구"));	  // 연락처 추가
		book.add(new Contact("정수진", "010-4444-4444", "가족"));	  // 연락처 추가
		book.add(new Contact("한지만", "010-5555-5555", "직장"));	  // 연락처 추가
		
		book.showAll();		// 전체 연락처 출력
		
		// 검색
		System.out.println("\n [검색]");
		Contact found = book.find("이영희");		// 이름으로 연락처 검색
		System.out.println(" 검색 결과: " + (found != null ? found : "없음"));  // 결과 출력
		
		// 삭제
		System.out.println("\n [삭제]");
		book.remove("정수진");
		book.showAll();
	}
}






























