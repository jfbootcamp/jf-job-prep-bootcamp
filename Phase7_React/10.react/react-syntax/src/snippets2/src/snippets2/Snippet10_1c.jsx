/*
    추가할 사항
        1) state : saveError, setSaveError 추가
        2) handleSave : 동기 + async + fetch 요청 + try/catch/finally

*/

import { useEffect, useState } from "react"

// 전체 200 중 10개만 요청
const BASE_URL = 'http://localhost:8085/api/customers'


const Snippet10_1c = () => {

    //state 선언
    const [list,        setList      ] = useState([])      // API 응답 데이터
    const [loading,     setLoading   ] = useState(true)    // 초기값 true --> 마운트 즉시 스피너
    const [error,       setError     ] = useState(null)    // 초기 데이터 로딩 에러 
    const [editingId,   setEditingId ] = useState(null)    // null --> 편집 중인 항목 없음  
    const [inputValue,  setInputValue] = useState('') 
    const [saveError,   setSaveError]  = useState(null)    // PATCH 저장 에러  
    
    //초기 데이터 패칭
    //GET  /api/customers -> CustomerResponseDto
    useEffect(() => {
        const fetchList = async () => {
            try{
                setLoading(true)    // 요청 시작 -> 스피너 표시 
                const res = await fetch(BASE_URL)    // API 서버에 HTTP GET 요청 - 응답이 올때까지 다음 줄로 넘어가지 않음
                if(!res.ok) throw new Error(`서버 오류: ${res.status}`)
                const data = await res.json()  // HTTP 응답 body (JSON 문자열) -> JS 배열로 파싱 
                setList(data)
            } catch (err) {
                setError(err.message)
            } finally {
                setLoading(false)
            }
        }
        fetchList()
    }, [])      // [] : 마운트 시 1번만 실행 

    // 편집 핸들러 (편집 모드 진입)
    const handleEdit = (item) => {
        setSaveError(null)    // 이전 저장 에러 초기화
        setEditingId(item.id)
        setInputValue(item.customerName)  // 기존 이름을 input에 미리 채움
    }

    // 저장
    /*
        10_1a : 동기 함수 (메모리만 변경)
        10_1b : async 함수 -> 서버 PATCH -> 성공 시 setList (서버 + 메모리 동시 변경)
                서버 성공 확인 후 setList 호출 -> DB와 화면 동기화 보장
    */
    const handleSave = async (id) => {
        if (!inputValue.trim()) return

        try {
            const target = list.find((item) => item.id === id)
            const res = await fetch(`${BASE_URL}/${id}`, {
                method: 'PATCH',
                headers: {'Content-Type': 'application/json'},
                body: JSON.stringify({  // JS 객체 -> JSON 문자열 변환. 
                    customerName: inputValue,       // 수정할 이름 (새 값)
                    age: target.age,                // 기존 나이 유지
                    occupation: target.occupation,   // 기존 직업 유지
                    email: target.email,             // 기존 이메일 유지
                    phone: target.phone,            // 기존 전화번호 유지
                    }),  
            })
            if(!res.ok) throw new Error(`저장 실패: ${res.status}`)
            
            const updated = res.json();  // HTTP 응답 body (JSON 문자열) -> JS 객체로 파싱. 서버가 저장후 반환한 최신 CustomerResponseDto              

            // 해당 항목만 customerName 교체, 나머지 필드 유지 // 다른 항목은 원본 그대로
            setList((prev) => 
                prev.map((item) => item.id === id ? updated : item)
            )
            setSaveError(null)                
        } catch (err) {
            setSaveError(err.message)                   // 서버 수정 실패 (state는 변경 안함)
        } finally {
            setEditingId(null)
            setInputValue('')
        }

    }

    // 취소
    const handleCancel = () => {
        setSaveError(null)
        setEditingId(null)
        setInputValue('')        
    }

    // 삭제
    const handleDelete = async (id) => {
        if (!window.confirm('정말 삭제하시겠습니까?')) return 

        try {
            const res = await fetch(`${BASE_URL}/${id}`, {
                method: 'DELETE',})      // 리소스 삭제 요청 - body 없음
            
            if (!res.ok) throw new Error(`삭제 실패: ${res.status}`)   
            // filter : 조건이 true인 항목만 남김 -> id 가 다른 항목만 유지 = 해당 항목 제거    
            setList((prev) => prev.filter((item) => item.id !== id))                

        } catch (err) {
            setSaveError(err.message)
        }
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
                    회원 목록 ({list.length}명)
                </h2>

                {saveError && (
                    <div className="mb-3 p-3 bg-red-50 border border-red-200 rounded-lg text-red-600 text-sm">
                        저장 중 오류가 발생했습니다: {saveError}
                    </div>
                )}

                <ul className="space-y-2">
                    {list.map((item) => (
                        <CustomerItem 
                            key={item.id}
                            item={item}
                            isEditing={editingId === item.id}
                            inputValue={inputValue}
                            onEdit={handleEdit}
                            onSave={handleSave}
                            onCancel={handleCancel}
                            onDelete={handleDelete}     // 삭제 핸들러 전담
                            onInputChange={(e) => setInputValue(e.target.value)}
                        />
                    ))
                    }
                </ul>
            </div>
        
        </>
    )
}

// 자식 컴포넌트 
const CustomerItem = ({ item, isEditing, inputValue, onEdit, onSave, onCancel, onDelete,  onInputChange }) => {

    // 등급별 배지 색상
    const ratingColor = {
        BRONZE:     'bg-amber-100 text-amber-700',
        SILVER:     'bg-gray-100 text-gray-600',
        GOLD:       'bg-yellow-100 text-yellow-700',
        PLATINUM:   'bg-blue-100 text-blue-700',
        VIP:        'bg-purple-100 text-purple-700',
    }

    return (
        <>
            <li className="flex items-center gap-2 p-3 border border-gray-200 rounded-lg hover:bg-gray-50 transition-colors">
                {isEditing ? (
                    // 편집 모드
                    <>
                        <input 
                            type="text" value={inputValue} onChange={onInputChange}
                            autoFocus onKeyDown={(e) => {
                                if(e.key === 'Enter') onSave(item.id)   // 저장
                                if(e.key === 'Escape') onCancel()       // 취소           
                            }}
                            className="flex-1 border border-blue-300 rounded px-2 py-1 text-sm outline-none focus:border-blue-500"  
                        />
                        <button 
                            onClick={() => onSave(item.id)}
                            className="px-3 py-1 bg-blue-500 text-white text-sm rounded hover:bg-blue-600">저장</button>
                        <button
                            onClick={onCancel}
                            className="px-3 py-1 text-sm rounded hover:bg-gray-100">취소</button>
                    </>
                ) : (
                    // 읽기 모드
                    <>
                        <span className={`text-xs px-2 py-0.5 rounded-full font-medium shrink-0 ${ratingColor[item.rating]}`}>
                            {item.rating}
                        </span>
                        <div className="flex-1 min-w-0">
                            <div>
                                <span className="text-sm font-medium">{item.customerName}</span>
                                <span className="text-xs text-gray-400 ml-2">{item.username}</span>
                            </div>
                            {(item.email || item.phone) && (
                                <div className="text-xs text-gray-400 mt-0.5">
                                    {item.email && <span>{item.email}</span>}
                                    {item.phone && <span>{item.phone}</span>}                             
                                </div>
                            )}
                        </div>
                        <span className="text-xs text-gray-400 shrink-0">{item.age}세</span>
                        <button
                            onClick={() => onEdit(item)}
                            className="px-3 py-1 text-sm rounded hover:bg-gray-100 shrink-0">편집</button>
                        <button
                            onClick={() => onDelete(item.id)}
                            className="px-3 py-1 text-sm rounded text-red-400 hover:bg-red-50 hover:text-red-600 shrink-0">삭제</button>

                     </>
                )

                }
            </li>
        </>
    )
}

export default Snippet10_1c