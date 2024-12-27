import {Routes, Route} from 'react-router-dom';
import RegisterForm from "../src/components/SignUpModal";
import LoginForm from './components/LoginFormModal/LoginForm';
import HomePage from './components/HomePage/HomePage';

function App() {
  return (
      <Routes>
        <Route path='/' element={<HomePage />} />
        <Route path='/register' element={< RegisterForm/>} />
        <Route path="/login" element={<LoginForm/>} />
      </Routes>
  );
}

export default App;
