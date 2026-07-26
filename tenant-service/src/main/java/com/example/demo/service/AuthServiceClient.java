package com.example.demo.service;

import com.example.demo.dto.CreateUserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AuthServiceClient {
    @Autowired
    RestTemplate restTemplate;

    public void createTenantAdmin(String email, String password, String tenantId) {

        CreateUserRequest request = new CreateUserRequest();

        request.setEmail(email);
        request.setPassword(password);
        request.setRole("TENANT_ADMIN");
        request.setTenantId(tenantId);

        restTemplate.postForObject("http://localhost:8081/auth/users", request, Object.class);
    }
}
