package com.example.demo.model;

public class TenantOnboardingRequest {
    private String tenantName;
    private String adminEmail;
    private String adminPassword;

    public TenantOnboardingRequest() {
    }

    public TenantOnboardingRequest(String tenantName, String adminEmail, String adminPassword) {
        this.tenantName = tenantName;
        this.adminEmail = adminEmail;
        this.adminPassword = adminPassword;
    }

    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    public String getAdminEmail() {
        return adminEmail;
    }

    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }
}
