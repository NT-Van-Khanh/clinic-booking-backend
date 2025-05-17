package com.ptithcm.clinic_booking.service;

import com.ptithcm.clinic_booking.dto.specialty.BaseMedicalSpecialtyDTO;
import com.ptithcm.clinic_booking.dto.specialty.MedicalSpecialtyRequestDTO;
import com.ptithcm.clinic_booking.dto.specialty.MedicalSpecialtyResponseDTO;

import java.util.List;

public interface MedicalSpecialtyService {
    // ----- MANAGER -----
    List<MedicalSpecialtyResponseDTO> getAllMSpecialties();
    MedicalSpecialtyResponseDTO getMSpecialtyById(String id);
    void addMSpecialty(MedicalSpecialtyRequestDTO specialtyRequestDTO);
    void updateMSpecialty(MedicalSpecialtyRequestDTO specialtyRequestDTO);
    void softDeleteMSpecialty(String specialtyId);


    List<BaseMedicalSpecialtyDTO> getAllActiveMSpecialties();
}
