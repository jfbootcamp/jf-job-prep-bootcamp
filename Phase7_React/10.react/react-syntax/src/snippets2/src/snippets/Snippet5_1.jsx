import { useState } from "react";

const Snippet5_1 = () => {
    /*
        state : React가 관리하는 데이터
        modelName : 현재 state 값 (읽기)
        setModelName : state 값을 변경하는 함수 (쓰기)
        useState(초기값) : 첫 화면에 보여줄 값 설정
    */
    let [modelName, setModelName] = useState('gpt-5.5');      // 네이밍 규칙: state 변경 함수는 항상 set + 변수명으로 짓는 것이 React 관례임.
    // 일반 변수 : React가 관리하지않는 데이터(값이 바뀌어도 화면이 갱신되지 않음)
    let releaseDate = '2026년 04월 출시';

    return (
        <>
            <div className="App">
                <div className="black-nav">
                    <div>LLM 모델 정보</div>
                </div>

                <div className="list">
                    <h4>최신 LLM 모델 현황</h4>
                    <p>2026년 5월 21일 업데이트</p>
                    <p>현재 모델 : {modelName}</p>  {/* state 값 출력 : 변경되면 화면 자동 재렌더링 */}
                    <p>{releaseDate}</p> 
                    <button onClick={() => setModelName('GPT-5')}>GPT-5로 변경</button>
                    <button onClick={() => setModelName('Gemina 3.5')}>Gemini로 변경</button>
                    <button onClick={() => setModelName('Claude Opus 4.7')}>Claude로 변경</button>
                </div>
                
            </div>
        </>
    );
};

export default Snippet5_1;