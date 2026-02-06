package chap09.nested02;

public class Product {
	private String name;
	private int price;
	
	public Product(String name, int price) {
		//super();
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return String.format("%s (%,d원)", name, price);
	}
	
	
	
	
}
