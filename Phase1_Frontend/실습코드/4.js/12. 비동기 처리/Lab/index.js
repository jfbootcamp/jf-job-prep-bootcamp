console.log('%c Promise 체이닝 Lab',
    'background: #00d9ff; color: #000; font-size: 16px; font-weight: bold; padding: 5px;'
)

//[함수 정의] 
// login
function login(email, password) {
    return new Promise((resolve, reject) => {
        setTimeout(() => {
            if(password.length >= 4) {
                resolve({ token: 'abc123' });   // 성공  --> .then()으로 체이닝 기능
            } else {
                reject(new Error('비밀번호는 4자 이상이어야 합니다.'));     // 실패 --> .catch()로 전달
            }
        }, 1000);
    });
}

// getUser
function getUser(token) {
    return new Promise((resolve) => {
        setTimeout(() => {
            resolve({ name: '김개발' });
        }, 1000);
    });
}

// 로그인 --> 사용자 정보 
console.log('%c🚀 로그인 시작...', 'color: #ff6b6b');

const start = Date.now();

login('dev@test.com', 'pas')
.then((result) => {
    console.log('%c✅ 로그인 성공! token: ' + result.token, 'color: #51cf66');
    return getUser(result.token);
})
.then((user) => {
    console.log('%c✅ 사용자: ' + user.name, 'color: #51cf66');
    console.log('');
    console.log('%c⏱️ 총 시간: ' + (Date.now() - start) + 'ms', 'color: #74c0fc');
    console.log('%c💡1초 + 1초 = 약 2초 (순차)', 'color: #74c0fc');
})
.catch((error) => {
    console.log('%c❌ 에러: ' + error.message, 'color: #ff6b6b');
});
