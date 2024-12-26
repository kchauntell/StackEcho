import React, { useState } from "react";
import { useNavigate } from 'react-router-dom';
import UserDataService from "../../Service/UserDataService";
import './RegisterForm.css'


function RegisterForm() {
    const navigate = useNavigate();
    const [firstname, setFirstname] = useState('');
    const [lastname, setLastname] = useState('');
    const [username, setUsername] = useState('');
    const [email, setEmail] = useState('');
    const [passwordHash, setPasswordHash] = useState('');
    const [confirmPassword, setConfirmPassword] = useState('');


    const handleSubmit = (e) => {

        e.preventDefault();
        if (passwordHash === confirmPassword) {
            UserDataService.createUser({
                username,
                firstname,
                lastname,
                email,
                passwordHash
            });
            return navigate("/")
        } else {
            return "Passwords Do Not Match"
        }
    }


    return (
        <form id='SignUpForm' onSubmit={handleSubmit}>
            <div id='SignUpModal'>
            <div>
                    <label>
                        Username:
                        <input
                        type="text"
                        value={username}
                        onChange={(e) => setUsername(e.target.value)}
                        required
                        />
                    </label>
                </div>
                <div>
                    <label>
                        First Name:
                        <input
                        type="text"
                        value={firstname}
                        onChange={(e) => setFirstname(e.target.value)}
                        required
                        />
                    </label>
                </div>
                <div>
                    <label>
                        Last Name:
                        <input
                        type="text"
                        value={lastname}
                        onChange={(e) => setLastname(e.target.value)}
                        required
                        />
                    </label>
                </div>
                <div>
                    <label>
                        Email:
                        <input
                        type="text"
                        value={email}
                        onChange={(e) => setEmail(e.target.value)}
                        required
                        />
                    </label>
                </div>
                <div>
                    <label>
                        Password:
                        <input
                        type="password"
                        value={passwordHash}
                        onChange={(e) => setPasswordHash(e.target.value)}
                        required
                        />
                    </label>
                </div>
                <div>
                    <label>
                        Confirm Password:
                        <input
                        type="password"
                        value={confirmPassword}
                        onChange={(e) => setConfirmPassword(e.target.value)}
                        required
                        />
                    </label>
                </div>
                <div id='SignupButtonDiv'>
                    <button
                        type="submit">Sign Up
                    </button>
                </div>
            </div>
        </form>
    )
    
}

export default RegisterForm;