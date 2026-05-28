/*
import customerList from './../customerList';
    Snippet9_2b - async/await + loading/error state 

    
    Snippet9_2a             Snippet9_2b
    -----------------------------------------
    .then 체인                  async/await
    fetch().then().then()      await fetch()
    에러 처리 없음                try/catch/finally 
    loading/error state없음        있음 (UX 완성)


    state 구조 
        customerList            []          API 응답 데이터 배열
        loading                 true        요청 진행 중 여부 (초기값 true)
        error                   null        에러 메시지 문자열 (없으면 null)

*/

import { useEffect, useState } from "react";

const Snippet9_2b = () => {

    // state 선언
    const [customerList, setCustomerList] = useState([])
    const [loading, setLoading] = useState(true)
    const [error, setError] = useState(null)

    useEffect(() => {
        const fetchData = async () => {
            try {
                const res = await fetch('https://jsonplaceholder.typicode.com/users')
                if (!res.ok) throw new Error(`서버 오류: ${res.status}`)

                const data = await res.json()       // HTTP 응답 본문 -> JS 배열로 변환(비동기)        
                setCustomerList(data)               // 데이터 저장 -> 리렌더 예약 

            } catch(err) {
                setError(err)    
            } finally {
                setLoading(false)
            }
        }

        fetchData()
    }, [])    // 빈 배열: 의존성 없음, 마운트 시 딱 1번만 실행, 이후 리랜더에서는 재실행되지 않음

    if(loading) {   // loading = true면  스피너를 반환하고 함수가 즉시 종료
        return (
            <div className="flex items-center gap-3 p-6 text-gray-500">
                <div className="w-5 h-5 border-2 border-gray-300 border-t-blue-500"></div>                    
                <span>고객 목록을 불러오는 중입니다....</span>
            </div>
        )
    }

    if(error) {   // 여기까지 도달했다는것은 loading = false, error가 있으면 에러 박스 반환하고 함수 즉시 종료   
        return(
            <div className="m-4 p-4 bg-red-50 border border-red-200 rounded-lg">
                <p className="text-red-700 font-medium mb-1">데이터를 불러오지 못했습니다.</p>                    
                <p className="text-red-500 text-sm">{error}</p>
            </div>
        )
    }

    // 여기까지 왔다는것은 loading=false, error=null이라는 의미임. 데이터 로딩 성공적 완료상태임
    return (
        <>
            <div className='overflow-x-auto p-4'>
                <table className="w-full border-collapse text-sm">
                    <thead className="bg-gray-100 text-gray-700">
                        <tr>
                            <th className="px-4 py-2 text-left border border-gray-300">이름</th>
                            <th className="px-4 py-2 text-left border border-gray-300">주소</th>
                            <th className="px-4 py-2 text-left border border-gray-300">전화</th>
                        </tr>
                    </thead>
                    <tbody>
                        {customerList.map((row, idx) => (
                            <tr key={idx} className="hover:bg-gray-50 transition-colors">
                                <td className="px-4 py-2 border border-gray-300">{row.name}</td>  
                                <td className="px-4 py-2 border border-gray-300">{row.address?.city}</td>
                                <td className="px-4 py-2 border border-gray-300">{row.phone}</td>                                  
                            </tr>                                
                        ))}
                    </tbody>
                </table>
            </div>
        </>
    )
}

export default Snippet9_2b;