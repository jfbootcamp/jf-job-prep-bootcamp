package chap14.fileio02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
 * 	문자 스트림과 버퍼링 - Reader / Writer / Buffered
 * 	
 * 	핵심 개념
 * 		- Reader / Writer = 문자(char) 단위로 데이터를 처리하는 스트림 
 * 		- FileReader / FileWriter = 파일에서 문자를 읽고 쓰는 구현 클래스 
 * 		- BufferedReader = 버퍼링 + readLine() 메서드 
 * 		- BufferedWriter = 버퍼링 + newLine() 메서드 --> 플랫폼 독립적 줄바꿈
 * 		- PrintWriter = println() / printf() --> System.out 처럼 편리한 출력 
 * 
 */
public class Main {
	public static void main(String[] args) {
		/*
		 *  바이트 스트림 : 1바이트 단위 
		 *  문자 스트림 : 문자 단위
		 *   
		 *  핵심 차이 : 문자 스트림은 인코딩을 자동 처리!
		 *    - 한글 "안녕" --> UTF-8로 자동 인코딩 --> 파일에 정상 저장	
		 *    - 바이트 스트림은 직접 인코딩 처리 필요 (getBytes("UTF-8"))	   
		 */
		
		String textFile = "text.txt";
		try(FileWriter writer = new FileWriter(textFile)) {
			// write(String str): 문자열 쓰기
			writer.write("안녕하세요, Java 문자 스트림입니다.\n");
			writer.write("한글도 정상적으로 처리됩니다.\n");
			
			// write(int c): 문자 하나 쓰기
			writer.write('A');  // 유니코드 값(65)을 int로 자동 변환하여 문자 하나 출력
			writer.write('\n');	// 줄바꿈 문자도 char --> int로 변환 (10)되어 write(int c)
			
			// write(char[] cbuf) : 문자 배열 쓰기
			char[] chars = {'J', 'a', 'v', 'a', '\n'};
			writer.write(chars); // char 배열의 모든 요소를 순서대로 파일에 출력
			
			System.out.println(" FileWriter로 텍스트 파일 작성 완료 : " + textFile);
			
		} catch (IOException e) {
			System.out.println(" 파일 쓰기 오류 : " + e.getMessage());
		}
		
		System.out.println();
		
		try(FileReader reader = new FileReader(textFile)) {
			// read() :  문자 하나 읽기, 읽은 문자 반환, EOF면 -1  리턴 
			int ch;
			StringBuilder sb = new StringBuilder();
			while((ch = reader.read()) != -1) {
				sb.append((char)ch);
			}
			System.out.println("[FileReader로 읽은 내용]:");
			System.out.println("  " + sb.toString().replace("\n", "\n  "));
			
		} catch (IOException e) {
			System.out.println(" 파일 읽기 오류 : " + e.getMessage());
		}
		
		System.out.println();
		
		System.out.println(" BufferedWriter / BufferedReader ");
		System.out.println("-----------------------------------");
		
		String noBufferFile = "no_buffer.txt";
		String withBufferFile = "with_buffer.txt";
		int totalLines = 100_000;		// 10만줄 : 버퍼 유무 차이를 체감하기 위한 충분한 데이터량
		
		// FileWriter만 사용 (버퍼 없음)
		long startTime = System.nanoTime();	// 나노초(10억분의 1초) 단위 현재 시각
		try(FileWriter fw = new FileWriter(noBufferFile)) {
			for(int i = 0 ; i < totalLines; i++) {
				fw.write( "테스트 데이터 라인 "+ i + "\n"); 	// 매 반복마다 디스크 I/O 발생 --> 10만 번의 시스템 콜 
			}
		} catch (IOException e) {
			System.out.println(" 파일 쓰기 오류 : " + e.getMessage());
		}
		
		long noBufferTime = System.nanoTime() - startTime;   // 종료 시각 - 시작 시각 = 경과 시간(나노초)
		
		// BufferedFileWriter만 사용 (8KB 버퍼)
		startTime = System.nanoTime();	
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(withBufferFile))) {  // 내부 8KB 버퍼에 데이터를 모았다가 버퍼가 차면 한번에 flush() --> 시스템 콜 횟수 대폭 감소
			for(int i = 0 ; i < totalLines; i++) {
				bw.write("테스트 데이터 라인 " +i);   // 버퍼에 쌓기만 함 --> 디스크 접근 아직 안 함
				bw.newLine(); 	// 플랫폼 독립적 줄바꿈 (Windows에서는 \r\n, Linux/MacOS에서는  \n 자동 삽입)
			}
		} catch (IOException e) {
			System.out.println(" 파일 쓰기 오류 : " + e.getMessage());
		}
		
		long withBufferTime = System.nanoTime() - startTime;
		
		// 결과 출력
		System.out.printf(" FileWriter만 사용 (버퍼 없음): %,d ms\n", noBufferTime / 1_000_000); // 나노초 -> 밀리초 변환 (1ms = 1,000,000ns)
		System.out.printf(" BufferedWriter 사용 (8KB 버퍼): %,d ms\n", withBufferTime / 1_000_000);
		if (noBufferTime > withBufferTime) {
			System.out.printf(" -> BufferedWriter가 약 %.1f배 빠름!%n", (double)noBufferTime / withBufferTime );
		}
		
		// 테스트 파일 정리
		new File(noBufferFile).delete();
		new File(withBufferFile).delete();
		
		System.out.println();
		
		/*
		 * 	핵심 기능
		 * 		1) 내부 버퍼(기본 8KB) --> I/O 회수 대폭 감소 --> 성능 향상
		 * 		2) readLine() -> 줄단위 읽기 
		 * 		3) newLine() -> 플랫폼에 맞는 줄바꿈 
		 */
		String bufferedFile = "buffered.txt";
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(bufferedFile))) {
			// BufferedWriter는 내부 버퍼에 데이터를 모았다가 한 번에 쓰기
			// write()는 줄바꿈을 자동으로 넣지 않음 --> 매번 newLine()을 별도 호출해야 줄이 바뀜
			bw.write("=== 직원 정보 ===");
			bw.newLine();		// 자동 판별
			bw.write("이름: 김자바");
			bw.newLine();
			bw.write("부서: 개발팀");
			bw.newLine();			
			bw.write("입사일: 2026-06-29");
			bw.newLine();			
			bw.newLine();		// 연속 호출로 빈 줄 삽입 
			
			// 여러 줄의 데이터 쓰기
			String[] skills = {"Java", "MySQL", "Spring Boot", "Docker"};
			bw.write("보유 기술: ");
			bw.newLine();	
			for(int i = 0 ; i < skills.length; i++) {
				bw.write(" " + (i + 1) + ". " + skills[i]);
				bw.newLine();	
			}
			
			System.out.println(" BufferedWriter로 파일 작성 완료: " + bufferedFile);
			
		} catch (IOException e) {
			System.out.println(" 파일 쓰기 오류 : " + e.getMessage());
		}
		
		System.out.println();
		
		System.out.println(" [BufferedReader로 줄 단위 읽기] ");
		try(BufferedReader br = new BufferedReader(new FileReader(bufferedFile))) {
			String line;
			int lineNumber = 1;
			while((line = br.readLine()) != null) {
				System.out.printf(" %3d | %s%n", lineNumber++, line);
			}
			
		} catch (IOException e) {
			System.out.println(" 파일 읽기 오류 : " + e.getMessage());
		}
	}
}














