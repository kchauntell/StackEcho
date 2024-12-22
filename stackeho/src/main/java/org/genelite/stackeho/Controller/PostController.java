package org.genelite.stackeho.Controller;

import org.genelite.stackeho.Entity.Posts;
import org.genelite.stackeho.Services.PostServices.PostApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class PostController {
    @Autowired
    private PostApplication postApplication;

    @GetMapping("/api/posts")
    public List<Posts> getPosts() {
        return this.postApplication.getAllPosts();
    }

    @PostMapping("/api/create_post")
    public Posts createPost(@RequestBody Posts post) throws Exception {
        return this.postApplication.createPost(post);
    }

    @PutMapping("/api/edit_post")
    public Posts editPost(@RequestBody Posts post) throws Exception {
        return this.postApplication.updatePost(post);
    }

    @DeleteMapping("/api/remove_post")
    public void removePost(@RequestBody Posts post) throws Exception {
        this.postApplication.deletePost(post);
    }
}
