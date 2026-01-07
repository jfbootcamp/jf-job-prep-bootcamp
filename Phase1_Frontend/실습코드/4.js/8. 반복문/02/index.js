/**
 *  1. Object.keys() - 키 배열
 *                  객체의 모든 키를 배열로 반환 
 *                  person[nowkey]로 해당 키의 값에 접근 
 * 
 */
console.log("\n[1. Object.keys() - 키 배열]")
const person = {
    name: "이순신",
    age: 25,
    height: 180
}

const keys = Object.keys(person);   // 객체의 모든 키를 배열로 반환 ["name", "age", "height"]
console.log("->",keys);             // 키 배열 출력 

for(let i = 0; i < keys.length; i++) {  // 키 배열의 길이만큼 반복
    let nowkey = keys[i];
    console.log(`-> key: ${nowkey}, value: ${person[nowkey]}`);     //키와 해당 키의 값 출력 
}

/*
    2. Object.values() - 값 배열
        - 객체의 모든 값을 배열로 반환
        - 키가 필요 없고 값만 필요할 때 사용 
*/
console.log("\n[2. Object.values() - 값 배열]")
const values = Object.values(person);       // 객체의 모든 값을 배열로 반환 ["이순신", 25, 180]
console.log("-> ",values);

for(let i = 0; i < values.length; i++) {    // 값 배열의 길이만큼 반복
    console.log(`-> value: ${values[i]}`)   // 현재 인덱스의 값 출력 
}

/*
    3. Object.entries() - [키, 값] 쌍 배열 
        - Object.entries()는 [키, 값] 쌍을 배열로 반환 
        - entries[i][0]: 키, entries[i][1]: 값
*/
console.log("\n[3. Object.entries() - [키, 값] 쌍 배열]")
const entries = Object.entries(person);     // [키, 값] 쌍의 2차원 배열 반환 
console.log("->", entries);

for(let i = 0; i < entries.length; i++) {       // entries 배열의 길이만큼 반복
    console.log(`-> key : ${entries[i][0]}, value : ${entries[i][1]}`); // [0]: 키, [1]: 값
}

/**
 *  4. 구조 분해와 함께 사용
 *      - [key, value]로 구조 분해하면 더 깔끔하게 접근 가능
 *      - entries[i][0], entries[i][1] 대신 key, value 사용
 */
console.log("\n[4. 구조 분해와 함께 사용]")
for(const [key, value] of Object.entries(person)) { // entries()를 구조 분해하여 key, value로 바로 접근
    console.log(`-> ${key}: ${value}`);         // 배열 인덱스 없이 깔끔하게 출력 
}

// 5.실용적인 예 
const product = {           // 상품 정보를 담는 객체
    name: '노트북',
    price: 1500000,
    brand: 'Samsung',
    inStock: true
}

console.log("-".repeat(40));

for(const[key, value] of Object.entries(product)) {  // product 객체를 [키, 값] 쌍으로 순회
    console.log(`-> ${key.padEnd(10)}: ${value}`);   // padEnd(10)로 키를 10자리로 맞춰 정렬 
}

console.log("-".repeat(40));