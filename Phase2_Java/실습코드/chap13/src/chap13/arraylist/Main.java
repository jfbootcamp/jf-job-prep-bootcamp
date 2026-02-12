package chap13.arraylist;

import java.util.ArrayList;

/*
 *   ArrayList - 학생 성적 관리
 *   	- ArrayList 생성과 기본 메서드 (add, get, set, remove, size, contains)
 *   	- ArrayList에 커스텀 객체 저장하기
 *   	- 실무에서 자주 쓰는 유틸리티 메서드 
 */
public class Main {
	public static void main(String[] args) {
		System.out.println("--------------------------------------");
		System.out.println(" 1. ArrayList - 학생 성적 관리  ");
		System.out.println("--------------------------------------\n");		
		
		// 1. ArrayList 생성 + add + size + 출력
		System.out.println(">> 1. ArrayList 생성 + add ");
		System.out.println("--------------------------------------\n");	
		
		ArrayList<String> names = new ArrayList<>(); 		// 배열과 달리 크기를 미리 정하지 않음
		names.add("김철수");		// add: 끝에 추가
		names.add("이영희");
		names.add("박민수");
		names.add("정수진");
		names.add("한지민");
		
		System.out.println(" names: " +names);			// toString()으로 전체 출력
		System.out.println(" size: "+names.size());		// 요소 개수 
		System.out.println(" isEmpty: "+names.isEmpty());	// 비어있는지 확인
		
		System.out.print(" 반복 출력: ");
		for (String name : names) {
			System.out.print(name + " ");
		}
		System.out.println();
		
		// 2. get, set, contains, indexOf
		System.out.println(">> 2. 조회와 수정 ");
		System.out.println("--------------------------------------\n");	
		
		System.out.println(" get(0) : "+names.get(0));			// 인덱스로 접근 (배열의 arr[i]와 동일)
		System.out.println(" get(2) : "+names.get(2));
		
		names.set(1, "이수정");
		System.out.println(" set() 수정 후: "+names);
		
		System.out.println(" contains() : "+names.contains("박민수"));		// 포함 여부
		System.out.println(" contains() : "+names.contains("홍길동"));
		
		System.out.println(" indexOf() : "+names.indexOf("한지민"));    // 위치 찾기 (-1이면 없음)
		System.out.println(" indexOf() : "+names.indexOf("홍길동"));
		
		// 3. remove
		System.out.println(">> 3. 삭제 ");
		System.out.println("--------------------------------------\n");		
		
		System.out.println(" 삭제 전: " +names+ " (size: " + names.size() + ")");
		
		String removed = names.remove(0);		// 인덱스로 삭제
		System.out.println(" remove(0) -> " + removed + " 삭제됨");
		//System.out.println(" 현재: "+ names);
		System.out.println(" 현재: " +names+ " (size: " + names.size() + ")");
		
		boolean success =  names.remove("정수진");		// 값으로 삭제 (성공 시 true)
		System.out.println(" remove(\"정수진\") -> " + success);
		System.out.println(" 현재: " +names+ " (size: " + names.size() + ")");
		System.out.println();
		
		// 4. ArrayList<Student> - 커스텀 객체 CRUD
		System.out.println(">> 4. 커스텀 객체 - 성적 관리 ");
		System.out.println("--------------------------------------\n");		
		
		GradeManager manager = new GradeManager("Java 기초반");
		
		manager.addStudent("김철수", 95);
		manager.addStudent("이영희", 87);
		manager.addStudent("박민수", 72);
		manager.addStudent("정수진", 63);
		manager.addStudent("한지민", 91);
		
		manager.showAll();		
		
		System.out.println("\n [검색]");
		Student found = manager.findStudent("이영희");		// 이름으로 검색
		System.out.println(" 결과: " + (found != null ? found : "없음"));  //null이면 "없음" 출력
		
		System.out.println("\n [수정]");
		manager.updateScore("박민수", 80);
		
		System.out.println("\n [삭제]");
		manager.removeStudent("정수민");
		
		System.out.println("\n [통계]");
		manager.showStatistics();
		
		manager.showAll();
		
	}
}




















