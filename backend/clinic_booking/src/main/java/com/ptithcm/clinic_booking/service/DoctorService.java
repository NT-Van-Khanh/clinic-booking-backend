package com.ptithcm.clinic_booking.service;

import com.ptithcm.clinic_booking.dto.doctor.DoctorCreateDTO;
import com.ptithcm.clinic_booking.dto.doctor.DoctorSimpleResponseDTO;
import com.ptithcm.clinic_booking.dto.doctor.DoctorResponseDTO;

import java.util.List;

public interface DoctorService {
    DoctorSimpleResponseDTO getDoctorSimpleById(String id);
    DoctorResponseDTO getDoctorById(String id);
    List<DoctorResponseDTO> getAllDoctors();
    List<DoctorSimpleResponseDTO> getAllActiveDoctors();
//    List<DoctorDTO> getDoctorsByService(String serviceId);
    List<DoctorSimpleResponseDTO> getDoctorsByMedicalSpecialty(String medicalSpecialtyId);

    void addDoctor(DoctorCreateDTO doctorDTO);
    void updateDoctor(DoctorSimpleResponseDTO doctor);
    void blockDoctor(String id);
    void softDeletingDoctor(String id);
}
