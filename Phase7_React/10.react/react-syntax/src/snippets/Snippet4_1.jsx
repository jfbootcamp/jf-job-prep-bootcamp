const Snippet4_1 = () => {

    // 스타일링 객체로 미리 정의
    // CSS와 다른점 : 속성명 camelCase로 작성
    // 핵심규칙 : -(하이픈)을 없애고 다음 글자를 대문자로 바꾸면 JSX 속성명이 됨

    const testStyle = {
        backgroundColor: '#4A90E2',
        fontSize: '24px',
        fontWeight: 'bold',
        color: '#ffffff',
        padding: '20px 40px',
        borderRadius: '12px',
        boxShadow: '0 4px 8px rgba(0,0,0,0.2)',
        textAlign: 'center',
        letterSpacing: '2px',
        width: 'fit-content'
    }

    return (
        <div style={testStyle}>Hello, React</div>
    );
};

export default Snippet4_1;