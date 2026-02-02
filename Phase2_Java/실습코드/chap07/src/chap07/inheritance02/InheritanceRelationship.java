package chap07.inheritance02;

/*
 *  클래스와 클래스간의 관계(RelationShip)
 *  	1) is-a 관계 - 상속
 *  		- Circle/Rectangle/Triangle is a Shape   | Square is a Rectangle
 *  	2) has-a 관계 - 집합
 *  		- SquareCalculator has a Shape 
 *  		
 */

/*
 * 	* 목표 
 * 		- 상속과 오버라이딩 활용해서 프로그램 구현
 * 		- 다형성 개념 일부 경험하기 (배열)
 * 		- 다단계 상속 이해하기 
 * 		- 객체 지향적 설계 이해 
 * 		
 * 	* 구현
 * 		- 다양한 도형의 넓이와 둘레를 계산하는 프로그램을 구현함 
 * 		- 기본 도형(Shape) 클래스를 상속받아 원, 사각형, 삼각형, 정사각형을 만듦
 * 
 */

class Shape {
	String name;
	String color;
	
	public Shape(String name, String color) {
		//super();
		this.name = name;
		this.color = color;
	}
	
	public double getArea() {
		return 0;
	}
	
	public double getPerimeter() {
		return 0;
	}
	
	public String describe() {
		return color +"색 "+ name;
	}
	
	public void printInfo() {
		System.out.println("--------------------------");
		System.out.println(" 도형: " + describe());
		System.out.printf("  넓이: %.2f%n", getArea());
		System.out.printf("  둘레: %.2f%n", getPerimeter());
		System.out.println("--------------------------");
	}
	
}

/*
 *   원 클래스 (Shape 상속)
 *   	- 넓이 : π * r^2, 둘레 = 2 * π * r 		
 */
class Circle extends Shape {
	//추가 필드
	double radius;
	//생성자 
	public Circle(String color, double radius) {
		super("원", color);		// 부모 생성자 호출
		this.radius = radius;	// Circle 고유 필드 초기화 
	}
	
	@Override
	public double getArea() {
		return Math.PI * radius * radius;
	}
	
	@Override
	public double getPerimeter() {
		return 2 * Math.PI * radius;
	}
	
	@Override
	public String describe() {
		// TODO Auto-generated method stub
		return color +"색 원 (반지름: "+ radius + ")";
	}
	
}

/*
 * 	사각형 클래스 (Shape 상속)
 * 		- 넓이 = width * height, 둘레 = 2 * (width+height)
 */
class Rectangle extends Shape {
	//추가 필드
	double width;
	double heignt;
	// 생성자
	public Rectangle(String color, double width, double heignt) {
		super("사격형", color);		//  부모 생성자 호출
		this.width = width;
		this.heignt = heignt;
	}
	
	@Override
	public double getArea() {
		return width * heignt;
	}
	
	@Override
	public double getPerimeter() {
		return 2 * (width + heignt);
	}
	
	@Override
	public String describe() {
		return color +"색 사각형 ("+ width + ", " +heignt+ ")";
	}
}

/*
 *  정사각형 클래스 (Rectangle 상속)
 *  	- width와 height에 같은 값을 넣어 정사각형을 구함 
 */

class Square extends Rectangle {
	//생성자
	public Square(String color, double side) {
		super(color, side, side);		// 부모 생성자 호출
	}
	
	@Override
	public String describe() {
		return color +"색 정사각형 (한 번: "+ width + ")";
	}
		
}

/*
 * 	삼각형 클래스 
 * 		- 넓이 = 0.5 * 밑변 * 높이
 *      - 둘레 = 세변의 합 (side1 + side2 + side3) 
 */
class Triangle extends Shape {
	// 추가 필드
	double base;
	double height;
	double side1, side2, side3;
	public Triangle(String color, double base, double height, double side1, double side2, double side3) {
		super("삼각형", color);		// 부모 생성자 호출 
		this.base = base;			// 밑변
		this.height = height;		// 높이
		this.side1 = side1;			// 세변의 길이
		this.side2 = side2;
		this.side3 = side3;
	}
	
	@Override
	public double getArea() {
		return 0.5 * base * height;
	}
	
	@Override
	public double getPerimeter() {
		return side1 + side2 + side3;
	}
	
	@Override
	public String describe() {
		
		return color +"색 삼각형";
	}
	
	
}

public class InheritanceRelationship {

}



















