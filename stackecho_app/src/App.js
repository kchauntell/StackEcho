import {Routes, Route} from 'react-router-dom';
import RegisterForm from "../src/components/SignUpModal";

function App() {
  return (
    <>
      <Routes>
        <Route path='/' element={<h1>Hello World!</h1>}></Route>
        <Route exact path='/register' element={< RegisterForm/>} />
      </Routes>
    </>
  );
}

export default App;
