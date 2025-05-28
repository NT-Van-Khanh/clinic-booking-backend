package com.ptithcm.clinic_booking.dto.service;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ServiceCreateDTO {

    @NotBlank(message = "Mã người tạo không được để trống")
    @Schema(description = "Mã người tạo dịch vụ", example = "manager1")
    private String creatorId;

    @NotBlank(message = "Mã chuyên khoa không được để trống")
    @Schema(description = "Mã chuyên khoa", example = "MS01")
    private String medicalSpecialtyId;

    @NotBlank(message = "Tên dịch vụ không được để trống")
    @Size(max = 100, message = "Tên dịch vụ tối đa 100 ký tự")
    @Schema(description = "Tên dịch vụ", example = "Khám tổng quát")
    private String name;

    @Schema(description = "Mô tả dịch vụ", example = "Dịch vụ khám tổng quát toàn diện")
    private String description;

    @NotBlank(message = "Trạng thái không được để trống")
    @Size(max = 15, message = "Trạng thái tối đa 15 ký tự")
    @Schema(description = "Trạng thái dịch vụ", example = "ACTIVE")
    private String status;

    public ServiceCreateDTO() {
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
}
