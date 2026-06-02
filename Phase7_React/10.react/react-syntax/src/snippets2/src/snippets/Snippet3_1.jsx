const Snippet3_1 = () => {

    // 화면에 올리기 전에 미리 담아두는 곳
    // JS 코드가 실행되는 공간 - 변수선언, 조건문, 계산, API 등
    // return 위쪽 전체
    let res = '';
    const loginName = '이순신1';

    if (loginName === '이순신') {
        res = <div>이순신입니다.</div>
    } else {
        res = <div>비회원 입니다.</div>
    }

    // 준비한 내용을 실제 화면에 올리는 곳
    // return () 안쪽 - 실제 화면에 그려질 JSX만 작성, JS 로직은 최대한 넣지 않는 것이 원칙
    return (
        <div>
            {res}
        </div>
           
    );

}

export default Snippet3_1;