package chap06.constructors;

class Book {
	// 필드
	String title;
	String author;
	int pages;
	double prices;
	String isbn;
	
	// 생성자 1: 기본생성자
	public Book() {
		this.title = "Unknown";
		this.author = "Unknown";
		this.pages = 0;
		this.prices = 0.0;
		this.isbn = "000-0-00-000000-0";
	};
	
	// 생성자 2: 제목만 할당 
	public Book(String title) {
		this.title = title;
		this.author = "Unknown";				// 중복
		this.pages = 0;							// 중복
		this.prices = 0.0;						// 중복
		this.isbn = "000-0-00-000000-0";		// 중복
	}
	
	// 생성자 3: 제목 + 저자
	public Book(String title, String author) {
		this.title = title;
		this.author = author;
		this.pages = 0;							// 중복
		this.prices = 0.0;						// 중복
		this.isbn = "000-0-00-000000-0";		// 중복	
	}
	
	// 생성자 4: 제목 + 저자 + 페이지 
	public Book(String title, String author, int pages) {
		this.title = title;
		this.author = author;
		this.pages = pages;
		this.prices = 0.0;						// 중복
		this.isbn = "000-0-00-000000-0";		// 중복	
	}
	
	// 생성자 5: 전체필드
	public Book(String title, String author, int pages, double price, String isbn) {
		this.title = title;
		this.author = author;
		this.pages = pages;
		this.prices = price;
		this.isbn = isbn;
		
	}
	
	void displayInfo() {
		System.out.println("-----------------------------------");
		System.out.println("제목: " + this.title);
		System.out.println("저자: " + this.author);
		System.out.println("페이지: " + this.pages);
		System.out.printf("가격: %,.0f원%n ", this.prices);
		System.out.println("ISBN" + this.isbn);
		
	}
	
}

public class Constructors {

	public static void main(String[] args) {
		System.out.println("=== 1. 생성자 오버로딩 기본 (this() 사용하기 전)");
		
		Book b1 = new Book();
		Book b2 = new Book("피지컬 AI 메가 트렌드");
		Book b3 = new Book("2026 글로벅 에이전틱 AI(Agentic AI) 기술 트렌드와 혁신 적용사례 및 사업전략", "IRS글로벌 산업조사실");
		Book b4 = new Book("AI 에이전트 마스터 클래스", "김구현 ", 340, 23400, "9791175790155");
		
		b1.displayInfo();
		b2.displayInfo();
		b3.displayInfo();
		b4.displayInfo();
	}
}















