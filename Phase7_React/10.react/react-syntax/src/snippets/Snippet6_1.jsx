const Snippet6_1 = () => {

    const myfunc = () => {
        console.log('장바구니 상품이 추가되었습니다.');
    }

    return (
        /* myfunc : 함수 자체를 React에게 넘김
            -> React가 클릭 이벤트 발생 시 대신 호출
        */
        <button onClick={myfunc}>장바구니 담기</button>
    );
}

export default Snippet6_1; 