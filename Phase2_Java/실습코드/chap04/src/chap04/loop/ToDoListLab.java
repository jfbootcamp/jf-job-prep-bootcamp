package chap04.loop;

import java.util.Scanner;

/*
 *  목표 : do-while 메뉴 시스템과 배열을 활용한 CRUD(생성/조회/수정/삭제) 연습
 *  		- 배열로 데이터 저장 및 관리
 *  		- switch문으로 메뉴 분기 관리
 *  
 *  출력 예시 (최대 10까지 저장 가능)
 *  
 *   === Todo 메뉴 ===
 *   1. 할 일 추가
 *   2. 목록 조회
 *   3. 완료 표시
 *   4. 할 일 삭제
 *   0. 종료
 *   선택 : 1
 *   할 일 입력: 자바 공부하기
 *   "자바 공부하기"가 추가되었습니다.
 * 
 *     
 *   === Todo 메뉴 ===
 *   1. 할 일 추가
 *   2. 목록 조회
 *   3. 완료 표시
 *   4. 할 일 삭제
 *   0. 종료
 *   선택 : 1
 *   할 일 입력: 알고리즘 문제 풀기
 *   "알고리즘 문제 풀기"가 추가되었습니다. 
 *   
 *   
 *   === Todo 메뉴 ===
 *   1. 할 일 추가
 *   2. 목록 조회
 *   3. 완료 표시
 *   4. 할 일 삭제
 *   0. 종료
 *   선택 : 2 
 *   
 *   === 할 일 목록 (2개) ===
 *   1. [ ] 자바 공부하기
 *   2. [ ] 알고리즘 문제 풀기
 *   
 *   
 *   === Todo 메뉴 ===
 *   1. 할 일 추가
 *   2. 목록 조회
 *   3. 완료 표시
 *   4. 할 일 삭제
 *   0. 종료
 *   선택 : 3 
 *   
 *   === 할 일 목록 ===
 *   1. [ ] 자바 공부하기
 *   2. [ ] 알고리즘 문제 풀기
 *      
 *   완료할 항목 번호: 1
 *   "자바 공부하기"를 완료했습니다.  
 * 
 * 
 *   === Todo 메뉴 ===
 *   1. 할 일 추가
 *   2. 목록 조회
 *   3. 완료 표시
 *   4. 할 일 삭제
 *   0. 종료
 *   선택 : 2 
 *   
 *   === 할 일 목록 (2개) ===
 *   1. [v] 자바 공부하기
 *   2. [ ] 알고리즘 문제 풀기
 *   
 *    
 *   === Todo 메뉴 ===
 *   1. 할 일 추가
 *   2. 목록 조회
 *   3. 완료 표시
 *   4. 할 일 삭제
 *   0. 종료
 *   선택 : 4
 *   삭제할 항목 번호: 1
 *   "자바 공부하기"가 삭제되었습니다.
 *   
 *      
 *   === Todo 메뉴 ===
 *   1. 할 일 추가
 *   2. 목록 조회
 *   3. 완료 표시
 *   4. 할 일 삭제
 *   0. 종료
 *   선택 : 2 
 *   
 *   === 할 일 목록 (1개) ===
 *   1. [ ] 알고리즘 문제 풀기    
 *            
 *            
 *   === Todo 메뉴 ===
 *   1. 할 일 추가
 *   2. 목록 조회
 *   3. 완료 표시
 *   4. 할 일 삭제
 *   0. 종료
 *   선택 : 0
 *   프로그램을 종료합니다. 오늘도 수고하셨습니다!            
 *            
 */

public class ToDoListLab {

	static final int MAX_SIZE = 10;		// 최대 저장 가능 개수(상수)
	static String[] todos = new String[MAX_SIZE];
	static boolean[] completed = new boolean[MAX_SIZE];	// 완료 여부 저장 
	static int count = 0;					// 현재 저장된 할 일 개수
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("--- 할 일 목록 관리 시스템 ---");
		System.out.println("할 일을 추가하고, 완료 표시하고, 삭제할 수 있습니다.");
		System.out.println("(최대 "+MAX_SIZE+"개까지 저장 가능)\n");		
		
		int choice;
		
		do {
			printMenu();
			choice = readValidInt("선택 :  ");
			
			switch(choice) {
				case 1 -> addTodo();
				case 2 -> viewTodoList();
				case 3 -> markComplete();
				case 4 -> deleteTodo();
				case 0 -> System.out.println("프로그램을 종료합니다. 오늘도 수고하셨습니다!");
				default -> System.out.println("잘못된 선택입니다. 0~4 사이의 숫자를 입력하시오.");
			}
			
		} while(choice != 0);
		
		scanner.close();		
	}

	private static void deleteTodo() {
		if(count == 0) {
			System.out.println("삭제할 일이 없습니다.");
			return;
		}
		
		// 먼저 목록을 보여줌
		printTodoList(false); 		// 개수 표시 없이 목록만
		
		// 유효한 번호가 입력될 때까지 반복
		while(true) {
			int num = readValidInt("삭제할 항목 번호 (한 개만 선택, 0: 취소)");
			
			if(num == 0) {
				System.out.println("삭제가 취소되었습니다.");
				return;
			} else if (num < 1 || num > count) {
				System.out.println("유효하지 않은 번호입니다. 다시 입력해 주세요");
			} else {
				String deletedTodo = todos[num-1];			// 삭제할 항목 이름 저장
				boolean shouldDelete;						// 삭제 여부 플래그 
				
				// 삭제 전 확인 (미완료/완료 여부에 따라 메시지 다르게)
				if(!completed[num-1]) {      // !completed[num-1] == false
					System.out.println("\""+deletedTodo+"\"는 아직 완료되지 않았습니다. 정말 삭제하시겠습니까? (y/n): ");
				} else {
					System.out.println("\""+deletedTodo+"\"를 정말 삭제하시겠습니까? (y/n): ");
				}
				
				String confirm = scanner.nextLine().trim().toLowerCase();		// 입력값 정규화(공백 제거 및 소문자 변환)
				shouldDelete = confirm.equals("y") || confirm.equals("yes");	// y 또는 yes면 삭제 진행
				
				if(shouldDelete) {
					/*
					 * 	배열에서 삭제하는 방법
					 *		- 삭제할 위치 이후의 모든 요소를 한 칸씩 앞으로 이동
					 *		- 예: [A, B, C, D] (count = 4)에서 사용자가 2번(B) 삭제 시
					 *			num = 2, 삭제할 인덱스 = num-1 = 1
					 *			반복: for(i=1; i<3; i++)
					 *				   i=1: todo[1] = todo[2] --> [A,C,C,D]
					 *                 i=2: todo[2] = todo[3] --> [A,C,D,D]
					 */
					for(int i = num-1; i < count -1; i++) {
						todos[i] = todos[i+1];		// 다음 요소를 현재 위치로 복사 (할 일 내용)
						completed[i] = completed[i+1];		// 다음 요소를 현재 위치로 복사 (완료 여부)
					}
					count--;		// 유효 데이터 개수 1 감소 (배열 크기는 그대로, 논리적 크기만 줄어듦)
					
					System.out.println("\""+deletedTodo+"\" 삭제하였습니다. ");
				} else {
					System.out.println("삭제가 취소되었습니다.");
				}
				break;
			}
	
		}
		
	}

	private static void markComplete() {
		if(count == 0) {
			System.out.println("완료 표시할 일이 없습니다.");
			return;
		}
		
		// 먼저 목록을 보여줌
		printTodoList(false);
		
		// 유효한 번호가 입력될 때까지 반복
		while(true) {
			int num = readValidInt("완료할 항목 번호 (0: 취소): ");
			
			if (num == 0) {
				System.out.println("완료 표시가 취소되었습니다.");
				break;
			} else if (num < 1 || num > count) {
				System.out.println("유효하지 않은 번호입니다. 다시 입력해주세요.");
			} else if (completed[num - 1]) {		// completed[num - 1] == true
				// 이미 완료된 항목
				System.out.println("\""+todos[num-1]+"\"는 이미 완료된 항목입니다.");
			} else {
				// 완료처리 (사용자 입력은 1부터, 배열 인덱스는 0부터이므로 num-1
				completed[num-1] = true;
				System.out.println("\""+todos[num-1]+"\"를  완료했습니다.");
				break;
			}
		}
		
	}

	private static void viewTodoList() {
		
		if(count == 0) {
			System.out.println("\n 할 일이 없습니다. 새로운 할 일을 추가해보시오.");
			return;
		}
		
		printTodoList(true);		// 개수 표시 포함
	}

	private static void printTodoList(boolean showCount) {
		if(showCount) {
			System.out.println("\n=== 할 일 목록 ("+count+"개) ===");
		} else {
			System.out.println("\n===할 일 목록 ===");
		}
		
		// 저장된 개수(count)만큼만 반복
		for(int i = 0; i < count; i++) {
			// 완료 여부에 따라 [v] 또는 [ ] 출력
			String status = completed[i] ? "[v]" : "[ ]";;		// 완료 여부에 따라 체크 표시
			// 사용자에게 1부터 시작하는 번호로 보여줌 (i+1)
			System.out.println((i+1) +". "+ status +" "+ todos[i]);  // 1부터 시작하는 번호로 표시
		}
		
	}

	private static void addTodo() {
		
		// 배열이 가득 찼는지 확인
		if(count >= MAX_SIZE) {
			System.out.println("할 일 목록이 가득 찼습니다. (최대 " +MAX_SIZE+ "개)");
			return;
		}
		
		System.out.print("할 일 입력: ");
		String todo = scanner.nextLine();
		
		// 빈 문자열 체크
		if(todo.trim().isEmpty()) {
			System.out.println("할 일 내용을 입력해주세요.");
			return;
		}
		
		// 배열 끝에 추가
		todos[count] = todo;		// count 위치에 할 일 저장
		completed[count] = false;	// 새 할일은 미완료 상태
		count++;					// 개수 증가
		
		System.out.println("\" "+todo+"\"가 추가되었습니다. ");
	}

	/*
	 * [공통 메서드]정수 입력 검증
	 * 	- 정수가 아닌 입력이 들어오면 재입력 요청
	 * 	- prompt : 입력 안내 메시지 
	 */
	private static int readValidInt(String prompt) {
		System.out.print(prompt);
		
		// 입력 검증
		while(!scanner.hasNextInt()) {
			System.out.println("잘못된 입력입니다. 점수를 입력하세요: ");
			scanner.next();		// 잘못된 입력 버리기 
		}
		
		int value = scanner.nextInt();
		scanner.nextLine();			// 버퍼 비우기 (nextInt()후 nextLine() 사용 시 필수)
		
		return value;
	}

	private static void printMenu() {
		System.out.println("\n=== Todo 메뉴 ===");
		System.out.println("1. 할 일 추가");
		System.out.println("2. 목록 조회");
		System.out.println("3. 완료 표시");
		System.out.println("4. 할 일 삭제");
		System.out.println("0. 종료");
	}
	
	
}





















