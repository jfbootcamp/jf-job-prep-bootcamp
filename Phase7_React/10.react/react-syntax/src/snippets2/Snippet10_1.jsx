import { useState } from "react"

/*
    1) 자식은 부모 state를 직접 바꿀수 없음
        - 부모가 함수를 만들어 자식에게 props로 내려줌
        - 자식은 버튼 클릭시 그 함수를 호출함 
        - 결과적으로 부모 state가 바뀜

    2) 패턴
        - 부모 : list state +  editingId state
        - 자식 : 편집 UI 랜더링 + 저장/취소 이벤트를 부모로 전달     
*/
const Snippet10_1 = () => {

    const [list, setList] = useState([
        { id: 1, title: '강원도'},
        { id: 2, title: '경기도'},
        { id: 3, title: '제주도'},
    ])
    const [editingId, setEditingId] = useState(null)
    const [inputValue, setInputValue] = useState('')

    // 편집 버튼 클릭 -> 해당 항목을 편집 모드로 전환
    const handleEdit = (item) => {
        setEditingId(item.id)       // 어느 항목인지 기억
        setInputValue(item.title)   // 기존 title을 input에 미리 채움
    }

    // 저장 버튼 클릭 -> list에서 해당 항목만 수정 후 편집 종료
    // 참조가 바뀌어야 React가 리랜더를 발생시킴 
    const handleSave = (id) => {
        if(!inputValue.trim()) return 
        setList((prev) => 
            prev.map(((item) => 
                item.id === id
                    ? {...item, title: inputValue} 
                    : item
            ))
        )
        setEditingId(null)      // 편집 종료 -> 모든 항목이 읽기 모드로 전환
        setInputValue('')       // input 값 초기화 
    }

    // 최소 버튼 -> 편집 종료 (저장 안 함)
    const handleCancel = () => {
        setEditingId(null)
        setInputValue('')
    }



    return (
        <>
            <div className="p-4 max-w-sm">
                <ul className="space-y-2">
                    {list.map((item) => (       // () => () : 암묵적 변환 -- return 생략 + 여러 줄 JSX를 하나의 표현식으로 묶음 
                        <ListItem 
                            key={item.id}
                            item={item}
                            isEditing={editingId === item.id}
                            inputValue={inputValue}
                            onEdit={handleEdit}
                            onSave={handleSave}
                            onCancel={handleCancel}
                            onInputChange={(e) => setInputValue(e.target.value)}
                        />
                    ))}
                </ul>
            </div>
        </>
    )
}

const ListItem = ({item, isEditing, inputValue, onEdit, onSave, onCancel, onInputChange }) => {

    return (
        <>
            <li className="flex items-center gap-2 p-3 border border-gray-200 rounded-lg">
                {isEditing ? (
                    // 편집 모드
                    <>
                        <input type="text" value={inputValue} onChange={onInputChange}
                               autoFocus  // 편집 모드 진입 시 자동 포커스
                               className="flex-1 border border-blue-300 rounded px-2 py-1 text-sm outline-none focus:border-blue-500" />
                        <button onClick={() => onSave(item.id)}
                            className="px-3 py-1 bg-blue-500 text-white text-sm rounded hover:bg-blue-600">저장</button>  
                        <button onClick={onCancel}
                            className="px-3 py-1 text-sm rounded hover:bg-gray-100">취소</button>                             
                    </>
                ) : (
                    // 읽기 모드
                    <>
                        <span className="flex-1 text-sm">{item.title}</span>
                        <button 
                            onClick={() => onEdit(item)}
                            className="px-3 py-1 rounded text-sm hover:bg-gray-100">편집</button>
                    </>
                )}
            </li>
        </>
    )
}

export default Snippet10_1