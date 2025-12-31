console.log("===나이 계산기===");

//사용자 정보
const user = {
    name: "이개발",
    birthYear: 2000,
    birthMonth: 6,
    birthDay: 15
}

// 현재 날짜 (실제로는 new Date() 사용)
const today = {
    year: 2025,
    month: 12,
    day: 31
}

console.log("===사용자 정보===");
console.log("이름: ", user.name);
console.log("생년월일:", `${user.birthYear}년 ${user.birthMonth}월 ${user.birthDay}일`);
console.log("오늘:", `${today.year}년 ${today.month}월 ${today.day}일`);
console.log();

/**
 * 문제 1: 만 나이 계산
 *       1) 기본 나이 = 현재년도 - 출생년도 
 *          생일이 안 지났으면 -1  
 * 
 *       2) 힌트
 *          - 생일 지났는지 판단하는 여부 
 *              - 예) 조건1) 오늘 12월, 생일 6월 ---> 12 > 6 = true
 *                    조건2) 같은 월이고 오늘날짜 >= 생일
 *                           오늘 6월 20일, 생일 6월 15일
 *                                6 === 6 (true)  &&  20 >= 15  (true) 
 */
console.log("===문제 1: 만 나이 계산===");

// 기본 나이 계산
const basicAge = today.year - user.birthYear;

// 생일 지남 여부 
const hasBirthDayPassed = 
    today.month > user.birthMonth || 
    (today.month === user.birthMonth && today.day >= user.birthDay);

// 만 나이 = 기본 나이 - (생일 안 지났으면 1)
const actualAge =  hasBirthDayPassed ? basicAge : basicAge - 1;

console.log("기본 나이:", basicAge);
console.log("생일 지남:", hasBirthDayPassed);
console.log("만 나이:", actualAge);

// 문제 2: 서비스 이용 자격 판별
console.log("\n===문제 2: 서비스 자격===");

// 각 서비스별 이용 가능 나이
const ageRequirements = {
    voting: 18,             // 투표권
    drinking: 19,           // 음주
    driving: 18,            // 운전면허
    movie19: 19,            // 19세 영화
    seniorDiscount: 65      // 경로 우대
}

// >= 연산자로 각 자격 판별 
const canVote = actualAge >= ageRequirements.voting;
const canDrink = actualAge >= ageRequirements.drinking;
const canDrive = actualAge >= ageRequirements.driving;
const canWatchMovie19 = actualAge >= ageRequirements.movie19;
const getSeniorDiscount = actualAge >= ageRequirements.seniorDiscount;

console.log("투표 가능: ", canVote);
console.log("음주 가능: ", canDrink);
console.log("운전 가능: ", canDrive);
console.log("19세 영화: ", canWatchMovie19);
console.log("경로 우대: ", getSeniorDiscount);

/*
    문제 3 : 청소년/성인/시니어 구분 
        - 청소년 : 14세 이상 19세 미만
          성인 : 19세 이상 65세 미만
          시니어 : 65세 이상 
*/
console.log("\n=== 문제 3 : 연령대 구분===");

// && 연산자로 범위 지정
const isTeenager = actualAge >= 14 && actualAge < 19;
const isAdult = actualAge >= 19 && actualAge < 65;
const isSenior = actualAge >= 65;

console.log("청소년 (14~18):", isTeenager);
console.log("성인 (19~64):", isAdult);
console.log("시니어 (65+):", isSenior);

// 연령대 문자열 생성
let ageGroup = "어린이";
if(isTeenager) ageGroup = "청소년";
else if(isAdult) ageGroup = "성인";
else if(isSenior) ageGroup = "시니어";
console.log("연령대:", ageGroup);