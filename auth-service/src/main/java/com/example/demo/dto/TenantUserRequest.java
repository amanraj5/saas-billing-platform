package com.example.demo.dto;

public class TenantUserRequest {
    private String email;
    private String password;

    public TenantUserRequest() {
    }

    public TenantUserRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
