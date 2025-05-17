package com.ptithcm.clinic_booking.service;

import com.ptithcm.clinic_booking.dto.ScheduleDTO;
import com.ptithcm.clinic_booking.mapper.ScheduleMapper;
import com.ptithcm.clinic_booking.exception.ResourceNotFoundException;
import com.ptithcm.clinic_booking.model.Schedule;
import com.ptithcm.clinic_booking.model.ScheduleStatus;
import com.ptithcm.clinic_booking.repository.ScheduleRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScheduleServiceImpl implements ScheduleService{
    private final ScheduleRepository scheduleRepository;

    public ScheduleServiceImpl(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    @Override
    public ScheduleDTO getScheduleById(String id) {
        Schedule schedule = scheduleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy lịch trình với ID: " + id));
        return ScheduleMapper.toScheduleDTO(schedule);
    }

    @Override
    public List<ScheduleDTO> getAllSchedules() {
        List<Schedule> schedules = scheduleRepository.findAll();
        if(schedules == null) throw new ResourceNotFoundException("Không lấy được danh sách lịch trình.");
        return schedules.stream()
                .map(ScheduleMapper::toScheduleDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ScheduleDTO> getAllSchedules(Pageable pageable) {
        Page<Schedule> schedules = scheduleRepository.findAll(pageable);
        if(schedules == null) throw new ResourceNotFoundException("Không lấy được danh sách lịch trình.");
        return schedules.getContent()
                .stream()
                .map(ScheduleMapper::toScheduleDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ScheduleDTO> getSchedulesByStatus(ScheduleStatus status) {
        List<Schedule> schedules = scheduleRepository.findByStatus(status);
        if(schedules == null) throw new ResourceNotFoundException("Không lấy được danh sách lịch trình theo trạng thái:"+ status);
        return schedules.stream()
                .map(ScheduleMapper::toScheduleDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ScheduleDTO> getSchedulesByDoctor(String doctorId) {
        List<Schedule> schedules = scheduleRepository.findByDoctorId(doctorId);
        if(schedules == null) throw new ResourceNotFoundException("Không lấy được danh sách lịch trình theo bác sĩ có id:"+ doctorId);
        return schedules.stream()
                .map(ScheduleMapper::toScheduleDTO)
                .collect(Collectors.toList());
    }

//    @Override
//    public List<ScheduleDTO> getSchedulesByService(String serviceId) {
//        List<Schedule> schedules = scheduleRepository.findByServiceId(serviceId);
//        if(schedules == null) throw new ResourceNotFoundException("Không lấy được danh sách lịch trình theo bác sĩ có id:"+ serviceId);
//        return schedules.stream()
//                .map(ScheduleMapper::toScheduleDTO)
//                .collect(Collectors.toList());
//    }

    @Override
    public void addSchedule(ScheduleDTO scheduleDTO) {
        if(scheduleDTO == null) throw new IllegalArgumentException("Dữ liệu lịch trình không hợp lệ.");
        try{
            Schedule schedule = ScheduleMapper.toSchedule(scheduleDTO);
            schedule.setId(createScheduleId());
            scheduleRepository.save(schedule);
        }catch( Exception e){
            throw new RuntimeException("Lỗi khi thêm lịch trình: " + e.getMessage(), e);
        }
    }

    private String createScheduleId() {
        long countSchedule = scheduleRepository.count();
        return String.format("SCHE%010d",countSchedule + 1);
    }

    @Override
    public void updateSchedule(ScheduleDTO scheduleDTO) {
        if(scheduleDTO == null )
                throw new IllegalArgumentException("Dữ liệu lịch trình không hợp lệ.");
        String scheduleId = scheduleDTO.getId();
        if(scheduleId == null ||scheduleId.isBlank())
            throw new IllegalArgumentException("Dữ liệu lịch trình thiếu ID.");
        scheduleRepository.findById(scheduleId)
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy lịch trình với ID: " + scheduleId));
        try{
            Schedule schedule = ScheduleMapper.toSchedule(scheduleDTO);
            scheduleRepository.save(schedule);
        }catch( Exception e){
            throw new RuntimeException("Lỗi khi cập nhật lịch trình: " + e.getMessage(), e);
        }
    }

    @Override
    public void softDeleteSchedule(String id) {
        if(id == null || id.isBlank())
            throw new IllegalArgumentException(" ID lịch trình không hợp lệ.");
        try{
            Schedule s = scheduleRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Không thể xóa. Không tìm thấy lịch trình với ID: " + id));
            s.setStatus(ScheduleStatus.DELETED);
        }catch( Exception e){
            throw new RuntimeException("Lỗi khi xóa lịch trình: " + e.getMessage(), e);
        }
    }

    @Override
    public boolean isDoctorAvailable(String doctorId, LocalDate date) {
        long count = scheduleRepository.countByDoctorAndDate(doctorId, date);
        return count == 0; // Bác sĩ có thể tham gia nếu không có lịch nào tại thời gian đ
    }

//    @Override
//    public boolean isServiceAvailable(String serviceId, LocalDateTime time) {
//        long count = scheduleRepository.countByServiceAndTime(serviceId, time);
//        return count == 0; // Bác sĩ có thể tham gia nếu không có lịch nào tại thời gian đ
//    }
}
