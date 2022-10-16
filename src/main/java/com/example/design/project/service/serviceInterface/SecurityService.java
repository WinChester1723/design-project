package com.example.design.project.service.serviceInterface;

public interface SecurityService {
    void autoLogin(String username,String password);
    boolean isAuthenticated();
}
