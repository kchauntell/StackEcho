import {Routes, Route} from 'react-router-dom';
import RegisterForm from "../src/components/SignUpModal";
import LoginForm from './components/LoginFormModal/LoginForm';
import HomePage from './components/HomePage/HomePage';
import Header from './components/Header/Header';
import Footer from './components/Footer/Footer';

function App() {
  return (
    <>
      <Header />
        <Routes>
          <Route path='/' element={<HomePage />} />
          <Route path='/register' element={< RegisterForm/>} />
          <Route path="/login" element={<LoginForm/>} />
        </Routes>
      <Footer />
    </>
  );
}

export default App;
