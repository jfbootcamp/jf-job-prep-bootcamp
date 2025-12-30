// 문자열(string) - 텍스트 데이터를 다루는 자료형 

// 문자열 생성 방법 3가지
let str1 = "큰따옴표 문자열";             // 1. 큰따옴표 ""
let str2 = '작은따옴표 문자열';           // 2. 작은따옴표 ''
let str3 = `백틱 문자열`;                // 3. 백띡 `` (템플릿 리터럴)

console.log("[string] 큰따옴표 ->", str1, " | typeof :", typeof str1);
console.log("[string] 작은따옴표 ->", str2, " | typeof :", typeof str2);
console.log("[string] 백틱 ->", str3, " | typeof :", typeof str3);

// 백틱(템플릿 리터럴)의 특별한 기능 
let name = 'leedo';
let age = 29;

// ${변수}
let intro1 = `안녕하세요, ${name}입니다. 나이는 ${age}살입니다.`
console.log("[템플릿 리터럴] 변수 삽입 ->", intro1);

// 표현식 사용 가능
let calc = `10 + 20 =  ${10 + 20}`;
console.log("[템플릿 리터럴] 표현식 ->", calc);

// 여러 줄 문자열
let multiline = `첫 번째 줄
두 번째 줄
세 번째 줄`;
console.log("[템플릿 리터럴] 여러 줄 ->\n", multiline);