package com.example.demo.controller;

import com.example.demo.config.SecurityConfig;
import com.example.demo.dto.CreateUserRequest;
import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.LoginResponse;
import com.example.demo.dto.TenantUserRequest;
import com.example.demo.model.Users;
import com.example.demo.repository.UserRepository;
import com.example.demo.security.JWTUtil;
import com.example.demo.security.UserContext;
import com.example.demo.service.UserManagementService;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    @Autowired
    private SecurityConfig securityConfig;
    @Autowired
    private JWTUtil jwtUtil;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserManagementService userManagementService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {

        Users user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        PasswordEncoder encoder = securityConfig.passwordEncoder();
        if (!encoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        String token = jwtUtil.generateToken(user);
        Claims claims = jwtUtil.extractAllClaims(token);
        String tenantId = claims.get("tenantId", String.class);
        String role = claims.get("role", String.class);
        return ResponseEntity.ok(new LoginResponse(token, tenantId, role));
    }

    @PostMapping("/users")
    public Users createUsers(@RequestBody CreateUserRequest request) {
        return userManagementService.createUser(request);
    }

    @PostMapping("/users/tenant")
    public Users createTenantUser(@RequestBody TenantUserRequest request) {
        return userManagementService.createTenantUser(request);
    }

    @GetMapping("/users")
    public List<Users> getUsers() {
        return userRepository.findByTenantId(UserContext.getTenantId());
    }

    @GetMapping("/debug")
    public String debug() {

        return UserContext.getRole()
                + " | "
                + UserContext.getTenantId()
                + " | "
                + UserContext.getEmail();
    }
}
