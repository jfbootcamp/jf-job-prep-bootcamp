// 숫자형(Number) - 특수 숫자값: Infinity, NaN

// 1. Infinity (무한대)
let inf1 = Infinity;
let inf2 = 100 / 0;     // 0으로 나누면 Infinity

console.log("[Infinity] Infinity 직접 할당 -> ", inf1, "| typeof: ", typeof inf1);
console.log("[Infinity]  -> 100 / 0 계산 결과 -> ", inf2, "| typeof: ", typeof inf2);

// 2. NaN (Not a Number)
let nan1 = NaN;
let nan2 = 'javascript' / 10;   //문자열을 숫자로 나누면 NaN

console.log("[NaN] NaN 직접 할당 -> ", nan1, "| typeof: ", typeof nan1);
console.log("[NaN] 'javascript' / 10 계산 결과 -> ", nan2, "| typeof: ", typeof nan2);


/**
 *  왜  100 / 0 = Infinity ?
 *      - 에러로 프로그램을 멈추지 않고 계속 실행되도록 설계 
 * 
 */

