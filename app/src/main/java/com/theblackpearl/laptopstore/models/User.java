package com.theblackpearl.laptopstore.models;

public class User {
    int id;
    String userName;
    String password;
    String name;

    public User(int id, String userName, String password, String name) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }
}
