package org.genelite.stackeho.DAO;

import org.genelite.stackeho.Entity.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Posts, Integer> {
    Optional<Posts> findByPostId(long id);
//    Optional<Posts> findByTitle(String title);
}
