package com.example.brian.fyp115494258.Model;

public class User {

    private String Name;
    private String Password;

    public User(){

    }

    public User(String name, String password){
        setName(name);
        setPassword(password);

    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
