package chap06.oopbasic;

class Product {
	String name;
	int price;
	int stock;	// 재고 수량
	
	void displayInfo() {
		
	}
	
	/*
	 *  if (stock >= quantity) {
	 *    //판매 성공 처리
	 *  } else {
	 *   // 판매 실패 처리 
	 *  }
	 */
	boolean sell(int quantity) {
		
		return false;
	}
	
	// stock += quantity
	void restock(int quantity) {
		
	}
}

public class ObjectCreation02 {

	public static void main(String[] args) {
		
		System.out.println("--- 1. 상품 관리 시스템 ---\n");
		
		// 상품 배열 생성 및 초기화
		Product[] products = new Product[4];
		
		products[0] = new Product();
		products[0].name = "노트북";
		products[0].price = 1500000;
		products[0].stock = 10;
	}
	
}















