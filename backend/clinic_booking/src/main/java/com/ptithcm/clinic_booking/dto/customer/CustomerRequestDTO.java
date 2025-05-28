package com.ptithcm.clinic_booking.dto.customer;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public class CustomerRequestDTO {
    @NotBlank(message = "Tên khách hàng không được để trống.")
    @Size(max = 100, message = "Tên khách hàng không được vượt quá 100 ký tự.")
    private String name;

    @NotBlank(message = "Số điện thoại không được để trống.")
    @Size(max = 15, message = "Số điện thoại không được vượt quá 15 ký tự.")
    private String phone;

    @NotBlank(message = "Email không được để trống.")
    @Email(message = "Email không hợp lệ.")
    @Size(max = 100, message = "Email không được vượt quá 100 ký tự.")
    @Schema(description = "Email liên hệ", example = "nguyenvana3@example.com")
    private String email;

    @Size(max = 255, message = "Địa chỉ không được vượt quá 255 ký tự.")
    @Schema(description = "Địa chỉ liên hệ", example = "123 Đường ABC, Quận 1, TP.HCM")
    private String address;
    @Schema(description = "Giới tính", example = "true")
    private Boolean gender;

//    @NotBlank(message = "Trạng thái không được để trống.")
//    @Size(max = 15, message = "Trạng thái không được vượt quá 15 ký tự.")
//    private String status;

    public @NotBlank(message = "Tên khách hàng không được để trống.") @Size(max = 100, message = "Tên khách hàng không được vượt quá 100 ký tự.") String getName() {
        return name;
    }

    public void setName(@NotBlank(message = "Tên khách hàng không được để trống.") @Size(max = 100, message = "Tên khách hàng không được vượt quá 100 ký tự.") String name) {
        this.name = name;
    }

    public @NotBlank(message = "Số điện thoại không được để trống.") @Size(max = 15, message = "Số điện thoại không được vượt quá 15 ký tự.") String getPhone() {
        return phone;
    }

    public void setPhone(@NotBlank(message = "Số điện thoại không được để trống.") @Size(max = 15, message = "Số điện thoại không được vượt quá 15 ký tự.") String phone) {
        this.phone = phone;
    }

    public @NotBlank(message = "Email không được để trống.") @Email(message = "Email không hợp lệ.") @Size(max = 100, message = "Email không được vượt quá 100 ký tự.") String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank(message = "Email không được để trống.") @Email(message = "Email không hợp lệ.") @Size(max = 100, message = "Email không được vượt quá 100 ký tự.") String email) {
        this.email = email;
    }

    public @Size(max = 255, message = "Địa chỉ không được vượt quá 255 ký tự.") String getAddress() {
        return address;
    }

    public void setAddress(@Size(max = 255, message = "Địa chỉ không được vượt quá 255 ký tự.") String address) {
        this.address = address;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

//    public @NotBlank(message = "Trạng thái không được để trống.") @Size(max = 15, message = "Trạng thái không được vượt quá 15 ký tự.") String getStatus() {
//        return status;
//    }
//
//    public void setStatus(@NotBlank(message = "Trạng thái không được để trống.") @Size(max = 15, message = "Trạng thái không được vượt quá 15 ký tự.") String status) {
//        this.status = status;
//    }
}
