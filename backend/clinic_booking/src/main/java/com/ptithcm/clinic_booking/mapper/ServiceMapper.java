package com.ptithcm.clinic_booking.mapper;

import com.ptithcm.clinic_booking.dto.service.ServiceCreateDTO;
import com.ptithcm.clinic_booking.dto.service.ServiceDTO;
import com.ptithcm.clinic_booking.model.Manager;
import com.ptithcm.clinic_booking.model.MedicalSpecialty;
import com.ptithcm.clinic_booking.model.Service;

public class ServiceMapper {
    public static ServiceDTO toServiceDTO(Service service){
        if(service == null) return null;
        return ServiceDTO.builder()
                .id(service.getId())
                // .creatorId(service.getCreator().getId())
                .medicalSpecialty(MedicalSpecialtyMapper.toResponseDTO(service.getMedicalSpecialty()))
                .name(service.getName())
                .description(service.getDescription())
                .status(service.getStatus())
                .createdAt(service.getCreatedAt())
                .build();
    }

    public static Service toService(ServiceDTO serviceDTO){
        if(serviceDTO == null) return null;

        return Service.builder()
                .id(serviceDTO.getId())
                .creator(new Manager())
                .medicalSpecialty(MedicalSpecialtyMapper.toEntity(serviceDTO.getMedicalSpecialty()))
                .name(serviceDTO.getName())
                .description(serviceDTO.getDescription())
                .status(serviceDTO.getStatus())
                .build();
    }

    public static Service toService(ServiceCreateDTO serviceDTO){
        if(serviceDTO == null) return null;
        Manager creator = new Manager(serviceDTO.getCreatorId());

        MedicalSpecialty specialty = new MedicalSpecialty(serviceDTO.getMedicalSpecialtyId());

        return Service.builder()
                .creator(creator)
                .medicalSpecialty(specialty)
                .name(serviceDTO.getName())
                .description(serviceDTO.getDescription())
                .status(serviceDTO.getStatus())
                .build();
    }
}
