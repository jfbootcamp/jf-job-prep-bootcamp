package chap06.encapsulation;

class Product {
	private String name;
	private int price;
	private int quantity;
	private String category;
	
	public Product(String name, int price, int quantity, String category) {
		//super();
		setName(name);
		setPrice(price);
		setQuantity(quantity);
		setCategory(category);
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

	public String getCategory() {
		return category;
	}

	// 유효성 검증 포함
	public void setName(String name) {
		if (name != null && !name.trim().isEmpty()) {
			this.name = name;
		} else {
			throw new IllegalArgumentException("상품명은 필수입니다.");
		}
	}

	public void setPrice(int price) {
		if(price >= 0) {
			this.price = price;
		} else {
			throw new IllegalArgumentException("가격은 0 이상이어야 합니다.");
		}
		
	}

	public void setQuantity(int quantity) {
		if (quantity >= 0) {
			this.quantity = quantity;
		} else {
			throw new IllegalArgumentException("수량은 0 이상이어야 합니다.");
		}
		
	}

	public void setCategory(String category) {
		this.category = category != null ? category : "미분류";
	}
	
	public boolean sell(int amount) {
		if(amount > 0 && quantity >= amount) {
			quantity -= amount;			// 재고 감소
			return true;
		}
		return false;		
	}
	
	// 입고하다
	public void revoke(int amount) {
		if(amount > 0) {
			quantity += amount;		//재고 증가
		}
	}
	
	// 재고 가치 계산
	public int getTotalValue() {
		return price * quantity;
	}
	
	public void displayInfo() {
		System.out.println("-------------------------");
		System.out.println("상품명 : " + getName());
		System.out.printf("가격 : %,d원%n", getPrice());
		System.out.println("수량: " + getQuantity() +"개");
		System.out.println("카테고리: " + getCategory());
		System.out.printf("재고 가치: %,d원%n", getTotalValue());
	}
}


// 학생 성적관리하는 클래스
class StudentsWithGrades {
	private String name;
	private String studentId;
	private int[] scores;
	private int scoreCount;
	
	public StudentsWithGrades(String name, String studentId) {
		//super();
		this.name = name;
		this.studentId = studentId;
		this.scores = new int[10];		// 최대 10개
		this.scoreCount = 0;			// 초기에는 저장된 점수가 없으므로 0으로 시작
	}
	
	// 점수 추가
	public boolean addScore(int score) {
		if(score >=0 && score <= 100 &&  scoreCount < 10) {
			scores[scoreCount++] = score;
			return true;
		}
		return false;
	}
	
	// 평균 계산 
	public double calculateAverage() {
		if (scoreCount == 0) return 0;
		int sum = 0;
		for(int i = 0; i < scoreCount; i++) {
			sum += scores[i];
		}
		return (double)sum / scoreCount;
	}
	
	// 등급 계산
	public String determineGrade() {
		double avg = calculateAverage();
		if (avg >= 90) return "A";
		if (avg >= 80) return "B";
		if (avg >= 70) return "C";
		if (avg >= 60) return "D";
		return "F";
	}
	
	// 값출력
	public void displayInfo() {
		System.out.println("------------------------------");
		System.out.println("이름 : " + name);
		System.out.println("학번 : " + studentId);
		System.out.print("점수: ");
		for(int i = 0; i < scoreCount; i++) {
			System.out.print(scores[i] + " ");
		}
		System.out.println();
		System.out.printf("평균 : %.2f%n", calculateAverage());
		System.out.println("등급 : " + determineGrade());
	}
	
	
}




public class Encapsulation {
	public static void main(String[] args) {
		System.out.println("=========================================");
		System.out.println("     1. 캡슐화 적용     ");
		System.out.println("=========================================");
		System.out.println("---- Product 클래스 테스트 ----");
		
		Product p1 = new Product("노트북", 1500000, 10, "전자제품");
		//Product p1 = new Product("", 1500000, 10, "전자제품");
		p1.displayInfo();
		
		System.out.println("\n3개 판매:");
		p1.sell(3);
		p1.displayInfo();
		
		System.out.println("\n5개 입고:");
		p1.revoke(5);
		p1.displayInfo();
		
		System.out.println("\n 가격 변동 시도 (음수)");
		try {
			p1.setPrice(-1000);
		} catch(IllegalArgumentException e) {
			System.out.println("예외 발생 : " + e.getMessage());
		}
		
		
		System.out.println();
		System.out.println("---- Students 클래스 테스트 ----");
		
		StudentsWithGrades s1 = new StudentsWithGrades("이순신", "2026001");
		s1.addScore(95);
		s1.addScore(88);
		s1.addScore(72);
		s1.addScore(90);
		s1.displayInfo();
	}
}





















