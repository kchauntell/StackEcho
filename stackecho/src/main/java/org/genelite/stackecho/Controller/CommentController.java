package org.genelite.stackecho.Controller;

import org.genelite.stackecho.Entity.Comments;
import org.genelite.stackecho.Services.CommentServices.CommApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class CommentController {
    @Autowired
    private CommApplication commApplication;

    @GetMapping("/api/comments")
    public List<Comments> getComments() {
        return commApplication.getComments();
    }

    @PostMapping("/api/create_comment")
    public Comments createComment(@RequestBody Comments comment) {
        return commApplication.addComment(comment);
    }

    @PutMapping("/api/edit_comment")
    public Comments editComment(@RequestBody Comments comment) {
        return commApplication.updateComment(comment);
    }

    @DeleteMapping("/api/remove_comment")
    public void removeComment(@RequestBody Comments comment) {
        this.commApplication.deleteComment(comment.getId());
    }

}
