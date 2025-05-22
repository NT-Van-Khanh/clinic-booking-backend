package com.ptithcm.clinic_booking.dto;

import com.ptithcm.clinic_booking.dto.doctor.DoctorSimpleResponseDTO;
import com.ptithcm.clinic_booking.model.ScheduleStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class ScheduleDTO {
    private String id;

    @NotNull(message = "Thông tin bác sĩ không được để trống")
    @Schema(description = "Thông tin bác sĩ")
    private DoctorSimpleResponseDTO doctor;

    @NotNull(message = "Thông tin phòng khám không được để trống")
    @Schema(description = "Thông tin phòng khám")
    private ClinicDTO clinic;

    @NotNull(message = "Ngày không được để trống")
    @FutureOrPresent(message = "Ngày phải là hôm nay hoặc trong tương lai")
    @Schema(description = "Ngày khám", example = "2025-06-01")
    private LocalDate date;

    @NotNull(message = "Thời gian bắt đầu không được để trống")
    @Schema(description = "Thời gian bắt đầu khám", example = "08:00:00")
    private LocalTime timeStart;

    @NotNull(message = "Thời gian kết thúc không được để trống")
    @Schema(description = "Thời gian kết thúc khám", example = "10:00:00")
    private LocalTime timeEnd;

    @NotNull(message = "Số lượt đặt tối đa không được để trống")
    @Min(value = 1, message = "Số lượt đặt tối thiểu là 1")
    @Schema(description = "Số lượt đặt tối đa", example = "10")
    private Short maxBooking;

    @Schema(description = "Trạng thái lịch khám", example = "UPCOMING")
    private ScheduleStatus status = ScheduleStatus.UPCOMING;

    @Schema(description = "Ngày tạo", example = "2025-05-22T10:00:00")
    private LocalDateTime createdAt;

    public ScheduleDTO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public @NotNull(message = "Thông tin bác sĩ không được để trống") DoctorSimpleResponseDTO getDoctor() {
        return doctor;
    }

    public void setDoctor(@NotNull(message = "Thông tin bác sĩ không được để trống") DoctorSimpleResponseDTO doctor) {
        this.doctor = doctor;
    }

    public @NotNull(message = "Thông tin phòng khám không được để trống") ClinicDTO getClinic() {
        return clinic;
    }

    public void setClinic(@NotNull(message = "Thông tin phòng khám không được để trống") ClinicDTO clinic) {
        this.clinic = clinic;
    }

    public @NotNull(message = "Ngày không được để trống") @FutureOrPresent(message = "Ngày phải là hôm nay hoặc trong tương lai") LocalDate getDate() {
        return date;
    }

    public void setDate(@NotNull(message = "Ngày không được để trống") @FutureOrPresent(message = "Ngày phải là hôm nay hoặc trong tương lai") LocalDate date) {
        this.date = date;
    }

    public @NotNull(message = "Thời gian bắt đầu không được để trống") LocalTime getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(@NotNull(message = "Thời gian bắt đầu không được để trống") LocalTime timeStart) {
        this.timeStart = timeStart;
    }

    public @NotNull(message = "Thời gian kết thúc không được để trống") LocalTime getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(@NotNull(message = "Thời gian kết thúc không được để trống") LocalTime timeEnd) {
        this.timeEnd = timeEnd;
    }

    public @NotNull(message = "Số lượt đặt tối đa không được để trống") @Min(value = 1, message = "Số lượt đặt tối thiểu là 1") Short getMaxBooking() {
        return maxBooking;
    }

    public void setMaxBooking(@NotNull(message = "Số lượt đặt tối đa không được để trống") @Min(value = 1, message = "Số lượt đặt tối thiểu là 1") Short maxBooking) {
        this.maxBooking = maxBooking;
    }

    public ScheduleStatus getStatus() {
        return status;
    }

    public void setStatus(ScheduleStatus status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
