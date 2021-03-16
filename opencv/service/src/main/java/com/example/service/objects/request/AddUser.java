package com.example.service.objects.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddUser {

    @JsonProperty("name")
    public String name;

    @JsonProperty("password")
    public String password;

    @JsonProperty("type")
    public String type;

    @JsonProperty("loc")
    public String loc;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    @Override
    public String toString() {
        return "AddUser{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", type='" + type + '\'' +
                ", loc='" + loc + '\'' +
                '}';
    }
}
