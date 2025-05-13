package com.ptithcm.clinic_booking.model;

import io.swagger.v3.oas.annotations.media.Schema;

public enum ScheduleStatus {
    @Schema(description = "Lịch đang diễn ra, cho phép đặt nếu trống")
    ONGOING("Lịch đang diễn ra, cho phép đặt nếu trống"),

    @Schema(description = "Lịch được đăng ký")
    ACTIVE("Lịch được đăng ký"),

    @Schema(description = "Lịch sắp tới, cho phép đặt nếu trống")
    UPCOMING("Lịch sắp tới, cho phép đặt nếu trống"),

    @Schema(description = "Lịch tạm dừng (nghỉ phép đột xuất)")
    PAUSED("Lịch tạm dừng (nghỉ phép đột xuất)"),

    @Schema(description = "Lịch đã quá hạn")
    EXPIRED("Lịch đã quá hạn"),

    @Schema(description = "Lịch bị hủy bởi bác sĩ")
    CANCELED("Lịch bị hủy bởi bác sĩ"),

    @Schema(description = "Lịch bị xóa")
    DELETED("Lịch bị xóa.");

    private String label;

    ScheduleStatus(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
