package chap09.nested02;

public class Main {
	public static void main(String[] args) {
		Order order = new Order();
		
		// 1. 리스너 등록 (익명 객체 사용)
		order.setOnOrderListener(new Order.OnOrderListener() {
			
			@Override
			public void onOrderComplete(String orderId, int totalPrice) {
				System.out.println("[알림] 주문이 완료되었습니다!");
				System.out.println("  주문번호: " +orderId);
				System.out.println("  결재금액: " + String.format("%,d원", totalPrice));
			}
			
			@Override
			public void onOrderCanceled(String orderId) {
				System.out.println("[알림] 주문이 취소되었습니다!");
				System.out.println("  주문번호: " +orderId);
			}
		});
		
		// 주문 처리 실행
		order.processOrder("ORD-2026-001", 1500000);
		System.out.println();
		order.cancelOrder("ORD-2026-002");
		
		// 2. 다른 리스너로 교체하기
		System.out.println("\n===== 2. 다른 리스너로 교체하기 =====");
		
		// 리너스를 다르게 구현하면 다른 동작!
		order.setOnOrderListener(new Order.OnOrderListener() {
			
			@Override
			public void onOrderComplete(String orderId, int totalPrice) {
				// 이번엔 영수증 스타일로 출력
				System.out.println("-------------------------");
				System.out.println("|      ** 영수증 **       |");
				System.out.println("|  주문번호: "+orderId+"  |");
				System.out.println("|  금   액: "+String.format("%,d원", totalPrice)+"  |");
				System.out.println("|  상   태: 결재 완료      |");
				System.out.println("-------------------------");
			}
			
			@Override
			public void onOrderCanceled(String orderId) {
				System.out.println("[통보] 주문 "+orderId+"가 취소 처리되었습니다!");
				System.out.println(" -> 환불은 3~5일 내 처리됩니다.");
			}
		});
		
		order.processOrder("ORD-2026-003", 50000);
		
		// 3. 간단한 계산기 - 익명 객체 
		System.out.println("\n===== 3. 간단한 계산기 - 익명 객체 =====");
		Calculator add = new Calculator() {
			
			@Override
			public int calculate(int a, int b) {
				return a + b;			// 덧셈
			}
		};
		
		Calculator multiply = new Calculator() {
			
			@Override
			public int calculate(int a, int b) {
				return a * b;			// 곱셈
			}
		};
		
		System.out.println(" 10 + 5 = "+add.calculate(10, 5));
		System.out.println(" 10 * 5 = "+multiply.calculate(10, 5));
		
		Product notebook = new Product("게이밍 노트북", 1700000);
		
		// 4. 메소드에 익명 객체 전달 
		printDiscountedPrice(notebook, new Discounter() {
			
			@Override
			public int discount(int price) {
				
				return price - 100000;		// 10만원 정액 할인
			}
		});
		
		printDiscountedPrice(notebook, new Discounter() {
			
			@Override
			public int discount(int price) {
				
				return price - (price * 20 / 100);    // 20% 할인
			}
		});
		
		
		
	}
	
	// 할인된 가격 출력
	private static void printDiscountedPrice(Product product, Discounter discounter) {
		int original = product.getPrice();
		int discounted = discounter.discount(original);
		int saved = original - discounted;
		
		System.out.println(product.getName() + " 할인");
		System.out.println( " 원래 가격 : "+String.format("%,d원", original));
		System.out.println( " 할인 가격 : "+String.format("%,d원", discounted));
		System.out.println( " 절약 금액 : "+String.format("%,d원", saved));
	}
}


















