
import { useEffect, useState } from 'react';
import customerList from './../customerList';
/*
    Snippet9_2 : 데이터를 useState 초기값에 직접 넣음 (정적)
    Snippet9_2a : 데이터를 API에서 받아옴 (동적) <-- 실무 패턴

    랜더링 흐름
        1) useState([])  -> customerList = [] (빈 배열)
        2) 첫 랜더        -> 빈 테이블 화면에 출력
        3) useEffect 실행  -> fetch로 API 호출 
        4) .then(data => ...)   -> 응답 데이터를 state에 저장 
        5) 리랜더           -> customerList = [10개] --> 테이블 채워짐 
*/

const Snippet9_2a = () => {

    // 초기값 [] -- API 응답 전까지 빈 테이블 유지 
    // 응답이 오면 setCustomerList로 채워짐 (리랜더 발생)
    const [customerList, setCustomerList] = useState([])

    useEffect(() => {
        fetch('https://jsonplaceholder.typicode.com/users') // 무료 테스트 API (실제 서버 URL로 교체)
        .then(res => res.json())                            // HTTP 응답 --> json으로 파싱
        .then(data => setCustomerList(data))                // 파싱된 배열을 state 에 저장 --> 리랜더 발생
    }, [])                                                  // 마운트시 딱 1번만 실행됨. 루프를 막을 수 있음

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

export default Snippet9_2a