package com.ptithcm.clinic_booking.controller;

import com.ptithcm.clinic_booking.dto.ScheduleDTO;
import com.ptithcm.clinic_booking.model.ApiResponse;
import com.ptithcm.clinic_booking.model.ScheduleStatus;
import com.ptithcm.clinic_booking.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/schedule")
public class ScheduleController {
    private final ScheduleService scheduleService;

    @Autowired
    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<ScheduleDTO>> getScheduleById(@PathVariable String id){
        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK, scheduleService.getScheduleById(id)));
    }

    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<ScheduleDTO>>> getAllSchedules(){
        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK, scheduleService.getAllSchedules()));
    }

    @GetMapping("/page")
    public ResponseEntity<ApiResponse<List<ScheduleDTO>>> getSchedulesPage(Pageable pageable){
        List<ScheduleDTO> schedules = scheduleService.getAllSchedules(pageable);
        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK, schedules));
    }

    @GetMapping("/by_status/{status}")
    public ResponseEntity<ApiResponse<List<ScheduleDTO>>> getAllSchedulesByStatus(@PathVariable ScheduleStatus status){
        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK, scheduleService.getSchedulesByStatus(status)));
    }
    @GetMapping("/by_doctor/{doctorId}")
    public ResponseEntity<ApiResponse<List<ScheduleDTO>>> getAllSchedulesByDoctor(@PathVariable String doctorId){
        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK, scheduleService.getSchedulesByDoctor(doctorId)));
    }

    @PostMapping("/add")
    public ResponseEntity<ApiResponse<String>> addSchedule(@RequestBody ScheduleDTO schedule){
        scheduleService.addSchedule(schedule);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse<>(HttpStatus.CREATED,"Thêm lịch trình thành công."));
    }

    @PutMapping("/update")
    public ResponseEntity<ApiResponse<String>> updateSchedule(@RequestBody ScheduleDTO schedule){
        scheduleService.updateSchedule(schedule);
        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK,"Cập nhật lịch trình thành công."));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse<String>> softDeleteSchedule(@PathVariable String id) {
        scheduleService.softDeleteSchedule(id);
        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK,"Xóa lịch trình thành công."));
    }
}
