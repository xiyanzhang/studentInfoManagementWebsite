package com.example.pojo;

public class Account {
    private String username;
    private String password;
    public String getUsername() {
        return username;
    }

    public void setUsername(String userName) {
        this.username = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "{\"name\":\"" + username + "\",\"studentId\":\"" + password + "\"}";
    }

}
