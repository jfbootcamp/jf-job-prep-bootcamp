// 숫자형(Number) - JavaScript는 정수와 소수를 구분하지 않음

let num1 = 125;         // 정수 
let num2 = 10.00012;    // 소수 (부동소수점)

console.log("[숫자형] 정수 num1 = ", num1, "-> typeof: ", typeof num1);
console.log("[숫자형] 정수 num2 = ", num2, "-> typeof: ", typeof num2);

/*
    JavaScript는 정수, 소수 모두 'number' 타입임.
    다른 언어 (Java, C++)는 int, float, double 등으로 구분하지만 JavaScript는 모든 숫자를 64비트 부동소수점으로 처리.
*/
