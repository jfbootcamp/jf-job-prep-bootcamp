package chap06.oopbasic;

/*
 *  사각형의 속성과 계산
 */

public class Rectangle {
	// 필드 정의
	double width;
	double height;
	
	// 메서드 정의
	/*
	 * getArea() - 넓이 계산
	 * 
	 * 	반환타입: double (넓이 반환)
	 * 	공식 : 가로 * 세로
	 */
	double getArea() {
		return width * height;
	}
	
	/*
	 *  getPerimeter() - 둘레 계산
	 *  
	 *  반환타입 : double
	 *  공식 : 2 * (가로 + 세로)
	 */
	double getPerimeter() {
		return 2 * (width + height);
	}
	
	void displayInfo() {
		System.out.println("==== 사각형 정보 ====");
		System.out.printf("크기: %.1f * %.1f%n", width, height);
		System.out.printf("넓이: %.2f%n", getArea());
		System.out.printf("둘레: %.2f%n", getPerimeter());
	}
	
	public static void main(String[] args) {
		System.out.println("----Rectangle 클래스 테스트----\n");
		
		Rectangle rect1 = new Rectangle();
		rect1.width = 10;
		rect1.height = 5;
		rect1.displayInfo();
		
		System.out.println();
		
		Rectangle rect2 = new Rectangle();
		rect2.width = 7;
		rect2.height = 7;
		rect2.displayInfo();
		
	}
}



























