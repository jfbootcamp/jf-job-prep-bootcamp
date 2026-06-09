import { useEffect, useState } from "react"

/*
    개발: http://localhost:8083 (Vite: 5173 <=> Spring:8083)
    배포: 빈 문자열 -> 상대경로 (React가 Spring static/에서 서빙)
*/
const BASE_URL = import.meta.env.VITE_API_URL ?? ''

const Snippet11 = () => {

    //state 선언
    const [bookList,        setBookList     ]   = useState([])          // 도서목록
    const [selectedId,      setSelectedId   ]   = useState('')          // select에서 선택된 bookId (업로드 대상)
    const [uploading,       setUploading    ]   = useState(false)       // 업로드 진행 중
    const [uploadResult,    setUploadResult ]   = useState(null)        // SUCCESS, ERROR
    const [previewId,       setPreviewId  ]   = useState([])          //   업로드 완료 후 미리보기용 imageId


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
        const files = e.target.files                //input에서 선택된 파일 목록 
        if (!files || files.length === 0) return    //파일 없으면 early return
        if (!selectedId) { alert('도서를 먼저 선택하세요.'); return}

        const formData = new FormData()     // 브라우저 내장 web API
        Array.from(files).forEach(file => formData.append('files', file))

        try {
            setUploading(true)      // 업로드 시작 - input 비활성화, 스피너 표시
            setUploadResult(null)   // 이전 결과 초기화 

            const res = await fetch(`${BASE_URL}/books/${selectedId}/images?type=1`, {
                method: 'POST',         // 파일 전송은 반드시 POST
                body: formData,         // FormData 객체 -> 브라우저가 multipart/form-data로 자동 변환
            })
            if(!res.ok) throw new Error(`업로드 실패: ${res.status}`)   // 4xx/5xx -> catch로 이동

            const data = await res.json()
            /**
             *  [
             *      "SUCCESS": ["photo.jpg"],
             *      "ERROR": []
             *  ]
             * 
             */
            const result = data[0]
            setUploadResult(result)     // 결과 state 저장 -> 성공/실패 메시지 랜더링

            if(result.SUCCESS?.length > 0) {
                //미리보기 <img src>
                const imgRes = await fetch(`${BASE_URL}/api/books/${selectedId}/images`) // GET: imageId 목록
                const imgData = await imgRes.json()             // [{imageId: 1}, ...]
                setPreviewId(imgData[imgData.length-1]?.imageId ?? null)
            }

        } catch(err) {
            setUploadResult({ SUCCESS: [], ERROR: [err.message]})

        } finally {
            setUploading(false) // 성공/실패 무관하게 업로드 상태 해제
            e.target.value = '' // input 초기화 
        }
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
                <label className={
                    uploading
                    ? `flex items-center justify-center gap-2 w-full py-4 border-2 border-dashed rounded-lg cursor-not-allowed border-gray-300 bg-gray-50`
                    : `flex items-center justify-center gap-2 w-full py-4 border-2 border-dashed rounded-lg cursor-pointer border-blue-300 bg-white hover:bg-blue-50`
                }>
                    {uploading ? (
                        <span className="text-sm text-gray-400">업로드 중...</span>
                    ) : (
                        <>
                            <span>📂</span>
                            <span className="text-sm text-blue-600">이미지 선택 (다중 가능)</span>
                        </>
                    )}
                    <input
                        type="file"
                        accept="image/*"        // 이미지 파일만 선택 가능하도록 제한
                        multiple                // 여러 파일 동시 선택 허용
                        disabled={uploading}    // 업로드 중 추가 선택 차단 
                        onChange={handleUpload} // 파일 선택 즉시 업로드 시작
                        className="hidden"      // input 숨김 -> label이 클릭 이벤트 처리
                        />
                </label>

                {/* 업로드 결과 */}        
                {uploadResult && (
                    <div className="mt-3 space-y-1 text-xs">
                        {uploadResult.SUCCESS?.length > 0 && (
                            <div className="p-2 bg-green-50 border border-green-200 rounded text-green-700">
                               ✅ 성공: {uploadResult.SUCCESS.join(', ')}     
                            </div>
                        )}
                        {uploadResult.ERROR?.length > 0 && (
                            <div className="p-2 bg-red-50 border border-red-200 rounded text-red-600">
                                ❌ 실패: {uploadResult.ERROR.join(', ')}
                            </div>
                        )}                            
                    </div>
                )}
                {/* 업로드된 이미지 미리보기 */} 
                {previewId && (
                    <div className="mt-4">
                        <p className="text-xs text-gray-400 mb-1">미리보기 (imageId: {previewId})</p>
                        <img 
                            src={`${BASE_URL}/books/${previewId}/imageSrc`}
                            alt="업로드 이미지"
                            className="w-full rounded border border-gray-200 object-cover"
                        />
                    </div>
                )}
            </div>
        </>
    )
}

export default Snippet11