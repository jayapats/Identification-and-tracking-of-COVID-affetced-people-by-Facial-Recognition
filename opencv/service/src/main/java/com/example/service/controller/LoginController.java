package com.example.service.controller;

import com.example.service.objects.request.AddUser;
import com.example.service.objects.request.LoginUser;
import com.example.service.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;



    @GetMapping("/")
    String test(){

        return "service running";
    }

    //@GetMapping("/login")
    @PostMapping("/login")
    //@GetMapping("/login")
    boolean login(@RequestBody LoginUser loginUser){
        //boolean res;
        System.out.println("Login Controller");
        System.out.println(loginUser.toString());

        /*res=loginService.validateLogin(loginUser);
        if(String.valueOf(res).equals("true")){
            return "true";
        }
        else
            return "false";*/
        return (loginService.validateLogin(loginUser));
    }


    @PostMapping("/addUser")
    String addUser(@RequestBody AddUser addUser){
        System.out.println(addUser.toString());
        return(loginService.addUser(addUser));

    }



}
