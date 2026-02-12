package chap13.arraylist;

import java.util.ArrayList;

/* 
 *  ArrayList로 학생 성적 관리 - CRUD 기능 제공
 */

public class GradeManager {
	private String className;				// 반 이름
	private ArrayList<Student> students;	// 학생 목록
	
	public GradeManager(String className) {
		//super();
		this.className = className;
		this.students = new ArrayList<>();		// 빈 리스트 시작 
	}
	
	// 학생 추가
	public void addStudent(String name, int score) {
		students.add(new Student(name, score));		// 객체생성 + 리스트 추가
		System.out.println("  + " +name+ " 추가됨 (현재 " +students.size()+ "명)");
	}
	
	// 학생 삭제
	public void removeStudent(String name) {
		for(int i = 0; i < students.size(); i++) {
			if(students.get(i).getName().equals(name)) {   //문자열 비교는 equals() 사용
				students.remove(i);		// 해당 인덱스 삭제, 뒤 요소는 한 칸씩 앞으로
				System.out.println(" - " + name + " 삭제됨");
				return;  // 첫 번째만 삭제 후 종료 
			}
		}
		System.out.println(" X " +name+ " 학생을 찾을 수 없습니다.");
	}
	
	// 학생 검색 (선형 검색)
	public Student findStudent(String name) {
		for(Student s : students) {			// 읽기만 하므로 for-each 사용
			if(s.getName().equals(name)) {
				return s;			// 원본 객체의 참조를 반환 (복사본 아님)
			}
		}
		return null;			// 못 찾으면 null --> 호출 쪽에서 null 체크 필수 
	}
	
	// 점수 수정
	public void updateScore(String name, int newScore) {
		Student s = findStudent(name);		// 이름으로 검색
		if(s != null) {
			int old = s.getScore();			// 변경 전 점수
			s.setScore(newScore); 			// findStudent가 원본 참조를 반환하므로 리스트 안의 데이터도 변경됨
			System.out.println(" ~ " +name+ " 점수 변경: " +old+ " -> " + newScore);
		} else {
			System.out.println(" X " +name+ " 학생을 찾을 수 없습니다.");
		}
	}
	
	// 전체 출력
	public void showAll() {
		System.out.println("\n === " +className+ " 성적표 ===");
		for(int i = 0 ; i < students.size(); i++) {
			System.out.println("  " +(i+1)+ ". " + students.get(i));
		}
		System.out.println("  총 " + students.size()+"명");
	}
	
	// 통계
	public void showStatistics() {
		if (students.isEmpty()) {	// 빈 리스트 체크
			System.out.println(" 등록된 학생이 없습니다.");
			return;
		}
		int sum = 0;		//점수 합계
		Student top = students.get(0);		// 첫 번째 학생을 기준값으로 초기화 (객체로 추적해야 이름도 출력 가능)
		Student bottom = students.get(0);
		
		for(Student s : students) {		// 한 번 순회 --> 합계/최고/최저 모두 계산
			sum += s.getScore();		// 합계 누적
			if(s.getScore() > top.getScore()) top = s;		     // 최고점 갱신
			if(s.getScore() < bottom.getScore()) bottom = s;	// 최저점 갱신
		}
		
		System.out.printf(" 평균: %.1f점\n", (double)sum / students.size());
		System.out.println(" 최고: " + top); 		// toString() 자동 호출
		System.out.println(" 최저: " + bottom); 		// toString() 자동 호출
	}
	
	// 등록된 학생 수 반환
	public int getCount() {
		
		return 0;
	}
}












