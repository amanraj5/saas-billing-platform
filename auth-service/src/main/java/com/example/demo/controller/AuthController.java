package com.example.demo.controller;

import com.example.demo.config.SecurityConfig;
import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.LoginResponse;
import com.example.demo.model.Users;
import com.example.demo.repository.UserRepository;
import com.example.demo.security.JWTUtil;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    @Autowired
    SecurityConfig securityConfig;
    @Autowired
    JWTUtil jwtUtil;
    @Autowired
    UserRepository userRepository;

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
}
