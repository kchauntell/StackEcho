import axios from 'axios';

const API_URL = "http://localhost:8080/api";
const headers = {
    "Content-Type": "application/json",
    "Acceptd": "application/json"
}

class UserDataService {
    retrieveAllUser = async() => {
        const response = await axios.get(`${API_URL}`);
        return response.data;
    }

    createUser = async(user) => {
        const response = await axios.post(`${API_URL}/create_user`, user);
        return response.data;
    }

    updateUser(user) {
        return axios.put(`${API_URL}/edit_user`, user);
    }

    deleteUser(user) {
        return axios.post(`${API_URL}/remove_user`,user);
    }

    userLogin(username, password) {
        return axios.post(`${API_URL}/login`, {headers},username,password)
    }
}

export default new UserDataService();