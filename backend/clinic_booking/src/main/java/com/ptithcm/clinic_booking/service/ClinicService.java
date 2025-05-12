package com.ptithcm.clinic_booking.service;

import com.ptithcm.clinic_booking.dto.ClinicDTO;

import java.util.List;

public interface ClinicService {
    ClinicDTO getClinicById(String id);
    List<ClinicDTO> getAllClinics();
    List<ClinicDTO> getAllActiveClinics();

    void addClinic(ClinicDTO clinicDTO);
    void updateClinic(ClinicDTO clinicDTO);
    void softDeleteClinic(String clinicId);
}
