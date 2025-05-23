package com.ptithcm.clinic_booking.dto;

import com.ptithcm.clinic_booking.dto.customer.CustomerDTO;
import com.ptithcm.clinic_booking.model.AppointmentStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public class AppointmentDTO {
    private Integer id;

    @NotNull(message = "Dịch vụ không được để trống.")
    @Schema(description = "Thông tin dịch vụ")
    private ServiceDTO service;

    @NotNull(message = "Lịch hẹn không được để trống.")
    @Schema(description = "Thông tin lịch trình")
    private ScheduleDTO schedule;

    @NotNull(message = "Khách hàng không được để trống.")
    @Schema(description = "Thông tin khách hàng")
    private CustomerDTO customer;

    @NotNull(message = "Số thứ tự không được để trống.")
    @Min(value = 1, message = "Số thứ tự phải lớn hơn hoặc bằng 1.")
    @Schema(description = "Số thứ tự trong danh sách", example = "1")
    private Short numericalOrder;

    @NotBlank(message = "Ghi chú không được để trống.")
    @Size(max = 255, message = "Ghi chú không được vượt quá 255 ký tự.")
    @Schema(description = "Ghi chú cho lịch hẹn", example = "Khách hàng đến đúng giờ")
    private String note;

    @NotBlank(message = "Trạng thái không được để trống.")
    @Size(max = 15, message = "Trạng thái không được vượt quá 15 ký tự.")
    @Schema(description = "Trạng thái lịch hẹn", example = "confirmed")
    private AppointmentStatus status;

    @Schema(description = "Thời gian cập nhật", example = "2025-05-22T15:30:00")
    private LocalDateTime updatedAt;

    @Schema(description = "Người cập nhật", example = "admin")
    private String updatedBy;

    @Schema(description = "Thời gian tạo", example = "2025-05-20T10:00:00")
    private LocalDateTime createdAt;


    public AppointmentDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public @NotNull(message = "Dịch vụ không được để trống.") ServiceDTO getService() {
        return service;
    }

    public void setService(@NotNull(message = "Dịch vụ không được để trống.") ServiceDTO service) {
        this.service = service;
    }

    public @NotNull(message = "Lịch hẹn không được để trống.") ScheduleDTO getSchedule() {
        return schedule;
    }

    public void setSchedule(@NotNull(message = "Lịch hẹn không được để trống.") ScheduleDTO schedule) {
        this.schedule = schedule;
    }

    public @NotNull(message = "Khách hàng không được để trống.") CustomerDTO getCustomer() {
        return customer;
    }

    public void setCustomer(@NotNull(message = "Khách hàng không được để trống.") CustomerDTO customer) {
        this.customer = customer;
    }

    public @NotNull(message = "Số thứ tự không được để trống.") @Min(value = 1, message = "Số thứ tự phải lớn hơn hoặc bằng 1.") Short getNumericalOrder() {
        return numericalOrder;
    }

    public void setNumericalOrder(@NotNull(message = "Số thứ tự không được để trống.") @Min(value = 1, message = "Số thứ tự phải lớn hơn hoặc bằng 1.") Short numericalOrder) {
        this.numericalOrder = numericalOrder;
    }

    public @NotBlank(message = "Ghi chú không được để trống.") @Size(max = 255, message = "Ghi chú không được vượt quá 255 ký tự.") String getNote() {
        return note;
    }

    public void setNote(@NotBlank(message = "Ghi chú không được để trống.") @Size(max = 255, message = "Ghi chú không được vượt quá 255 ký tự.") String note) {
        this.note = note;
    }

    public @NotBlank(message = "Trạng thái không được để trống.") @Size(max = 15, message = "Trạng thái không được vượt quá 15 ký tự.") AppointmentStatus getStatus() {
        return status;
    }

    public void setStatus(@NotBlank(message = "Trạng thái không được để trống.") @Size(max = 15, message = "Trạng thái không được vượt quá 15 ký tự.") AppointmentStatus status) {
        this.status = status;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
