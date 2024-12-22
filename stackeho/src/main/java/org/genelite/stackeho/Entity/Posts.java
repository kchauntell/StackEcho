package org.genelite.stackeho.Entity;

import jakarta.persistence.*;

@Entity
@Table(name="Posts")
public class Posts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="post_id")
    private long postId;

    @Column(name="title", nullable=false, columnDefinition = "varchar(75)")
    private String title;

    @Column(name="body", nullable=false)
    private String body;

    @Column(name = "user_id")
    private long user_id;


    public Posts() {}
    public Posts(String title, String body, Users user) {
        this.title = title;
        this.body = body;
        this.user_id = user.getId();
    }

    public Long getPostId() { return postId; }
    public void setPostId(long postId) { this.postId = postId; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getBody() { return body; }
    public void setBody(String body) { this.body = body; }
    public long getUser() { return user_id; }
    public void setUser(Users user) { this.user_id = user.getId(); }

    @Override
    public String toString() {
        return "Posts [postId=" + postId
                + ", title=" + title
                + ", body=" + body
                + ", user=" + user_id
                + "]";}
    }