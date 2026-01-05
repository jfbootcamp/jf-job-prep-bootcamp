/*
    문제 1: 요일별 처리 

    new Date() : 현재 날짜/시간 객체 생성
    getDay() : 요일을 숫자로 반환 (0=일, 1=월,..., 6=토)
*/

const today = new Date().getDay();

switch(today) {
    case 0:
        console.log("일요일: 휴식");
        break;
    case 1:
        console.log("월요일: 주간 회의");
        break;        
    case 2:
        console.log("화요일: 개발 집중");
        break;       
    case 3:
        console.log("수요일: 코드 리뷰");
        break;   
    case 4:
        console.log("목요일: 테스트");
        break;                     
    case 5:
        console.log("금요일: 배포 & 회고");
        break;   
    case 6:
        console.log("토요일: 자기계발");
        break;        
    default:
        console.log("잘못된 요일");                                  
}

/*
    문제 2: 요일별 처리 (입력)
        - prompt()로 사용자 입력을 받아 테스트
        - parseInt()로 문자열을 숫자로 변환 
*/
const input = prompt("요일을 입력하세요 (0=일, 1=월,..., 6=토)");
const inputDay = parseInt(input);

switch(inputDay) {
    case 0:
        console.log("일요일: 휴식");
        break;
    case 1:
        console.log("월요일: 주간 회의");
        break;        
    case 2:
        console.log("화요일: 개발 집중");
        break;       
    case 3:
        console.log("수요일: 코드 리뷰");
        break;   
    case 4:
        console.log("목요일: 테스트");
        break;                     
    case 5:
        console.log("금요일: 배포 & 회고");
        break;   
    case 6:
        console.log("토요일: 자기계발");
        break;        
    default:
        console.log("잘못된 요일");                                  
}

/* 문제 3 : HTTP 상태 코드 선택
    - 실무에서 정말 많이 쓰는 패턴임
    - HTML <select> 드롭다운으로 사용자 입력을 받아 처리  

    DOM 접근하기
        - 브라우저가 HTML을 읽으면 DOM Tree를 만듦

            document
                |
                ----- html
                        |
                        ----head
                        |
                        ----body
                             |
                             ----- div
                             |       |
                             |       ------select#statusCodeSelect
                             |
                             ---------p#statusResult

*/
console.log("\n===문제 3 : HTTP 상태 코드===");

// DOM Tree에서 id로 요소를 찾아 반환 => JS 변수로 가져옴
const selectElement = document.getElementById("statusCodeSelect");
const resultElement = document.getElementById("statusResult");

// 상태 코드 처리 함수 
function handleStatusCode(code) {
    let message;

    switch(code) {
        case 200:
            message = "✅ 성공: 요청이 정상 처리되었습니다.";
            break;
        case 201:
            message = "✅ 생성됨: 리소스가 생성되었습니다.";
            break;            
        case 400:
            message = "⚠️ 잘못된 요청: 요청 형식을 확인해주세요.";
            break;            
        case 401:
            message = "🔐 인증 필요: 로그인이 필요합니다.";
            break;
        case 403:
            message = "🚫 접근 금지: 권한이 없습니다.";
            break;  
        case 404:
            message = "❓찾을 수 없음: 요청한 리소스가 없습니다.";
            break;                      
        case 500:
            message = "🤧 서버 오류: 잠시 후 다시 시도해주세요";
            break;            
        default:
            message = "상태 코드를 선택해 주세요";            
    }

    return message;
}

// selectElement에 "change" 이벤트 리스너 등록 
selectElement.addEventListener("change", function() {
    const statusCode = parseInt(selectElement.value);
    const message = handleStatusCode(statusCode);

    resultElement.textContent = message;

    console.log(`HTTP ${statusCode}: ${message}`);

} )