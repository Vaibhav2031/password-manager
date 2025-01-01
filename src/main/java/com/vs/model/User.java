package com.vs.model;

public class User {
    private String userName;
    private String salt;
    private String hashPassword;

    // Constructors
    public User(String userName, String salt, String hashPassword) {
        this.userName = userName;
        this.salt = salt;
        this.hashPassword = hashPassword;
    }

    // Getters and Setters
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getHashPassword() {
        return hashPassword;
    }

    public void setHashPassword(String hashPassword) {
        this.hashPassword = hashPassword;
    }
}
