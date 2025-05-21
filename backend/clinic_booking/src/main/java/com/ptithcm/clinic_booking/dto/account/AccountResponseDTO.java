package com.ptithcm.clinic_booking.dto.account;

import com.ptithcm.clinic_booking.dto.RoleDTO;

import java.time.LocalDateTime;

public class AccountResponseDTO {
    private String username;
    private RoleDTO role;
    private String status;
    private LocalDateTime createdAt;

    public AccountResponseDTO() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public RoleDTO getRole() {
        return role;
    }

    public void setRole(RoleDTO role) {
        this.role = role;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
