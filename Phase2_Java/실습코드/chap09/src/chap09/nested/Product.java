package chap09.nested;

public class Product {
	private String name;
	private int basePrice;
	
	public Product(String name, int basePrice) {
		//super();
		this.name = name;
		this.basePrice = basePrice;
	}

	public String getName() {
		return name;
	}

	public int getBasePrice() {
		return basePrice;
	}

	@Override
	public String toString() {
		return String.format("%s (%,d원)", name, basePrice);
	}
	
	/*
	 *  인스턴스 멤버 클래스 - 상품 옵션
	 *  	- 바깥 객체(Product)가 있어야 생성 가능
	 */
	public class Option {
		private String optionName;
		private int addtionalPrice;
		
		public Option(String optionName, int addtionalPrice) {
			//super();
			this.optionName = optionName;
			this.addtionalPrice = addtionalPrice;
		}
		
		// 바깥 클래스(Product)의 필드 접근 가능
		public int getTotalPrice() {
			return basePrice + addtionalPrice;
		}

		@Override
		public String toString() {
			return String.format("%s [%s] - 총 %,d원 (기본 %,d + 추가 %,d)", 
					name, optionName, getTotalPrice(), basePrice, addtionalPrice);
		}
			
	}
	
	/*
	 * 정적 멤버 클래스 - 카테고리
	 * 	- 바깥 객체 없이 바로 생성 가능	
	 */
	public static class Category {
		private String categoryName;
		private String description;
		
		public Category(String categoryName, String description) {
			//super();
			this.categoryName = categoryName;
			this.description = description;
		}

		@Override
		public String toString() {
			return String.format("%s (%s원)", categoryName, description);
		}
		
		
	}
	
}

































