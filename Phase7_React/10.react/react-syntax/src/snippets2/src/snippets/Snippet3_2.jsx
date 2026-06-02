const Snippet3_2 = () => {
    const loginName = "신사임당1"

    return(
        <>
            {loginName === "신사임당" ? <div>신사임당</div> : <div>비회원 입니다.</div>}
        </>
    );
}

export default Snippet3_2;