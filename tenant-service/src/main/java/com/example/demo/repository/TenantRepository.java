package com.example.demo.repository;

import com.example.demo.model.Tenant;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;
import java.util.Optional;

@Repository
public interface TenantRepository extends MongoRepository<Tenant, String> {
    List<Tenant> findByTenantId(String tenantId);
}
