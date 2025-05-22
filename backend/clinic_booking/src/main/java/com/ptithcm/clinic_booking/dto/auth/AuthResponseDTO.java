package com.ptithcm.clinic_booking.dto.auth;

public class AuthResponseDTO {
    private String token;
    private Object user;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Object getUser() {
        return user;
    }

    public void setUserData(Object user) {
        this.user = user;
    }
}
