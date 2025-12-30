console.log("===할인가 계산기 ===\n");

// 상품 정보 
const product = {
    name: "나이키 에어맥스",
    originalPrice: 159000,      // 정가 (원)
    discountRate: 20,           // 할인율 (%)
    couponDiscount: 5000        // 쿠폰 할인 (원)
}

console.log("===상품 정보===");
console.log("상품명 :", product.name);
console.log("정가 :", product.originalPrice.toLocaleString() + "원");
console.log("할인율 :", product.discountRate + "%");
console.log("쿠폰 :", product.couponDiscount.toLocaleString() + "원");

//문제 1: 할인 금액 계산
console.log("===문제 1: 할인 금액===");

// 할인 금액: 31,800원
// 정가 * (할인율/100) = 할인 금액
const discountAmount = product.originalPrice * (product.discountRate / 100);
console.log("할인 금액:", discountAmount.toLocaleString() + "원");

//문제 2: 할인 적용 가격 
console.log("===문제 2: 최종 가격===");
// 최종 가격: 122,200원

// 정가 - 할인금액 - 쿠폰할인 = 최종가격
const finalPrice = product.originalPrice - discountAmount - product.couponDiscount;
console.log("최종 가격:", finalPrice.toLocaleString() + "원");

//문제 3: 실제 할인율 계산
console.log("===문제 3: 실제 할인율===");
// ((정가 - 최종가) / 정가) * 100 
const totalDiscount = product.originalPrice - finalPrice;
const actualDiscountRate = (totalDiscount / product.originalPrice) * 100;

console.log("총 할인금액:", totalDiscount.toLocaleString() + "원");
console.log("실제 할인율:", actualDiscountRate.toFixed(1) + "%");

// toFixed(1)

// 총 할인금액: 36,800원
// 실제 할인율: 23.1%

