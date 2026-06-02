const Snippet3_3 = () => {
    const loginName = '이방원'

    return (
        <>
            {/* && 연산자 : 앞의 조건이 true일때만 뒤의 내용을 화면 출력 */}
            {loginName === '이방원' && <div>이순신입니다.</div>}
        </>
    );
};

export default Snippet3_3;