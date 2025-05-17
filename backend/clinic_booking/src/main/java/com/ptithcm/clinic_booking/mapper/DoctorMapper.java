package com.ptithcm.clinic_booking.mapper;

import com.ptithcm.clinic_booking.dto.DoctorDTO;
import com.ptithcm.clinic_booking.model.Account;
import com.ptithcm.clinic_booking.model.Doctor;
import com.ptithcm.clinic_booking.model.MedicalSpecialty;

public class DoctorMapper {

    public static DoctorDTO toDoctorDTO(Doctor doctor){
        if(doctor == null) return null;
        DoctorDTO d = new DoctorDTO();
        d.setId(doctor.getId());
        d.setAccountId(doctor.getAccount().getUsername());
        d.setMedicalSpecialtyId(doctor.getMedicalSpecialty().getId());
        d.setName(doctor.getName());
        d.setPhone(doctor.getPhone());
        d.setEmail(doctor.getEmail());
        d.setAddress(doctor.getAddress());
        d.setGender(doctor.getGender());
        d.setStatus(doctor.getStatus());
        d.setCreatedAt(doctor.getCreatedAt());
        return d;
    }

    public static Doctor toDoctor(DoctorDTO doctorDTO){
        if(doctorDTO == null) return null;
        Doctor d = new Doctor();
        d.setId(doctorDTO.getId());

        Account account = new Account();
        account.setUsername(doctorDTO.getAccountId());
        d.setAccount(account);

        MedicalSpecialty specialty = new MedicalSpecialty();
        specialty.setId(doctorDTO.getMedicalSpecialtyId());
        d.setMedicalSpecialty(specialty);

        d.setName(doctorDTO.getName());
        d.setPhone(doctorDTO.getPhone());
        d.setEmail(doctorDTO.getEmail());
        d.setAddress(doctorDTO.getAddress());
        d.setGender(doctorDTO.getGender());
        d.setStatus(doctorDTO.getStatus());
        return d;
    }
}
