// 함수 (Function)

// 1. 함수 없이 덧셈하기
console.log("[1. 함수 없이 덧셈하기]");

let num1 = 10;
let num2 = 15;
let sum = num1 + num2;

console.log("num1 = ", num1, "num2 = ", num2);
console.log("-> sum = ", sum);

let num3 = 1;
let num4 = 5;
let sum2 = num3 + num4;

console.log("num3 = ", num3, "num4 = ", num4);
console.log("-> sum2 = ", sum2);

// 2. 기본 함수 선언 
console.log("[2. 기본 함수 선언]");

function add(num1, num2) {
    console.log(`-> 함수 호출됨: add(${num1}, ${num2})`);
    console.log(`-> 결과: ${num1+num2}`);    
}

add(10, 15);
add(1, 5);

//3. return 문 사용하기
console.log("[3. return 문 사용하기]");

function addWithReturn(num1, num2) {
    return num1 + num2;
}

let result = addWithReturn(10, 15);
console.log("addWithReturn(10, 15) 호출");
console.log(`-> 두 숫자를 더한 결과는 ${result} 입니다.`);

//4. return 후 코드는 코드는 실행되지 않음
console.log("[4. return 후 코드는 코드는 실행되지 않음]");

function addWithLog(num1, num2) {
    return num1 + num2;
    console.log("함수 호출");           // 이 코드는 실행되지 않음
}

let result2 = addWithLog(20, 30);
console.log("addWithLog(20, 30) 호출");
console.log("-> 결과:", result2);

/*
    5. 매개변수와 인수
        - 매개변수 (parameter) : 함수 정의 시 선언하는 변수 
        - 인수 (argument) : 함수 호출 시 전달하는 실제 값
*/
console.log("[5. 매개변수와 인수]");

function greet(name) {          // name -> 매개변수(parameter)
    console.log(`안녕하세요, ${name}님!`);
}

greet('이순신');                // '이순신' -> 인수 (argument)
greet('신사임당');

// 6. 여러 매개변수 사용
console.log("[6. 여러 매개변수 사용]");

function introduce(name, age, city) {  //name, age, city -> 매개변수들 (parameters)
    console.log(`-> 이름: ${name}, 나이: ${age}세, 도시: ${city}`);
}

console.log("introduce('홍길동', 25, '서울') 호출");
introduce('홍길동', 25, '서울');     // '홍길동', 25, '서울' -> 인수 (arguments)

// 7. 기본 매개변수 (Default Parametes)
console.log("[7. 기본 매개변수 (Default Parametes)]");

function greetWithDefault(name = '손님') {
    console.log(`-> 환영합니다. ${name}님!`);
}

console.log("greetWithDefault() 호출 (인수없음)");
greetWithDefault();     // 인수없음 -> 기본값 '손님' 사용

console.log("greetWithDefault('회원') 호출");
greetWithDefault('회원');   // '회원' -> 인수(argument), 기본값 대신 사용됨