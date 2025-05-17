package com.ptithcm.clinic_booking.dto.account;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class AccountRequestDTO {
    @NotBlank(message = "Tên đăng nhập không được để trống.")
    @Size(max = 50)
    private String username;

    @NotBlank(message = "Mật khẩu không được để trống.")
    @Size(min = 6, max = 255)
    private String password;

    @NotNull(message = "Vai trò không được để trống.")
    private Short roleId; // Chỉ truyền id role để đơn giản

    @NotBlank(message = "Trạng thái không được để trống.")
    @Size(max = 15)
    private String status;

    public AccountRequestDTO() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Short getRoleId() {
        return roleId;
    }

    public void setRoleId(Short roleId) {
        this.roleId = roleId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
