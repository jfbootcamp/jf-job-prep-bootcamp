import { useState } from "react";

const Snippet9_2 = () => {

    const [customerList, setCustomerList] = useState([
        { name: "이순신", address: "서울시", phone: "010-0000-0000"},
        { name: "신사임당", address: "제주시", phone: "010-0000-0000"},
        { name: "이방원", address: "강원도", phone: "010-0000-0000"},
        { name: "정몽구", address: "경기도", phone: "010-0000-0000"},
    ])

    return (
        <>
            <div className="overflow-x auto p-4">
                <table className="w-full border-collapse text-sm">
                    <thead className="bg-gray-100 text-gray-700">
                        <tr>
                            <th className="px-4 py-2 text-left border border-gray-300">이름</th>
                            <th className="px-4 py-2 text-left border border-gray-300">주소</th>
                            <th className="px-4 py-2 text-left border border-gray-300">전화</th>
                        </tr>
                    </thead>
                    <tbody>
                        {customerList.map((element, idx) => (
                            <tr key={idx} className="hover:bg-gray-50 transition-colors">
                                <td className="px-4 py-2 border border-gray-300">{element.name}</td>  
                                <td className="px-4 py-2 border border-gray-300">{element.address}</td>
                                <td className="px-4 py-2 border border-gray-300">{element.phone}</td>                                  
                            </tr>
                        ))}
                    </tbody>

                </table>
            </div>
        </>
    )
}

export default Snippet9_2;