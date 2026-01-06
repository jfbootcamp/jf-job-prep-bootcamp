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

/*
    문제 4
        결제 대기중
        결제를 완료해주세요

        결제 완료
        상품을 준비중입니다

        상품 준비중
        곧 발송될 예정입니다

        배송중
        배송 조회가 가능합니다

        배송 완료
        구매 확정을 눌러주세요 

        주문 취소됨
        환불이 진행합니다

        알 수 없는 상태
        고객센터에 문의하세요

*/
/*
    객체 (Object)로 여러 값을 한 번에 반환하기 

    함수에서는 return으로 값을 하나만 반환할 수 있음
    하지만 여러 값을 "묶어서" 객체로 만들면 한 번에 전달 가능!

    (ES6 문법)
    {
        icon: icon,
        statusMessage: statusMessage,
        nextAction: nextAction
    }
    
    위와 같이 객체의 변수명과 속성명이 같으면 축약 가능함
    { icon, statusMessage, nextAction }

*/

/*
    innerHTML 개념
*/

console.log("\n===문제 4 : 주문 상태 ===");

// DOM에서 select와 결과 표시 영역 가져오기
    // HTML : <select id="orderStatusSelect"> ==> js 변수로 가져옴
    const orderSelectElement = document.getElementById("orderStatusSelect"); 
    const orderResultElement = document.getElementById("orderResult");

// 주문 상태 코드 처리 함수 
function handleOrderStatus(status) {
    let statusMessage;
    let nextAction;
    let icon;

    switch(status) {
        case "pending":
            icon = "⌛";
            statusMessage = "결제 대기중";
            nextAction = "결제를 완료해주세요";
            break;
        case "paid":
            icon = "⌛";
            statusMessage = "결제 완료";
            nextAction = "상품을 준비중입니다";
            break;
        case "preparing":
            icon = "⌛";
            statusMessage = "상품 준비중";
            nextAction = "곧 발송될 예정입니다";
            break;
        case "shipping":
            icon = "⌛";
            statusMessage = "배송중";
            nextAction = "배송 조회가 가능합니다";
            break;
        case "delivered":
            icon = "⌛";
            statusMessage = "배송 완료";
            nextAction = "구매 확정을 눌러주세요";
            break;
        case "cancelled":
            icon = "⌛";
            statusMessage = "주문 취소됨";
            nextAction = "환불이 진행합니다";
            break;
        default:
            icon = "⌛";
            statusMessage = "알 수 없는 상태";
            nextAction = "고객센터에 문의하세요";                                                                     
    }

    return { icon, statusMessage, nextAction };
}

// 주문 상태 select 변경 이벤트 리스너
orderSelectElement.addEventListener("change", function() {
    const status = orderSelectElement.value;

    const result = handleOrderStatus(status);
    console.log(`주문 상태: ${status} => ${result.statusMessage} `);

    orderResultElement.innerHTML = `
        <p><strong>${result.icon} 상태 : </strong>${result.statusMessage}</p>
        <p><strong>📢 안내: </strong>${result.nextAction}</p>
    `;


});
