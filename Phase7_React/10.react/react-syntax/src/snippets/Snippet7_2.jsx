/*
    div1 오버레이
        - 화면 전체를 고정으로 덮음
        - 뒷배경 반투명 처리
        - div2를 정중앙에 배치

    div2 모달 카드
*/

const ApplyModal = ({ company, onClose }) => {
    return (
        <div className="fixed inset-0 bg-black/40 flex items-center justify-center">
            <div className="bg-white rounded-xl p-8 w-80 text-center shadow-lg">
                <h3 className="text-lg font-semibold mb-3">✔ 지원 완료</h3>
                <p className="mb-2">
                    <strong>{company}</strong>에<br/>지원서가 제출되었습니다.
                </p>
                <p className="text-gray-500 text-sm mb-6">
                    서류 결과는 2주 내로 이메일로 안내드립니다.
                </p>
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

const Snippet7_2 = () => {

    return (
        <>
        
        </>
    );
}

export default Snippet7_2;