package com.example.dto;

public class UserDTO {

    private String username;
    private String password;
    private String mail;
    private String role;

    public UserDTO(){}

    public UserDTO(String username, String password, String mail, String role) {
        this.username = username;
        this.password = password;
        this.mail = mail;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
