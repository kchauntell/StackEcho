import React, { useState, useEffect } from "react";
// import PostDataService from "../../Service/PostDataService";
import axios from "axios";

const headers = {
    "Content-Type": "application/json",
    "Accepted": "application/json"
}


function HomePage() {
    const[allPosts, setAllPosts] = useState([]);


    useEffect(() => {
        const api_url = "http://localhost:8080/api/posts";
        axios.get(api_url, {headers})
        .then((response) => response.data)
        .then ((data) => {
            setAllPosts(data);
        })
    }, [])

    return (
        <div>
            <h1>Welcome to StackEcho! </h1>
            <h2>Community of Coders Helping Coders!</h2>
            {allPosts.map(post => (
                <div key = {post.postId}>
                <h3 key={post.postId}>{post.title}</h3>
                <p key={post.postId}>{post.body}</p>
                </div>
            ))}
        </div>
    )
}

export default HomePage;