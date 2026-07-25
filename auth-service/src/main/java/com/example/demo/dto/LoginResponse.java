package com.example.demo.dto;

public class LoginResponse {
    private String token;
    private String tenantId;
    private String role;

    public LoginResponse(String token, String tenantId, String role) {
        this.token = token;
        this.tenantId = tenantId;
        this.role = role;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
