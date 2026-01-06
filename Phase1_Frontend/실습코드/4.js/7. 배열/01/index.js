// 배열 

console.log(`배열(Array): 여러 값을 순서대로 저장하는 자료구조
    -> 인덱스(index)로 각 요소에 접근 (0부터 시작)`)

// 생성자 함수로 빈 배열 생성
let arr = new Array();      // 생성자 함수로 빈 배열 생성 (결과: [])  
console.log("arr =", arr);  

// new Array()에 값 전달하기 
let arr1 = new Array(1, 2, 3);      // 여러 값 전달 ==> 요소로 저장 [1, 2, 3]
console.log("arr1 =", arr1);

let arr2 = new Array(3);            // 숫자 하나만 전달 => 길이가 3인 빈 배열 생성
console.log("arr2 =", arr2);

// 배열 리터럴로 생성 (권장)
let arr3 = [1, 2, 3];               
console.log("arr3 =", arr3);

let arr4 = [3];                     // [3]은 요소가 3 하나인 배열 
console.log("arr4 =", arr4);

// 다양한 타입의 요소 
let mixed = [1, 'hello', true, null, { name: '이순신' }, [1, 2, 3]];
console.log("mixed =", mixed);
console.log(`배열에는 숫자, 문자열, 불리언, null, 객체, 배열 등
            다양한 타입을 함께 저장할 수 있습니다.`);

// 배열 요소 접근
let fruits = ['사과', '바나나', '오렌지'];    
console.log("fruits[0] = ", fruits[0], "(첫 번째 요소)");      
console.log("fruits[1] = ", fruits[1], "(두 번째 요소)");      
console.log("fruits[2] = ", fruits[2], "(세 번째 요소)");  
console.log("fruits[3] = ", fruits[3], "(네 번째 요소)"); 
console.log("fruits =", fruits);   