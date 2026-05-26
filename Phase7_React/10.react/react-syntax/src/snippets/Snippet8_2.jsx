import { useState } from "react";

const Snippet8_2 = () => {

    let [title, setTitle] = useState(['경기도', '강원도', '제주도']);

    return (
        <>
            <div>
                {/* map(callback(region)) : 배열의 각 요소마다 callback을 실행해 새 배열을 반환 */ }
                {   
                    title.map(function(region) {
                        return (
                            <div className="p-4 mb-2 border rounded-lg shadow-sm bg-white hover:bg-green-100">
                                <h4>{region}</h4>
                            </div>
                        )
                    })
                }
            </div>
        </>
    )
}

export default Snippet8_2;