package com.ptithcm.clinic_booking.dto.doctor;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public class DoctorDTO {
    private String id;

    @NotBlank(message = "Không được để trống mã tài khoản")
    @Schema(description = "Mã tài khoản bác sĩ", example = "acc123")
    private String accountId;

    @NotBlank(message = "Không được để trống mã chuyên khoa")
    @Schema(description = "Mã chuyên khoa", example = "med456")
    private String medicalSpecialtyId;

    @NotBlank(message = "Không được để trống họ tên")
    @Size(max = 100, message = "Họ tên tối đa 100 ký tự")
    @Schema(description = "Họ tên bác sĩ", example = "Nguyễn Văn A")
    private String name;

    @NotBlank(message = "Không được để trống số điện thoại")
    @Size(max = 15, message = "Số điện thoại tối đa 15 ký tự")
    @Schema(description = "Số điện thoại", example = "0912345678")
    private String phone;

    @NotBlank(message = "Không được để trống email")
    @Email(message = "Email không hợp lệ")
    @Size(max = 100, message = "Email tối đa 100 ký tự")
    @Schema(description = "Email liên hệ", example = "doctor@example.com")
    private String email;

    @Size(max = 255, message = "Địa chỉ tối đa 255 ký tự")
    @Schema(description = "Địa chỉ", example = "123 Đường ABC, Quận 1, TP.HCM")
    private String address;

    @Schema(description = "Giới tính", example = "true")
    private Boolean gender;

    @NotBlank(message = "Không được để trống trạng thái")
    @Size(max = 15, message = "Trạng thái tối đa 15 ký tự")
    @Schema(description = "Trạng thái bác sĩ", example = "ACTIVE")
    private String status;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @Schema(description = "Thời gian tạo", example = "2025-05-22T10:15:30")
    private LocalDateTime createdAt;

    public DoctorDTO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public @NotBlank(message = "Không được để trống mã tài khoản") String getAccountId() {
        return accountId;
    }

    public void setAccountId(@NotBlank(message = "Không được để trống mã tài khoản") String accountId) {
        this.accountId = accountId;
    }

    public @NotBlank(message = "Không được để trống mã chuyên khoa") String getMedicalSpecialtyId() {
        return medicalSpecialtyId;
    }

    public void setMedicalSpecialtyId(@NotBlank(message = "Không được để trống mã chuyên khoa") String medicalSpecialtyId) {
        this.medicalSpecialtyId = medicalSpecialtyId;
    }

    public @NotBlank(message = "Không được để trống họ tên") @Size(max = 100, message = "Họ tên tối đa 100 ký tự") String getName() {
        return name;
    }

    public void setName(@NotBlank(message = "Không được để trống họ tên") @Size(max = 100, message = "Họ tên tối đa 100 ký tự") String name) {
        this.name = name;
    }

    public @NotBlank(message = "Không được để trống số điện thoại") @Size(max = 15, message = "Số điện thoại tối đa 15 ký tự") String getPhone() {
        return phone;
    }

    public void setPhone(@NotBlank(message = "Không được để trống số điện thoại") @Size(max = 15, message = "Số điện thoại tối đa 15 ký tự") String phone) {
        this.phone = phone;
    }

    public @NotBlank(message = "Không được để trống email") @Email(message = "Email không hợp lệ") @Size(max = 100, message = "Email tối đa 100 ký tự") String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank(message = "Không được để trống email") @Email(message = "Email không hợp lệ") @Size(max = 100, message = "Email tối đa 100 ký tự") String email) {
        this.email = email;
    }

    public @Size(max = 255, message = "Địa chỉ tối đa 255 ký tự") String getAddress() {
        return address;
    }

    public void setAddress(@Size(max = 255, message = "Địa chỉ tối đa 255 ký tự") String address) {
        this.address = address;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public @NotBlank(message = "Không được để trống trạng thái") @Size(max = 15, message = "Trạng thái tối đa 15 ký tự") String getStatus() {
        return status;
    }

    public void setStatus(@NotBlank(message = "Không được để trống trạng thái") @Size(max = 15, message = "Trạng thái tối đa 15 ký tự") String status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
