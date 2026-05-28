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
        
        </>
    )
}

const ListItem = ({item, isEditing, inputValue, onEdit, onSave, onCancel, onInputChange }) => {

    return (
        <>
        
        </>
    )
}

export default Snippet10_1