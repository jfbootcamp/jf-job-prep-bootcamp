console.log('%c Promise.all()',
    'background: #00d9ff; color: #000; font-size: 16px; font-weight: bold; padding: 5px;'
)

// getDashboardUser() -- 사용자 정보 API (1초)
// * 항상 성공하는 시뮬레이션 --> reject 생략 가능
function getDashboardUser() {
    return new Promise((resolve) => {
        setTimeout(() => {
            resolve({name: '김개발'});
        }, 1000);
    });
}

// getNotification() -- 알림 목록 API (0.8초)
// * 항상 성공하는 시뮬레이션 --> reject 생략 가능
function getNotification() {
    return new Promise((resolve) => {
        setTimeout(() => {
            resolve(['새 댓글', '새 팔로워']);
        }, 800);
    });
}

// getStatus()
// * 실패 가능성 있음 ==> reject 필요!
function getStatus() {
    return new Promise((resolve, reject) => {
        setTimeout(() => {
            // 랜덤하게 성공/실패 결정 (50% 확률)
            const isSucess = Math.random() > 0.5;
            if(isSucess) {
                resolve({ views: 100});
            } else {
                reject(new Error('통계 서버 연결 실패'));    
            }
        }, 600);
    });
}

console.log('🚀 대시보드 로딩 (3개 동시 호출!)...');

const start = Date.now();

Promise.all([
    getDashboardUser(),
    getNotification(),
    getStatus()
])
.then(([user, notifications, stats]) => {
    console.log('✅ 사용자:', user.name);
    console.log('✅ 알림:', notifications.join(', '));
    console.log('✅ 통계: 조회수 ', stats.views);
    console.log('');
    console.log(`⏱️ 총 시간: ${Date.now() - start}ms`);
})
.catch((error) => {
    console.log('❌ 에러: ', error.message);
});