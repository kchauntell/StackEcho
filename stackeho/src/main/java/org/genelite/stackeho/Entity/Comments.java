package org.genelite.stackeho.Entity;

import jakarta.persistence.*;

@Entity
@Table(name="Comments")
public class Comments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="comment_id")
    private Long id;

    @Column(name="comments", nullable=false)
    private String comments;

    @Column(name="user_id")
    private long user_id;

    @Column(name="post_id")
    private long post_id;

    public Comments() {}
    public Comments(String comments, Users user, Posts post) {
        this.comments = comments;
        this.user_id = user.getId();
        this.post_id = post.getPostId();
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getComments() { return comments; }
    public void setComments(String comments) { this.comments = comments; }
    public long getUser() { return user_id; }
    public void setUser(Users user) { this.user_id = user.getId();}
    public long getPost() { return post_id; }
    public void setPost(Posts post) { this.post_id = post.getPostId(); }

    @Override
    public String toString() {
        return "Comments [id=" + id
                + ", comments=" + comments
                + ", user_id=" + user_id
                + ", post_id=" + post_id + "]";
    }

}
