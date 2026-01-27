package chap06.oopbasic;

class Dog {
	String name;
	String breed;
	int age;
	int energy;
	
	/*
	 * 짖기
	 * 	- 에너지가 있으면 짓고, 없으면 피곤하다고 출력
	 * 	- 에너지 소모 -5
	 */
	void bark() {
		if(energy > 0) {
			System.out.println(name + ": 멍멍!");
			energy -= 5;
		} else {
			System.out.println(name + "은(는) 너무 피곤해서 짖을 수 없어요.");
		}
	}
	
	/*
	 * eat () - 밥 먹기
	 * 	- 동작 : 에너지 +20, 최대 100 제한
	 *  - 에너지 회복 +20 
	 */
	void eat() {
		energy += 20;
		
		// 100 초과 방지
		if(energy > 100) {
			energy = 100;
		}
		
		System.out.println(name +"이(가) 밥을 먹었습니다. 에너지: "+ energy);
	}
	
	/*
	 * play() - 놀기
	 * 	- 동작 : 에너지가 15 이상이면 놀고, 부족하면 밥 먼저 달라고 함
	 *  - 에너지 소모 : -15
	 */
	void play() {
		if(energy >= 15) {
			energy -= 15;
			System.out.println(name +"이(가) 신나게 놀았습니다! 에너지: "+ energy);
		} else {
			System.out.println(name +"은(가) 에너지가 부족해요. 먼저 밥을 주세요!");
		}
	}
	
	/*
	 * sleep() - 자기
	 * 	- 동작 : 에너지를 100으로 완전 회복
	 *  - 에너지 회복 : 100 (완전 충전)  
	 */
	void sleet() {
		energy = 100;	
		System.out.println(name +"이(가) 푹 잤습니다. 에너지가 가득 찼어요!");
	}
	
	/*
	 * displayInfo() - 정보 출력
	 */
	void displayInfo() {
		System.out.println("----------------");
		System.out.println("이름: " + name);
		System.out.println("품종: " + breed);
		System.out.println("나이: " + age +"살");
		System.out.println("에너지: " + energy + "/100");
	}
	
	/*
	 * greet(Dog other) - 다른 강아지에게 인사
	 * 	- 파라미터 : Dog other - 인사할 상대 강아지 객체 
	 * 	- 동작 : 1) dog1이 dog2에게 꼬리를 흔듦
	 * 			2) dog2가 응답으로 짖음 	
	 */
	void greet(Dog other) {
		System.out.println(name +"이(가)"+ other.name + "에게 꼬리를 흔듭니다!");
		other.bark();		// 상대방 객체의 메서드 호출
	}
}

public class ObjectCreation {

	public static void main(String[] args) {
		System.out.println("=====================================");
		System.out.println("  	객체 생성과 사용 		     ");
		System.out.println("=====================================\n");
		
		System.out.println("--- 1. 강아지 객체 관리 ---\n");
		
		// 객체 생성 및 초기화
		Dog dog1 = new Dog();
		dog1.name = "초코";
		dog1.breed = "푸들";
		dog1.age = 3;
		dog1.energy = 80;
		
		Dog dog2 = new Dog();
		dog2.name = "뽀삐";
		dog2.breed = "진돗개";
		dog2.age = 2;
		dog2.energy = 60;
		
		Dog dog3 = new Dog();
		dog3.name = "맥스";
		dog3.breed = "리트리버";
		dog3.age = 5;
		dog3.energy = 30;		
		
		// 각 객체의 정보 출력
		dog1.displayInfo();
		dog2.displayInfo();
		dog3.displayInfo();
		
		System.out.println();
		
		// 강아지들 활동 
		dog1.play(); 		// 에너지 80 -> 65
		dog2.bark(); 		// 에너지 60 -> 55
		dog3.eat();   		// 에너지 30 -> 50
		dog3.play(); 		// 에너지 50 -> 35
		
		System.out.println();
		
		// 초코가 뽀삐에게 인사 --> 뽀삐가 응답으로 짖음
		dog1.greet(dog2);
		
		System.out.println();
		
		System.out.println("dog1 참조값 : "+dog1);
		System.out.println("dog2 참조값 : "+dog2);
		System.out.println("dog3 참조값 : "+dog3);
		
		System.out.println("--- 2. 객체 배열 ---\n");
		
		// 객체 배열 생성 및 할당
		Dog[] dogs = new Dog[3];
		dogs[0] = dog1;
		dogs[1] = dog2;
		dogs[2] = dog3;
		
		System.out.println("dogs 참조값 : "+dogs);
		System.out.println();
		
		for(Dog dog : dogs) {
			System.out.println(dog);
		}
		
		System.out.println();
		
		System.out.println("모든 강아지에게 밥을 줍니다.");
		for(Dog dog : dogs) {
			dog.eat();  // 각 객체의 eat() 메서드 호출
		}
		
		System.out.println();
		
		for(int i = 0; i < dogs.length; i++) {
			System.out.println("[" +(i + 1)+ "번]");
			dogs[i].displayInfo();
		}
	}
}





















