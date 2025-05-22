package com.ptithcm.clinic_booking.dto.doctor;

import com.ptithcm.clinic_booking.dto.account.AccountResponseDTO;

import java.time.LocalDateTime;

public class DoctorResponseDTO {
    private String id;
    private AccountResponseDTO account;
    private String medicalSpecialtyId;
    private String name;
    private String phone;
    private String email;
    private String address;
    private Boolean gender;
    private String status;
    private LocalDateTime createdAt;

    public DoctorResponseDTO() {
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
