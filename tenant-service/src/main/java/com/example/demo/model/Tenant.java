package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "tenants")
public class Tenant {

    @Id
    private String id;
    private String name;
    private String tenantId;
    private Boolean active;
    private String adminEmail;

    public String getAdminEmail() {
        return adminEmail;
    }

    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Tenant(String id, String name, String tenantId, Boolean active, String adminEmail) {
        this.id = id;
        this.name = name;
        this.tenantId = tenantId;
        this.active = active;
        this.adminEmail = adminEmail;
    }

    public Tenant() {
    }
}

