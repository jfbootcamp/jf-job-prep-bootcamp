package chap11.object02;

import java.util.ArrayList;
import java.util.List;

/*
 *  직원 비즈니스 로직 서비스 
 */
public class EmployeeService {
	private final List<Employee> employees = new ArrayList<>();
	
	/*
	 * 직원 추가 (중복 사번 체크)
	 */
	public boolean addEmployee(Employee employee) {
		if (employee == null || employee.getEmpId() == null) {
			return false;
		}
		
		/*
		 * ArrayList는 중복 허용 -> contains()로 수동 중복 체크 필수 
		 * 						 - 내부적으로 리스트를 순회 --> 각 요소.equals() 실행
		 * 						 -> Employee.equals()에서 empId끼리 비교 --> 같은 사번이면 true 반환		
		 */
		if (employees.contains(employee)) {
			return false;							// 같은 사번(empId)이 이미 존재 -> 추가 거부 
		}		
		employees.add(employee);					// 중복 없으면 리스트 추가 
		return true;
	}
	
}










