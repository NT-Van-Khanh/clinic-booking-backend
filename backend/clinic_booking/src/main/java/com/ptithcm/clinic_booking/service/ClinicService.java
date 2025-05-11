package com.ptithcm.clinic_booking.service;

import org.springframework.stereotype.Service;
import com.ptithcm.clinic_booking.model.Clinic;
import com.ptithcm.clinic_booking.repository.ClinicRepository;

import java.util.List;

@Service
public class ClinicService {
    private final ClinicRepository clinicRepository;

    public ClinicService(ClinicRepository clinicRepository) {
        this.clinicRepository = clinicRepository;
    }

    public Clinic getClinicById(String id){
        return clinicRepository.getById(id);
    }

    public List<Clinic> getAllClinic(){
        return clinicRepository.findAll();
    }
}
