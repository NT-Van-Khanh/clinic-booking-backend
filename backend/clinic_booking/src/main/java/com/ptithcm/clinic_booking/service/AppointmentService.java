package com.ptithcm.clinic_booking.service;

import com.ptithcm.clinic_booking.dto.AppointmentDTO;
import com.ptithcm.clinic_booking.model.AppointmentStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;

public interface AppointmentService {
    //Chung
    AppointmentDTO getAppointmentById(String id);
    Page<AppointmentDTO> getAppointmentsByDate(LocalDate date, Pageable pageable);

    // Quản lý: phân trang
    Page<AppointmentDTO> getAllAppointments(Pageable pageable);
    Page<AppointmentDTO> getAppointmentsByStatus(AppointmentStatus status, Pageable pageable);
    Page<AppointmentDTO> searchAppointments(String keyword, Pageable pageable);
    void softDeleteAppointment(String appointmentId);

    // Khách hàng-public
    AppointmentDTO getAppointmentByCustomerInfo(String email, String phone, String scheduleId);
    void addAppointment(AppointmentDTO appointmentDTO);
    void updateAppointment(AppointmentDTO appointmentDTO);

    // Bác sĩ- Quan lý
    List<AppointmentDTO> getAppointmentsBySchedule(String scheduleId);
    int countAppointmentsBySchedule(String scheduleId);
    void changeAppointmentStatus(String id, AppointmentStatus status);
    }


//    List<AppointmentDTO> getAppointmentsByDoctor(String doctorId);
//    List<AppointmentDTO> getAppointmentsByDoctorAndSchedule(String doctorId, String scheduleId);