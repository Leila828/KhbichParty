package com.example.khbichparty.Model;

public class user {
    private String name;
    private String passwoed;

    public user() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPasswoed() {
        return passwoed;
    }

    public void setPasswoed(String passwoed) {
        this.passwoed = passwoed;
    }

    public user(String name, String passwoed) {
        this.name = name;
        this.passwoed = passwoed;
    }
}
