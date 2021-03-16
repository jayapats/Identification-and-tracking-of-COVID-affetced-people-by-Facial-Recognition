package com.example.service.repository;

import com.example.service.crud.UserRepository;
import com.example.service.objects.binding.User;
import com.example.service.objects.request.AddUser;
import com.example.service.objects.request.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LoginRepo {

    @Autowired
    private UserRepository userRepository;

    public List<LoginUser> getAllUsers() {

        Iterable<User> users= userRepository.findAll();
        return populateUsers(users);

    }

    private List<LoginUser> populateUsers(Iterable<User> users) {
        List<LoginUser> loginUsers=new ArrayList<>();
        for(User user:users){
            LoginUser loginUser = new LoginUser();
            loginUser.setName(user.getName());
            loginUser.setPassword(user.getPassword());
            loginUsers.add(loginUser);
        }
        return loginUsers;
    }

    public void addUser(AddUser addUser) {
        User  user =  populateAddUserObject(addUser);
        userRepository.save(user);
    }

    private User populateAddUserObject(AddUser addUser) {
        User  user = new User();
        user.setLoc(addUser.getLoc());
        user.setName(addUser.getName());
        user.setPassword(addUser.getPassword());
        user.setType(addUser.getType());
        return user;
    }
}
