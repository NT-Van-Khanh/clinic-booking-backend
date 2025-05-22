package com.ptithcm.clinic_booking.controller.manager;

import com.ptithcm.clinic_booking.dto.doctor.DoctorCreateDTO;
import com.ptithcm.clinic_booking.dto.doctor.DoctorSimpleResponseDTO;
import com.ptithcm.clinic_booking.dto.doctor.DoctorResponseDTO;
import com.ptithcm.clinic_booking.model.ApiResponse;
import com.ptithcm.clinic_booking.service.AccountService;
import com.ptithcm.clinic_booking.service.DoctorService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/api/v1/m/doctors")
public class DoctorManageController {
    private AccountService accountService;
    private final DoctorService doctorService;

    @Autowired
    public DoctorManageController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<DoctorResponseDTO>> getDoctorById(@PathVariable String id) {
        DoctorResponseDTO doctor = doctorService.getDoctorById(id);
        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK, doctor));
    }

    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<DoctorResponseDTO>>> getAllDoctors(){
        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK, doctorService.getAllDoctors()));
    }

    @PostMapping("/add")
    public ResponseEntity<ApiResponse<String>> addDoctor(@RequestBody @Valid DoctorCreateDTO doctor){
        doctorService.addDoctor(doctor);
        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK, "Cập nhật bác sĩ thành công"));
    }

    @PutMapping("/update")
    public ResponseEntity<ApiResponse<String>> updateDoctor(@RequestBody @Valid DoctorSimpleResponseDTO doctor){
        doctorService.updateDoctor(doctor);
        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK, "Cập nhật bác sĩ thành công"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse<String>> softDeleteDoctor(@PathVariable  @NotBlank String id){
        doctorService.softDeletingDoctor(id);
        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK, "Bác sĩ đã được xóa."));
    }

}
