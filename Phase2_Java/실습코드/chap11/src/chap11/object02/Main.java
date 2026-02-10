package chap11.object02;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/*
 * 	직원 관리 시스템
 * 		-  Object 클래스 활용 : equals/hashCode로 중복 체크, toString으로 출력
 */
public class Main {
	public static void main(String[] args) {
		System.out.println("-----------------------------");
		System.out.println("        직원 관리 시스템        ");
		System.out.println("-----------------------------");
		
		EmployeeService service = new EmployeeService();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		// 1: 직원 데이터 등록
		try {
			service.addEmployee(new Employee("E001", "김개발", "개발팀", 55_000_000, sdf.parse("2020-03-15")));
			service.addEmployee(new Employee("E002", "이디자인", "디자인팀", 48_000_000, sdf.parse("2021-07-01")));
			service.addEmployee(new Employee("E003", "박서버", "개발팀", 62_000_000, sdf.parse("2019-01-10")));
			service.addEmployee(new Employee("E004", "최프런트", "개발팀", 52_000_000, sdf.parse("2022-05-20")));
			service.addEmployee(new Employee("E005", "정기획", "기획팀", 45_000_000, sdf.parse("2023-02-01")));
			
			System.out.println(" 5명 등록 완료\n");
			
			// 중복 등록 테스트 (같은 사번)
			boolean duplicateResult = service
				.addEmployee(new Employee("E001", "김개발", "개발팀", 55_000_000, sdf.parse("2020-03-15")));
			System.out.println(" 중복 사번(E001) 등록 시도: " + (duplicateResult ? "성공" : "실패(중복!)"));
			System.out.println(" --> equals 덕분에 중복 감지!\n");
			
		} catch (ParseException e) {
			System.out.println(" 날짜 파싱 오류 : " + e.getMessage());
		}
		
	}
}


















