package com.ptithcm.clinic_booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ptithcm.clinic_booking.model.Clinic;

import java.util.List;

@Repository
public interface ClinicRepository extends JpaRepository<Clinic, String> {
    Clinic getById(String id);
    List<Clinic> findAll();
}
