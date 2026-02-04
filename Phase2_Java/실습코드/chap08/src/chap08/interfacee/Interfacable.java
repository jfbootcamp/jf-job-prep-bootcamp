package chap08.interfacee;

/*
 *    Movable 인터페이스를 정의하고, 다양한 이동 수단 클래스를 구현함 
 *    
 *    					<<interface>>
 *    						Movable
 *    					|     |      |
 *    				   Car   Bicycle Boat	
 */

interface Movable {
	// 상수 (자동으로 public static final)
	int MAX_SPEED = 200;
	int MIN_SPEED = 0;
	
	// 추상 메서드 (자동으로 public abstract)
	void move();
	void stop();
	void setSpeed(int speed);
	int getSpeed();
	String getVehicleType();	//이동 수단 종류 반환
}


public class Interfacable {

}
















