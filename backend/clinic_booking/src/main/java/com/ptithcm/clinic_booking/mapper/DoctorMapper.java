package com.ptithcm.clinic_booking.mapper;

import com.ptithcm.clinic_booking.dto.doctor.DoctorCreateDTO;
import com.ptithcm.clinic_booking.dto.doctor.DoctorSimpleResponseDTO;
import com.ptithcm.clinic_booking.dto.doctor.DoctorResponseDTO;
import com.ptithcm.clinic_booking.model.Doctor;
import com.ptithcm.clinic_booking.model.MedicalSpecialty;

public class DoctorMapper {

    public static DoctorSimpleResponseDTO toDoctorSimpleDTO(Doctor doctor){
        if(doctor == null) return null;
        return DoctorSimpleResponseDTO.builder()
                .id(doctor.getId())
                .medicalSpecialtyId(doctor.getMedicalSpecialty().getId())
                .name(doctor.getName())
                .phone(doctor.getPhone())
                .email(doctor.getEmail())
                .address(doctor.getAddress())
                .gender(doctor.getGender())
                .imageLink(doctor.getImageLink())
                .createdAt(doctor.getCreatedAt())
                .birthday(doctor.getBirthday())
                .description(doctor.getDescription())
                .qualification(doctor.getQualification())
                .build();
    }
    public static DoctorResponseDTO toDoctorDTO(Doctor doctor){
        if(doctor == null) return null;
        return DoctorResponseDTO.builder()
                .id(doctor.getId())
                .account(AccountMapper.toAccountResponseDTO(doctor.getAccount()))
                .medicalSpecialtyId(doctor.getMedicalSpecialty().getId())
                .name(doctor.getName())
                .phone(doctor.getPhone())
                .email(doctor.getEmail())
                .address(doctor.getAddress())
                .gender(doctor.getGender())
                .imageLink(doctor.getImageLink())
                .status(doctor.getStatus())
                .createdAt(doctor.getCreatedAt())
                .birthday(doctor.getBirthday())
                .description(doctor.getDescription())
                .qualification(doctor.getQualification())
                .build();
    }

    public static Doctor toDoctor(DoctorCreateDTO doctorDTO){
        if (doctorDTO == null) return null;

        MedicalSpecialty specialty = MedicalSpecialty.builder()
                .id(doctorDTO.getMedicalSpecialtyId())
                .build();
        //.id(doctorDTO.getId())
        return Doctor.builder()
                .account(AccountMapper.toAccount(doctorDTO.getAccount()))
                .medicalSpecialty(specialty)
                .name(doctorDTO.getName())
                .phone(doctorDTO.getPhone())
                .email(doctorDTO.getEmail())
                .address(doctorDTO.getAddress())
                .gender(doctorDTO.getGender())
                .status(doctorDTO.getStatus())
                .birthday(doctorDTO.getBirthday())
                .description(doctorDTO.getDescription())
                .qualification(doctorDTO.getQualification())
                .imageLink(doctorDTO.getLink())
                .build();
    }

    public static Doctor toDoctor(DoctorSimpleResponseDTO doctorDTO){
        if (doctorDTO == null) return null;

        MedicalSpecialty specialty = MedicalSpecialty.builder()
                .id(doctorDTO.getMedicalSpecialtyId())
                .build();

        return Doctor.builder()
                .id(doctorDTO.getId())
                .medicalSpecialty(specialty)
                .imageLink(doctorDTO.getImageLink())
                .name(doctorDTO.getName())
                .phone(doctorDTO.getPhone())
                .email(doctorDTO.getEmail())
                .address(doctorDTO.getAddress())
                .gender(doctorDTO.getGender())
                .qualification(doctorDTO.getQualification())
                .description(doctorDTO.getDescription())
                .build();
    }
}
