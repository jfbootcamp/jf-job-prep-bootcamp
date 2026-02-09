package chap11.object02;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

/*
 * 	직원 도메인 클래스
 * 		- Object 메서드 모두 재정의
 * 		- 도메인 객체에 비즈니스 로직 메서드 포함
 * 		- 불변 필드와 가변 필드 구현 	
 */
public class Employee {
	private final String empId;		//사변 (불변 - 비즈니스 키)
	private String name;
	private String department;
	private double salary;
	private Date hireDate;
	
	public Employee(String empId, String name, String department, double salary, Date hireDate) {
		//super();
		this.empId = empId;
		this.name = name;
		this.department = department;
		this.salary = salary;
		this.hireDate = hireDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public String getEmpId() {
		return empId;
	}

	// Object 메서드 재정의
	/*
	 * equals()에서 비교한 필드(empId)와 동일한 필드로 해시코드 생성
	 * -> equals()가 true인 두 객체는 반드시 같은 hashCode를 가져야 함(규칙)
	 */
	@Override
	public int hashCode() {
		return Objects.hash(empId);		// empId를 기반으로 해시값 계산
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;				//  같은 객체면 바로 true (자기 자신과 비교)
		if (obj == null || getClass() != obj.getClass()) return false;   //  null이거나 다른 클래스면 false
		Employee other = (Employee)obj;             // Object --> Employee로 다운캐스팅
		return Objects.equals(empId, other.empId);  // 사번(empId)이 같으면 같은 직원으로 판단 
	}

	@Override
	public String toString() {
		return String.format("Employee{empId='%s', name='%s', dept='%s', salary='%s', hired='%s'}", 
								empId, name, department, getFormattedSalary(), getFormattedHireDate());
	}

	// 2020-03-15
	private Object getFormattedHireDate() {
		if(hireDate == null) return "미정";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(hireDate);
	}

	// 45,000,000원
	private Object getFormattedSalary() {
		return String.format("%,.0f원", salary);
	}
	
	
	
	
}











