package com.ptithcm.clinic_booking.controller;

import com.ptithcm.clinic_booking.dto.AppointmentDTO;
import com.ptithcm.clinic_booking.model.ApiResponse;
import com.ptithcm.clinic_booking.model.AppointmentStatus;
import com.ptithcm.clinic_booking.model.PageResponse;
import com.ptithcm.clinic_booking.service.AppointmentService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Validated
@RequestMapping("/api/appointment")
@RestController
public class AppointmentController {

    private final AppointmentService appointmentService;

    @Autowired
    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<AppointmentDTO>> getAppointmentById(@PathVariable @NotBlank String id){
        AppointmentDTO appointment = appointmentService.getAppointmentById(id);
        return ResponseEntity.ok( new ApiResponse<>(HttpStatus.OK, appointment));
    }
    @GetMapping("/by-customer-schedule")
    public ResponseEntity<ApiResponse<AppointmentDTO>> getAppointmentByCustomerAndSchedule(@RequestParam String email,
                                                                                          @RequestParam String phone,
                                                                                          @RequestParam @NotBlank String scheduleId){
        AppointmentDTO appointment = appointmentService.getAppointmentByCustomerInfo(email, phone, scheduleId);
        return ResponseEntity.ok( new ApiResponse<>(HttpStatus.OK, appointment));
    }

    @GetMapping("/page")
    public ResponseEntity<ApiResponse<PageResponse<AppointmentDTO>>> getAppointmentsPage(
            @PageableDefault(size = 20, sort = "date", direction = Sort.Direction.DESC) Pageable pageable){
        Page<AppointmentDTO> pageAppointments = appointmentService.getAllAppointments(pageable);
        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK,  new PageResponse<>(pageAppointments)));
    }

    @GetMapping("/by-status/{status}")
    public ResponseEntity<ApiResponse<PageResponse<AppointmentDTO>>> getAppointmentsByStatus(@PathVariable AppointmentStatus status, Pageable pageable){
        Page<AppointmentDTO> pageAppointments = appointmentService.getAppointmentsByStatus(status, pageable);
        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK,  new PageResponse<>(pageAppointments)));
    }

    @GetMapping("/by-date")
    public ResponseEntity<ApiResponse<PageResponse<AppointmentDTO>>> getAppointmentsByDate(@RequestParam @NotBlank String date, Pageable pageable){
        LocalDate localDate = LocalDate.parse(date);
        Page<AppointmentDTO> pageAppointments = appointmentService.getAppointmentsByDate(localDate, pageable);
        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK,  new PageResponse<>(pageAppointments)));
    }

    @GetMapping("/search")
    public ResponseEntity<ApiResponse<PageResponse<AppointmentDTO>>> searchAppointments(@NotBlank String keyword, Pageable pageable){
        Page<AppointmentDTO> pageAppointments = appointmentService.searchAppointments(keyword, pageable);
        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK,  new PageResponse<>(pageAppointments)));
    }

    @GetMapping("/by-schedule")
    public ResponseEntity<ApiResponse<List<AppointmentDTO>>> getAppointmentsBySchedule(@NotBlank String scheduleId){
        List<AppointmentDTO> appointments = appointmentService.getAppointmentsBySchedule(scheduleId);
        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK, appointments));
    }

    @PostMapping("/add")
    public ResponseEntity<ApiResponse<String>> addAppointment(@RequestBody @Valid AppointmentDTO appointment){
        appointmentService.addAppointment(appointment);
        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.CREATED, "Đăng ký lịch hẹn khám bệnh thành công."));
    }

    @PutMapping("/update")
    public ResponseEntity<ApiResponse<String>> updateAppointment(@RequestBody @Valid AppointmentDTO appointment){
        appointmentService.updateAppointment(appointment);
        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK, "Chỉnh sửa thông tin lịch hẹn khám bệnh thành công."));
    }

    @PutMapping("/change-status")
    public ResponseEntity<ApiResponse<String>> changeAppointmentStatus(@NotBlank String id, AppointmentStatus status){
        appointmentService.changeAppointmentStatus(id, status);
        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK, "Cập nhật trạng thái lịch hẹn khám bệnh thành công."));
    }

    @PostMapping("/count-by-schedule")
    public ResponseEntity<ApiResponse<Integer>> countAppointmentsBySchedule(@NotBlank String scheduleId){
        int count = appointmentService.countAppointmentsBySchedule(scheduleId);
        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.CREATED, count));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse<String>> deleteAppointment(@NotBlank String id){
        appointmentService.softDeleteAppointment(id);
        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK,"Xóa lịch hẹn thành công."));
    }
}
