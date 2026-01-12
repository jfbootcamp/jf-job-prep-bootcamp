console.log('%c 1. 콜백(Callback) 기초 & API 시뮬레이션',
    'background: #00d9ff; color: #000; font-size: 16px; font-weight: bold; padding: 5px;'
)

// 1. 동기(Synchronous) vs 비동기(Asynchronous)
console.groupCollapsed('📘[1] 동기 vs 비동기 - 기본 개념');      // 그룹 시작 - 콘솔에서 접고 펼 수 있음

console.log(`
    동기(Synchronous): 코드가 위에서 아래로 순서대로 실행
    비동기(Asynchronous): 작업을 예약하고 다음 코드로 바로 넘어감
        - 서버에 데이터 요청 시 응답까지 기다리면 화면이 멈춤!
            -> setTimeout으로 서버 응답 대기를 시뮬레이션 
    `)

console.groupEnd();                                  // 그룹 종료 - 반드시 group()과 짝을 이뤄야 함 

// 2. 서버 요청 시뮬레이션 
console.groupCollapsed('📘[2] 코드 보기 (클릭해서 펼치기)');   // 접힌 상태로 그룹 시작
console.groupEnd(); 

/*
    Mock API 함수 정의
     - 실제 서버에 HTTP 요청을 보내지 않고, setTimeout으로 네트워크 지연을 시뮬레이션
     - 하드코딩된 데이터를 반환하여 서버 응답을 흉내냄 
     - 목적: 비동기 처리 개념을 이해하기 위함 
*/
function fetchUser(userId, callback) {
    setTimeout(() => {
        const user = {
            id: userId,
            name: '이개발',                 // 고정된 mock 데이터
            email: 'dev.lee@example.com',
            role: 'Backend Developer'
        };
        callback(user);
    }, 1000);                              // 네트워크 지연을 흉내내는 setTimeout
}

// 3초 후에 실행
// setTimeout(() => {
//     console.group('[3] Mock API 호출 - 실행 결과')  // 펼쳐진 상태로 그룹 시작
//     console.log('서버에 정보 요청 중...')

//     fetchUser(1, (user) => {
//         console.log('✅ 사용자 정보 수신 완료:');
//         console.table(user);                      // 객체를 테이블 형태로 출력 
//         console.groupEnd();                       // [3] 실행 결과를 그룹 종료
//     });

// }, 5000);

// 로그인 시도 ... --> 로그인 성공! 토큰 : xxxxx
// 사용자 정보 조회 ...  --> 사용자: 이개발
// 권한 확인 ... --> 관리자 권한: 있음 

// 함수 정의 
function login(username, password, callback) {      // 로그인 시뮬레이션 함수
    setTimeout(() => {  // 서버 응답 지연 시뮬레이션 (800ms)
        const token = 'abc123xyz';          // 인증 성공 시 발급되는 토큰 (Mock)
        callback(token);                    // 토큰을 콜백으로 전달
    }, 800);
}

function getUserInfo(token, callback) {     // 토큰으로 사용자 정보 조회 시뮬레이션 함수
    setTimeout(() => {  // 서버 응답 지연 시뮬레이션 (800ms)
        const userInfo = {
            id: 1,
            name: "이개발",
            permissions: ['read', 'write', 'admin']     // 사용자 권한 목록
        };
        callback(userInfo);             // 사용자 정보를 콜백으로 전달 
    }, 800);
}

function checkPermission(userInfo, action, callback) {      // 특정 권한 보유 여부 확인 시뮬레이션 함수
    setTimeout(() => {
        const hasPermission = userInfo.permissions.includes(action); // 권한 배열에 해당 action이 있는지 확인
        callback(hasPermission);        // 권한 유무(boolean)를 콜백으로 전달 
    }, 500);
}

// 6초 후에 순차 실행 
setTimeout(() => {              // 6초 후 실행 
    console.group('📗[4] 콜백으로 순서 보장 - 실행 결과');
    console.log('로그인 -> 사용자 정보 -> 권한 확인 순서로 실행');
    console.log('-'.repeat(30));

    console.log('1️⃣ 로그인 시도...');
    login('dev.lee', 'password123', (token) => {            // 1단계: 로그인 후 토큰 받기 
        console.log('    -> 로그인 성공! 토큰:', token);

        console.log('2️⃣ 사용자 정보 조회...');
        getUserInfo(token, (userInfo) => {                  // 2단계: 토큰으로 사용자 정보 조회 (로그인 완료 후 실행)
            console.log('    -> 사용자:', userInfo.name);

            console.log('3️⃣ 권한 확인...');
            checkPermission(userInfo, 'admin', (hasPermission) => { // 3단계: 사용자 정보로 권한 확인 (조회 완료 후 실행)
                console.log('    -> 관리자 권한:', hasPermission ? '있음 ✅' : '없음 ❌');
                console.log('-'.repeat(30));
                console.log("모든 작업 완료!");             // 모든 비동기 작업이 순차적으로 완료됨                
                console.groupEnd();
            });
        });
    });

}, 6000);

/*
    콜백 함수 --> 콜백 지옥 (Callback hell)
        * 문제점
            - 가독성 저하 : 들여쓰기가 점점 깊어짐
            - 에러 처리 복잡 : 각 단계마다 에러 처리 필요
            - 디버깅 어려움: 어디서 문제 발생했는지 추적 힘듦
            - 유지보수 힘듦: 중간예 단계 추가/삭제 어려움 

    해결책 : Promise와 async/await            
*/


