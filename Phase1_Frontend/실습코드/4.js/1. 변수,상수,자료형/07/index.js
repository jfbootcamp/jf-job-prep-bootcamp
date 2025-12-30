// 불리언(Boolean) - 참/거짓을 나타내는 자료형 

// Boolean 값: true 또는 false (오직 2가지)

let isClicked = false;
let isLoggedIn = true;

console.log("[Boolean] isClicked ->", isClicked, "| typeof:", typeof isClicked);
console.log("[Boolean] isLoggedIn ->", isLoggedIn, "| typeof:", typeof isLoggedIn);

// 조건문에서 Boolean 사용
console.log("\n[조건문 예]");

if(isClicked) {
    console.log("-> isClicked가 true: 클릭 O")
} else {
    console.log("-> isClicked가 false: 클릭 X")
}

// Truthy와 Falsy 값 
console.log("\n[Falsy 값들] - false로 평가되는 값");

// Falsy 값: false로 평가되는 6가지
console.log(`false -> ${Boolean(false)}
0 -> ${Boolean(0)}  
''(빈 문자열) -> ${Boolean('')} 
null -> ${Boolean(null)}
undefined -> ${Boolean(undefined)}
NaN -> ${Boolean(NaN)}
`);

console.log("\n[Truthy 값들] - true로 평가되는 값");
// Truthy 값 : 위 6가지를 제외한 모든 값 
console.log(` 'hello' -> ${Boolean('hello')}
123 -> ${Boolean(123)}
[] (빈 배열) -> ${Boolean([])}   
{} (빈 객체) -> ${Boolean({})}
`)

