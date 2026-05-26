const Snippet8_1 = () => {

    // 랜더링할 과일 목록 배열
    const fruit = ['딸기', '수박', '토마토'];

    return (
        <>
            <div>
                <ul>
                    {
                        fruit.map((link) => (
                            <li>{link}</li>
                        ))
                    }
                </ul>
            </div>
        </>
    )
}

export default Snippet8_1;