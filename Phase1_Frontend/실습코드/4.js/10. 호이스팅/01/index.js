/*
    호이스팅 (Hoisting)
        - 식별자의 선언문이,
          스코프의 최상단으로 끌어올려진 듯한 현상 
*/
//1. 함수 호이스팅 - 선언 전 호출
console.log("[1. 함수 호이스팅 - 선언 전 호출]");

connectString('study', 'hoisting');

function connectString(str1, str2) {
    console.log("-> 결과:", str1 + str2);
}

console.log("-> 함수 선언 전에 호출했지만 정상 작동!");

//2. 함수 표현식은 호이스팅 안됨
console.log("[2. 함수 표현식은 호이스팅 안됨]");

// add(1, 2);      //ReferenceError 

// 함수 표현식
const add = function(a, b) {
    return a + b;
}

console.log("선언 후 호출: add(1,2) = ", add(1, 2));