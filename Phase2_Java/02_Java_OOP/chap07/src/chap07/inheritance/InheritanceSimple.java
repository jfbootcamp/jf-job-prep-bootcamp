package chap07.inheritance;

/*
 * 		* 온라인 쇼핑몰의 상품 관리 시스템을 구현.
 * 			- 기본 상품(Product) 클래스를 상속받아 책(Book) 클래스를 만듦
 */

class Product {
	String name;
	int price;
	int stock;
	
	public Product(String name, int price, int stock) {
		//super();
		this.name = name;
		this.price = price;
		this.stock = stock;
	}
	
	public void displayInfo() {
		System.out.println("상품명: " + name);
		System.out.println("가격: " + price);
		System.out.println("재고: " + stock);
	}
	
	/*
	 * 상품 구매 가능 여부 확인 메서드 
	 * 	- 재고 > 0 이면 true(구매가능), 아니면 false(품절)
	 */
	public boolean isAvailable() {
		return stock > 0;
	}
	
	/*
	 * 상품 판매 처리
	 * 	- 파라미터 : 판매할 수량
	 * 	- 리턴 : 판매 성공시 true, 재고 부족시 false
	 */
	public boolean sell(int quantity) {
		if(stock >= quantity) {
			stock -= quantity;
			return true;
		} else {
			System.out.println("재고가 부족합니다.");
			return false;
		}
	}
	
}

/*
 * 	책 상품 클래스 (Product 상속)
 * 		- extends로 Product를 상속받음
 * 		- 부모 필드 + 추가 필드 가짐
 */
class Book extends Product {
	//추가 필드
	String author;
	String isbn;
	public Book(String name, int price, int stock, String author, String isbn) {
		super(name, price, stock);  // 부모 생성자 호출 (반드시 첫줄!)
		this.author = author;
		this.isbn = isbn;
	}
	
	@Override
	public void displayInfo() {
		super.displayInfo();
		System.out.println("저자: " + author);
		System.out.println("ISBN: " + isbn);		
	}
	
//	public void displayInfo() {
//		super.displayInfo();		// 부모의 displayInfo() 호출
//		System.out.println("저자: " + author);
//		System.out.println("ISBN: " + isbn);
//	}
	
}

/*
 *  전자제품 클래스 (Product 상속)
 *  	- 전자제품의 고유 속성인 brand, warrantyMonths 추가
 *  	- 부모의 displayInfo()를 오버라이딩하여 추가 정보 출력
 */
class Electronics extends Product {
	// 추가 필드
	String brand;
	int warrantyMonths;
	
	// 생성자
	public Electronics(String name, int price, int stock, String brand, int warrantyMonths) {
		super(name, price, stock);
		this.brand = brand;
		this.warrantyMonths = warrantyMonths;
	}

	@Override
	public void displayInfo() {
		super.displayInfo();
		System.out.println("브랜드 : " + brand);
		System.out.println("보증기간 : " + warrantyMonths + "개월");
	}
		
}

/*
 * 	의류 클래스 (Product 상속)
 * 		- 의류만의 고유 속성인 	,   추가
 * 		- displayInfo() 오버라이딩
 */
class Clothing extends Product {
	//추가 필드
	String size;
	String material;
	
	//생성자
	public Clothing(String name, int price, int stock, String size, String material) {
		super(name, price, stock);
		this.size = size;
		this.material = material;
	}
	
	@Override
	public void displayInfo() {
		super.displayInfo();
		System.out.println("사이즈: " + size);
		System.out.println("소재: " + material);
	}
	
	
}

public class InheritanceSimple {
	public static void main(String[] args) {
		System.out.println("테스트 1 : Product 기본 클래스");
		System.out.println("----------------------------------");
		
		Product product = new Product("일반상품", 10000, 5);
		product.displayInfo();
		System.out.println("재고 있음: " + product.isAvailable());
		System.out.println();
		
		System.out.println("테스트 2 : Book 기본 클래스");
		System.out.println("----------------------------------");
		
		Book book = new Book("혼자공부하는 자바", 25000, 10, "신용권", "978-89-6077-000-0");
		book.displayInfo();
		System.out.println("저자 : " + book.author);
		System.out.println();
		
		System.out.println("테스트 3 : Electronics 기본 클래스");
		System.out.println("----------------------------------");		
		
		Electronics notebook = new Electronics("맥북 프로14", 2500000, 3, "Apple", 12);
		notebook.displayInfo();
		System.out.println();
		
		System.out.println("▶테스트 4 : Clothing 기본 클래스");
		System.out.println("----------------------------------");	
		
		Clothing tshirt = new Clothing("오버핏 티셔츠", 29000, 20, "L", "면 100%");
		tshirt.displayInfo();
		System.out.println();
		
		// 판매 가능 테스트 
		System.out.println("[책 2권 판매 시도]");
		boolean sold = book.sell(2);
		System.out.println("판매 성공: " + sold);
		book.displayInfo();
		System.out.println();
		
		System.out.println("[노트북 5대 판매 시도(재고 부족)]");
		sold = notebook.sell(5);
		System.out.println("판매 성공: " + sold);
		notebook.displayInfo();
		
	}
}


















