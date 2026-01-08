// 변수 호이스팅 (Variable Hoisting)
console.log("[1. var 변수 호이스팅 (Variable Hoisting)]");

console.log("-> num1 = ", num1);
var num1 = 123;
console.log("-> num1 = ", num1);

console.log("[2. let/const 변수의 TDZ(Temporal Dead Zone) ]");
console.log(num2);
let num2 = 213;
