/*
    1. 쇼핑몰 주문 금액 계산
        - 노트북(1,200,000원)을 2대 주문하고, 마우스(35,000원)를 3개 주문했습니다.
          총 주문 금액을 계산해 보세요.
*/

let laptopPrice = 1200000;
let laptopQty = 2;
let mousePrice = 35000;
let mouseQty = 3;

let totalPrice = laptopPrice * laptopQty + mousePrice * mouseQty;
console.log(totalPrice);

/*
    2. 할인 금액 계산
        - 원가 50,000원인 상품에 20% 할인을 적용합니다.
          할인 금액과 최종 가격을 각각 계산해보세요.

        - 10000
        - 40000  
*/
let originalPrice = 50000;
let discountRate = 20;

// 원가 * (할인율/100)
let discountAmount = originalPrice * (discountRate / 100);
let finalPrice = originalPrice - discountAmount;

console.log(discountAmount);
console.log(finalPrice);
