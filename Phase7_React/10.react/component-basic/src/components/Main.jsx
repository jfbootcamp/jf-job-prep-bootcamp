// 자식 컴포넌트 불러오기
import Dog from '../Dog.jsx'
import Cow from './Cow.jsx'

const Main = () => {

    // 스타일 변수에 미리 담아두기 (props 없이 컴포넌트 내부에서 직접 정의)
    const style2 = {
        width: '100%',
        height: '200px',
        backgroundColor: 'skyblue',
        color: '#fff'
    }

    return (
        // style2 변수를 중괄호로 감싸서 div에 적용
        <div style={style2}>
            메인  
            {/* 자식 컴포넌트 배치: Main안에 Dog와 Cow를 품고 있음 */}          
            <Dog></Dog>    
            <Cow />
        </div>
    )
}

export default Main 