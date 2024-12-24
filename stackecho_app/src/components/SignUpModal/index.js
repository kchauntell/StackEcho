import React, { useState } from "react";
import Modal from "../../context/Modal";
import RegisterForm from "./RegisterForm";

function SignUpModal() {
    const [showModal, setShowModal] = useState(false);

    return (
        <>
            <button onClick={() => setShowModal(true)}> Register</button>
            {showModal && (
                <Modal onClose={()=> setShowModal(false)}>
                    <RegisterForm />
                </Modal>
            )}
        </>
    )
}

export default SignUpModal;