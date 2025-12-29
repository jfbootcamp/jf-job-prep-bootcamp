// BigInt - 아주 큰 정수를 다루는 자료형

// BigInt 생성 방법1 : 숫자 뒤에 n 붙이기
let bigNum1 = 9999999999999999n;

// BigInt 생성 방법2 : BigInt() 함수 사용 
let bigNum2 = BigInt("9999999999999999");

console.log("[BigInt] 숫자n 방식 -> ", bigNum1, "| typeof: ", typeof bigNum1);
console.log("[BigInt] BigInt() 방식 -> ", bigNum2, "| typeof: ", typeof bigNum2);

// number vs bigint
let maxSafeInt = Number.MAX_SAFE_INTEGER        // 9007199254740991
let beyondMax = 9007199254740992;               // 정밀도 손실 발생!
let beyondMaxBigInt = 9007199254740992n;        // BigInt는 정확함

console.log("[비교] Number.MAX_SAFE_INTEGER =>", maxSafeInt)
console.log("[비교] Number로 큰 수 표현 ->", beyondMax, "(정밀도 손실 발생!)");
console.log("[비교] BigInt로 큰 수 표현 ->", beyondMaxBigInt, "(정확함!)");