// 블록 스코프 - let 키워드
function print() {
    for(let i = 0; i < 10; i++) {
        console.log("[for 블록 내부] i -> ", i);
    }
    console.log("[for 블록 외부] i 접근 시도 ->", i); //ReferenceError: let으로 선언된 변수는 블록 {} 내부에서만 유효 
}

print();