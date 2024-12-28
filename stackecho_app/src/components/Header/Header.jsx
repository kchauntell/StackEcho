import './Header.css';
import Navigation from "../Navigation/Navigation";

function Header() {
    return (
        <div id='header-container'>
            <Navigation />
            <h1>
                Welcome to StackEcho
            </h1>
        </div>
    )
}

export default Header;