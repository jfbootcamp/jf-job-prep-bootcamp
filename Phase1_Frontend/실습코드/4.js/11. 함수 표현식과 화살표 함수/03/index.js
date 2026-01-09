console.log("===학생 성적 관리 시스템===\n")

//함수 선언문
function greetStudent1(name) {
    return "안녕하세요, " +name+ " 학생!";
}

//함수 표현식  - 함수를 변수에 할당하는 방식 
const greetStudent2 = function(name) {
    return "안녕하세요, " +name+ " 학생!";
};

//테스트 실행
console.log(greetStudent1("이순신"));       // 함수 선언문으로 호출 
console.log(greetStudent2("신사임당"));     // 함수 표현식 호출


/*
    학생 데이터와 배열 메서드 
*/
console.log("=== 1. 학생 데이터와 배열 메서드 ===");

// 객체들의 배열 [ {}, {}, {}, ...]
const students = [
    { id:1, name: "이순신", score: 85, grape: "B"},         //학생 1번
    { id:2, name: "김출수", score: 92, grape: "A"},         //학생 2번
    { id:3, name: "이영희", score: 78, grape: "C"},         //학생 3번
    { id:4, name: "박민수", score: 95, grape: "A"},         //학생 4번
    { id:5, name: "정수진", score: 88, grape: "B"},         //학생 5번
];

console.log(students);      // 전체 배열 출력

// 1. 학생 이름만 추출하기
const names = students.map(student => student.name);
console.log("[이름만 추출]");
console.log(" 결과:", names);

// 2. 점수에 보너스 5점 가산하시오 
// 결과 : [90, 97, 83, 100, 93]

const bonusScores = students.map(student => student.score + 5);
console.log("\n[점수 + 5 가산]");
console.log(" 결과:", bonusScores);

// 3. 새로운 형태의 객체로 변환 
const simpleList = students.map(student => ({
    이름: student.name,     // name 속성을 "이름"으로
    점수: student.score     // score 속성을 "점수"으로 
}));
// 이 소괄호가 없으면 { }가 함수 본문으로 해석되어 undefined 반환!
console.log("\n[새로운 형태의 객체로 변환]");
console.log(" 결과:", simpleList);

/*
    filter 
        - 조건에 맞는 요소만 추출 
        - 조건을 만족하는 요소만 새 배열로 생성
        - 원본 배열 변경되지 않음 (불변성)
*/
// 90점 이상 학생만 추출하시오
const topStudents = students.filter(student => student.score >= 90);
console.log("\n[90점 이상 학생]");
console.log(" 결과:", topStudents);
// [김출수, 박민수]
console.log(" 결과:", topStudents.map(s => s.name));    // 이름만 출력

// A등급 학생만 추출하시오 
// [김출수, 박민수]
const grapeA = students.filter(student => student.grape === 'A');
console.log("\n[A등급 학생]");
console.log(" 결과:", grapeA.map(s => s.name));

// 복합 조건 (80점 이상 and 90점 미만)
const midRange = students.filter(student => 
    student.score >=80 && student.score < 90 
)
console.log("\n[80~89점 학생]");
console.log(" 결과:", midRange.map(s => `${s.name}(${s.score}점)`));

// 성적 처리 
/*
    핵심 포인트 : 화살표 함수로 유틸리티 함수 작성 
                - 재사용 가능한 함수들을 만들어 활용 
                - 단일 책임 원칙 : 한 함수는 한 가지 일만 함                     
*/
console.log("=== 실무 패턴 - 유틸리티 함수 ===\n");
// 유틸리티 함수1:  점수를 등급으로 변환
const getGrade = score => {
    if(score >= 90) return "A";
    if(score >= 80) return "B";
    if(score >= 70) return "C";
    if(score >= 60) return "D";
    return "F";
}

// 유틸리티 함수2: 합격 여부 판단
const isPassed = score => score >= 60;

// 유틸리티 함수3: 점수 포맷팅
const formatScore = score => `${score}점`;

// 유틸리티 함수 테스트 
console.log("[유틸리티 함수 테스트]");
console.log("getGrade(85):", getGrade(85));    
console.log("isPassed(55):", isPassed(55));  
console.log("formatScore(92):", formatScore(92));  

// 유틸리티 함수들을 조합해서 성적표 생성
const report = students.map(s => ({     // 각 학생을 새 형태로 변환 
    이름: s.name,
    점수: formatScore(s.score),
    등급: getGrade(s.score),
    합격여부: isPassed(s.score) ? "합격" : "불합격"
}));

console.log("\n[성적표]");
report.forEach(r => {
    console.log(`  ${r.이름}: ${r.점수} (${r.등급}) - ${r.합격여부}`);
});