package com.ptithcm.clinic_booking.dto.account;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class AccountRequestDTO {
    @Schema(description = "Tên đăng nhập của tài khoản",
            example = "manager123", minLength = 8, maxLength = 100)
    @NotBlank(message = "Tên đăng nhập không được để trống.")
    @Size(min = 8, max = 100, message = "Tên đăng nhập phải từ 8 đến 50 ký tự")
    private String username;

    @Schema(description = "Mật khẩu đăng nhập",
            example = "Abc@123456",  minLength = 8, maxLength = 255 )
    @NotBlank(message = "Mật khẩu không được để trống.")
    @Size(min = 8, max = 255, message = "Mật khẩu phải có ít nhất 8 ký tự")
    private String password;

    @Schema( description = "Vai trò của tài khoản (chỉ cho phép MANAGER và DOCTOR)", example = "2")
    @NotNull(message = "Vai trò không được để trống.")
    private Short roleId;

    @Schema( description = "Trạng thái của tài khoản (ACTIVE, BLOCKED hoặc DELETED)",  example = "ACTIVE")
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
