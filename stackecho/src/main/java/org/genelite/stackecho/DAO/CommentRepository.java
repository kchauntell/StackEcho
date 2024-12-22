package org.genelite.stackecho.DAO;

import org.genelite.stackecho.Entity.Comments;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface CommentRepository extends CrudRepository<Comments, Integer> {
    Optional<Comments> findById(long id);
//    Optional<Comments> findByUserId(Users user);
}
