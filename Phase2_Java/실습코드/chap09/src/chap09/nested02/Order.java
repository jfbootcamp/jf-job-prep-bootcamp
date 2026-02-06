package chap09.nested02;

/*
 * 주문 처리 클래스 
 * 	- 중첩 인터페이스를 포함하고 있음 
 */
public class Order {

	public interface OnOrderListener {
		void onOrderComplete(String orderId, int totalPrice);		// 주문 완료 시 호출
		void onOrderCanceled(String orderId);						// 주문 취소 시 호출 
	}
	
	/*
	 * 콜백을 받을 객체를 저장하는 필드
	 */
	private OnOrderListener listener;
	
	/*
	 * 외부에서 리스너(콜백 받을 객체)를 등록하는 메소드
	 */
	public void setOnOrderListener(OnOrderListener listener) {
		this.listener = listener;
	}
	
	// 주문 처리
	public void processOrder(String orderId, int totalPrice) {
		System.out.println("주문 처리 중....(주문번호: " +orderId+ ")");
		
		// ... 실제로는 여기서 결재, DB 저장 등 처리...
		
		// 처리 완료 후 리스너에게 알려줌 (콜백!)
		if(listener != null) {
			listener.onOrderComplete(orderId, totalPrice);
		}
	}
	
	// 주문 취소 
	public void cancelOrder(String orderId) {
		System.out.println("주문 취소 중....(주문번호: " +orderId+ ")");
		
		// ...취소 처리...
		
		// 취소 완료 후 리스너에게 알려줌 (콜백!)
		if(listener != null) {
			listener.onOrderCanceled(orderId);
		}
	}
}
















