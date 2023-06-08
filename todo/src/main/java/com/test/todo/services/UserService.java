package com.test.todo.services;

import com.test.todo.dao.UserRepo;
import com.test.todo.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;
    public User save(User user) {
        return userRepo.save(user);
    }

    public boolean login(String username, String password) {
        User user = null;
        user =  userRepo.findByUserName(username);
        if(user == null){
            return false;
        }else{
            if (user.getPassword().equals(password)){
                return true;
            }
        }
        return true;
    }
}
