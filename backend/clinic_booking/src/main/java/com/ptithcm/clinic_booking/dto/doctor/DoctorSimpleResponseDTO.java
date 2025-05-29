package com.ptithcm.clinic_booking.dto.doctor;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

public class DoctorSimpleResponseDTO {

    @Schema(description = "ID bác sĩ", example = "D001")
    private String id;
    @Schema(description = "Mã chuyên khoa", example = "MS01")
    private String medicalSpecialtyId;

    @Schema(description = "Họ tên bác sĩ", example = "Nguyễn Văn A")
    private String name;

    @Schema(description = "Số điện thoại", example = "0912345678")
    private String phone;


    @Schema(description = "Email liên hệ", example = "doctor@example.com")
    private String email;

    @Schema(description = "Địa chỉ", example = "123 Đường ABC, Quận 1, TP.HCM")
    private String address;

    private Boolean gender;;

    @Schema(description = "Trạng thái bác sĩ", example = "doctor.com")
    private String imageLink;

    private LocalDateTime createdAt;

    public DoctorSimpleResponseDTO() {
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMedicalSpecialtyId() {
        return medicalSpecialtyId;
    }

    public void setMedicalSpecialtyId(String medicalSpecialtyId) {
        this.medicalSpecialtyId = medicalSpecialtyId;
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


    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
