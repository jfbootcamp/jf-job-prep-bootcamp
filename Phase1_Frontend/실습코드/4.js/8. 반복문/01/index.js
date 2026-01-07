// 1. 반복문 (Loop) - for, while
// 카운팅, 배열 순회

// 2. 기본 for문 
/*
    for문 구조: for(초기식; 조건식; 증감식)
*/
for(let i = 1; i < 6; i++) {        // i=1부터 시작, i < 6일 때 까지, 매반복 후 i가 1 증가
    console.log("=>",i);            // 1, 2, 3, 4, 5 순서로 출력 
}

// 3. 역순 for문 (i--)
console.log("\n [3. 역순 for문 (i--)]");
for(let i = 5; i > 0; i--) {
    console.log("=>",i); 
}

// 4. while문 
/*
    while문 구조: while(조건식)
        - 조건이 참인 동안 반복 
        - 반드시 종료 조건(i++)이 있어서 무한루프 방지
*/
console.log("\n [4. while문]");
let j = 1;
while(j < 6) {
    console.log("=>",j); 
    j++;        // j 증가 (없으면 무한루프!)
}

// 5. for문으로 배열 순회 
/*
    배열 인덱스는 0부터 시작
    arr.length를 조건으로 사용 
*/
console.log("\n 5. for문으로 배열 순회");
let arr = [1, 2, 3, 4, 5];
console.log("arr =", arr);
for(let j = 0; j < arr.length; j++) {   // 인덱스 0부터 배열 길이-1까지 반복
    console.log(`-> arr[${j}] = `, arr[j]); // 인덱스와 해당 값 출력
}

// 6. for...of문 (ES6)
// for...of: 배열의 값을 직접 순회, 인덱스가 필요없을 때 간편하게 사용
console.log("\n [6. for...of문 (ES6)]");

const fruits = ['사과', '바나나', '오렌지'];
for(const fruit of fruits) {        // 배열의 각 요소를 fruit 변수에 할당하며 순회 
    console.log("=>", fruit);       // 인덱스 없이 값만 직접 접근 
}

// 7. for...in문 (객체 순회)
// for...in: 객체의 키(속성명)를 순회
// person[key]로 값에 접근 
console.log("\n [7. for...in문 (객체 순회)]");

const person = { name: '이순신', age: '25', job: 'Developer'};
for(const key in person) {          // 객체의 각 속성명(키)을 key 변수에 할당하며 순회
    console.log(`-> ${key}:`, person[key]);     // 키와 해당 값을 출력 
}

// 8. break와 continue
console.log("\n [8. break와 continue]");

for(let k = 1; k <= 5; k++) {       // 1부터 5까지 반복 예정
    if (k === 3) break;             // k가 3이면 반복문 즉시 탈출
    console.log("->", k);           // 1, 2만 출력 (3에서 종료)
}
console.log("");

for(let k = 1; k <= 5; k++) {           // 1부터 5까지 반복 예정
    if (k === 3) continue;             // k가 3이면 아래 코드 건너뛰고 다음 반복으로
    console.log("->", k);               // 1, 2, 4, 5 출력 (3만 건너뜀)
}

/*
    반복문 비교 

        종류        용도
      ----------------------------
        for       횟수가 정해진 반복
        while     조건 기반 반복 
        for...of   배열 값 순회 (ES6)
        for...in   객체 키 순회    
*/