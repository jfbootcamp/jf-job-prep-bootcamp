import { useState } from "react";

const Snippet5_2 = () => {

    let [fruit, setFruit] = useState("사과");

    return (
        <>
            <h4>{fruit}</h4>
            <button onClick={() => setFruit("수박")}>
                change
            </button>

            {/* 현재 state를 읽고 -> 반대 값으로 새 state를 셋팅하기 */}
            <button onClick={() => {
                if (fruit === "사과") setFruit("수박");
                else setFruit("사과")
            }}>
                toggle
            </button>
        </>
    );
};

export default Snippet5_2;