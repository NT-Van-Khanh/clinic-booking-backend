package com.ptithcm.clinic_booking.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public class ClinicDTO {
    private String id;

    @NotNull(message = "Tên phòng khám không được để trống.")
    @Size(min = 3, max = 100, message = "Tên phòng khám phải có độ dài từ 3 đến 100 ký tự")
    private String name;

    @NotNull(message = "Địa chỉ không được để trống.")
    private String address;

    @NotNull(message = "Số điện thoại không được để trống.")
    private String phone;

    @Email(message = "Email không hợp lệ.")
    private String email;

    private String description;
    private String status;
    private LocalDateTime createdAt;

    public ClinicDTO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
