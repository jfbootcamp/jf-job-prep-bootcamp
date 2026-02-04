package chap07.abstractt;

/*
 * 추상 클래스 
 * 		- 동물(Animal) 추상 클래스 정의, 다양한 동물 클래스를 구현함 
 * 
 *  	- 추상 클래스 구조 
 *  		- is-a 
 *  			- Animal 
 *  				|      |      |
 *  			 Dog      Cat    Bird
 *  		- has-a (집합관계)
 *  			- AnimalShelter
 *  				- 동물 보호소가 동물들을 관리함 		
 */


/*
 * 	모든 동물의 추상 부모 클래스 
 * 		- 추상 메서드 
 * 			- 자식 클래스에서 반드시 구현해야 함 
 */
abstract class Animal {
	// 필드 - 모든 동물이 공통으로 가지는 속성
	protected String name;
	protected int age;
	protected String species;	// 종류
	// 생성자 
	public Animal(String name, int age, String species) {
		//super();
		this.name = name;
		this.age = age;
		this.species = species;
	}
	
	/*
	 * 추상 메서드 - 자식 클래스에서 반드시 구현해야함
	 * abstract: 구현부 없음 (;로 끝남), 자식이 @Override 필수  
	 */
	public abstract void makeSound();		// 소리내기 (동물마다 다름)
	public abstract void move();			// 이동 (동물마다 다름)
	
	// 일반 메서드 - 모든 동물이 공유하는 기능 (구현 포함)
	public void eat(String food) {
		System.out.println(name +"이(가) "+ food + "을(를) 먹습니다.");
	}
	
	public void sleep() {
		System.out.println(name +"이(가) 잠을 잡니다. Zzz....");
	}
	
	public void displayInfo() {
		System.out.println("-----------------");
		System.out.println(" 동물 정보");
		System.out.println(" 이름: " + name);
		System.out.println(" 나이: " + age + "살");
		System.out.println(" 종류: " + species);
	}

	// Getter 메서드 
	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getSpecies() {
		return species;
	}
	
}

// Dog 클래스 - Animal 상속
class Dog extends Animal {
	// 고유 필드 - 강아지만의 속성
	private String breed;		//견종
	// 생성자
	public Dog(String name, int age, String breed) {
		super(name, age, "강아지");		// 부모 생성자 호출
		this.breed = breed;
	}
	
	// 추상 메서드 구현 (필수)
	@Override
	public void makeSound() {
		System.out.println("    >> [Dog.makeSound() 호출됨] ");
		System.out.println(name + ": 멍멍! 왈왈!");
	}
	
	@Override
	public void move() {
		System.out.println("    >> [Dog.move() 호출됨] ");
		System.out.println(name + "이(가) 네 발로 뛰어갑니다.");
	}
	
	// Dog 고유 메서드
	public void fetch() {
		System.out.println(name + "이(가) 공을 물어옵니다.");
	}
	
	public void wagTail() {
		System.out.println(name + "이(가) 꼬리를 흔듭니다.");
	}

	public String getBreed() {
		return breed;
	}
	
}

// Cat 클래스 - Animal 상속
class Cat extends Animal {
	// 고유 필드
	private boolean isIndoor;			// 실내 고양이 여부 
	// 생성자
	public Cat(String name, int age, boolean isIndoor) {
		super(name, age, "고양이");
		this.isIndoor = isIndoor;
	}
	
	// 추상 메서드 구현
	@Override
	public void makeSound() {
		System.out.println("    >> [Cat.makeSound() 호출됨] ");
		System.out.println(name + ": 야옹~ 냐옹");				
	}
	
	@Override
	public void move() {
		System.out.println("    >> [Cat.move() 호출됨] ");
		System.out.println(name + "이(가) 살금살금 걸어갑니다");			
	}
	
	// Cat 고유 메서드
	public void scratch() {
		System.out.println(name + "이(가) 발톱을 갈습니다.");
	}
	
	public void purr() {
		System.out.println(name + "이(가) 가르랑거립니다");
	}
	
}

// Bird 클래스 - Animal 상속
class Bird extends Animal {
	// 고유 필드
	private double wingspan;			// 날개 길이 
	// 생성자
	public Bird(String name, int age, double wingspan) {
		super(name, age, "새");
		this.wingspan = wingspan;
	}
	
	// 추상 메서드 구현
	@Override
	public void makeSound() {
		System.out.println("    >> [Bird.makeSound() 호출됨] ");
		System.out.println(name + ": 짹짹! 삐약삐약");		
	}
	@Override
	public void move() {
		System.out.println("    >> [Bird.move() 호출됨] ");
		System.out.println(name + "이(가) 하늘을 납니다.");			
	}
	
	// Bird 고유 메서드 
	public void fly() {
		System.out.println(name + "이(가) " + wingspan+ "m 날개를 펴고 비행합니다.");
	}
	
}

/*
 * 	다형성 활용
 *  Animal[] 배열 하나로 모든 동물 관리  (업캐스팅 활용)
 */
class AnimalShelter {
	private String shelterName;			// 보호소 이름
	private Animal[] animals;			// 추상 클래스 타입 배열 (다형성 활용)
	private int count;					// 현재 등록된 동물 수 
	
	public AnimalShelter(String shelterName, int capacity) {
		//super();
		this.shelterName = shelterName;			// 보호소 이름 초기화
		this.animals = new Animal[capacity];	// 주어진 용량으로 동물 배열 생성 
		this.count = 0;							// 현재 동물 수 0으로 초기화
	}
	
	// 동물 추가 (업캐스팅 발생)
	public void addAnimal(Animal animal) {
		if(count < animals.length) {				// 수용 가능한지 확인
			animals[count] = animal;				// 배열에 동물 추가 (업캐스팅)
			count++;								// 동물 수 증가
			System.out.println("O " +animal.getName()+ " ("+ animal.getSpecies() +") 입소!");
		} else {
			System.out.println("X 보호소 수용 인원 초과");
		}
	}
	
	// 모든 동물 소리 내기 (동적 바인딩)
	public void makeAllSounds() {
		System.out.println("\n[모든 동물 소리 내기 - 동적 바인딩 테스트]");
		System.out.println("-------------------------------------");
		
		for(int i = 0; i < count; i++) {
			System.out.println(animals[i].getName() + ":");
			animals[i].makeSound();   		// 실제 객체의 makeSound() 호출!
			System.out.println();
		}
	}
	
	/*
	 * 특정 종류의 동물 찾기 (instanceof + 다운캐스팅)
	 * 	- animals[i]는 Animal 타입으로 저장되어 있음(업캐스팅된 상태)
	 *  - Animal 타입으로는 Dog 고유 메서드 호출 불가
	 *  - 다운캐스팅하면 컴파일러에게 "이건 Dog야!"라고 알려주는 것
	 */
	public void findDogs() {
		System.out.println("\n[강아지 목록 - instanceof + 다운캐스팅]");
		System.out.println("-------------------------------------");
		
		for(int i = 0; i < count; i++) {
			if(animals[i] instanceof Dog) {		// 실제 객체가 Dog인지 확인
				Dog dog = (Dog)animals[i];		// 다운캐스팅: Animal -> Dog
				System.out.printf("  %s - 견종: %s, 나이: %d살%n", 
						dog.getName(), dog.getBreed(), dog.getAge());  // Dog 고유 메서드 호출
				dog.wagTail();										   // Dog 고유 메서드 호출		
			}
		}
	}
	
	// 가장 나이 많은 동물 찾기
	public Animal getOldestAnimal() {
		if (count == 0) return null;		// 동물이 없으면 null 반환
		
		Animal oldest = animals[0];			// 첫 번째 동물을 최고령으로 가정
		for (int i = 1; i < count; i++) {	// 두번째부터 순회
			if(animals[i].getAge() > oldest.getAge()) {		// 더 나이 많은 동물 발견 시
				oldest = animals[i];		// 최고령 갱신
			}
		}
		
		return oldest;
	}
	
}

public class AbstractClass {
	public static void main(String[] args) {
		System.out.println(">> 테스트 1: 추상 클래스 특성");
		//Animal animal = new Animal("동물",10,"동물");	// 추상 클래스는 직접 인스턴스 생성 불가 
		
		// 업캐스팅: 자식 객체를 부모 타입 변수에 저장
		Animal a1 = new Dog("바둑이", 3, "진돗개");		// Dog -> Animal
		Animal a2 = new Cat("나비", 2, true);			// Cat -> Animal
		Animal a3 = new Bird("참새", 1, 0.2);			// Bird -> Animal
		
		// 다형성: 같은 메서드 호출, 다른 결과!
		a1.makeSound(); 
		System.out.println();
		a2.makeSound();
		System.out.println();
		a3.makeSound();
		
		// 다운캐스팅
		// 방법1 : 전통적인 방식 
		System.out.println(">> 테스트 2: 다운캐스팅");
		System.out.println("방법1 : 전통적인 방식");
		if(a1 instanceof Dog) {
			Dog dog = (Dog)a1;
			dog.fetch(); 		// Dog 고유 메서드 
			dog.wagTail();
		}
		
		// 방법2 : Java 16+ 패턴 매칭
		System.out.println("방법2 : Java 16+ 패턴 매칭");
		if(a2 instanceof Cat cat) {
			cat.scratch();		// Cat 고유 메서드 
			cat.purr();
		}
		
		// AnimalShelter
		System.out.println(">> 테스트 3: AnimalShelter - 다형성 실전 활용");
		System.out.println("-----------------------------------------");
		
		AnimalShelter shelter = new AnimalShelter("행복 동물 보호소", 10);
		
		System.out.println("\n 동물 입소 - 업캐스팅 발생");
		shelter.addAnimal(new Dog("바둑이", 3, "리트리버"));
		shelter.addAnimal(new Dog("뽀삐", 5, "푸들"));
		shelter.addAnimal(new Cat("나비", 2, true));
		shelter.addAnimal(new Cat("까미", 4, false));
		shelter.addAnimal(new Bird("파랑이", 1, 0.3));
		
		// 모든 동물 소리 (동적 바인딩)
		shelter.makeAllSounds();
		
		// 강아지만 찾기 (다운캐스팅)
		shelter.findDogs();
		
		// 가장 나이 많은 동물
		Animal oldest = shelter.getOldestAnimal();
		System.out.println("\n[가장 나이 많은 동물]");
		if(oldest != null) {
			oldest.displayInfo();
		}
		
	}
}













































