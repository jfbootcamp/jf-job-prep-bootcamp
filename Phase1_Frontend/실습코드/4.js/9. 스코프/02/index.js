// 중첩 함수 (Nested Function)에서의 스코프 체인 

let global = '나는 전역 변수입니다.';           // 전역 스코프 

function outerFunction() {
    let outer = '나는 외부 함수의 변수입니다.';     // outerFunction 스코프 

    function innerFunction() {
        let inner = '나는 내부 함수의 변수입니다.'; // innerFunction 스코프
        console.log("[innerFunction 스코프] 전역 변수 global 접근 ->", global);
        console.log("[innerFunction 스코프] 외부 함수 변수 outer 접근 ->",outer);
        console.log("[innerFunction 스코프] 내부 함수 변수 inner 접근 ->", inner);
    }

    innerFunction();
    console.log("[outerFunction 스코프] 전역 변수 global 접근 ->", global);
    console.log("[outerFunction 스코프] 외부 함수 변수 outer 접근 ->",outer);
    console.log("[outerFunction 스코프] 내부 함수 변수 inner 접근 ->",inner);  // 접근 불가 
}

outerFunction();
