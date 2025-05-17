package com.ptithcm.clinic_booking.mapper;

import com.ptithcm.clinic_booking.dto.AppointmentDTO;
import com.ptithcm.clinic_booking.model.Appointment;

public class AppointmentMapper {
    public static Appointment toAppointment(AppointmentDTO dto){
        if (dto == null) return null;
        Appointment appointment = new Appointment();

        appointment.setId(dto.getId());
        appointment.setService(ServiceMapper.toService(dto.getService()));
        appointment.setSchedule(ScheduleMapper.toSchedule(dto.getSchedule()));
        appointment.setCustomer(CustomerMapper.toCustomer(dto.getCustomer()));
        appointment.setNumericalOrder(dto.getNumericalOrder());
        appointment.setNote(dto.getNote());
        appointment.setStatus(dto.getStatus());
        appointment.setUpdatedAt(dto.getUpdatedAt());
        appointment.setUpdatedBy(dto.getUpdatedBy());
        return appointment;
    }

    public static AppointmentDTO toAppointmentDTO(Appointment appointment){
        if (appointment == null) return null;
        AppointmentDTO dto = new AppointmentDTO();

        dto.setId(appointment.getId());
        dto.setService(ServiceMapper.toServiceDTO(appointment.getService()));
        dto.setSchedule(ScheduleMapper.toScheduleDTO(appointment.getSchedule()));
        dto.setCustomer(CustomerMapper.toCustomerDTO(appointment.getCustomer()));
        dto.setNumericalOrder(appointment.getNumericalOrder());
        dto.setNote(appointment.getNote());
        dto.setStatus(appointment.getStatus());
        dto.setUpdatedAt(appointment.getUpdatedAt());
        dto.setUpdatedBy(appointment.getUpdatedBy());
        dto.setCreatedAt(appointment.getCreatedAt());

        return dto;
    }
}
