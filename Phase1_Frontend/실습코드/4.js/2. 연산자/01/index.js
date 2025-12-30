// 산술 연산자 (Arithmetic Operators)

let num1 = 10;
let num2 = 5;

console.log("[원본] num1 =", num1, ", num2 =", num2);

// 1. 기본 산술 연산자
console.log("\n [기본 산술 연산자]");

console.log("num1 + num2 (덧셈) ->", num1 + num2);
console.log("num1 - num2 (뺄셈) ->", num1 - num2);
console.log("num1 * num2 (곱셈) ->", num1 * num2);
console.log("num1 / num2 (나눗셈) ->", num1 / num2);
console.log("num1 % num2 (나머지) ->", num1 % num2);
console.log("num1 ** 2 (거듭제곱) ->", num1 ** 2);

//2. 증감 연산자 (++, --)
console.log("\n [증감 연산자]");

let a = 10;
console.log("초기값 a =", a);

// 후위 증가 (a++) - 먼저 사용하고, 나중에 증가 
console.log("a++ (후위 증가) ->", a++, "| 출력 후 a =", a);

// 전위 증가 (++a) - 먼저 증가하고, 나중에 사용
console.log("++a (전위 증가) ->", ++a, "| 출력 후 a =", a); 

let b = 10;
console.log("\n초기값 b =", b);

// 후위 감소 (b--) - 먼저 사용하고, 나중에 감소 
console.log("b-- (후위 증가) ->", b--, "| 출력 후 a =", b);

// 전위 감소 (--b) - 먼저 감소하고, 나중에 사용
console.log("--b (전위 증가) ->", --b, "| 출력 후 b =", b); 
