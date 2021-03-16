package com.example.service.service;

import com.example.service.objects.request.AddUser;
import com.example.service.objects.request.LoginUser;
import com.example.service.repository.LoginRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService {

    @Autowired
    LoginRepo loginRepo;

    public boolean validateLogin(LoginUser loginUser){
        List<LoginUser> loginUsers= loginRepo.getAllUsers();

       return loginUsers.stream().filter(o ->  o.getName().equals(loginUser.getName())
        && o.getPassword().equals(loginUser.getPassword())
        ).findFirst().isPresent();

    }


    public String addUser(AddUser addUser) {
        loginRepo.addUser(addUser);
        return "saved";
    }
}
