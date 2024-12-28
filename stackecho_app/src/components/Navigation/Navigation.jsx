import { NavLink } from "react-router-dom";
import  RegisterForm  from "../SignUpModal";
import  LoginForm  from "../LoginFormModal";

function Navigation () {
    return (
        <nav id ='nav-container'>
            <div id='home'>
                <button id='home-button'>
                    <NavLink to='/'> Home </NavLink>
                </button>
            </div>

            <div id='login-register-buttons'>
                <div>
                    <LoginForm/>
                    <RegisterForm/>
                </div>
            </div>
        </nav>
    )
}

export default Navigation;