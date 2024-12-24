package org.genelite.stackecho.Controller;

import jakarta.validation.Valid;
import org.genelite.stackecho.DAO.UserRepository;
import org.genelite.stackecho.Entity.Users;
import org.genelite.stackecho.Entity.Status;
import org.genelite.stackecho.Services.UserServices.UserApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = { "http://localhost:3000/" })
public class UserController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    private UserApplication userApplication;

    @GetMapping("/api/users")
    public List<Users> getUsers() {
        return this.userApplication.getUsers();
    }

    @CrossOrigin(origins = "/register")
    @PostMapping("/api/create_user")
    public Users createUser(@RequestBody Users user) throws Exception {
        return this.userApplication.createUser(user);
    }

    @PutMapping("/api/edit_user")
    public Users editUser(@RequestBody Users user) throws Exception {
        return this.userApplication.updateUser(user);
    }

    @PostMapping("/login")
    public Status loginUser(@Valid @RequestBody Users user) {
        Optional<Users> userToLogin = this.userApplication.findByUsername(user.getUsername());
        if (userToLogin.isEmpty()) {
            return Status.FAILED;
        }

        user.setIsLoggedIn(true);
        this.userRepository.save(user);
        return Status.SUCCESS;


    }

    @DeleteMapping("/api/remove_user")
    public void removeUser(@RequestBody Users user) throws Exception {
        this.userApplication.deleteUserByUsername(user);
    }
}
