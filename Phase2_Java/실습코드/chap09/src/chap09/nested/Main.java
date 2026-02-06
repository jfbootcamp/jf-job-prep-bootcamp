package chap09.nested;

//테스트 클래스
public class Main {
	public static void main(String[] args) {
		Product notebook = new Product("AI 노트북", 2000000); 		// 바깥 객체 먼저 생성
		
		// 1. 인스턴스 멤버 클래스 
		Product.Option opt1 = notebook.new Option("RAM 16GB", 200000);	// 바깥객체.new 내부클래스()
		Product.Option opt2 = notebook.new Option("RAM 32GB", 400000);
		
		System.out.println(opt1.toString());		// toString() 자동 호출
		
		// 2. 정적 멤버 클래스 - 바깥 객체 없이 바로 생성 가능
		Product.Category category = new Product.Category("전자기기", "노트북, 태블릿 등");  // new 바깥클래스.내부클래스()
		System.out.println(category);
	}
}
