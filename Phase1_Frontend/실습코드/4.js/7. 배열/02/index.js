// 배열 (Array) - 요소 접근과 추가/수정

let arr = [         // 배열에 다양한 타입의 요소 저장
    { name: '이순신'}, //객체
    1,                //숫자
    'array',          //문자열
    function () {       //함수
        console.log('hello World!');
    },
    null,
    undefined  
]

console.log("arr = ", arr);

// 인덱스로 요소 접근
let array = [1, 'hello', null];
console.log("array[0] = ", array[0]);
console.log("array[1] = ", array[1]);
console.log("array[2] = ", array[2]);
console.log("array[3] = ", array[3]);

// push() - 맨 뒤에 요소 추가
let fruits = ['apple', 'orange', 'peach'];      //초기 배열: 3개 요소
console.log("초기 fruits =", [...fruits]);

fruits.push('grape');
console.log("추가후 fruits =", fruits);

// unshift() - 맨 앞에 요소 추가 
let fruits2 = ['apple', 'orange', 'peach'];
console.log("초기 fruits2 =", [...fruits2]);

fruits2.unshift('grape');
console.log("추가후 fruits2 =", fruits2);

// 인덱스로 요소 수정
let animal = ['cat', 'dog', 'hamster'];
console.log("초기 animal =", [...animal]);

animal[1] = 'rabbit';     // 인덱스 1의 'dog'를  'rabbit'으로 수정 
console.log("animal[1] = ", animal[1]);
console.log("수정후 animal =", [...animal]);

animal[2] = 'parrot';     // 인덱스 2의 'hamster'를 'parrot'으로 수정 
console.log("animal[2] = ", animal[2]);
console.log("수정후 animal =", [...animal]);