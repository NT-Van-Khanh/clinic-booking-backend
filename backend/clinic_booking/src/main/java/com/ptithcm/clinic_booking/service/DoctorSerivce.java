package com.ptithcm.clinic_booking.service;

import com.ptithcm.clinic_booking.dto.DoctorDTO;

import java.util.List;

public interface DoctorSerivce {
    DoctorDTO getDoctorById(String id);
    List<DoctorDTO> getAllDoctors();
    List<DoctorDTO> getAllActiveDoctors();

    void addDoctor(DoctorDTO doctor);
    void updateDoctor(DoctorDTO doctor);
    void blockDoctor(String id);
    void softDeletingDoctor(String id);
}
