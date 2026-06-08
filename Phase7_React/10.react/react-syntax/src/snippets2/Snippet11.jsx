import { useEffect, useState } from "react"

const BASE_URL = 'http://localhost:8083'

const Snippet11 = () => {

    //state 선언
    const [bookList,        setBookList     ]   = useState([])          // 도서목록
    const [selectedId,      setSelectedId   ]   = useState('')          // select에서 선택된 bookId (업로드 대상)
    const [uploading,       setUploading    ]   = useState(false)       // 업로드 진행 중
    const [uploadResult,    setUploadResult ]   = useState(null)        // SUCCESS, ERROR
    const [previewList,     setPreviewList  ]   = useState([])          // 미리보기 imageId 배열


    // 도서 목록 패칭 
    useEffect(() => {
        const fetchBooks = async () => {
            try {
                const res = await fetch(`${BASE_URL}/api/books`)    // GET /api/books
                if (!res.ok) throw new Error(`서버 오류: ${res.status}`)
                const data = await res.json()       // JSON 파싱                    
                setBookList(data)                   // state 업데이트 
            } catch (err) {
                console.error('도서 목록 조회 실패: ', err)         // UI 변경 없이 콘솔 출력
            } 
        }
        fetchBooks()    // useEffect안에서 async 직접 호출 불가 -> 내부 함수 선언 후 호출
    }, [])  // [] : 마운트 시 1회만 실행

    // 파일 업로드
    const handleUpload = async (e) => {

    }

    return (
        <>
            <div className="p-6 max-w-md">
                <h2 className="text-base font-semibold text-gray-700 mb-4">
                    파일 업로드 
                </h2>

                <select
                    value={selectedId ?? ''}
                    onChange={e => setSelectedId(e.target.value)}
                    className="w-full border border-gray-300 rounded px-3 py-2 text-sm mb-4"
                >
                    <option value="">--도서 선택--</option>
                    {bookList.map(book => (
                        <option key={book.id} value={book.id}>{book.subject}</option>
                    ))}
                </select>
                
                {/** 파일 선택 영역 */}
                <label className="">
                    <input
                        type="file"
                        accept="image/*"        // 이미지 파일만 선택 가능하도록 제한
                        multiple                // 여러 파일 동시 선택 허용
                        disabled={uploading}    // 업로드 중 추가 선택 차단 
                        onChange={handleUpload} // 파일 선택 즉시 업로드 시작
                        className="hidden"      // input 숨김 -> label이 클릭 이벤트 처리
                        />
                </label>
            </div>
        </>
    )
}

export default Snippet11