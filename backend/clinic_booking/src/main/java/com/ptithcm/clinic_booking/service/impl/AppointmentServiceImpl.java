package com.ptithcm.clinic_booking.service.impl;

import com.ptithcm.clinic_booking.dto.AppointmentDTO;
import com.ptithcm.clinic_booking.exception.ResourceNotFoundException;
import com.ptithcm.clinic_booking.mapper.AppointmentMapper;
import com.ptithcm.clinic_booking.model.Appointment;
import com.ptithcm.clinic_booking.model.AppointmentStatus;
import com.ptithcm.clinic_booking.repository.AppointmentRepository;
import com.ptithcm.clinic_booking.service.AppointmentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AppointmentServiceImpl implements AppointmentService {
    private final AppointmentRepository appointmentRepository;

    public AppointmentServiceImpl(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public AppointmentDTO getAppointmentById(String id) {
        Appointment appointment = appointmentRepository.findById(Integer.valueOf(id))
                .orElseThrow(() -> new ResourceNotFoundException("Appointment not found with id: " + id));
        return AppointmentMapper.toAppointmentDTO(appointment);
    }

    @Override
    public Page<AppointmentDTO> getAppointmentsByDate(LocalDate date, Pageable pageable) {
        Page<Appointment> page = appointmentRepository.findByScheduleDate(date, pageable);
        return page.map(AppointmentMapper::toAppointmentDTO);
    }

    @Override
    public Page<AppointmentDTO> getAllAppointments(Pageable pageable) {
        Page<Appointment> page = appointmentRepository.findAll(pageable);
        return page.map(AppointmentMapper::toAppointmentDTO);
    }

    @Override
    public Page<AppointmentDTO> getAppointmentsByStatus(AppointmentStatus status, Pageable pageable) {
        Page<Appointment> page = appointmentRepository.findByStatus(status, pageable);
        return page.map(AppointmentMapper::toAppointmentDTO);
    }

    @Override
    public Page<AppointmentDTO> searchAppointments(String keyword, Pageable pageable) {
        Page<Appointment> page = appointmentRepository.searchByKeyword(keyword, pageable);
        return page.map(AppointmentMapper::toAppointmentDTO);
    }

    @Override
    public AppointmentDTO getAppointmentByCustomerInfo(String email, String phone, String scheduleId) {
        Appointment appointment = appointmentRepository
                .findByCustomerEmailAndCustomerPhoneAndScheduleId(email, phone, scheduleId)
                .orElseThrow(() -> new ResourceNotFoundException("Appointment not found with given customer info"));
        return AppointmentMapper.toAppointmentDTO(appointment);
    }

    @Override
    public void addAppointment(AppointmentDTO appointmentDTO) {
        Appointment appointment = AppointmentMapper.toAppointment(appointmentDTO);
        appointmentRepository.save(appointment);
    }

    @Override
    public List<AppointmentDTO> getAppointmentsBySchedule(String scheduleId) {
        List<Appointment> appointments = appointmentRepository.findByScheduleId(scheduleId);
        return appointments.stream()
                .map(AppointmentMapper::toAppointmentDTO)
                .collect(Collectors.toList());
    }

    @Override
    public int countAppointmentsBySchedule(String scheduleId) {
        return appointmentRepository.countByScheduleId(scheduleId);
    }

    @Override
    public void changeAppointmentStatus(String id, AppointmentStatus status) {
        Appointment appointment = appointmentRepository.findById(Integer.valueOf(id))
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy lịch hẹn với ID: " + id));
        appointment.setStatus(status);
        appointmentRepository.save(appointment);
    }

    @Override
    public void updateAppointment(AppointmentDTO appointmentDTO) {
        appointmentRepository.findById(appointmentDTO.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy lịch hẹn với ID: " + appointmentDTO.getId()));
        Appointment appointment = AppointmentMapper.toAppointment(appointmentDTO);
        appointmentRepository.save(appointment);
    }

    @Override
    public void softDeleteAppointment(String id) {
        Appointment appointment = appointmentRepository.findById(Integer.valueOf(id))
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy lịch hẹn với ID: " + id));
        appointment.setStatus(AppointmentStatus.DELETED);
        appointmentRepository.save(appointment);
    }
}
