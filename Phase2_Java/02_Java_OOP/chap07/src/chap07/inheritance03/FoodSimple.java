package chap07.inheritance03;

class Food {
	String name;
	int price;
	
	public Food(String name, int price) {
		//super();
		this.name = name;
		this.price = price;
	}
	
	public int getPrice() {
		return price;
	}
	
	public String describe() {
		return name;
	}
	
	public void printInfo() {
		System.out.println("------------------");
		System.out.println(" " + describe());
		System.out.printf(" 가격 : %,d원%n", getPrice());
		System.out.println("------------------");
	}
	
}

class Beverage extends Food {
	String size;			// 사이즈 : T, G, V
	boolean isIced;			// 아이스 여부
	
	public Beverage(String name, int price, String size, boolean isIced) {
		super(name, price);				// 부모 생성자 호출
		this.size = size;				// 음료 고유 필드 초기화
		this.isIced = isIced;
	}
	
	//가격 계산 - 사이즈에 따라 추가 요금
	@Override
	public int getPrice() {
		int finalPrice = price;			// 기본가격
		
		//사이즈 업 추가 요금
		if(size.equals("Grande")) {
			finalPrice += 500;
		} else if(size.equals("Venti")) {
			finalPrice += 1000;
		}
		
		return finalPrice;
	}
	
	// 사이즈와 온도 정보 포함 
	@Override
	public String describe() {
		String temp = isIced ? "아이스" : "따뜻한";
		return  temp + " " + name ;
	}
	
}

public class FoodSimple {
	public static void main(String[] args) {
		Beverage americano = new Beverage("아메리카노", 4500, "Tall", true);
		americano.printInfo();
		
		Beverage latte = new Beverage("카페라때", 5000, "Grande", false);
		latte.printInfo();
		
		Beverage mocha = new Beverage("카페모카", 5500, "Venti", true);
		mocha.printInfo();
	}
}















