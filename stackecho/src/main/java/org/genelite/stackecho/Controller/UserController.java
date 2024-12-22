package org.genelite.stackecho.Controller;

import org.genelite.stackecho.Entity.Users;
import org.genelite.stackecho.Services.UserServices.UserApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserApplication userApplication;

    @GetMapping("/api/users")
    public List<Users> getUsers() {
        return this.userApplication.getUsers();
    }

    @PostMapping("/api/create_user")
    public Users createUser(@RequestBody Users user) throws Exception {
        return this.userApplication.createUser(user);
    }

    @PutMapping("/api/edit_user")
    public Users editUser(@RequestBody Users user) throws Exception {
        return this.userApplication.updateUser(user);
    }

    @DeleteMapping("/api/remove_user")
    public void removeUser(@RequestBody Users user) throws Exception {
        this.userApplication.deleteUserByUsername(user);
    }
}
