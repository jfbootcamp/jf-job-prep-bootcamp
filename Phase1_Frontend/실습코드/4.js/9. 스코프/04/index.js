// 함수 스코프 (Function Scope) - var 키워드 

function print() {
    for(var i = 0; i < 10; i++) {
        console.log("[for 블록 내부] i -> ", i);
    }
    console.log("[for 블록 외부] i 접근 -> ", i); // var는 함수 스코프이므로 블록 외부에서도 접근 가능!
}

print();