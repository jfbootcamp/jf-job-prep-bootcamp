import './App.css'
import Header from './components/Header'
import Slider from './components/Slider'
import Main from './components/Main'
import Footer from './components/Footer'

function App() {

  return (
    <>
      <Header />
      {/* Slider 컴포넌트에 style을 props로 전달, 부모(App)가 자식(Slider)에게 스타일을 택배로 보내는것 */}
      <Slider style={{width:"100%", color:"white", height:"200px", backgroundColor:"gold"}} />
      <Main />
      <Footer></Footer>
    </>
  )
}

export default App
