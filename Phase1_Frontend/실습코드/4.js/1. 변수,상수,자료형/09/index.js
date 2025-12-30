let num = "100";
console.log(typeof num);

num = 10;
console.log(typeof num);

// 형 변환 (Type Conversion)
let num1 = '15';        //문자열
let num2 = 5;           //숫자

// 1.묵시적(암묵적) 형 변환 - JS가 자동으로 변환
console.log("\n[묵시적 형 변환]")

//나눗셈, 곱셈, 뺄셈 -> 문자열이 숫자로 자동변환
console.log("'15' / 5 ->", num1 / num2, "(문자열 -> 숫자 자동 변환)");
console.log("'15' * 5 ->", num1 * num2, "(문자열 -> 숫자 자동 변환)");
console.log("'15' - 5 ->", num1 - num2, "(문자열 -> 숫자 자동 변환)");

//덧셈 -> 숫자가 문자열로 변환 (문자열 연결!)
console.log("'15' + 5 ->", num1 + num2, "(숫자 -> 문자열, 연결됨!)");


// 2. 명시적 형 변환 - 개발자가 직접 변환 
console.log("\n[명시적 형 변환]")

// 문자열 -> 숫자 
console.log("parseInt('15') + 5 ->", parseInt(num1) + num2, "(정수로 변환)");
console.log("parseFloat('15.7') + 5 -> ", parseFloat('15.7') + num2, "(소수로 변환)");
console.log("Number('15') + 5 -> ", Number(num1) + num2, "(숫자로 변환)");

// 숫자 -> 문자열
console.log("String(123) ->", String(123), "| typeof:" ,typeof String(123));
console.log("(123).toString() ->", (123).toString(), "| typeof:", typeof (123).toString());
console.log("123 + '' ->", 123 + '', "| typeof:", typeof (123 + ''));
