package com.ptithcm.clinic_booking.mapper;

import com.ptithcm.clinic_booking.dto.specialty.BaseMedicalSpecialtyDTO;
import com.ptithcm.clinic_booking.dto.specialty.MedicalSpecialtyRequestDTO;
import com.ptithcm.clinic_booking.dto.specialty.MedicalSpecialtyResponseDTO;
import com.ptithcm.clinic_booking.model.MedicalSpecialty;

public class MedicalSpecialtyMapper {
    public static MedicalSpecialtyResponseDTO toResponseDTO(MedicalSpecialty specialty){
        if(specialty == null) return null;
        return MedicalSpecialtyResponseDTO.builder()
                .id(specialty.getId())
                .name(specialty.getName())
                .description(specialty.getDescription())
                .status(specialty.getStatus())
                .createdAt(specialty.getCreatedAt())
                .build();
    }

    public static MedicalSpecialty toEntity(MedicalSpecialtyRequestDTO specialtyRequestDTO) {
        if (specialtyRequestDTO == null) return null;

        return MedicalSpecialty.builder()
                .id(specialtyRequestDTO.getId())
                .name(specialtyRequestDTO.getName())
                .description(specialtyRequestDTO.getDescription())
                .status(specialtyRequestDTO.getStatus())
                .build();
    }

    public static MedicalSpecialty toEntity(BaseMedicalSpecialtyDTO specialtyRequestDTO) {
        if (specialtyRequestDTO == null) return null;

        return MedicalSpecialty.builder()
                .id(specialtyRequestDTO.getId())
                .name(specialtyRequestDTO.getName())
                .description(specialtyRequestDTO.getDescription())
                .build();
    }

    public static BaseMedicalSpecialtyDTO toBaseDTO(MedicalSpecialty specialty) {
        if (specialty == null) return null;

        return BaseMedicalSpecialtyDTO.builder()
                .id(specialty.getId())
                .name(specialty.getName())
                .description(specialty.getDescription())
                .build();
    }
}
