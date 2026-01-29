package chap06.constructors03;

/*
 * 	Employee 클래스 - 직원 정보를 관리하는 클래스 
 * 		- 특징
 * 			- static 필드로 사원번호 자동 생성
 * 				- 클래스 로드 시 1회  
 * 			- 인스턴스 초기화 블록 사용
 * 				- 객체 생성 시 마다 실행됨
 * 				- 모든 생성자에서 공통으로 수행할 작업에 사용
 * 		- 객체 생성 시 실행 순서
 * 			- static 필드 초기화 
 * 			- 인스턴스 초기화 블록 실행
 * 			- 생성자 실행 
 */
		
class Employee {
	private static int nextId = 1001;			// 클래스 변수, 공유 변수 
	String employeeId;							// 인스턴스 변수, 객체 변수		
	String name;
	String department;
	String position;
	int salary;
	
	{
		employeeId = "EMP-" + nextId++;			// 사원번호 자동 생성
	}
	
	/*
	 * 생성자1 : 기본 생성자
	 * 		동작: 신입사원 기본 정보로 초기화 
	 * 			- 이름: "신입사원"
	 * 			- 부서: "미정"
	 * 			- 직급: "사원"
	 * 			- 연봉: 3000만원
	 */
	public Employee() {
		this("신입사원", "미정", "사원", 3000);
	}
	
	/*
	 * 생성자2 : 이름만 받는 생성자
	 * 		파라미터 - name (직원 이름)
	 */	
	public Employee(String name) {
		//super();
		this(name, "미정", "사원", 3000);
	}

	/*
	 * 생성자3 : 이름과 부서를 받는 생성자
	 * 		파라미터 - name (직원 이름), department (부서명)
	 */		
	public Employee(String name, String department) {
		//super();
		this(name, department, "사원", 3000);

	}

	/*
	 * 생성자4 : 주 생성자
	 * 		- 연봉 변환 
	 * 			- salaryInTenThousand * 10000 --> 원 단위로 변환
	 * 			예) 3000 (만원) --> 30,000,000 (원)
	 * 	
	 */
	public Employee(String name, String department, String position, int salaryInTenThousand) {
		//super();
		this.name = name;
		this.department = department;
		this.position = position;
		this.salary = salaryInTenThousand * 10000;
	}
	
	/*
	 * 	직원 정보 출력
	 */
	void displayInfo() {
		System.out.println("-----------------------------");
		System.out.println("사원번호 : " + employeeId);
		System.out.println("이름 : " + name);
		System.out.println("부서 : " + department);
		System.out.println("직급 : " + position);
		System.out.printf("연봉 : %,d원%n", salary);
	}
}

/*
 * 	Computer 클래스 - 컴퓨터 사양을 관리하는 클래스 
 */
class Computer {
	String brand;
	String cpu;
	int ramGB;
	int storageGB;
	double price;
	
	
	
	public Computer() {
		//super();
		this("Generic", "Unknown CPU", 8, 256, 500000);
	}
	

	public Computer(String brand) {
		//super();
		this(brand, "Unknown CPU", 8, 256, 500000);
	}

	public Computer(String brand, String cpu) {
		// super();
		this(brand, cpu, 8, 256, 500000);
	}

	/*
	 * 	* 가격은 스펙 기반 자동 계산
	 * 		- 기본가 : 30만원
	 * 		- RAM 1GB당 : 1만원 추가
	 * 		- 저장소 	1GB당 : 1만원 추가
	 */
	public Computer(String brand, String cpu, int ramGB, int storageGB) {
		//super();
		this(brand, cpu, ramGB, storageGB, 300000 + (ramGB * 10000) + (storageGB * 10000));
	}


	public Computer(String brand, String cpu, int ramGB, int storageGB, double price) {
		//super();
		this.brand = brand;
		this.cpu = cpu;
		this.ramGB = ramGB;
		this.storageGB = storageGB;
		this.price = price;
	}
	
	void displayInfo() {
		System.out.println("-----------------------------");
		System.out.println("브랜드 : " + brand);
		System.out.println("CPU : " + cpu);
		System.out.println("RAM : " + ramGB + "GB");
		System.out.println("저장소 : " + storageGB +"GB");
		System.out.printf("가격 : %,.0f원%n", price);
	}	
	
}

// 테스트 클래스
public class PConstructor {
	public static void main(String[] args) {
		System.out.println("---Employee 클래스 테스트 ---");
		
		Employee e1 = new Employee();
		Employee e2 = new Employee("이순신");
		Employee e3 = new Employee("신사임당", "개발팀");
		Employee e4 = new Employee("이도", "기획팀", "팀장", 6000);
		
		
		e1.displayInfo();
		e2.displayInfo();
		e3.displayInfo();
		e4.displayInfo();
		
		System.out.println("---Computer 클래스 테스트 ---");
		
		Computer c1 = new Computer();
		Computer c2 = new Computer("Apple");
		Computer c3 = new Computer("Samsung", "Intel i7");
		Computer c4 = new Computer("LG", "AMD Ryzen 9", 32, 1000);
		Computer c5 = new Computer("Dell", "Intel i9", 64, 2000, 3500000);
		
		c1.displayInfo();
		c2.displayInfo();
		c3.displayInfo();
		c4.displayInfo();
		c5.displayInfo();
		
	}
}





















