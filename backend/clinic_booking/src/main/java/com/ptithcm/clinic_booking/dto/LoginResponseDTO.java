package com.ptithcm.clinic_booking.dto;

public class LoginResponseDTO {
        private String token;
        private String role; // "CUSTOMER" hoặc "EMPLOYEE"
        private Object userInfo; // Có thể là CustomerDTO hoặc EmployeeDTO

    public LoginResponseDTO() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Object getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(Object userInfo) {
        this.userInfo = userInfo;
    }
}
