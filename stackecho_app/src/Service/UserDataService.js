import axios from 'axios';

class UserDataService {
    retrieveAllUser() {
        return axios.get("http://localhost:8080/api")
    }

    createUser(user) {
        return axios.post("http:localhost:8080/api/create_user", user);
    }

    updateUser(user) {
        return axios.put("http://localhost:8080/api/edit_user", user);
    }

    deleteUser(user) {
        return axios.post("http:localhost:8080/api/remove_user");
    }

    userLogin(username, password) {
        return axios.post("http://localhost8080:/api/login",username,password)
    }
}

export default new UserDataService();