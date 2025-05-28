package com.ptithcm.clinic_booking.dto.specialty;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class BaseMedicalSpecialtyDTO {
    @Schema(description = "Mã chuyên khoa", example = "MS01")
    private String id;

    @NotNull(message = "Tên chuyên khoa không được để trống.")
    @Size(max = 100, message = "Tên chuyên khoa không được vượt quá 100 ký tự.")
    private String name;
    private String description;

    public BaseMedicalSpecialtyDTO() {
    }

    public BaseMedicalSpecialtyDTO(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public @NotNull(message = "Tên chuyên khoa không được để trống.") @Size(max = 100, message = "Tên chuyên khoa không được vượt quá 100 ký tự.") String getName() {
        return name;
    }

    public void setName(@NotNull(message = "Tên chuyên khoa không được để trống.") @Size(max = 100, message = "Tên chuyên khoa không được vượt quá 100 ký tự.") String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
