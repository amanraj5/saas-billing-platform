package com.example.demo.config;

import com.example.demo.model.Users;
import com.example.demo.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


@Component
public class DataLoader {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SecurityConfig config;

    @Value("${spring.data.mongodb.uri}")
    private String mongoUri;
    @Value("${spring.data.mongodb.database}")
    private String dbName;

    @PostConstruct
    public void loadAdmin() {
        System.out.println("Mongo-uri "+mongoUri+" dbname "+dbName);
        PasswordEncoder encoder = config.passwordEncoder();
        if (userRepository.findByEmail("admin@saas.com").isEmpty()) {
            Users admin = new Users(
                    null,
                    "admin@saas.com",
                    encoder.encode("admin123"),
                    "SUPER_ADMIN",
                    "TENANT_123"
            );
            userRepository.save(admin);
        }
    }
}
