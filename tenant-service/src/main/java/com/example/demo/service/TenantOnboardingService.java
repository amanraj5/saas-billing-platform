package com.example.demo.service;

import com.example.demo.model.Tenant;
import com.example.demo.model.TenantOnboardingRequest;
import com.example.demo.repository.TenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TenantOnboardingService {
    @Autowired
    private AuthServiceClient authServiceClient;
    @Autowired
    private TenantRepository tenantRepository;
    @Autowired
    private TenantIdGenerator tenantIdGenerator;

    public Tenant onboard(TenantOnboardingRequest request) {
        String tenantId = tenantIdGenerator.generateTenantId();
        Tenant tenant = new Tenant();

        tenant.setTenantId(tenantId);
        tenant.setAdminEmail(request.getAdminEmail());
        tenant.setActive(true);
        tenant.setName(request.getTenantName());

        tenantRepository.save(tenant);
        authServiceClient.createTenantAdmin(request.getAdminEmail(), request.getAdminPassword(), tenantId);
        return tenant;
    }
}
