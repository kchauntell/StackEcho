import {Routes, Route} from 'react-router-dom';
import RegisterForm from "../src/components/SignUpModal";
import LoginForm from './components/LoginFormModal/LoginForm';

function App() {
  return (
      <Routes>
        <Route path='/' element={<h1>Hello World!</h1>}></Route>
        <Route path='/register' element={< RegisterForm/>} />
        <Route path="/login" element={<LoginForm/>} />
      </Routes>
  );
}

export default App;
