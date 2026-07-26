package com.example.demo.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class UserContextFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain)
            throws ServletException, IOException {

        try {

            UserContext.setEmail(request.getHeader("X-USER-EMAIL"));

            UserContext.setRole(request.getHeader("X-USER-ROLE"));

            UserContext.setTenantId(request.getHeader("X-TENANT-ID"));

            filterChain.doFilter(request, response);

        } finally {

            UserContext.clear();
        }
    }
}