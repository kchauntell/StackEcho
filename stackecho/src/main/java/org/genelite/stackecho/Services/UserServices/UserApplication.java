package org.genelite.stackecho.Services.UserServices;

import org.genelite.stackecho.Entity.Users;


import java.util.List;
import java.util.Optional;

public interface UserApplication {
    public List<Users> getUsers();
    public Optional<Users> findByUsername(String username);
    public Optional<Users> findByEmail(String email);
    public Users createUser(Users user) throws Exception;
    public Users updateUser(Users user) throws Exception;
    public void deleteUserByEmail(Users user) throws Exception;
    public void deleteUserByUsername(Users user) throws Exception;
}
