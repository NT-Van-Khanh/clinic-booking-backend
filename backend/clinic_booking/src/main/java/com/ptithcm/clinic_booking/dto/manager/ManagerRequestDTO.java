package com.ptithcm.clinic_booking.dto.manager;

import jakarta.validation.constraints.*;

public class ManagerRequestDTO {
    @NotBlank(message = "Mã quản lý không được để trống")
    @Size(max = 10, message = "Mã quản lý không được vượt quá 10 ký tự")
    private String id;

    @NotBlank(message = "Tên đăng nhập không được để trống")
    @Size(min = 8, max = 50, message = "Tên đăng nhập phải từ 4 đến 50 ký tự")
    private String username;

    @NotBlank(message = "Tên không được để trống")
    @Size(max = 100, message = "Tên không được vượt quá 100 ký tự")
    private String name;

    @NotBlank(message = "Số điện thoại không được để trống")
    @Pattern(regexp = "^(0|\\+84)[0-9]{9,10}$", message = "Số điện thoại không hợp lệ")
    private String phone;

    @NotBlank(message = "Email không được để trống")
    @Email(message = "Email không hợp lệ")
    @Size(max = 100, message = "Email không được vượt quá 100 ký tự")
    private String email;

    @Size(max = 255, message = "Địa chỉ không được vượt quá 255 ký tự")
    private String address;

    @NotNull(message = "Giới tính không được để trống")
    private Boolean gender;

    @NotBlank(message = "Trạng thái không được để trống")
    @Pattern(regexp = "^(ACTIVE|BLOCKED|DELETED)$", message = "Trạng thái phải là ACTIVE, BLOCKED hoặc DELETED")
    private String status;

    @NotBlank(message = "Quyền không được để trống")
    @Pattern(regexp = "^(MANAGER)$", message = "Quyền chỉ được phép là MANAGER")
    private String role;

    public ManagerRequestDTO() {
    }

    public @NotBlank(message = "Mã quản lý không được để trống") @Size(max = 10, message = "Mã quản lý không được vượt quá 10 ký tự") String getId() {
        return id;
    }

    public void setId(@NotBlank(message = "Mã quản lý không được để trống") @Size(max = 10, message = "Mã quản lý không được vượt quá 10 ký tự") String id) {
        this.id = id;
    }

    public @NotBlank(message = "Tên đăng nhập không được để trống") @Size(min = 8, max = 50, message = "Tên đăng nhập phải từ 4 đến 50 ký tự") String getUsername() {
        return username;
    }

    public void setUsername(@NotBlank(message = "Tên đăng nhập không được để trống") @Size(min = 8, max = 50, message = "Tên đăng nhập phải từ 4 đến 50 ký tự") String username) {
        this.username = username;
    }

    public @NotBlank(message = "Tên không được để trống") @Size(max = 100, message = "Tên không được vượt quá 100 ký tự") String getName() {
        return name;
    }

    public void setName(@NotBlank(message = "Tên không được để trống") @Size(max = 100, message = "Tên không được vượt quá 100 ký tự") String name) {
        this.name = name;
    }

    public @NotBlank(message = "Số điện thoại không được để trống") @Pattern(regexp = "^(0|\\+84)[0-9]{9,10}$", message = "Số điện thoại không hợp lệ") String getPhone() {
        return phone;
    }

    public void setPhone(@NotBlank(message = "Số điện thoại không được để trống") @Pattern(regexp = "^(0|\\+84)[0-9]{9,10}$", message = "Số điện thoại không hợp lệ") String phone) {
        this.phone = phone;
    }

    public @NotBlank(message = "Email không được để trống") @Email(message = "Email không hợp lệ") @Size(max = 100, message = "Email không được vượt quá 100 ký tự") String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank(message = "Email không được để trống") @Email(message = "Email không hợp lệ") @Size(max = 100, message = "Email không được vượt quá 100 ký tự") String email) {
        this.email = email;
    }

    public @Size(max = 255, message = "Địa chỉ không được vượt quá 255 ký tự") String getAddress() {
        return address;
    }

    public void setAddress(@Size(max = 255, message = "Địa chỉ không được vượt quá 255 ký tự") String address) {
        this.address = address;
    }

    public @NotNull(message = "Giới tính không được để trống") Boolean getGender() {
        return gender;
    }

    public void setGender(@NotNull(message = "Giới tính không được để trống") Boolean gender) {
        this.gender = gender;
    }

    public @NotBlank(message = "Trạng thái không được để trống") @Pattern(regexp = "^(ACTIVE|BLOCKED|DELETED)$", message = "Trạng thái phải là ACTIVE, BLOCKED hoặc DELETED") String getStatus() {
        return status;
    }

    public void setStatus(@NotBlank(message = "Trạng thái không được để trống") @Pattern(regexp = "^(ACTIVE|BLOCKED|DELETED)$", message = "Trạng thái phải là ACTIVE, BLOCKED hoặc DELETED") String status) {
        this.status = status;
    }

    public @NotBlank(message = "Quyền không được để trống") @Pattern(regexp = "^(MANAGER)$", message = "Quyền chỉ được phép là MANAGER") String getRole() {
        return role;
    }

    public void setRole(@NotBlank(message = "Quyền không được để trống") @Pattern(regexp = "^(MANAGER)$", message = "Quyền chỉ được phép là MANAGER") String role) {
        this.role = role;
    }
}
