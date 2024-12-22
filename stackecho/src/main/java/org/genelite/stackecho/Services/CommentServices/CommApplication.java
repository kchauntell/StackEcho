package org.genelite.stackecho.Services.CommentServices;

import org.genelite.stackecho.Entity.Comments;
import java.util.List;
import java.util.Optional;

public interface CommApplication {
    public List<Comments> getComments();
    public Optional<Comments> getCommentById(long id);
    public Comments addComment(Comments comment);
    public Comments updateComment(Comments comment);
    public void deleteComment(long id);
}
