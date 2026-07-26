package com.example.demo.service;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class TenantIdGenerator {
    public String generateTenantId(){
        return "TENANT_" +
                UUID.randomUUID()
                        .toString()
                        .substring(0,8)
                        .toUpperCase();
    }
}
