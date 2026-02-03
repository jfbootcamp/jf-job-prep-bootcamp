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
		//System.out.println("------------------");
		System.out.println(" " + describe());
		System.out.printf(" 가격 : %,d원%n", getPrice());
		//System.out.println("------------------");
		System.out.println();
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

/*
 * 	Dessert 클래스 - Food 상속 (is-a: 디저트는 음식이다)
 */
class Dessert extends Food {
	// 고유 필드 - 디저트만의 속성
	String topping;			// 토핑 이름 : ""(없음), "생크림", "초콜릿" 등 (+1000원)
	boolean isGiftBox;		// 선물 포장 여부 : (+1500원)
	
	// 생성자 - 디제트 객체 초기화
	public Dessert(String name, int price, String topping, boolean isGiftBox) {
		super(name, price);
		this.topping = topping;
		this.isGiftBox = isGiftBox;
	}
	
	// 토핑과 선물 포장에 따른 추가 요금 계산 
	@Override
	public int getPrice() {
		int finalPrice = price;
		if(!topping.equals("")) {		// 토핑이 있으면(빈 문자열이 아니면)
			finalPrice += 1000;
		}
		
		if(isGiftBox) {					// 선물 포장 선택 시
			finalPrice += 1500;
		}	
		return finalPrice;
	}
	
	// 토핑과 포장 정보 포함
	@Override
	public String describe() {
		String desc = "";
		
		if(!topping.equals("")) {					// 토핑이 있으면 추가 (예: 생크림 추가)
			desc += topping + " 추가 ";
		}
		desc += name;								// 기본 이름 추가 
		
		if(isGiftBox) {								// 선물 포장이면 (예: 생크림 추가 치즈케이크 (선물포장))
			desc += " (선물포장)";				
		}
		
		return desc;
	}
	
}

/*
 * 	메인요리 클래스 - Food 상속 (is-a : 메인요리는 음식이다)
 */
class MainDish extends Food {
	// 고유 필드 - 메인요리만의 속성
	boolean includeSide;			// 세트 메뉴 여부: 사이드(감자튀김, 음료 등) 포함 시 +2000원
	int spicylevel;					// 메운맛 레벨: 0=순한 맛, 1=보통, 2=매운맛
	
	// 생성자 - 메인요리 객체 초기화
	public MainDish(String name, int price, boolean includeSide, int spicylevel) {
		super(name, price);
		this.includeSide = includeSide;				// 세트 여부 결정
		this.spicylevel = spicylevel;				// 매운맛 레벨 설정
	}
	
	// 세트 메뉴 추가 요금 계산
	@Override
	public int getPrice() {
		int finalPrice = price;				// 기본 가격
		if(includeSide) {					// 세뉴 메뉴 선택시
			finalPrice += 2000;				// 사이드 추가 + 2000
		}
		
		return finalPrice;
	}
	
	// 매운 맛 레벨과 세트 정보 포함
	@Override
	public String describe() {
		String spicy = "";
		if(spicylevel == 1) {
			spicy = "★ ";			// 보통 매운 맛: 별 1개
		} else if(spicylevel == 2) {
			spicy = "★★ ";			// 매운 맛: 별 2개
		}
		// spicylevel == 0 -> 순한 맛, 표시 없음
		
		String set = includeSide ? " 세트" : "";
		
		return spicy + name + set;	// 예) ★★ 양념치킨 세트
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
		
		System.out.println("-------------------------------------------");
		
		Food cheesecake = new Dessert("치즈케이크", 6000, "", false);
		cheesecake.printInfo();
		
		Food tiramisu = new Dessert("티라미수", 7000, "생크림", true);
		tiramisu.printInfo();
		
		Food macaron = new Dessert("마카롱 세트", 5500, "초코릿", false);
		macaron.printInfo();
		
		System.out.println("▶테스트 : MainDish (메인요리)");
		System.out.println("-------------------------------------------");
		
		Food burger = new MainDish("불고기 버거", 6500, false, 0);
		burger.printInfo();
		
		Food chicken = new MainDish("양념치킨", 18000, true, 2);
		chicken.printInfo();
		
		Food bibimbap = new MainDish("비빔밥", 9000, true, 1);
		bibimbap.printInfo();
		
	}
}















