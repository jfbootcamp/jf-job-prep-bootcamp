// DOM API - 요소 선택하기 

// 1. ID로 요소 선택하기 
/*
    document.getElementById('아이디명')
        - 가장 빠른 선택 방법
        - ID는 문서에서 유일해야 함
        - 요소가 없으면 null 반환 
        - '#' 기호 붙이지 않음

    getElementByClassName() : 클래스로 여러 요소 선택
    getElementByTagName() : 태그로 여러 요소 선택   

    document.querySelector('선택자')
        - CSS 선택자 문법 사용
        - ID: '#아이디', 클래스: '.클래스', '태그': '태그명'        
        - 복합 선택자 가능 : 'div.class', 'ul > li'

   querySelectorAll() : CSS 선택자로 모든 요소 선택 

*/

let $name = document.getElementById('name'); // HTML에서 id='name'인 요소 선택
let $color = document.getElementById('color');
let $age = document.getElementById('age');

console.log($name);
console.log($color);
console.log($age);

// 2. CSS 선택자로 요소 선택
let $animalInfo = document.querySelector('div.animal-info');
let ageElement = document.querySelector('div#age');

console.log($animalInfo);   // 클래스 선택자로 선택 
console.log(ageElement);    // ID 선택자로 선택 

