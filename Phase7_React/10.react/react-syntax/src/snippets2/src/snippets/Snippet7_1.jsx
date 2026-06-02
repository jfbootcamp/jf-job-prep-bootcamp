import { useState } from "react";

const Snippet7_1 = () => {
    let [todos, setTodos] = useState(['React 스터디', '포트폴리오 작성', '이력서 수정']);

    return (
        <>
            <h1>오늘 할 일: {todos.join(' / ')}</h1>
            <button onClick={()=> {
                // 스프레드 연산자로 배열 전체를 복사한 뒤 수정함 (새배열 생성, 원본 유지)
                let copy = [...todos];
                copy[0] = '✓ React 스터디 완료';
                setTodos(copy); // 변경된 복사본으로 state 업데이트 -> 리랜더링 발생 -> 화면 자동 개신
            }}>
                첫 번째 항목 완료 처리
            </button>
        </>
    );
}

export default Snippet7_1;