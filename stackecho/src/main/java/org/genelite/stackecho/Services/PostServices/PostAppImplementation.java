package org.genelite.stackecho.Services.PostServices;

import org.genelite.stackecho.DAO.PostRepository;
import org.genelite.stackecho.Entity.Posts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PostAppImplementation implements PostApplication {
    @Autowired
    public PostRepository postRepository;

    public PostAppImplementation(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public List<Posts> getAllPosts() {
        return this.postRepository.findAll();
    }

    @Override
    public Optional<Posts> getPostById(long id) {
        return this.postRepository.findByPostId(id);
    }

    @Override
    public Posts createPost(Posts post) {
        return this.postRepository.save(post);
    }

    @Override
    public Posts updatePost(Posts post) {
        Optional<Posts> postToUpdateOptional = this.postRepository.findByPostId(post.getPostId());
        if (postToUpdateOptional.isEmpty()) {
            return null;
        }

        Posts postToUpdate = postToUpdateOptional.get() ;

        if(post.getTitle() != null) {
            postToUpdate.setTitle(post.getTitle());
        }
        if(post.getBody() != null) {
            postToUpdate.setBody(post.getBody());
        }

        Posts updatedPost = this.postRepository.save(postToUpdate);
        return updatedPost;
    }

    @Override
    public void deletePost(Posts post) {
        long postId = post.getPostId();

        Optional<Posts> postToDeleteOptional = this.postRepository.findByPostId(postId);
        if (postToDeleteOptional.isEmpty()) {
            return;
        }
        Posts postToDelete = postToDeleteOptional.get();
        this.postRepository.delete(postToDelete);
    }
}
