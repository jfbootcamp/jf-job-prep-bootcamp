package chap05.array02;

import java.util.Arrays;

public class ArrayCopy {

	public static void main(String[] args) {
		System.out.println("--- 1. 배열 복사 ---");
		
		int[] original = {1, 2, 3, 4, 5};
		
		/*
		 * 방법 1. 반복문으로 복사 (Manual Copy)
		 * 	- 장점: 복사 과정을 완전히 제어 가능, 조건부 복사 가능
		 * 	- 단점: 코드가 길고, 직접 구현해야 함
		 * 	- 적합한 상황: 복사 중 값을 변환하거나 필터링이 필요할 때 
		 */
		
		int[] copy1 = new int[original.length];		// 같은 크기의 새 배열 생성 
		for(int i = 0; i < original.length; i++) {
			copy1[i] = original[i];					// 요소를 하나씩 복사
		}
		
//		System.out.println("원본 수정 전:");
//		System.out.println("original[0] : "+original[0]);
//		System.out.println("copy1[0] : "+copy1[0]);
//		
//		original[0] = 999;
//		
//		System.out.println("원본 수정 후:");
//		System.out.println("original[0] : "+original[0]);
//		System.out.println("copy1[0] : "+copy1[0]);		
//		
//		System.out.println();
		
		/*
		 * 	방법 2:  System.arraycopy() 사용
		 *   - 네이티브 메서드로 가장 빠른 성능을 제공
		 *   - 매개변수 : (원본배열, 원본시작위치, 대상배열, 대상시작위치, 복사길이)
		 *   - 장점 : 가장 빠름, 부분 복사 가능
		 *   - 단점 : 대상 배열을 미리 생성해야 함
		 *   - 적합한 상황 : 성능이 중요하거나 부분 복사가 필요할 때  			
		 */
		int[] copy2 = new int[original.length];
		System.arraycopy(original, 0, copy2, 0, original.length);
		
//		System.out.println("원본 수정 전:");
//		System.out.println("original[0] : "+original[0]);
//		System.out.println("copy2[0] : "+copy2[0]);
//		
//		original[0] = 999;
//		
//		System.out.println("원본 수정 후:");
//		System.out.println("original[0] : "+original[0]);
//		System.out.println("copy2[0] : "+copy2[0]);			
		
		/*
		 * 방법 3: Arrays.copyOf()  사용
		 * 	- 매개변수 : (원본배열, 새로운길이)
		 * 	- 장점 : 간결함, 배열 크기 조절 가능 (확장/축소)
		 * 	- 단점 : java.util.Arrays import 필요
		 * 	- 적절한 상황 : 간단한 전체 복사, 배열 크기 변경이 필요할 때 
		 */
		int[] copy3 = Arrays.copyOf(original, original.length);
		
//		System.out.println("원본 수정 전:");
//		System.out.println("original[0] : "+original[0]);
//		System.out.println("copy3[0] : "+copy3[0]);
//		
//		original[0] = 999;
//		
//		System.out.println("원본 수정 후:");
//		System.out.println("original[0] : "+original[0]);
//		System.out.println("copy3[0] : "+copy3[0]);		
		
		/*
		 * 방법 4: clone() 메서드 사용
		 * 	- 장점: 가장 간결함. import 불필요
		 * 	- 단점: 배열 크기 조절 불가, 부분 복사 불가
		 * 	- 적합한 상황 : 전체 배열을 간단히 복사할 때 
		 */
		/*
		 *  성능 비교 (일반적인 경우)
		 *  	System.arraycopy() > clone() >  Arrays.copyOf > 반복문
		 */
		int[] copy4 = original.clone();
		
//		System.out.println("원본 수정 전:");
//		System.out.println("original[0] : "+original[0]);
//		System.out.println("copy3[0] : "+copy3[0]);
//		
//		original[0] = 999;
//		
//		System.out.println("원본 수정 후:");
//		System.out.println("original[0] : "+original[0]);
//		System.out.println("copy3[0] : "+copy3[0]);			
		
		// 2차원 배열 복사
		System.out.println("--- 2. 2차원 배열 복사 ---");
		
		int[][] original2D = {
				{1, 2, 3},
				{4, 5, 6}
		};
		
		int[][] shallowCopy = original2D.clone();
		
//		System.out.println("원본 수정 전:");
//		System.out.println("original2D[0][0] : "+original2D[0][0]);
//		System.out.println("shallowCopy[0][0] : "+shallowCopy[0][0]);
//		
//		original2D[0][0] = 999;
//		
//		System.out.println("원본 수정 후:");
//		System.out.println("original2D[0][0] : "+original2D[0][0]);
//		System.out.println("shallowCopy[0][0] : "+shallowCopy[0][0]);	
		
		// 깊은 복사 (안전!)
		int[][] deepCopy = new int[original2D.length][];
		for(int i = 0; i < original2D.length; i++) {
			deepCopy[i] = original2D[i].clone();			// 각 행을 개별적으로 복사
		}
		
		System.out.println("원본 수정 전:");
		System.out.println("original2D[0][0] : "+original2D[0][0]);
		System.out.println("deepCopy[0][0] : "+deepCopy[0][0]);
		
		original2D[0][0] = 999;
		
		System.out.println("원본 수정 후:");
		System.out.println("original2D[0][0] : "+original2D[0][0]);
		System.out.println("deepCopy[0][0] : "+deepCopy[0][0]);			
	}
}



















