// switch case문 (Switch Statements)

// 1. 기본 switch문
console.log("[1. 기본 switch문]");

let fruit = 'pie';
console.log("fruit =", fruit);

switch(fruit) {
    case 'banana':
        console.log("-> 바나나입니다.");
        break;
    case 'orange':
        console.log("-> 오렌지입니다.");
        break;     
    case 'apple':
        console.log("-> 사과입니다.");
        break;   
    case 'grape':
        console.log("-> 포도입니다.");
        break;      
    default:
        console.log("-> 다른 과일입니다.");                                 
}

// 2. break 생략 시 
console.log("\n[2. break 생략 시]");

let fruit2 = 'orange';
console.log("fruit2 =", fruit2);
console.log("->break를 생략하면 아래 case도 실행됩니다.");

switch(fruit2) {
    case 'banana':
        console.log("-> 바나나입니다.");
    case 'orange':
        console.log("-> 오렌지입니다.");    
    case 'apple':
        console.log("-> 사과입니다.");   
    case 'grape':
        console.log("-> 포도입니다.");     
    default:
        console.log("-> 다른 과일입니다.");                                 
}

// 3. 여러 case 묶기
console.log("\n[3. 여러 case 묶기]");

let day = 'saturday';
console.log("day =", day);

switch(day) {
    case 'monday':
    case 'tuesday':
    case 'wednesday':
    case 'thursday':
    case 'friday':
        console.log("-> 평일입니다.");
        break;
    case 'saturday':
    case 'sunday':
        console.log("-> 주말입니다.");
        break;              
    default:
        console.log("-> 올바른 요일이 아닙니다.");                           
}

// 4. 성적 등급
console.log("\n[4. 성적 등급]");

let score = 85;
let grade = Math.floor(score/10);
console.log("점수 =", score, "->10으로 나눈 몫 =", grade);

switch(grade) {
    case 10:
    case 9:
        console.log("-> 등급: A");
        break;
    case 8:
        console.log("-> 등급: B");
        break;   
    case 7:
        console.log("-> 등급: C");
        break;    
    case 6:
        console.log("-> 등급: D");
        break;  
    default:
        console.log("-> 등급: F");                                 
}