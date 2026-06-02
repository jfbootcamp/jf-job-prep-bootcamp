import { useState } from "react";

const Snippet9_1 = () => {

    const [name, setName] = useState("");  // input 실시간 입력값
    const [nameList, setNameList] = useState([]);   // 초기값: 빈 배열 (추가 시 {id, name} 객체가 쌓임) 

    // input 변경시 name state 실시간 반영하는 함수(이벤트 핸들러)
    const handleNameChange = (e) => {
       setName(e.target.value)              // e.target.value = 현재 입력된 텍스트    
    }

    const handleAddName = () => {
        if(!name.trim()) return        // 앞뒤 공백 제거 -> "  " 이면 "" 반환

        setNameList((prevState) => [
            ...prevState,           // 기존 목록 복사 (불변성 유지)
            { id: crypto.randomUUID(), name}
        ]);

        setName("")                 // 추가 완료 후 input 초기화 
    }

    const handleDelete = (id) => {
        setNameList((prevState) => prevState.filter((item) => item.id !== id) );    
        // filter: 조건이 true인 항목만 남김
        // item.id !== id --> 클릭한 항목의 id와 다른것만 남김 = 클릭한 항목 삭제 
    }


    return (
        <>
            <div>
                <input type="text" value={name} 
                 onChange={handleNameChange}
                 className="border border-gray-300 rounded px-3, py-1, mr-2 outline-none 
                            focus:border-blue-400"/>
                <button onClick={handleAddName}
                        className="px-4 py-1 bg-blue-500 text-white rounded hover:bg-blue-600">
                    Add
                </button>

                <ul className="mt-3">
                   {nameList.map((item) => (
                        <li key={item.id} className="flex items-center gap-2 mb-1">
                            <span>{item.name}</span>  
                            <button
                                onClick={() => handleDelete(item.id)} // 해당 항목의 id만 전달
                                className="text-sm text-red-400 hover:text-red-600"
                            >삭제</button>                                  
                        </li>                        
                    ))

                   } 
                </ul>
            </div>
        </>
    );
}

export default Snippet9_1;