package com.ptithcm.clinic_booking.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;

public class ServiceDTO {
    private String id;

    @NotBlank(message = "Mã người tạo không được để trống")
    private String creatorId;

    @NotBlank(message = "Mã chuyên khoa không được để trống")
    private String medicalSpecialtyId;

    @NotBlank(message = "Tên dịch vụ không được để trống")
    @Size(max = 100, message = "Tên dịch vụ tối đa 100 ký tự")
    private String name;

    private String description;

    @NotBlank(message = "Trạng thái không được để trống")
    @Size(max = 15, message = "Trạng thái tối đa 15 ký tự")
    private String status;

    private LocalDateTime createdAt;

    public ServiceDTO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public @NotBlank(message = "Mã người tạo không được để trống") String getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(@NotBlank(message = "Mã người tạo không được để trống") String creatorId) {
        this.creatorId = creatorId;
    }

    public @NotBlank(message = "Mã chuyên khoa không được để trống") String getMedicalSpecialtyId() {
        return medicalSpecialtyId;
    }

    public void setMedicalSpecialtyId(@NotBlank(message = "Mã chuyên khoa không được để trống") String medicalSpecialtyId) {
        this.medicalSpecialtyId = medicalSpecialtyId;
    }

    public @NotBlank(message = "Tên dịch vụ không được để trống") @Size(max = 100, message = "Tên dịch vụ tối đa 100 ký tự") String getName() {
        return name;
    }

    public void setName(@NotBlank(message = "Tên dịch vụ không được để trống") @Size(max = 100, message = "Tên dịch vụ tối đa 100 ký tự") String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public @NotBlank(message = "Trạng thái không được để trống") @Size(max = 15, message = "Trạng thái tối đa 15 ký tự") String getStatus() {
        return status;
    }

    public void setStatus(@NotBlank(message = "Trạng thái không được để trống") @Size(max = 15, message = "Trạng thái tối đa 15 ký tự") String status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
