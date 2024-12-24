import axios from 'axios';

const API_URL = "http://localhost8080/api";

class UserDataService {
    retrieveAllUser = async() => {
        const response = await axios.get(`${API_URL}`);
        return response.data;
    }

    createUser(user) {
        return axios.post(`${API_URL}/create_user`, user);
    }

    updateUser(user) {
        return axios.put(`${API_URL}/edit_user`, user);
    }

    deleteUser(user) {
        return axios.post(`${API_URL}/remove_user`,user);
    }

    userLogin(username, password) {
        return axios.post("http://localhost8080:/api/login",username,password)
    }
}

export default new UserDataService();