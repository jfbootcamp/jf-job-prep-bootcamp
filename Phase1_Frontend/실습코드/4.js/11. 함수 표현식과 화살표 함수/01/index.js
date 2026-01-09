// 1. 함수 선언문 
function addDeclaration(a, b) {
    return a + b;
}

console.log("addDeclaration(10, 20) = " , addDeclaration(10, 20));

// 2. 함수 표현식 
const addExpression = function(a, b) {
    return a + b;
};   // 세미콜론 필수(변수 할당문)

console.log("addExpression(100, 200) = ", addExpression(100, 200)); //변수명으로 함수 호출

// 3. 화살표 함수 (Arrow Function) - 기본
// 형태: (매개변수) => { 함수 본문 };
const addArrow = (a, b) => { return a + b; };

console.log("addArrow(20, 30) = ", addArrow(20, 30));

// 4. 화살표 함수 (Arrow Function) - 간결한 표현 
// 본문이 한 줄(표현식 하나)일 때 더 짧게 작성 가능 
const addShort = (a, b) => a + b;   // 한줄로 가장 많이 쓰는 형태

console.log("addShort(40, 50) = ", addShort(40, 50));

// 5. 화살표 함수 (Arrow Function) - 매개변수가 하나일 때
// [매개변수 1개] 괄호 ()도 생략 가능! - 가장 간결한 형태
const doubleVar = x => x * 2;       // 매개변수 x 하나, 반환값 x * 2 

console.log("doubleVar(5) = ", doubleVar(5));

// 6. 화살표 함수 (Arrow Function) - 매개변수가 없을 때 
// [매개변수 0개] 빈 괄호 ()는 반드시 필요! (생략 불가)
const sayHello = () => "안녕하세요!";       // 매개변수 없이 문자열 반환 

console.log("sayHello() = ", sayHello());

/*
    세가지 형태 비교 
        1) 함수 표현식 : function 키워드 사용, 가장 전통적인 방식
        2) 화살표 함수(기본): => 사용, 중괄호와 return 표현 
        3) 화살표 함수(간결): => 사용, 한 줄로 축약 (실무에서 가장 많이 사용)
*/

// 7. 실용적인 예

// 배열 선언 
const numbers = [1, 2, 3, 4, 5];        // 숫자 5개가 담긴 배열
console.log("numbers = ", numbers);

// [map 메서드] : 배열의 각 요소를 변환하여 새 배열 반환 (원본 배열은 그대로)
const doubleVar2 = numbers.map(n => n *2);
console.log("numbers.map(n => n *2) =", doubleVar2);

// [filer 메서드] : 조건을 만족하는 요소만 걸러서 새 배열 반환 
const evens = numbers.filter(n => n % 2 === 0);
console.log("numbers.filter(n => n % 2 === 0) = ", evens);

// [reduce 메서드] : 배열의 모든 요소를 하나의 값으로 축소 (누적);
const sum = numbers.reduce((acc, n) => acc + n, 0);     // 줄이다, 축소하다 
console.log("numbers.reduce((acc, n) => acc + n, 0) = " + sum);