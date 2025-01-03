package org.genelite.stackecho.Services.PostServices;

import org.genelite.stackecho.Entity.Posts;
import java.util.List;
import java.util.Optional;

public interface PostApplication {
    public List<Posts> getAllPosts();
    public Optional<Posts> getPostById(long id);
    public Posts createPost(Posts post) throws Exception;
    public Posts updatePost(Posts post) throws Exception;
    public void deletePost(Posts post) throws Exception;
}
