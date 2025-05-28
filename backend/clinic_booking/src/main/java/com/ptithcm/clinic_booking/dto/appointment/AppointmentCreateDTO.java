package com.ptithcm.clinic_booking.dto.appointment;

import com.ptithcm.clinic_booking.dto.customer.CustomerRequestDTO;
import com.ptithcm.clinic_booking.model.AppointmentStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class AppointmentCreateDTO {

    @NotNull(message = "Dịch vụ không được để trống.")
    @Schema(description = "Thông tin dịch vụ",example = "SV001")
    private String serviceId;

    @NotNull(message = "Lịch hẹn không được để trống.")
    @Schema(description = "Thông tin lịch trình", example = "10")
    private Integer scheduleId;

    @NotNull(message = "Khách hàng không được để trống.")
    @Schema(description = "Thông tin khách hàng")
    private CustomerRequestDTO customer;

    @NotNull(message = "Số thứ tự không được để trống.")
    @Min(value = 1, message = "Số thứ tự phải lớn hơn hoặc bằng 1.")
    @Schema(description = "Số thứ tự trong danh sách", example = "1")
    private Short numericalOrder;

    @NotBlank(message = "Ghi chú không được để trống.")
    @Size(max = 255, message = "Ghi chú không được vượt quá 255 ký tự.")
    @Schema(description = "Ghi chú cho lịch hẹn", example = "Khách hàng đến đúng giờ")
    private String note;

    @Schema(description = "Trạng thái lịch hẹn", example = "PENDING")
    private AppointmentStatus status;

    @Schema(description = "Người cập nhật", example = "null")
    private String updatedByUser;

    public AppointmentCreateDTO() {
    }

    public @NotNull(message = "Dịch vụ không được để trống.") String getServiceId() {
        return serviceId;
    }

    @NotNull(message = "Lịch hẹn không được để trống.")
    public Integer getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(@NotNull(message = "Lịch hẹn không được để trống.") Integer scheduleId) {
        this.scheduleId = scheduleId;
    }

    public void setServiceId(@NotNull(message = "Dịch vụ không được để trống.") String serviceId) {
        this.serviceId = serviceId;
    }

    public @NotNull(message = "Khách hàng không được để trống.") CustomerRequestDTO getCustomer() {
        return customer;
    }

    public void setCustomer(@NotNull(message = "Khách hàng không được để trống.") CustomerRequestDTO customer) {
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

    public AppointmentStatus getStatus() {
        return status;
    }

    public void setStatus(AppointmentStatus status) {
        this.status = status;
    }

    public String getUpdatedByUser() {
        return updatedByUser;
    }

    public void setUpdatedByUser(String updatedByUser) {
        this.updatedByUser = updatedByUser;
    }
}
