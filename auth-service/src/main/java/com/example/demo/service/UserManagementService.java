package com.example.demo.service;

import com.example.demo.dto.CreateUserRequest;
import com.example.demo.dto.TenantUserRequest;
import com.example.demo.model.Users;
import com.example.demo.repository.UserRepository;
import com.example.demo.security.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserManagementService {
    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Users createUser(CreateUserRequest request) {

        Users user = new Users();
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(request.getRole());
        user.setTenantId(request.getTenantId());

        return repository.save(user);
    }

    public Users createTenantUser(TenantUserRequest request) {
        String tenantId = UserContext.getTenantId();

        Users user = new Users();
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setTenantId(tenantId);;
        user.setRole("USER");

        user.setActive(true);
        return repository.save(user);

    }
}
