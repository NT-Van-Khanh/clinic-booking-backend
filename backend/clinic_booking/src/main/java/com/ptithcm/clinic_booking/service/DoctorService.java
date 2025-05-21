package com.ptithcm.clinic_booking.service;

import com.ptithcm.clinic_booking.dto.doctor.DoctorDTO;

import java.util.List;

public interface DoctorService {
    DoctorDTO getDoctorById(String id);
    List<DoctorDTO> getAllDoctors();
    List<DoctorDTO> getAllActiveDoctors();
//    List<DoctorDTO> getDoctorsByService(String serviceId);
    List<DoctorDTO> getDoctorsByMedicalSpecialty(String medicalSpecialtyId);

    void addDoctor(DoctorDTO doctor);
    void updateDoctor(DoctorDTO doctor);
    void blockDoctor(String id);
    void softDeletingDoctor(String id);
}
