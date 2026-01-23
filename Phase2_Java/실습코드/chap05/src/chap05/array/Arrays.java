package chap05.array;

public class Arrays {

	public static void main(String[] args) {
		
		// 1. 배열 선언과 초기화
		System.out.println("--- 1. 배열 선언과 초기화 ---");
		
		// 방법 1: 선언 후 생성
		int[] numbers1;
		numbers1 = new int[5];		// 크기 5인 배열 생성 (기본값 0)
		
		// 방법 2: 선언과 동시에 생성
		int[] numbers2 = new int[5];
		
		// 방법 3: 선언과 동시에 초기화
		int[] numbers3 = {10, 20, 30, 40, 50};
		
		// 방법 4: new 키워드와 함께 초기화
		int[] numbers4 = new int[] {10, 20, 30, 40, 50};
		
		System.out.println("numbers3 배열 길이: "+ numbers3.length);
		System.out.println("numbers3[0]: " + numbers3[0]);
		System.out.println("numbers3[4]: " + numbers3[4]);
		
		// 2. 배열 요소 접근과 수정
		System.out.println("--- 2. 배열 요소 접근과 수정 ---");
		
		int[] scores = new int[5];
		System.out.println("초기화 전 scores[0]: " + scores[0]);
		
		// 값 할당
		scores[0] = 95;
		scores[1] = 88;
		scores[2] = 76;
		scores[3] = 92;
		scores[4] = 83;
		
		System.out.println("값 할당 후 : ");
		for(int i = 0; i < scores.length; i++) {
			System.out.println("scores[" +i+ "] = " + scores[i]);
		}
		
		// 3. 향상된 for문으로 배열 순회
		System.out.println("--- 3. 향상된 for문(for-each) ---");
		
		String[] fruits = {"사과", "바나나", "오렌지", "포도", "망고"};
		
		System.out.println("과일 목록");
		for(String fruit : fruits) {
			System.out.println("- " + fruit);
		}
		System.out.println();
		
		// 4. 배열의 합계와 평균
		int[] examScores = {95, 88, 76, 92, 83};
		int sum = 0;
		
		for(int score : examScores) {
			sum += score;
		}
		
		double average = (double)sum / examScores.length;
		
		System.out.println("점수 : ");
		for(int score : examScores) {
			System.out.print(score + " ");
		}
		System.out.println();
		System.out.println("합계: " + sum);
		System.out.printf("평균: %.2f%n", average);
		
		// 5. 최대값과 최소값 찾기
		System.out.println("\n--- 5. 최대값과 최소값 찾기 ---");
		
		int[] values = {36, 78, 12, 89, 45, 23, 67};
		
		/*
		 * 최대값과 최소값 찾기 알고리즘 
		 * 	- 핵심 아이디어
		 * 		- 배열의 첫 번째 요소를 기준값으로 설정한 후,
		 *        나머지 요소들과 비교하여 더 큰/작은 값을 발견하면 갱신함
		 *      - 첫 번째 요소를 최대값과 최소값의 초기 기준으로 설정
		 *        두 번째 요소(인덱스 1)부터 순회 시작
		 *        현재 요소가 기존 최대값보다 큰 경우 --> 최대값을 현재 요소로 갱신
		 *                                         최대값 인덱스도 함께 갱신   
		 *        현재 요소가 기존 최소값보다 작은 경우 --> 최소값을 현재 요소로 갱신
		 *                                          최소값 인덱스도 함께 갱신  		 *                                         
		 */
		
		int max = values[0];			// 현재까지 발견된 최대값
		int min = values[0];			// 현재까지 발견된 최소값
		int maxIndex = 0;				// 최대값이 위치한 인덱스
		int minIndex = 0;				// 최소값이 위치한 인덱스
		
		for(int i = 1; i < values.length; i++) {
			if(values[i] > max) {		// 최대값 갱신 (현재 요소가 기존 최대값보다 큰 경우)
				max = values[i];
				maxIndex = i;
			}
			
			if(values[i] < min) {		// 최소값 갱신 (현재 요소가 기존 최소값보다 작은 경우)
				min = values[i];
				minIndex = i;
			}
		}
		
		System.out.print("배열: ");
		for(int v : values) {
			System.out.print(v + " ");
		}
		System.out.println();
		System.out.println("최대값: " +max+ " (인덱스: " +maxIndex+ ")");
		System.out.println("최소값: " +min+ " (인덱스: " +minIndex+ ")");
		
		// 6. 배열 요소 검색
		System.out.println("\n--- 6. 배열 요소 검색 ---");
		
		int[] data = {5, 2, 9, 1, 7, 3, 8};
		
		/*
		 * 선형 검색 알고리즘
		 * 	- 핵심 아이디어
		 * 		- 배열의 처음부터 끝까지 순차적으로 탐색하여
		 *        찾고자 하는 값(target)과 일치하는 요소를 발견하면 즉시 종료함
		 */
		
		// 검색할 목표값과 결과를 저장할 변수 선언과 초기화
		int target = 0;
		int foundIndex = -1;
		
		for(int i = 0; i < data.length; i++) {
			
			if(data[i] == target) {
				foundIndex = i;
				break;
			}
		}
		
		if(foundIndex != -1) {
			System.out.println(target +"을(를) 인덱스 "+ foundIndex + "에서 찾았습니다.");
		} else {
			System.out.println(target + "을(를) 찾지 못했습니다.");
		}
		
	}
}























