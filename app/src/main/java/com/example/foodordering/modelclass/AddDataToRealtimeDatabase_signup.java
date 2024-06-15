package com.example.foodordering.modelclass;

public class AddDataToRealtimeDatabase_signup {

    private String username, email;
    private String phnum;

    public AddDataToRealtimeDatabase_signup() {
    }

    public AddDataToRealtimeDatabase_signup(String username, String email, String phnum) {
        this.username = username;
        this.email = email;
        this.phnum = phnum;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhnum() {
        return phnum;
    }

    public void setPhnum(String phnum) {
        this.phnum = phnum;
    }
}
