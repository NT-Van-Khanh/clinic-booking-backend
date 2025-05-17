package com.ptithcm.clinic_booking.dto.specialty;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class MedicalSpecialtyRequestDTO extends BaseMedicalSpecialtyDTO{
    @NotBlank(message = "Trạng thái không được để trống.")
    @Size(max = 15, message = "Trạng thái không được vượt quá 15 ký tự.")
    private String status;

    public MedicalSpecialtyRequestDTO() {
        super();
    }

    public MedicalSpecialtyRequestDTO(String id, String name, String description, String status) {
        super(id, name, description);
        this.status = status;
    }

    public @NotBlank(message = "Trạng thái không được để trống.") @Size(max = 15, message = "Trạng thái không được vượt quá 15 ký tự.") String getStatus() {
        return status;
    }

    public void setStatus(@NotBlank(message = "Trạng thái không được để trống.") @Size(max = 15, message = "Trạng thái không được vượt quá 15 ký tự.") String status) {
        this.status = status;
    }

}
