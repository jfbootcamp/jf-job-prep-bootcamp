const Snippet3_4 = () => {

    const loginName = '이성계'

    return(
        <>
            {
                /* 
                즉시실행함수 (Immediately Invoked Function Expression)
                   (() => {....})() 
                   ------------- --
                   함수 선언      바로 실행
                */

                (() => {
                    if(loginName === "이성계1") {
                        return (<div>이성계입니다.</div>);
                    } else {
                        return (<div>비회원 입니다.</div>);
                    }
                })()    // 함수 선언하자마자 여기서 바로 실행   
            }
        </>
    );
};

export default Snippet3_4;
