package com.example.demo.security;

public class UserContext {

    private static final ThreadLocal<String> tenantId =
            new ThreadLocal<>();

    private static final ThreadLocal<String> role =
            new ThreadLocal<>();

    private static final ThreadLocal<String> email =
            new ThreadLocal<>();

    public static void setTenantId(String value) {
        tenantId.set(value);
    }

    public static String getTenantId() {
        return tenantId.get();
    }

    public static void setRole(String value) {
        role.set(value);
    }

    public static String getRole() {
        return role.get();
    }

    public static void setEmail(String value) {
        email.set(value);
    }

    public static String getEmail() {
        return email.get();
    }

    public static void clear() {
        tenantId.remove();
        role.remove();
        email.remove();
    }
}