console.log("===쇼핑몰 시스템 시뮬레이션===");

/*
    1. 회원 등급별 할인 계산
        1) 스코프 포인트 : const로 전역 상수 정의
            - 여러 함수에서 공통으로 사용하는 값은 전역 상수로 관리
            - 실수로 값을 변경하는 것을 방지 
*/
console.log("===1. 회원 등급별 할인===");

const DISCOUNT_RATES = {        // 전역 상수 : 어디서든 접근 가능, 재할당 불가
    BRONZE: 0.03,               // 브론즈 3%
    SILVER: 0.05,               // 실버 5%
    GOLD: 0.1,                  // 골드 10%
    VIP: 0.15                   // VIP 15%
}

function calculateDiscount(price, memberGrade) {
    // 지역 변수 : 함수 내부에서만 유효
    // 함수가 끝나면 메모리에서 사라짐
    // 다른 함수의 변수와 이름이 같아도 충돌 없음
    let discountRate = 0;       // 지역 변수: 이 함수 내에서만 존재
    let discountAmount = 0;     // 지역 변수: 외부에서 접근 불가

    // 전역 상수 DISCOUNT_RATES에 접근 (스코프 체인)
    // -> 현재 스코프에 없으면 상위(전역) 스코프에서 탐색
    if(memberGrade === "BRONZE") {
        discountRate = DISCOUNT_RATES.BRONZE;
    } else if(memberGrade === "SILVER") {
        discountRate = DISCOUNT_RATES.SILVER;
    } else if(memberGrade === "GOLD") {
        discountRate = DISCOUNT_RATES.GOLD;
    } else if(memberGrade === "VIP") {
        discountRate = DISCOUNT_RATES.VIP;
    }

    discountAmount = price * discountRate;
    let finalPrice = price - discountAmount;

    // 객체로 변환 : 지역 변수 값을 외부에서 사용 가능하게 함 
    return { discountRate, discountAmount, finalPrice };

}

// 테스트 
const order1 = calculateDiscount(100000, "GOLD");
console.log("[골드 회원] 10만원 상품 구매");
console.log(` 할인율: ${order1.discountRate * 100}%`);
console.log(` 할인액: ${order1.discountAmount.toLocaleString()}원`);
console.log(` 결재액: ${order1.finalPrice.toLocaleString()}원\n`);

/*
    2. 장바구니 총액 계산
        - 스코프 포인트 : 함수 내부의 지역 상수
        - 이 함수에서만 사용하는 상수는 함수 내부에 선언
        - 전역 스코프를 깔끔하게 유지 
*/
console.log("===2. 장바구니 총액 계산===");

const cart = [                                  // 전역 상수: 장바구니 데이터 
    {name: "맥북 프로", price: 2500000, quantity: 1},
    {name: "에어팟", price: 200000, quantity: 2},
    {name: "애플워치", price: 500000, quantity: 1}
]

function calculateCartTotal(cartItems) {
    let subtotal = 0;               // 지역 변수: 상품 합계 누적용
    let itemCount = 0;              // 지역 변수: 수량 누적용

    const FREE_SHIPPING = 50000;    // 지역 상수: 무료배송 기준
    const SHIPPING_FEE = 3000;      // 지역 상수: 배송비 

    // for문의 블록 스코프 
    for(let i = 0; i < cartItems.length; i++) {
        // 블록 스코프 변수: 각 반복에서만 유효
        let item = cartItems[i];                    // 이 반복에서만 존재
        let itemTotal = item.price * item.quantity; // 이 반복에서만 존재  
        
        subtotal += itemTotal;          // 외부 지역 변수 수정 가능 
        itemCount += item.quantity;     // 외부 지역 변수 수정 가능

        console.log(`${item.name}: ${item.price.toLocaleString()}원 x ${item.quantity}개 = ${itemTotal.toLocaleString()}원`);
    }
    // (블록 스코프 종료) item, itemTotal은 접근 불가

    let shipping = subtotal >= FREE_SHIPPING ? 0 : SHIPPING_FEE;
    let total = subtotal + shipping;
    
    return { subtotal, shipping, total, itemCount }
}

console.log("[장바구니 내역]");
const cartResult = calculateCartTotal(cart);        // 함수 반환값을 전역 상수에 저장
console.log("-".repeat(40));
console.log(` 상품 합계: ${cartResult.subtotal.toLocaleString()}원`);
console.log(` 배송비: ${cartResult.shipping.toLocaleString()}원 ${cartResult.shipping === 0 ? "(무료)" : ""}`);
console.log(` 총 결재액: ${cartResult.total.toLocaleString()}원`);
console.log(` 총 ${cartResult.itemCount}개 상품\n`);

/*
    1. const로 전역 상수 정의
        - 여러 함수에서 공통으로 사용하는 값
    2. 함수 내부 const로 지역 상수 정의
        - 해당 함수에서만 사용하는 값
    3. let으로 지역 변수 선언
        - 함수 밖에 영향 없음
        - 각 함수 호출마다 새로운 변수 생성
    4. for/if 블록 내 let 변수
        - 블록 내에서만 유효
        - 반복마다 독립적인 변수 생성
    5. 객체로 여러 값 반환
        - return { a, b, c };
        - 지역 변수 값을 외부에서 사용 가능                     
*/
