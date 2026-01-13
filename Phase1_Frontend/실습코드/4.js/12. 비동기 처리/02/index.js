console.log('%c 2. Promise 기초 & 체이닝',
    'background: #00d9ff; color: #000; font-size: 16px; font-weight: bold; padding: 5px;'
)

console.groupCollapsed('📘[1] Promise 기본 사용법 - 클릭해서 펼치기');
console.groupEnd();

// const myPromise = new Promise((resolve, reject) => {
//     setTimeout(() => {                  // 1초 후 실행 예약 (비동기)
//         resolve('작업 성공');            // 이 값이 .then()의 result로 전달됨     
//     }, 3000);
// }); 

// myPromise.then((result)=>{
//     console.group('[2] 📗 Promise 기본 - 실행결과: ');
//     console.log('✅ 성공: ', result);
//     console.groupEnd();
// });

const myPromise = new Promise((resolve, reject) => {
    setTimeout(() => {
        const success = true; 
        if(success) {
            resolve('작업 성공!');  
        } else {
            reject(new Error('작업 실패!'))
        }                       
    }, 3000);
}); 

myPromise.then((result)=>{
            console.group('[2] 📗 Promise 기본 - 실행결과: ');
            console.log('✅ 성공: ', result);
        })
        .catch((error) => console.log('❌ 실패:', error.message));
console.groupEnd();        
        
