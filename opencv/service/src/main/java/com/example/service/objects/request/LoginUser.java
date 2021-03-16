package com.example.service.objects.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LoginUser {


    @JsonProperty("name")
    public String name;


    @JsonProperty("password")
    public String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginUser{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
