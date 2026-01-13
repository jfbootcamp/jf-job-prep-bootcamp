console.log('%c 3. 콜백 대신 Promse를 반환하는 패턴',
    'background: #00d9ff; color: #000; font-size: 16px; font-weight: bold; padding: 5px;'
)

/*
    차이점 정리
    -----------------------------------------------------------
        콜백 방식                   Promise 반환 방식
    -----------------------------------------------------------
      결과를 콜백 함수의 인자로 전달    결과를 resolve()로 반환
      에러를 콜백 첫 번째 인자로 전달   에러를 reject()로 반환
      중첩되어 콜백 지옥 발생          .then() 체이닝으로 평탄화 
      에러 처리 각각 해야 함           .catch() 하나로 모든 에러 처리  


      const token = 'token_' + Math.random().toString(36).slice(2, 11);
        - Math.random() : 0~1 사이 랜덤 소수 (0.7291836450)
        - .toString(36) : 36진수 변환 ("0.q8z5n2kxr")
            - 36진수 : 숫자(0-9) 10개 + 알파벳(a-z) 26개 = 36개 문자 사용
            - 짧은 문자열로 다양한 조합 가능 --> 간단한 ID 생성에 활용
        - .slice(2, 11) : "0." 제거, 9글자 추출 (q8z5n2kxr)
*/

// 실제 API 함수들 -- 콜백 대신 Promse를 반환
function loginPromise(username, password) {     // 로그인 시뮬레이션
    return new Promise((resolve, reject) => {   // Promise를 반환 --> .then()으로 체이닝 가능 
        setTimeout(() => {                      // 서버 응답 지연 시뮬레이션 (800ms)
            if(password.length >= 4) {          // 비밀번호 유효성 검사
                const token = 'token_' + Math.random().toString(36).slice(2, 11);
                resolve(token);                 // 성공 --> .then()으로 token 전달
            } else {
                reject(new Error('비밀번호는 4자 이상이어야 합니다.'));     // 실패 -> .catch()로 전달
            }
        }, 800);
    });
}

function getUserInfoPromise(token) {           // 토큰으로 사용자 정보 조회 시뮬레이션     
    return new Promise((resolve) => {          // Promise를 반환 --> 다음 .then()으로 체이닝 
        setTimeout(() => {                     // 서버 응답 지연 시뮬레이션 (800ms) 
            resolve({
                id: 1,
                name: '이개발',
                email: 'dev.lee@example.com'
            })
        }, 800);
    });
}

function getPostsPromise(userId) {              // 사용자 ID로 게시글 목록 조회 시뮬레이션
    return new Promise((resolve) => {           // Promise를 반환 -> 다음 .then()으로 체이닝
        setTimeout(() => {                      // 서버 응답 지연 시뮬레이션 (600ms)
            resolve([                           // 성공 --> .then()에 posts로 전달
                {id: 1, title: 'JavaScript Promise 이해하기'},
                {id: 2, title: 'async/await 활용법'},
                {id: 3, title: 'API 호출 패턴 정리'}
            ])
        }, 600);
    });
}


setTimeout(() => {
    console.group('Promise 체이닝 - 실행 결과');
    console.log('로그인 -> 사용자 정보 -> 게시글 순서로 실행');
    console.log('-'.repeat(30));

    // loginPromise() 호출 + 모든 .then() 등록
    loginPromise('dev.lee', 'password123')
        .then(token => {
            console.log('1️⃣ 로그인 성공! 토큰:', token.slice(0, 15) + '....');

            return getUserInfoPromise(token);  // 새 Promise 객체 반환 
        })
        .then((user) => {
            console.log('2️⃣ 사용자 :', user.name);

            return getPostsPromise(user.id);   // 새 Promise 객체 반환  
        })
        .then((posts) => {
            console.log('3️⃣ 게시글 목록');
            console.table(posts);
            console.log('-'.repeat(30));
            console.log('💐모든 작업 완료!');
        })
        .catch((error) => {
            console.log('❌ 에러: ', error.message);
        })
        .finally(() => {
            console.log('📌 finally: 항상 실행됨');
            console.groupEnd();
        });

}, 3000);