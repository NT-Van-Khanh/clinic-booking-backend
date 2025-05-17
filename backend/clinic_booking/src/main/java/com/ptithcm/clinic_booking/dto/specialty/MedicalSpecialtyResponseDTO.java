package com.ptithcm.clinic_booking.dto.specialty;
import java.time.LocalDateTime;

public class MedicalSpecialtyResponseDTO extends BaseMedicalSpecialtyDTO{
    private String status;
    private LocalDateTime createdAt;

    public MedicalSpecialtyResponseDTO() {
        super();
    }

    public MedicalSpecialtyResponseDTO(String id, String name, String description, String status, LocalDateTime createdAt) {
        super(id, name, description);
        this.status = status;
        this.createdAt = createdAt;
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
