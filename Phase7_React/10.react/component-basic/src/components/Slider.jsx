// props: 부모(App)가 보낸 택배를 받는 매개변수
const Slider = (props) => {
    return (
        // props로 전달받은 style을 div에 그대로 적용
        <div style={props.style}>
            슬라이더
        </div>
    )
}

export default Slider 