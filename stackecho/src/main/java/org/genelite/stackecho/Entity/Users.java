package org.genelite.stackecho.Entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Objects;
import java.util.List;

@Entity
@Table(name="Users")
public class Users {
    @Id
    @Column(name="user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="username", nullable=false, unique=true, columnDefinition = "varchar(25)")
    private String username;

    @Column(name="firstname", nullable = false,columnDefinition = "varchar(50)")
    private String firstname;

    @Column(name="lastname", nullable = false, columnDefinition = "varchar(50)")
    private String lastname;

    @Column(name="email", nullable = false, unique = true, columnDefinition = "varchar(50)")
    private String email;

    @Column(name="password_hash", nullable = false)
    private String passwordHash;

    @OneToMany
    @Column(name="post_id")
    private List<Posts> posts = new ArrayList<>();

    @OneToMany
    @Column(name="comment_id")
    private List<Comments> comments = new ArrayList<>();

    public Users () {}

    public Users(
            long user_id,
            String username,
            String firstname,
            String lastname,
            String email,
            String passwordHash
            ) {
        this.id = user_id;
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.passwordHash = passwordHash;
//        this.isLoggedIn = false;
    }

    public Long getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getFirstname() { return firstname; }
    public void setFirstname(String firstname) { this.firstname = firstname; }
    public String getLastname() { return lastname; }
    public void setLastname(String lastname) { this.lastname = lastname; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPasswordHash() { return passwordHash; }
    public void setPasswordHash(String passwordHash) { this.passwordHash = passwordHash; }
//    public List<Posts> getPosts() { return posts; }
//    public void setPosts(List<Posts> posts) { this.posts = posts; }
//    public List<Comments> getComments() { return comments; }
//    public void setComments(List<Comments> comments) { this.comments = comments; }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Users)) return false;
        Users users = (Users) o;
        return Objects.equals(username, users.username)
                && Objects.equals(passwordHash, users.passwordHash);
    }

    @Override
    public String toString() {
        return "Users [id=" + id + ", username=" + username
                + ", firstname=" + firstname
                + ", lastname=" + lastname
                + ", email=" + email
                + ", passwordHash=" + passwordHash
                + "]";
    }

}

// pre-created users for database
// bCrypt rounds (cost Factor)= 10
// INSERT INTO Users (username, firstname,lastname,email,passwordHash) VALUES
// ('kchauntell','Kendra','Miller','kchauntell@stackecho.org','$2y$10$r1BYmjJmUCO7331EEO/J8OdVMn34hpf6/O9jVbNycfkM.EM/R43tG'),
// ('carrie70','Carrie','Priester','cpriester@stackecho.org','$2y$10$ebQZ4uGg8/lEPS8Xyjk8Luw5Y6zA4X29FQZ0aptKy1PGNnhrtjOay');
//kchauntell , p@$$word89
//carrie70, N@naIsAwesome61
