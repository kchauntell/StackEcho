package org.genelite.stackeho.Services.UserServices;

import org.genelite.stackeho.DAO.UserRepository;
import org.genelite.stackeho.Entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserAppImplementation implements UserApplication {
    @Autowired
    public UserRepository userRepository;

    public UserAppImplementation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<Users> getUsers() {
        return this.userRepository.findAll();
    }

    @Override
    public Optional<Users> findByUsername(String username) {
        return this.userRepository.findByUsername(username);
    }

    @Override
    public Optional<Users> findByEmail(String email) {
        return this.userRepository.findByEmail(email);
    }

    @Override
    public Users createUser(Users user) {
        return this.userRepository.save(user);
    }


    @Override
    public Users updateUser(Users user) {
        Optional<Users> userToUpdateOptional = this.findByUsername(user.getUsername());
        if (userToUpdateOptional.isEmpty()) {
            return null;
        }

        Users userToUpdate = userToUpdateOptional.get();

        if(user.getFirstname() != null){
            userToUpdate.setFirstname(user.getFirstname());
        }
        if(user.getLastname() != null){
            userToUpdate.setLastname(user.getLastname());
        }
        if(user.getEmail() != null){
            userToUpdate.setEmail(user.getEmail());
        }
        if(user.getUsername() != null){
            userToUpdate.setUsername(user.getUsername());
        }
        if(user.getPasswordHash() != null){
            userToUpdate.setPasswordHash(user.getPasswordHash());
        }

        Users updatedUser = this.userRepository.save(userToUpdate);
        return updatedUser;
    }

    @Override
    public void deleteUserByEmail(Users user) throws Exception {
        String email = user.getEmail();
        Optional<Users> userToDeleteOptional = this.findByEmail(email);

        if (userToDeleteOptional.isEmpty()) {
            return;
        }

        Users userToDelete = userToDeleteOptional.get();
        this.userRepository.delete(userToDelete);
    }

    @Override
    public void deleteUserByUsername(Users user) throws Exception {
        String username = user.getUsername();

        Optional<Users> userToDeleteOptional = this.findByUsername(username);
        if (userToDeleteOptional.isEmpty()) {
            return;
        }
        Users userToDelete2 = userToDeleteOptional.get();
        this.userRepository.delete(userToDeleteOptional.get());
    }

}
