/*
    Lab 01: for문과 while문의 기본 구조 익히기
        - 횟수가 정해지면 for문, 조건 기반이면 while문 이용(무한루프 주의:증감식 빠드리지 않기)
        - 증감 패턴
            - i++ => 1씩 증가 
            - i-- => 1씩 감소
            - i += 2 => 2씩 증가 (2,4,6,8,10)
            - i *= 2 => 2배씩 증가 (1,2,4,8,16)
        - 누적 합계 패턴
            - let sum = 0;
              for() {
                sum += i;
              }              
*/

/*
    문제 1: 짝수만 출력 (2,4,6,8,10)
*/
console.log("\n=== 문제 1: 짝수만 출력 ===");

// i += 2로 2씩 증가
for(let i = 2; i <= 10; i += 2) {
    console.log(i);
}

console.log("\n");

for(let i = 1; i <= 10; i++) {
    if(i % 2 === 0) console.log(i);
}

/*
    문제 2: while문으로 카운트다운

    counter > 0 이 참인 동안 반복 
    매 반복마다 count--로 감소
    counter가 0이 되면 반복 종료
*/
console.log("\n=== 문제 2: while문으로 카운트다운 ===");

let counter = 10;
while(counter > 0) {
    console.log(counter);
    counter--;      // counter = counter - 1;
}
console.log("발사!");

/*
    문제 3: 1부터 N까지의 합
*/
console.log("\n=== 문제 3: 1부터 10까지의 합 ===");

const n = 50;
let sum = 0;        // 누적 변수 초기화

// 누적 합계 패턴
for(let i = 1; i <= n; i++) {
    sum += i;       // sum = sum + i
}

console.log(`1부터 ${n}까지의 합: ${sum}`);

/*
    구구단 한 줄 출력
*/
console.log("\n=== 구구단 한 줄 출력 ===");

const dan = 5;
let result = "";

// 문자열 누적 패턴 
for(let i = 1; i <= 9; i++) {
    result += `${dan} x ${i} = ${dan * i}`;
    if(i < 9) result += ", ";
}

console.log(result);

console.log("\n");

const userDan = 5;

console.log(`\n=== ${userDan}단 ===`);
for(let i = 1; i <= 9; i++) {
    console.log(`${userDan} x ${i} = ${userDan * i}`);
}