// null과 undefined - "값이 없음"을 나타내는 두 가지 방법 

/*
    null - 의도적으로 "값이 없음"을 표현 
           존재하지 않는 값, 알 수 없는 값
           개발자가 명시적으로 "비어있음"을 할당 
*/
let user = null;        // 사용자 정보가 아직 없음(의도적)

console.log("[null] user ->", user);
console.log("[null] user === null  ->", user === null);
console.log("[null] typeof null ->", typeof null, "<-- 주의: 'object'로 나옴(JS 버그!)");

/*
    undefined - 값이 할당되지 않은 상태 
                변수가 선언했지만 값은 할당되지 않음
                자동으로 undefined가 됨 
*/

let num;        // 값을 할당하지 않음 

console.log("\n [undefined] num ->", num);
console.log("\n [undefined] typeof num ->", typeof num);

// 명시적으로 undefined 할당 (권장하지 않음)
let value = undefined;
console.log("[undefined] value ->", value, "<-- undefined 직접 할당 (비권장)");

// null vs undefined 비교
console.log("\n[비교] null == undefined ->", null == undefined, "(느슨한 비교: 같음)");
console.log("\n[비교] null === undefined ->", null === undefined, "(엄격한 비교: 다름)");