package chap06.constructors03encapsulation;

import java.math.BigDecimal;

/*
 * 		BigDecimal - 정밀한 숫자 계산을 위한 Java 클래스 
 */
public class BigDecimalTest {
	
	public static void main(String[] args) {
		// double 사용시 문제
		System.out.println(0.1 + 0.2);
		
		double price = 19.99;
		double quantity = 100;
		System.out.println(price * quantity);
		
		// BigDecimal 사용 
		BigDecimal a = new BigDecimal("0.1");
		BigDecimal b = new BigDecimal("0.2");
		System.out.println(a.add(b));
		
		BigDecimal price2 = new BigDecimal("19.99");
		BigDecimal quantity2 = BigDecimal.valueOf(100);
		System.out.println(price2.multiply(quantity2));
	}

}













