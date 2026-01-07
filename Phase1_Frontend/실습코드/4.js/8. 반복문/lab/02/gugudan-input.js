/*
    사용자 입력 받기와 입력 검증 익히기 

    prompt() 사용자 입력
        - 항상 문자열 반환!
    
    Number() 숫자 변환
    
    isNaN()  입력 검증

    prompt --> 문자열 | Number() --> 숫자 변환 필수 | isNaN() --> 유효성 체크 (범위 체크)
*/

// 1단계 : prompt()로 사용자 입력 받기
const inputString = prompt("몇 단을 출력할까요? (1-9)");    // 팝업 창으로 입력 받음 

// 취소 버튼 누른 경우
if(inputString == null) {
    console.log("입력이 취소되었습니다.");
} else {
    // 2단계: Number()로 숫자 변환
    const userDan = Number(inputString);    // 문자열 --> 숫자 변환

    // 3단계: 입력 검증
    if(isNaN(userDan) || userDan < 1 || userDan > 9) {
        console.log("1부터 9 사이의 숫자를 입력해주세요.");     // 콘솔에 에러 메시지 출력
    } else {
        // 4단계: 구구단 콘솔 출력
        console.log(`\n=== ${userDan}단 ===`);

        for(let i = 1; i <= 9; i++) {
            console.log(`${userDan} x ${i} = ${userDan * i}`);      // 콘솔에 구구단 출력 
        }        
    }
} 

