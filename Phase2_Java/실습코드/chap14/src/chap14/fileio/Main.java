package chap14.fileio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
	public static void main(String[] args) {
		System.out.println(" FileOutputStream으로 파일 쓰기");
		System.out.println("----------------------------");
		String outputFile = "output.txt";
		
		try(FileOutputStream fos = new FileOutputStream(outputFile)) {
			// write(int b) : 1 바이트 쓰기 
			fos.write(72);		// 'H'
			fos.write(101); 	// 'e'
			fos.write(108); 	// 'l'
			fos.write(108); 	// 'l'
			fos.write(111); 	// 'o'	
			System.out.println(" 1) write(int b): 'Hello' 바이트 단위 쓰기 완료");
			
			// write(byte[] b) : 바이트 배열 전체 쓰기 
			byte[] data = " World!".getBytes();		//  문자열 --> 바이트 배열 변환
			fos.write(data);
			System.out.println(" 2) write(byte[] b): ' World!' 배열 쓰기 완료");
			
			// write(byte[] b, int off, int len) :  배열의 일부만 쓰기 
			byte[] extra = "\nJava File I/O 학습 중!".getBytes();
			fos.write(extra, 0, extra.length);		// off=0부터 len개 바이트 
			System.out.println(" 3) write(byte[] b, int off, int len): 추가 데이터 쓰기 완료");
			
			fos.flush();		// 버퍼에 남은 데이터를 즉시 파일에 기록 
			System.out.println(" 4) flush(): 버퍼 강제 출력 완료");
			

			
		} catch (IOException e) {
			System.out.println(" 파일 쓰기 오류 : " + e.getMessage());
		}
		
		System.out.println("  -> 파일 생성 완료 : " +outputFile+ "\n");
		
		System.out.println();
		
		System.out.println(" FileInputStream으로 파일 읽기");
		System.out.println("----------------------------");			
		
		System.out.println(" 방법1 : 1바이트식 읽기: ");
		/*
		 * 	read()의 반환값이 int인 이유
		 * 		- byte 타입 범위 : -128 ~ 127
		 * 		- 읽은 데이터 범위 : 0 ~ 255
		 * 		- EOF : -1
		 * 		--> byte로는 0~255와 -1을 동시에 표현할 수 없음 --> int 타입을 사용함 
		 */
		try(FileInputStream fis = new FileInputStream(outputFile)) {
			int data;
			StringBuilder sb = new StringBuilder();		// 1바이트씩 읽은 데이터를 하나의 문자열로 합치기 위해
			
			while((data = fis.read()) != -1) {			// read()가 -1을 반환하면 파일 끝(EOF)
				sb.append((char)data);					// 바이트 --> 문자 변환 (ASCII 범위만 정상)
			}
			System.out.println(" 읽은 내용: " + sb.toString().replace("\n", "\\n"));  // 줄바꿈 문자를 \n 문자열로 치환하여 한줄로 출력
			
		} catch (FileNotFoundException e) {
			System.out.println(" 파일을 찾을 수 없음: " + e.getMessage());
		} catch (IOException e) {
			System.out.println(" 파일 읽기 오류: " + e.getMessage());
		}
		
		System.out.println();
		
		System.out.println(" 방법2 : 바이트 배열로 효율적으로 읽기(실무 권장): ");
		/*
		 * 	1바이트씩 읽기 : read() 100번 호출 
		 *  배열로 읽기 : read(byte[1024]) 1번 호출 
		 */
		
		try(FileInputStream fis = new FileInputStream(outputFile)) {
			byte[] buffer = new byte[1024];		// 1KB 버퍼 
			int byteRead;
			
			while((byteRead = fis.read(buffer)) != -1) {
				String chunk = new String(buffer, 0, byteRead);
				System.out.println(" 읽은 바이트 수: " + byteRead);
				System.out.println(" 내용: " +chunk.replace("\n", "\\n"));
			}
			
		} catch (IOException e) {
			System.out.println(" 파일 읽기 오류: " + e.getMessage());
		}
		
		System.out.println();
		
		System.out.println(" 파일 복사 - 바이트 스트림 활용");
		System.out.println("----------------------------");			
		/*
		 * 파일 복사 = 입력스트림에서 읽은 바이트를 출력 스트림 쓰기 
		 * 	- 이 패턴은 바이너리 파일(이미지, 동영상 등) 복사에 가장 기본적인 방법 
		 * 	- 원본 파일 ---> FileInputStream
		 *      |
		 *     \ /
		 *     read(byte[] buffer)
		 *      |
		 *     \ /
		 *     FileOutputStream -- write(buffer, 0, bytesRead) --> 복사본 파일  
		 */
		String outputFile2 = "03-mvp-lecture.pdf";
		String copyFile = "mvp-lecture.pdf";
		try(FileInputStream fis = new FileInputStream(outputFile2);
			FileOutputStream fos = new FileOutputStream(copyFile)) {
			
			byte[] buffer = new byte[4096];		// 4KB 버퍼 (실무에서는 4KB~8KB 권장)
			int bytesRead;
			long totalBytes = 0;
			
			while((bytesRead = fis.read(buffer)) != -1) {
				// write(byte[], offset, length) : 읽은 만큼만 쓰기 
				fos.write(buffer, 0, bytesRead);		// 파일 끝에서 쓰레기 데이터 포함!
				totalBytes += bytesRead;
			}
			
			System.out.println(" 파일 복사 완료!");
			System.out.println(" 원본: " + outputFile);
			System.out.println(" 복사본: " + copyFile);
			System.out.println(" 복사된 바이트 수 : " +totalBytes+ " bytes");
			
		} catch(IOException e) {
			System.out.println(" 파일 복사 오류: " + e.getMessage());
		}
		
		System.out.println();
		
		System.out.println(" 파일에 내용 추가하기 (append 모드)");
		System.out.println("----------------------------");
		
		/*
		 * FileOutputStream(파일명, true) : 두 번재 파라미터가 append 모드 
		 * true = 기존 내용 뒤에 추가
		 * false(기본값) = 기존 내용 덮어쓰기  
		 */
		try(FileOutputStream fos = new FileOutputStream(outputFile, true)) {
			String apppendData = "\n---추가된 내용---\n이 줄은 append 모드로 추가되었습니다.";
			fos.write(apppendData.getBytes());
			System.out.println(" append 모드로 내용 추가 완료");
			
		} catch (IOException e) {
			System.out.println(" 파일 추가 오류: " + e.getMessage());
		}
	}
}













