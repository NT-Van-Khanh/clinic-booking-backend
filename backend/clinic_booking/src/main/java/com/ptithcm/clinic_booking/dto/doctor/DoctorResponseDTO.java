package com.ptithcm.clinic_booking.dto.doctor;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ptithcm.clinic_booking.dto.account.AccountResponseDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class DoctorResponseDTO {
    @Schema(description = "ID bác sĩ", example = "D001")
    private String id;

    private AccountResponseDTO account;

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

    private Boolean gender;

    @Schema(description = "Trạng thái bác sĩ", example = "ACTIVE")
    private String status;

    @Schema(description = "Trạng thái bác sĩ", example = "doctor.com")
    private String imageLink;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Schema(description = "Ngày sinh", example = "1980-11-12")
    private LocalDate birthday;

    @Schema(description = "Mô tả chi tiết",
            example = "Chuyên gia về điều trị các bệnh lý về mắt, từ các bệnh thông thường đến các bệnh lý nghiêm trọng về mắt.")
    private String description;

    @Schema(description = "Trình độ chuyên môn", example = "Bác sĩ Chuyên khoa I")
    private String qualification;

    private LocalDateTime createdAt;

    public DoctorResponseDTO() {
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
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

    public AccountResponseDTO getAccount() {
        return account;
    }

    public void setAccount(AccountResponseDTO account) {
        this.account = account;
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
