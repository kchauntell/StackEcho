package org.genelite.stackecho.Services.CommentServices;

import org.genelite.stackecho.DAO.CommentRepository;
import org.genelite.stackecho.Entity.Comments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CommAppImplementation  implements CommApplication {
    @Autowired
    public CommentRepository commentRepository;

    public CommAppImplementation(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public List<Comments> getComments() {
        return (List<Comments>) this.commentRepository.findAll();
    }

    @Override
    public Optional<Comments> getCommentById(long id) {
        return this.commentRepository.findById(id);
    }

    @Override
    public Comments addComment(Comments comment) {
        return this.commentRepository.save(comment);
    }

    @Override
    public Comments updateComment(Comments comment) {
        Optional<Comments> commentToUpdateOptional = this.commentRepository.findById(comment.getId());
        if (commentToUpdateOptional.isEmpty()) {
            return null;
        }
        Comments commentToUpdate = commentToUpdateOptional.get();

        if(comment.getComments() != null) {
            commentToUpdate.setComments(comment.getComments());
        }

        Comments updatedComment = this.commentRepository.save(commentToUpdate);
        return updatedComment;
    }

    @Override
    public void deleteComment(long id) {
        Optional<Comments> commentToDeleteOptional = this.commentRepository.findById(id);
        if (commentToDeleteOptional.isEmpty()) {
            return;
        }
        Comments commentToDelete = commentToDeleteOptional.get();
        this.commentRepository.delete(commentToDelete);
    }


}
