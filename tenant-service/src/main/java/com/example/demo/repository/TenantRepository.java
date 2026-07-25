package com.example.demo.repository;

import com.example.demo.model.Tenant;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface TenantRepository extends MongoRepository<Tenant, String> {
    List<Tenant> findByTenantId(String tenantId);

}
