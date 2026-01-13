console.log('%c 4. Promise.all() 병렬 처리 ',
    'background: #00d9ff; color: #000; font-size: 16px; font-weight: bold; padding: 5px;'
)

/*
    체이닝 vs Promise.all() 비교 
        - 체이닝 (순차) : A(1초) -> B(1초) -> C(1초) = 총 3초
        - Promise.all() :   A(1초)
                            B(1초)  --> 동시 실행 = 총 약 1초 (가장 느린 것 기준)
                            C(1초)

    Promise.all([
        fetchUserById(1),
        fetchUserById(2),    --> 3개가 "동시에" 시작
        fetchUserById(3)
    ])                  
                                --> 모두 완료될 때까지 대기   
    .then([user1, user2, user3])  <---- 결과를 배열로 전달 (순서 보장!) 
                       
     Promise.all()이 내부적으로 "인덱스 위치"를 기억하고 있음.
*/  

function fetchUserById(id) {
    return new Promise((resolve) => {
        setTimeout(() => {
            resolve({ id, name: `사용자${id}`});  // 이 resolve()가 호출되면 해당 Promise는 fulfilled 상태
        }, 500 + Math.random() * 500);      // 500~1000ms 랜덤 지연 
    });
}

setTimeout(() => {
    console.group('Promise.all() - 실행 결과');
    console.log('3명의 사용자를 동시에 조회');

    const startTime = Date.now();

    // 1단계: Promise.all() 호출 -- 3개 Promise가 "동시에" 시작
    Promise.all([
        fetchUserById(1),       // 인덱스 0 <-- 완료 순서와 관계없이 users[0]에 저장됨 
        fetchUserById(2),       // 인덱스 1 <-- 완료 순서와 관계없이 users[1]에 저장됨
        fetchUserById(3)        // 인덱스 2 <-- 완료 순서와 관계없이 users[2]에 저장됨
                                // 3개가 순차가 아닌 "동시에" 실행! (병렬 처리)
    ])
    .then((users) => {
        // users = [user1, user2, user3] <--- 배열로 결과 받음
        // 순서 보장 : users[0]=id:1, users[1]=id:2, users[2]=id:3
        // 완료 순서: 2->3->1이어도, 입력 순서대로 정렬됨

        const elasped = Date.now() - startTime;
        console.log(`✅ 완료! (${elasped}ms)`);
        console.table(users);
        console.log('💡 병렬 처리로 시간 단축!');
        console.groupEnd();
    })
    .catch((error) => {
        console.log('❌ 에러:' , error.message);
        // 주의 : 하나라도 실패하면 전체 실패로 처리됨 
    });


}, 8000);