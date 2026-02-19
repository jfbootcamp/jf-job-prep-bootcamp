package chap14.fileio04;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		System.out.println(" Java NIO - Paths, Files");
		
		Path path1 = Paths.get("data", "users.txt");  // "data/users.txt" 경로 객체 생성 (실제 파일 생성 X)
		Path path2 = Paths.get("data/users.txt");     // 위와 동일한 경로를 문자열로 직접 지정 
		
		System.out.println("경로: " + path1);
		System.out.println("파일 명: " + path1.getFileName());
		System.out.println("부모 경로: " + path1.getParent());
		System.out.println("절대 경로: " + path1.toAbsolutePath());
		System.out.println("경로 요소 수: " + path1.getNameCount());
		
		// Path 조작
		Path basePath = Paths.get("/project/src");
		Path resolved = basePath.resolve("main/App.java");		// 경로 결합
		Path relative = basePath.relativize(Paths.get("/project/src/main/App.java")); 		// 상대 경로
		
		System.out.println(" resolved : " + resolved);		
		System.out.println(" relative : " + relative);
		
		System.out.println(" Files - 파일 읽기/쓰기");
		System.out.println("------------------------");
		
		/*
		 *  Paths.get(): 문자열 경로를 Path 객체로 변환
		 *  	- NIO에서는 파일 경로를 String이 아닌 Path 타입으로 다룸 (타입 안정성 + 경로 조작 메소드 제공)
		 *  Path : 파일/디렉토리의 "위치 정보"만 담는 객체 (실제 파일이 존재하지 않아도 생성 가능 --> 경로 지정용)
		 */
		Path nioFile = Paths.get("nio.txt");
		
		try {
			Files.writeString(nioFile, "NIO로 파일 쓰기 - 한 줄이면 충분!\n");
			
			List<String> lines = List.of(
					"=== NIO 테스트 데이터 ===",
					"이름: 김자바",
					"언어: Java 17",
					"프레임워크: Spring Boot",
					"DB: MySQL"
					);
			
			// 줄단위 쓰기 (List의 각 요소를 한 줄씩 파일에 기록)
			Files.write(nioFile, lines, StandardCharsets.UTF_8);  // write(경로, 내용, 인코딩)
			System.out.println(" Files.write(List<String>) 완료");
			
			// 추가 쓰기 (append) : 기존 내용 뒤에 이어쓰기
			Files.writeString(nioFile, "\n ---추가 정보---\n상태: 학습 중\n", StandardOpenOption.APPEND);
			System.out.println(" Files.writeString() APPEND 모드 완료");
			
			// 읽기
			System.out.println("\n [파일 읽기 결과]");
			
			// 전체 문자열 읽기: readString(경로) 
			String content = Files.readString(nioFile);
			System.out.println(" readString() 문자 수 : " + content.length());
			
			// 줄 단위 읽기: readAllines(경로) 
			List<String> readLines = Files.readAllLines(nioFile);
			for(int i = 0 ; i < readLines.size(); i++) {
				System.out.printf(" %2d | %s%n", i + 1, readLines.get(i));
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}













