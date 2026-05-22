import { useState } from "react";

const Snippet6_2 = () => {

    /*
        useState() 초기값으로 boolean, 숫자, 문자열(''), 배열([]), 객체({}) 등
        모든 JS 자료형 사용 가능
    */
   let [isRead, setIsRead] = useState(false);

    return (
        <div
            style = {{cursor: 'pointer', padding: '12px', background: '#f0f4ff', display: 'inline-block', borderRadius: '8px'}}
            onClick={function() {
                console.log('알림을 읽음으로 표시했습니다.');
                setIsRead(true);
            }}
        >
            새 알림 3건 - {isRead ? '확인완료' : '클릭하여 확인'}
        </div>
    );
}

export default Snippet6_2;