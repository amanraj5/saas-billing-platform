package com.example.demo.dto;

public class CreateUserRequest {
    private String email;
    private String password;
    private String role;
    private String tenantId;

    public CreateUserRequest() {
    }

    public CreateUserRequest(String email, String password, String role, String tenantId) {
        this.email = email;
        this.password = password;
        this.role = role;
        this.tenantId = tenantId;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }
}
