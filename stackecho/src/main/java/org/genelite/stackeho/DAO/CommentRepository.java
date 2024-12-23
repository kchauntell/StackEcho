package org.genelite.stackeho.DAO;

import org.genelite.stackeho.Entity.Comments;
import org.genelite.stackeho.Entity.Users;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface CommentRepository extends CrudRepository<Comments, Integer> {
    Optional<Comments> findById(long id);
//    Optional<Comments> findByUserId(Users user);
}
