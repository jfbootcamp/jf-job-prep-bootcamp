import { useEffect, useState } from "react"

/*
    useEffect([keyword]) 의존성 값 패턴 

    Snippet9_2b : useEffect(fn, [])         -> 마운트 시 1번, 고정 URL
    Snippet9_2c : useEffect(fn, [keyword])  -> keyword 바뀔 때마다, 동적 URL

    실행 흐름
        input 입력 --> setKeyword -> 리랜더
        -> 값이 바뀌었으면 effect 재실행 -> 새 keyword 로 fetch
    실무 사용
        - 검색창, 자동완성, 페이지네이션..    
*/
const Snippet9_2c = () => {

    const [keyword, setKeyword] = useState('')    // 검색어 - input 값과 1:1 동기화
    const [postList, setPostList] = useState([])   // 검색 결과 목록
    const [loading, setLoading] = useState(false)  // 첫 랜더 시 검색어가 없어 로딩 상태 불필요
    const [error, setError] = useState(null)

    useEffect(() => {

        //검색어가 비어있으면 결과를 초기화하고 fetch 하지 않음
        if (!keyword.trim()) {
            setPostList([])
            return
        }

        const fetchPosts = async () => {
            try {
                setLoading(true)
                setError(null)

                const res = await fetch(
                    `https://jsonplaceholder.typicode.com/posts?q=${keyword}&_limit=5`
                )
                // fetch는 404, 500 응답도 에러로 처리하지 않음 
                if(!res.ok) throw new Error(`서버 오류: ${res.status}`)

                const data = await res.json()    
                setPostList(data)

            } catch (err) {
                setError(err.message)  //  에러 메시지를 state에 저장 -> 화면에 표시                     
            } finally {
                setLoading(false)      // 성공,실패 무관하게 반드시 로딩 종료
            }
        }

        fetchPosts()

    }, [keyword])    // keyword가 바뀔때마다 재실행 -> 실시간 검색 가능


    return (
        <>
            <div className="mb-4">
                <input type="text" value={keyword} 
                onChange={(e) => setKeyword(e.target.value)}
                placeholder="검색어를 입력하세요..."
                className="w-full border border-gray-300 rounded px-3 py-2 outline-none 
                           focus:border-blue-400" />
            
                {keyword && (
                    <p className="text-xs text-gray-400 mt-1">
                        &ldquo;{keyword}&rdquo; 검색 결과</p>
                )}

                {loading && (
                    <div className="flex items-center gap-2 text-gray-400 text-sm">
                        <div className="w-4 h-4 border-2 border-gray-300 border-t-blue-500 animate-spin" />
                        <span>검색 중...</span>                            
                    </div>
                )}

                {error && (
                    <div className="p-3 bg-red-50 border border-red-200 rounded 
                                    text-red-600 text-sm">
                        {error}
                    </div>
                )}

                {/** 초기 안내 - 검색어가 없을 때만 표시 */}
                {!keyword && (
                    <p className="text-gray-400 text-sm">검색어를 입력하면 결과가 나타납니다.</p>
                )}

                {/** 결과 목록 - 로딩이 끝났고 결과가 1개 이상일때만 랜더링 */}
                {!loading && postList.length > 0 && (
                    <ul className="space-y-2">
                        {postList.map((post) => (
                            <li key={post.id}
                                className="p-3 border border-gray-200 rounded-lg text-sm hover:bg-gray-50 
                                            transition-colors"
                            >
                                <p className="font-medium text-gray-800 mb-1">{post.title}</p>       
                                <p className="text-gray-500 text-xs">{post.body}</p>
                            </li>
                        ))}
                    </ul>
                )}

                {/** 결과 없음 - 아래 조건이 모두 참일때만 표시
                 *    !loading, keyword,  length ===0, !error      
                 */}
                {!loading && keyword && postList.length === 0 && !error && (
                    <p className="text-gray-400 text-sm"
                    >&ldquo;{keyword}&rdquo; 에 대한 결과가 없습니다.</p>
                )}

            </div>
        </>
    )
}

export default Snippet9_2c