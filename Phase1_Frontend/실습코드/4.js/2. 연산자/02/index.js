// 대입 연산자와 비교 연산자 (Assignment & Comparison Operators)

console.log("[대입 연산자]");

let num = 10;
console.log("초기값 num = ", num);

// 1. 기본 대입 연산자 
num = 20;
console.log("num = 20 -> ", num);

// 복합 대입 연산자 (산술 + 대입)
num = 10;           // 초기화 
console.log("\n [복합 대입 연산자] 초기값 num = ", num);

num += 5;       // num = num + 5
console.log("num += 5 (num = num + 5) ->", num);

num -= 3;       // num = num - 3
console.log("num -= 3 (num = num - 3) ->", num);

num *= 2;       // num = num * 2
console.log("num *= 2 (num = num * 2) ->", num);

num /= 4;       // num = num / 4
console.log("num /= 4 (num = num / 4) ->", num);

num %= 3;       // num = num % 3
console.log("num %= 3 (num = num % 3) ->", num);

num **= 2;       // num = num ** 2
console.log("num **= 2 (num = num ** 2) ->", num);

// 2. 비교 연산자 
console.log("\n[비교 연산자]");

let a = 5;
let b = "5";
let c = 10;

console.log("a = ", a, "(숫자), b= ", b, "(문자열), c =", c, "(숫자)");

// 동등 비교 (== vs ===)
console.log("\n[동등 비교]");
console.log("a == b (느슨한 비교) ->", a == b, "<-- 값만 비교, 타입 무시");
console.log("a === b (엄격한 비교) ->", a === b, "<-- 값과 타입 모두 비교 (권장)");

// 부등 비교 (!= vs !==)
console.log("\n[부등 비교]");
console.log("a != b (느슨한 비교) ->", a != b, "<-- 값만 비교, 타입 무시");
console.log("a !== b (엄격한 비교) ->", a !== b, "<-- 값과 타입 모두 비교 (권장)");

// 크기 비교 (<, >, <=, >=)
console.log("\n[크기 비교]");
console.log("a < c (미만) ->", a < c);
console.log("a > c (초과) ->", a > c);
console.log("a <= c (이하) ->", a <= c);
console.log("a >= c (이상) ->", a >= c);

// 느슨한 비교(==)의 함정
console.log("\n[느슨한 비교(==)의 함정]");
console.log("0 == '' ->", 0 == '', "<- 둘 다 falsy라서 같음");
console.log("0 == false ->", 0 == false, "<- 둘 다 falsy라서 같음 ");
console.log("null == undefined ->", null == undefined, "<- 특별 규칙으로 같음" );

console.log("\n[엄격한 비교로 해결]");
console.log("0 === '' ->", 0 === '');
console.log("0 === false ->", 0 === false);
console.log("null === undefined ->", null === undefined);