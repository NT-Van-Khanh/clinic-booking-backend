package com.ptithcm.clinic_booking.mapper;

import com.ptithcm.clinic_booking.dto.appointment.AppointmentCreateDTO;
import com.ptithcm.clinic_booking.dto.appointment.AppointmentDTO;
import com.ptithcm.clinic_booking.model.Appointment;
import com.ptithcm.clinic_booking.model.Schedule;
import com.ptithcm.clinic_booking.model.Service;

public class AppointmentMapper {
    public static Appointment toAppointment(AppointmentDTO dto){
        if (dto == null) return null;

        return Appointment.builder()
                .id(dto.getId())
                .service(ServiceMapper.toService(dto.getService()))
                .schedule(ScheduleMapper.toSchedule(dto.getSchedule()))
                .customer(CustomerMapper.toCustomer(dto.getCustomer()))
                .numericalOrder(dto.getNumericalOrder())
                .note(dto.getNote())
                .status(dto.getStatus())
                .updatedAt(dto.getUpdatedAt())
                .updatedBy(dto.getUpdatedBy())
                .build();
    }

    public static AppointmentDTO toAppointmentDTO(Appointment appointment){
        if (appointment == null) return null;

        return AppointmentDTO.builder()
                .id(appointment.getId())
                .service(ServiceMapper.toServiceDTO(appointment.getService()))
                .schedule(ScheduleMapper.toScheduleDTO(appointment.getSchedule()))
                .customer(CustomerMapper.toCustomerDTO(appointment.getCustomer()))
                .numericalOrder(appointment.getNumericalOrder())
                .note(appointment.getNote())
                .status(appointment.getStatus())
                .updatedAt(appointment.getUpdatedAt())
                .updatedBy(appointment.getUpdatedBy())
                .createdAt(appointment.getCreatedAt())
                .build();
    }

    public static Appointment toAppointment(AppointmentCreateDTO dto){
        if (dto == null) return null;

        return Appointment.builder()
                .service(new Service(dto.getServiceId()))
                .schedule(new Schedule(dto.getScheduleId()))
                .customer(CustomerMapper.toCustomer(dto.getCustomer()))
//                .numericalOrder(dto.getNumericalOrder())
                .note(dto.getNote())
                .status(dto.getStatus())
                .updatedBy(dto.getUpdatedByUser())
                .build();
    }
}
