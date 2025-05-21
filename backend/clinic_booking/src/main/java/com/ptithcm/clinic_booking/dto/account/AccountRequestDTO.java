package com.ptithcm.clinic_booking.dto.account;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class AccountRequestDTO {
    @NotBlank(message = "Tên đăng nhập không được để trống.")
    @Size(min = 8, max = 50, message = "Tên đăng nhập phải từ 4 đến 50 ký tự")
    private String username;

    @NotBlank(message = "Mật khẩu không được để trống.")
    @Size(min = 8, max = 255, message = "Mật khẩu phải có ít nhất 6 ký tự")
    private String password;

    @NotNull(message = "Vai trò không được để trống.")
    @Pattern(regexp = "^(MANAGER)$", message = "Quyền chỉ được phép là MANAGER")
    private Short roleId;

    @NotBlank(message = "Trạng thái không được để trống.")
    @Size(max = 15)
    @Pattern(regexp = "^(ACTIVE|BLOCKED|DELETED)$", message = "Trạng thái phải là ACTIVE, BLOCKED hoặc DELETED")
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
