/*
ApplyModal 컴포넌트 (자식, 보조)
    div 1 오버레이
        - 화면 전체를 고정으로 덮음 (fixed inset-0)
        - 뒷배경 반투명 처리 (bg-black/40)
        - div2를 정중앙에 배치

    div 2 모달 카드
        
*/

import { useState } from "react";

// 고정된 값
const JOBS = ['토스 풀스택 개발자', '네이버 Spring 백엔드 개발자', '카카오 React 개발자'];

const ApplyModal = ({ company, onClose }) => {
    return (
        <div className="fixed inset-0 bg-black/40 flex items-center justify-center">
            <div className="bg-white rounded-xl p-8 w-80 text-center shadow-lg">
                <h3 className="text-lg font-semibold mb-3">✔ 지원 완료</h3>
                <p className="mb-2">
                    {/* company prop: 부모에서 받은 회사명을 동적으로 표시 */}
                    <strong>{company}</strong>에<br/>지원서가 제출되었습니다.
                </p>
                <p className="text-gray-500 text-sm mb-6">
                    서류 결과는 2주 내로 이메일로 안내드립니다.
                </p>
                {/* 클릭 시 부모의 setModal(false) 실행 -> 모달 사라짐 */}
                <button 
                    onClick={onClose}
                    className="bg-blue-700 text-white py-2.5 px-7 rounded-lg text-sm cursor-pointer hover:bg-blue-800 trasition-colors"
                >
                    확인
                </button>
            </div>

        </div>
    );
}

/*
    메인 컴포넌트
*/
const Snippet7_2 = () => {
    let [modal, setModal] = useState(false);  // modal만 useState로 관리 -- 클릭에 따라 true/false 

    return (
        <>
            <div className="p-10">
                <h2 className="text-xl font-semibold mb-4">지원 가능한 공고</h2>
                {/* 클릭 -> setModal(true) -> 리렌더링 -> ApplyModal 표시 */}
                <button
                    onClick={()=> {setModal(true)}}>
                    {JOBS[2]}지원하기
                </button>
                {modal == true 
                    ? <ApplyModal 
                        company={JOBS[2]}
                        onClose={() => {setModal(false)}} />
                    : null    
                }
            </div>
        </>
    );
}

export default Snippet7_2;