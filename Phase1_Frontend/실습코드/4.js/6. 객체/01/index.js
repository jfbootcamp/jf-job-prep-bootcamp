// 객체(Object) - 생성자 함수, 리터럴 

//1. 생성자 함수로 객체 생성
console.log("[1. 생성자 함수로 객체 생성]");

let obj1 = new Object();        // 생성자 함수로 빈 객체 생성 (결과: {})
console.log("obj1 = ", obj1);

//2. 객체 리터럴로 객체 생성
console.log("[2. 객체 리터럴로 객체 생성]");
let obj2 = {};
console.log("obj2 = ", obj2);
console.log("-> 리터럴 방식이 더 간결하고 권장됩니다.");

//3. 속성(property)을 가진 객체
console.log("\n[3. 속성(property)을 가진 객체]");

let book = {
    title: '자바스크립트 바이블',       // 키: title, 값: 문자열
    author: '이순신',                 // 키: author, 값: 문자열
    category: '자바스크립트'           // 키: category, 값: 문자열
}
console.log("book = ", book);

//4. 속성 접근하기 - 점 표기법(Dot notation), 대괄호 표기법(Bracket Notation)
console.log("\n[4. 속성 접근하기]");
console.log("book.title =",book.title);
console.log("book.author = ", book.author);

console.log("book['category'] =", book['category']);
console.log("book['title'] = ", book['title']);

//5. 다양한 값 타입의 속성
console.log("\n[5. 다양한 값 타입의 속성]");

let product = {
    name: "노트북",             // 문자열
    price: 1500000,            // 숫자
    inStock: true,             // 불리언 
    discount: undefined,       // undefined (할인 정보 없음)
    tags:['전자기기', 'IT'],    //  배열 (객체 안에 배열 가능 )  
}
console.log("product.discount = ", product.discount);
console.log("product.tags = ", product.tags);


//6. 메서드 (객체 안의 함수)
console.log("\n[6. 메서드 (객체 안의 함수)]");

let bookWithMethod = {
    title: '자바스크립트 바이블',       // 키: title, 값: 문자열
    author: '이순신',                 // 키: author, 값: 문자열
    category: '자바스크립트',           // 키: category, 값: 문자열  
    year: undefined,                  
    color: function() {
        console.log('-> orange');
    }  
}
console.log("bookWithMethod.author = ", bookWithMethod.author);
bookWithMethod.color();

//7. 속성 추가, 수정, 삭제
console.log("\n[7. 속성 추가, 수정, 삭제]");

let person = { name : '이순신'};            // 속성 1개를 가진 객체 
console.log("person =" + person);   
console.log("person.name =" + person.name); 

//속성 추가
person.age = 25;        // 속성 추가
console.log("person.age =" + person.age);

//속성 수정
person.name = '신사임당';
console.log("person.name =" + person.name); 

//속성 삭제
delete person.age;      // 속성 삭제
console.log("person =" + person); 
console.log("person.age =" + person.age);