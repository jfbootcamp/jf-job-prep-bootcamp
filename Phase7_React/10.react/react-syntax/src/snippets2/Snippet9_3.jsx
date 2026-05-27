import { useState } from "react"

const Snippet9_3 = () => {

    // 테이블에 표시할 고객 목록 - 객체 배열 {name,address,phone}
    // 실무에서는 초기값 []로 선언 후 useEffect +  fetch 로 채움
    const [customerList, setCustomerList] = useState([
        { name: "이순신", address: "서울시", phone: "010-0000-0000"},
        { name: "신사임당", address: "제주시", phone: "010-0000-0000"},
        { name: "이방원", address: "강원도", phone: "010-0000-0000"},
        { name: "정몽구", address: "경기도", phone: "010-0000-0000"},
    ])
    
    // 폼 입력값 전체를 객체 하나로 관리 - 입력 필드가 3개여도 state는 1개
    const [customer, setCustomer] = useState({name: '', address: '', phone: ''})

    const handleChange = (e) => {
        const {name, value} = e.target   // e.target = 이벤트가 발생한 input 요소
        setCustomer((prevState) => ({...prevState, [name]: value}))            
    }

    // 목록 맨 앞에 추가 - 추가 후 폼 초기화 
    const handleCommit = () => {
        if (!customer.name.trim()) return       // " " 만 입력한 경우도 막음

        setCustomerList((prevState) => [customer, ...prevState])  // 새 항목을 맨 앞에 추가
        setCustomer({name: '', address: '', phone: ''})  // 세 필드를 빈 값으로 리셋
    }



    return (
        <>
            <div className="flex gap-2 mb-4">
                <input 
                    type="text" name="name" value={customer.name}
                    onChange={handleChange} placeholder="이름"
                    className="border border-gray-300 rounded px-3 py-1 outline-none 
                                    focus:border-blue-400"      
                />
                <input 
                    type="text" name="address" value={customer.address}
                    onChange={handleChange} placeholder="주소"
                    className="border border-gray-300 rounded px-3 py-1 outline-none 
                                    focus:border-blue-400"      
                />    
                <input 
                    type="text" name="phone" value={customer.phone}
                    onChange={handleChange} placeholder="전화"
                    className="border border-gray-300 rounded px-3 py-1 outline-none 
                                    focus:border-blue-400"      
                />  
                <button onClick={handleCommit}
                    className="px-4 py-1 bg-blue-500 text-white rounded hover:bg-blue-600">
                    추가
                </button>                            
            </div>

            <div className="overflow-x-auto">
                <table className="w-full border-collapse text-sm">
                    <thead className="bg-gray-100 text-gray-700">
                        <tr>
                            <th className="px-4 py-2 text-left border border-gray-300">이름</th>
                            <th className="px-4 py-2 text-left border border-gray-300">주소</th>
                            <th className="px-4 py-2 text-left border border-gray-300">전화</th>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            customerList.map((row, idx) => (
                                <tr key={idx} className="hover:bg-gray-50 transition-colors">
                                  <td className="px-4 py-2 border border-gray-300">{row.name}</td>
                                  <td className="px-4 py-2 border border-gray-300">{row.address}</td>
                                  <td className="px-4 py-2 border border-gray-300">{row.phone}</td>          
                                </tr>
                            ))
                        }
                    </tbody>
                </table>
            </div>
        </>
    )
}

export default Snippet9_3