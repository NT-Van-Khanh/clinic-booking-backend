package com.ptithcm.clinic_booking.repository;

import com.ptithcm.clinic_booking.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {
    List<Appointment> findAllByCustomerId(Integer customerId);
}
