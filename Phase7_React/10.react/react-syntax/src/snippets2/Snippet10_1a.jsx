/*
    API 응답 구조 (JSONPlaceholder / todos)
    {userId, id, title, completed}
*/

import { useEffect, useState } from "react"

// 전체 200 중 10개만 요청
const API = 'https://jsonplaceholder.typicode.com/todos?_limit=10'


const Snippet10_1a = () => {

    //state 선언
    const [list,        setList      ] = useState([])      // API 응답 데이터
    const [loading,     setLoading   ] = useState(true)    // 초기값 true --> 마운트 즉시 스피너
    const [error,       setError     ] = useState(null)
    const [editingId,   setEditingId ] = useState(null)    // null --> 편집 중인 항목 없음  
    const [inputValue,  setInputValue] = useState('')   
    
    //데이터 패칭
    useEffect(() => {
        const fetchList = async () => {
            try{
                setLoading(true)    // 요청 시작 -> 스피너 표시 
                const res = await fetch(API)    // API 서버에 HTTP GET 요청 - 응답이 올때까지 다음 줄로 넘어가지 않음
                if(!res.ok) throw new Error(`서버 오류: ${res.status}`)
                const data = await res.json()    
                setList(data)
            } catch (err) {
                setError(err.message)
            } finally {
                setLoading(false)
            }
        }
        fetchList()
    }, [])      // [] : 마운트 시 1번만 실행 

    // 편집 핸들러
    const handleEdit = (item) => {
        setEditingId(item.id)
        setInputValue(item.title)  // 기존 title을 input에 미리 채움
    }

    // 저장
    const handleSave = () => {
        if (!inputValue.trim()) return
        setList((prev) => 
            prev.map((item) => 
                item.id === id 
                ? {...item, title: inputValue}      // 해당 항목만 title 교체, 나머지 필드 유지
                : item                              // 다른 항목은 원본 그대로
            )
        )
        setEditingId(null)
        setInputValue('')
    }

    // 취소
    const handleCancel = () => {
        setEditingId(null)
        setInputValue('')        
    }

    // loading --> error
    if(loading) return (
        <>
            <div className="flex items-center gap-3 p-6 text-gray-500">
                <div className="w-5 h-5 border-2 border-gray-300 border-t-blue-500 rounded-full animate-spin" />
                <span>할 일 목록을 불러오는 중입니다....</span>
            </div>
        </>
    )

    if(error) return (
        <>
            <div className="m-4 p-4 bg-red-50 border border-red-200 rounded-lg">
                <p className="text-red-700 font-medium mb-1">데이터를 불러오지 못했습니다</p>
                <p className="text-red-500 text-sm">{error}</p>
            </div>
        </>
    )

    // 정상 데이터 랜더링
    return (
        <>
            <div className="p-4 max-w-lg">
                <h2 className="text-sm font-medium text-gray-500 mb-3">
                    할 일 목록 ({list.length}개) - 제목을 클릭해서 편집하세요
                </h2>

                <ul className="space-y-2">
                    {list.map((item) => (
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
                    ))
                    }
                </ul>
            </div>
        
        </>
    )
}

const ListItem = ({ item, isEditing, inputValue, onEdit, onSave, onCancel, onInputChange }) => {
    return (
        <>
            <li className="flex items-center gap-2 p-3 border border-gray-200 rounded-lg hover:bg-gray-50 transition-colors">
                {isEditing ? (
                    // 편집 모드
                    <>
                    </>
                ) : (
                    // 읽기 모드
                    <>
                        <span className="{`text-lg ${item.completed ? 'opacity-100' : 'opacity-20'}`}">✓</span>
                    
                    </>
                )

                }
            </li>
        </>
    )
}

export default Snippet10_1a