import { useState } from "react"
import customerList from "../customerList"

const Snippet9_3 = () => {
    
    // 폼 입력값 전체를 객체 하나로 관리 - 입력 필드가 3개여도 state는 1개
    const [list, setlist] = useState(customerList)

    return (
        <>
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