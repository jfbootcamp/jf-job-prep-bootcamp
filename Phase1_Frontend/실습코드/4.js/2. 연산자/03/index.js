// 연결연산자와 논리연산자 (Concatenation & Logical Operators)
console.log("[연결 연산자] 문자열 + 문자열");

// 1. 연결연산자
let price = 10000;
console.log("'가격: ' + price + '원' ->", '가격: ' + price + '원');

let firstName = "순신";
let lastName = "이";
console.log("firstName + lastName -> ", firstName + lastName);

// 템플릿 리터럴 (권장)
console.log("\n[권장] 템플릿 리터럴 사용");
console.log(` \`가격: \${price}원 \` -> `, `가격: ${price}원`);

// 2. 논리연산자 

// 2-1. NOT 연산자 (!)
console.log("\n [NOT 연산자] ! (반전)");

let isClicked = true;
let isOpened = false;

console.log("isClicked =", isClicked, "| !isClicked ->", !isClicked);
console.log("isOpened =", isOpened, "| !isOpened ->", !isOpened);

// 2-2. OR 연산자 (||)
console.log("\n [OR 연산자] || (하나라도 true면 true)");
console.log("true || true ->", true || true);
console.log("true || false ->", true || false);
console.log("false || true ->", false || true);
console.log("false || false ->", false || false);

// 2-3. AND 연산자 (&&)
console.log("\n [AND 연산자] && (둘다 true면 true)");
console.log("true && true ->", true && true);
console.log("true && false ->", true && false);
console.log("false && true ->", false && true);
console.log("false && false ->", false && false);

// 3. 삼항 연산자 
console.log("\n [삼항 연산자] 조건 ? 참일때 : 거짓일때")

let num = 100;
let result = num % 2 === 0 ? '짝수' : '홀수';
console.log(` num= ${num} | num % 2 === 0 ? '짝수' : '홀수' -> `, result);

num = 101;
result = num % 2 === 0 ? '짝수' : '홀수';
console.log(` num= ${num} | num % 2 === 0 ? '짝수' : '홀수' -> `, result);

console.log("\n 삼항 연산자 활용");
let age = 20;
let status = age >= 18 ? '성인' : '미성년자';
console.log(`age = ${age} | age >= 18 ? '성인' : '미성년자' -> `, status);

let score = 67;
let grade = score >= 90 ? 'A' : score >= 80 ? 'B' : score >= 70 ? 'C' : 'F';
console.log(`score = ${score} | 중첩 상항 연산자 =>`, grade);
