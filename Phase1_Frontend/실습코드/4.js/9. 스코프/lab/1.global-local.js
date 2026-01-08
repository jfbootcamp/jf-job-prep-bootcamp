//1. 전역 변수 접근 
console.log("=== 1. 전역 변수 접근 ===");

/*
    전역 변수는 프로그램 어디서든 접근 가능
    함수 내부에서도 전역 변수를 읽을 수 있음 
*/

let appName = "My App";         // 전역 변수

function showAppName() {
    console.log("앱 이름:", appName);       //전역 변수 접근 가능
}

showAppName();

// 2. 지역 변수 접근 
/*
    지역 변수는 선언된 함수 내부에서만 접근 가능
    함수 외부에서 접근하면 ReferenceError 발생
*/
console.log("=== 2. 지역 변수 접근 ===");

function createUser() {
    let userName = "이순신";             //지역 변수
    console.log("함수 내부에서:", userName);
}
//console.log("함수 외부에서:", userName);

createUser();

// 3. 같은 이름, 다른 스코프 
/**
 *  지역 변수가 전역 변수를 가림 (shadowing)
 *  함수 내부에서는 지역 변수가 우선
 *  전역 변수는 영향받지 않음 
 */
console.log("=== 3. 같은 이름, 다른 스코프 ===");

let count = 100;            // 전역 변수

function updateCount() {
    let count = 50;         // 지역 변수 (같은 이름)
    console.log("함수 내부에서:", count);       // 50 (지역 변수)
}
console.log("호출 전 전역 count: ", count);     // 100
updateCount();
console.log("호출 후 전역 count: ", count);     // 100

// 4. 전역 변수 수정하기 
/**
 * 함수 내부에서 let/const 없이 변수에 접근하면 전역 변수 참조 
 * 전역 변수를 직접 수정 가능 
 * 하지만 이 방식은 권장하지 않음 (부작용 발생 가능)
 */
console.log("=== 4. 전역 변수 수정하기 ===");

let score = 0;          // 전역 변수 

function addScore() {
    score += 10;        // 전역 변수 수정 
}

console.log("초기 점수:", score);       // 0
addScore();
console.log("증가 후 점수:", score);       // 10
addScore();
console.log("한번 더 증가 후 점수:", score);  // 20

// 5. 지역 변수로 계산하고 반환하기 
/**
 * 지역 변수는 함수 실행이 끝나면 사라짐
 * return으로 값을 반환하면 외부에서 사용 가능
 * 매번 새로운 result가 생성되고 사라짐 
 */
console.log("=== 5. 지역 변수로 계산하고 반환하기 ===");

function calculateSum(a, b) {
    let result = a + b;         // 지역 변수
    return result;
}

const sum1 = calculateSum(10, 20);
console.log("10 + 20 = ", sum1);

const sum2 = calculateSum(100, 200);
console.log("100 + 200 = ", sum2);

// 6. 전역 변수 최소화 
/**
 * 전역 변수 대신 함수의 지역 변수 사용
 * 필요한 값은 객체로 반환
 * 전역 네임스페이스를 깨끗하게 유지 
 */
console.log("=== 6. 전역 변수 최소화 ===");

function calculatePrice(price, taxRate = 0.1) {  //가격과 세율을 매개변수 전달
    let tax = price * taxRate;      //세금 계산 (지역변수)
    let total = price + tax;        // 총액 계산 (지역변수)
    return { price, tax, total };   // 객체로 반환 (단축 속성명 사용)
}

const result = calculatePrice(10000);
console.log("가격 :", result.price);
console.log("세금 :", result.tax);
console.log("총액 :", result.total);