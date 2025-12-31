console.log("===접근 권한 제어===");

/*
    웹 애플리케이션의 페이지 접근 권한을 체그합니다.
    사용자의 로그인 상태와 권한에 따라 접근을 허용하거나 거부합니다.
*/

// 현재 사용자 정보 
const currentUser = {
    isLoggedIn: true,
    username: "developer2026",
    role: "member",         // "guest", "member", "admin"
    isPremiun: false,
    lastLoginDate: "2025-12-31"
}

console.log("===사용자 정보===");
console.log("로그인 상태:", currentUser.isLoggedIn);
console.log("사용자명:", currentUser.username);
console.log("권한:", currentUser.role);
console.log("프리미엄:", currentUser.isPremiun);
console.log();

/*
    문제 1: 로그인 상태 확인

    로그인이 되어있으면 "환영합니다!" 출력
    로그인이 안 되어있으면 "로그인이 필요합니다." 출력
*/
console.log("===문제 1: 로그인 상태 확인===");

if(currentUser.isLoggedIn) {
    console.log("환영합니다, " + currentUser.username + "님!");
} else {
    console.log("로그인이 필요합니다.");
}

/**
 *  문제 2: 관리자 페이지 접근
 *  
 *  조건 : role이 "admin"이어야 접근 가능    
 * 
 *  관리자인지 확인해서
 *      - 관리자 페이지에 접근합니다.
 *      - 접근 권한이 없습니다.
 */
console.log("===문제 2: 관리자 페이지===");

// === 연산자로 정확한 값 비교
if(currentUser.role === "admin") {
    console.log("관리자 페이지에 접근합니다.");
} else {
    console.log("접근 권한이 없습니다.");
}

/*
    문제 3: 프리미엄 컨텐츠 접근

    조건 : 로그인 && 프리미엄 회원

    프리미엄 큰텐츠 접근 가능 여부 확인
        - "프리미엄 큰텐츠를 시청합니다."
        - "프리미엄 회원만 이용 가능합니다."
*/
console.log("===문제 3: 프리미엄 컨텐츠===");

if(currentUser.isLoggedIn && currentUser.isPremiun) {
    console.log("프리미엄 큰텐츠를 시청합니다.");
} else {
    console.log("프리미엄 회원만 이용 가능합니다.");
}

/*
    문제 4: 글쓰기 권한 확인

    조건 : 로그인 && (member 또는 admin)

    글쓰기 권한 확인
        - "글을 작성할 수 있습니다."
        - "글쓰기 권한이 없습니다."
*/
const canWrite = currentUser.isLoggedIn 
        && (currentUser.role === "member" || currentUser.role === "admin");

if(canWrite) {
    console.log("글을 작성할 수 있습니다.")
} else {
    console.log("글쓰기 권한이 없습니다.")
}       

/**
 * 문제 5 : 삼항 연산자로 간단한 분기 
 * 
 * 로그인 상태에 따라 다른 버튼 텍스트 표시하기 
 * 
 * 로그인 -> "로그아웃",  비로그인 -> "로그인"
 * 
 * 삼항 연산자 (조건 ? 참값 : 거짓값)
 *  - 간단한 if-else를 한줄로 표현!
 * 
 * const 결과 = 조건 ? "true일때" : "false일때";
 * 
 * 복잡한 로직에는 if-else가 더 읽기 좋음 
 */

const buttonText = currentUser.isLoggedIn ? "로그아웃" : "로그인";
console.log("버튼:", buttonText);

const welcomeMesssage = currentUser.isLoggedIn
        ? `안녕하세요, ${currentUser.username}님!`
        : "로그인 해주세요.";
console.log(welcomeMesssage);    

/*
    문제 6: 중첩 조건문
        - 1차: 로그인 확인
        - 2차: 관리자 여부 확인

        - 관리자님 환영합니다!
        - 회원님 환영합니다.
        - 로그인 해주세요.
*/

if(currentUser.isLoggedIn) {
    if(currentUser.role === "admin") {
        console.log("관리자님 환영합니다!");
    } else {
        console.log("회원님 환영합니다.");
    }
} else {
    console.log("로그인 해주세요.");
}
