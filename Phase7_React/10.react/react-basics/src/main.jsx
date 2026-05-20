// React 핵심 기능 중 StrictMode(엄격 모드) 가져오기
import { StrictMode } from 'react'
// 실제 HTML에 React 앱을 그려주는 도구 가져오기
import { createRoot } from 'react-dom/client'
// 전체 앱에 적용할 CSS 스타일 가져오기
import './index.css'
// 우리가 만든 최상위 컴포넌트 가져오기 
import App from './App.jsx'

// index.html의 <div id="root">를 찾아서 React 앱을 그려넣기
createRoot(document.getElementById('root')).render(
  // StrictMode : 개발 중 잠재적 문제를 미리 경고해주는 감시자 역할
  <StrictMode>
    {/* 우리 앱의 시작점 : 모든 컴포넌트는 App 안에서 시작됨 */}
    <App /> 
  </StrictMode>,
)
