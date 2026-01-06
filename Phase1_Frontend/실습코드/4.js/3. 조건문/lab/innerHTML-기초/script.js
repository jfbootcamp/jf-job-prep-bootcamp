/*
    1. innerHTML이란?
        - innerHTML은 HTML 요소 안의 "HTML 내용"을 가져오거나 설정하는 속성임
*/

function showInnerHTML() {
    // 1단계 : DOM에서 요소 가져오기 
    const element = document.getElementById("demo1");  // id가 "demo1"인 요소를 찾음

    // 2단계 : innerHTML로 내용 읽기 
    const content = element.innerHTML;      // 요소 안의 HTML 내용을 가져옴

    // 3단계 : 결과 출력
    const output = document.getElementById("output1");
    output.textContent = "innerHTML 값: " + content;        // 읽은 내용을 화면에 표시

}

/*
    2. innerHTML vs textContent 비교
        1) innerHTML
            - HTML 태그를 "해석"해서 랜더링
            - "<b>굵게</b>" => 굵게 (실제로 굵은 글씨로 표시)

        2) textContent 
            - HTML 태그를 "문자 그대로" 표시
            - "<b>굵게</b>" => <b>굵게</b> (태그가 텍스트로 보임)
*/