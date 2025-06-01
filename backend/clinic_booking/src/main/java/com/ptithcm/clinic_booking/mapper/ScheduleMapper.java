package com.ptithcm.clinic_booking.mapper;

import com.ptithcm.clinic_booking.dto.schedule.ScheduleCreateDTO;
import com.ptithcm.clinic_booking.dto.schedule.ScheduleDTO;
import com.ptithcm.clinic_booking.model.Clinic;
import com.ptithcm.clinic_booking.model.Doctor;
import com.ptithcm.clinic_booking.model.Schedule;
import com.ptithcm.clinic_booking.model.ScheduleStatus;

public class ScheduleMapper {
    public static ScheduleDTO toScheduleDTO(Schedule schedule) {
        if (schedule == null) return null;
        return ScheduleDTO.builder()
                .id(schedule.getId())
                .doctor(DoctorMapper.toDoctorSimpleDTO(schedule.getDoctor()))
                .clinic(ClinicMapper.toClinicDTO(schedule.getClinic()))
                .date(schedule.getDate())
                .timeStart(schedule.getTimeStart())
                .timeEnd(schedule.getTimeEnd())
                .maxBooking(schedule.getMaxBooking())
                .status(schedule.getStatus())
                .createdAt(schedule.getCreatedAt())
                .build();
    }

    public static Schedule toSchedule(ScheduleDTO dto) {
        if (dto == null) return null;

        return Schedule.builder()
                .id(dto.getId())
                .date(dto.getDate())
                .timeStart(dto.getTimeStart())
                .timeEnd(dto.getTimeEnd())
                .maxBooking(dto.getMaxBooking())
                .status(dto.getStatus() != null ? dto.getStatus() : ScheduleStatus.PENDING)
                .doctor(DoctorMapper.toDoctor(dto.getDoctor()))
                .clinic(ClinicMapper.toClinic(dto.getClinic()))
                .build();
    }

    public static Schedule toSchedule(ScheduleCreateDTO dto) {
        if (dto == null) return null;

        Doctor doctor = new Doctor(dto.getDoctorId());
        Clinic clinic = new Clinic(dto.getClinicId());
        return Schedule.builder()
                .date(dto.getDate())
                .timeStart(dto.getTimeStart())
                .timeEnd(dto.getTimeEnd())
                .maxBooking(dto.getMaxBooking())
                .status(dto.getStatus() != null ? dto.getStatus() : ScheduleStatus.PENDING)
                .doctor(doctor)
                .clinic(clinic)
                .build();
    }
}
