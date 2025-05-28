package com.ptithcm.clinic_booking.dto.manager;

import com.ptithcm.clinic_booking.dto.RoleDTO;
import com.ptithcm.clinic_booking.dto.account.AccountResponseDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public class ManagerResponseDTO {
    @Schema(description = "Mã quản lý", example = "M001", maxLength = 10)
    private String id;

    @Schema(description = "Thông tin tài khoản")
    private AccountResponseDTO account;

    @Schema(description = "Tên khách hàng", example = "Nguyễn Văn A", maxLength = 100)
    private String name;

    @Schema(description = "Số điện thoại", example = "0912345678", pattern = "^(0|\\+84)[0-9]{9,10}$")
    private String phone;

    @Schema(description = "Email khách hàng", example = "nguyenvana@example.com", maxLength = 100)
    private String email;

    @Schema(description = "Địa chỉ khách hàng", example = "123 Đường ABC, Quận 1, TP.HCM", maxLength = 255)
    private String address;

    @Schema(description = "Giới tính (true = nam, false = nữ)", example = "true")
    private Boolean gender;

    @Schema(description = "Trạng thái khách hàng", example = "ACTIVE", allowableValues = {"ACTIVE", "BLOCKED", "DELETED"})
    private String status;

    @Schema(description = "Thời gian tạo", example = "2025-05-29T14:30:00")
    private LocalDateTime createdAt;

    public ManagerResponseDTO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public AccountResponseDTO getAccount() {
        return account;
    }

    public void setAccount(AccountResponseDTO account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
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
