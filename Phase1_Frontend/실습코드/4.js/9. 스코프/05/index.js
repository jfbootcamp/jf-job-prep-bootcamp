// 변수 재선언 (var vs let)

// 1. let은 재선언 불가 (let은 같은 스코프에서 재선언할수 없음)
let num1 = 10;
//let num1 = 100;      --> SyntaxError 발생 

// 2. var는 재선언 가능  (var는 같은 스코프에서 재선언이 가능함)
var num2 = 10;
var num2 = 100;

// 3. let은 재할당은 가능
let num3 = 10;
num3 = 100;   // 재할당 (재선언 X)

// 4. const는 재선언, 재할당 모두 불가 
const PI = 3.14159;
// const PI = 3.14;
// PI = 3.14; --> TyeError 발생 

// 5. var 재선언의 문제점
var count = 1;
var count = 100;        // 기존 값이 사라짐 (실수로 재선언)
