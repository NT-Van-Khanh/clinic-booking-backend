package com.ptithcm.clinic_booking.service;

import com.ptithcm.clinic_booking.dto.ScheduleDTO;
import com.ptithcm.clinic_booking.model.ScheduleStatus;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface ScheduleService {
    ScheduleDTO getScheduleById(String id);
    List<ScheduleDTO> getAllSchedules();
    List<ScheduleDTO> getAllSchedules(Pageable pageable);
    List<ScheduleDTO> getSchedulesByStatus(ScheduleStatus status);
    List<ScheduleDTO> getSchedulesByDoctor(String doctorId);
//    List<ScheduleDTO> getSchedulesByService(String serviceId);

    void addSchedule(ScheduleDTO scheduleDTO);
    void updateSchedule(ScheduleDTO scheduleDTO);
    void softDeleteSchedule(String id);

    boolean isDoctorAvailable(String doctorId, LocalDate date);
//    boolean isServiceAvailable(String serviceId, LocalDateTime time);
}
