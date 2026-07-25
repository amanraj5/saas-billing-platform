package com.example.demo.controller;

import com.example.demo.model.Tenant;
import com.example.demo.repository.TenantRepository;
import com.example.demo.service.TenantContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tenants")
public class TenantController {

    @Autowired
    private TenantRepository tenantRepository;

    @PostMapping
    public Tenant createTenant(@RequestBody Tenant tenant) {
        System.out.println(tenant);
        tenant.setActive(true);
        return tenantRepository.save(tenant);
    }

    @GetMapping("/info")
    public String info(@RequestHeader("X-USER-EMAIL") String email,
                       @RequestHeader("X-USER-ROLE") String role,
                       @RequestHeader("X-TENANT-ID") String tenantId){
        return "Tenant info for " + email + " with role " + role + " with tenatId " + tenantId;
    }

    @GetMapping("/getTenants")
    public List<Tenant> getTenants() {
        return tenantRepository.findByTenantId(
                TenantContext.getTenantId()
        );
    }

}

