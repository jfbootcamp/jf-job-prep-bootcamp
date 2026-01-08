// 전역(Global) 스코프, 지역(Local) 스코프 

let globalNum = 100;            // 전역 변수 : 어디서든 접근 가능

function testFunc() {
    let innerNum = 50;      // 지역 변수: testFunc() 내부에서만 접근 가능
    console.log("[지역 스코프] testFunc()에서 전역 변수 globalNum 접근 ->",globalNum);
    console.log("[지역 스코프] testFunc()에서 지역 변수 innerNum 접근 ->",innerNum);
}

testFunc();

console.log("[전역 스코프] globalNum ->",globalNum);
console.log("[전역 스코프] innerNum 접근 시도 ->",innerNum); //ReferenceError
// 함수 내부에서는 접근 가능하지만, 전역에서 접근하면 에러 발생 
