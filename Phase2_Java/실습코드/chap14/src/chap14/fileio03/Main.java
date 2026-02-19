package chap14.fileio03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
 * 	InputStreamReader, OutputStreamWriter
 * 	 = 바이트 스트림 <=> 문자 스트림 변환 (인코딩 지정 가능)
 */
public class Main {
	public static void main(String[] args) {
		String encodingFile = "encoding.txt";
		
		try(OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(encodingFile), "UTF-8")) {
			osw.write("UTF-8 인코딩으로 작성된 한글 파일입니다.\n");
			osw.write("日本語も大丈夫です。\n");
			System.out.println(" UTF-8 인코딩으로 파일 작성 완료");
		} catch (IOException e) {
			System.out.println(" 파일 쓰기 오류 : " + e.getMessage());
		}
		
		// 보조 스트림 감싸기 : BufferedReader + InputStreamReader + FileInputStream
		/*					--------------  -------------------  -----------------------------
		 * 					내부 8KB 버퍼       바이트 --> 문자변환     파일에서 바이트를 읽는 기본 스트림 
		 * 									  + UTF-8 인코딩 지정
		 * 									  ==> 바이트 스트림을
		 *  								  문자 스트림으로 변환하는
		 *  						          다리 역할	 
		 */   
		try(BufferedReader br = new BufferedReader(
				new InputStreamReader(new FileInputStream(encodingFile), "UTF-8"))) {
			String line;
			while((line = br.readLine()) != null) {
				System.out.println(" 읽은 내용: " + line);
			}
			
		} catch (IOException e) {
			System.out.println(" 파일 읽기 오류 : " + e.getMessage());
		}
		
		System.out.println();
	}
}













