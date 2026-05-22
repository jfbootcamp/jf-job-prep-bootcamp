import { useState } from "react";

const Snippet5_3 = () => {

    const allFruits = ['사과', '수박', '딸기', '바나나', '오렌지', '토마토'];

    /* isExpanded: 목록의 펼침/접힘 여부를 저장하는 state
        false -> 접힌 상태 (처음 3개만 표시)
        true -> 펼친 상태 (전체 표시)
       useState(false): 초기값을 false로 지정 
    */
    const [isExpanded, setIsExpanded] = useState(false)
    // 파생 데이터
    const displayed = isExpanded ? allFruits : allFruits.slice(0, 3);

    return (
        <>
            <h4>{displayed.join(', ')}</h4>
            <button onClick={() => setIsExpanded(!isExpanded)}>
                {isExpanded ? '접기' : '더 보기'}
            </button>
        </>
    );
}

export default Snippet5_3;

