package com.ptithcm.clinic_booking.controller;

import com.ptithcm.clinic_booking.dto.ClinicDTO;
import com.ptithcm.clinic_booking.exception.ResourceNotFoundException;
import com.ptithcm.clinic_booking.model.ApiResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.ptithcm.clinic_booking.service.ClinicService;

import java.util.List;

@RestController
@RequestMapping("/api/clinic")
@Validated
public class ClinicController {
    private final ClinicService clinicService;

    @Autowired
    public ClinicController(ClinicService clinicService) {
        this.clinicService = clinicService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<ClinicDTO>> getClinicById(@PathVariable  @NotBlank String id) {
        ClinicDTO clinic = clinicService.getClinicById(id);
        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK, clinic));
    }

    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<ClinicDTO>>> getAllClinic() {
        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK, clinicService.getAllClinics()));
    }

    @GetMapping("/active")
    public ResponseEntity<ApiResponse<List<ClinicDTO>>> getAllClinicActive() {
        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK, clinicService.getAllActiveClinics()));
    }

    @PostMapping("/add")
    public ResponseEntity<ApiResponse<String>> addClinic(@RequestBody @Valid ClinicDTO clinic){
            clinicService.addClinic(clinic);
            return ResponseEntity.ok(new ApiResponse<>(HttpStatus.CREATED,"Thêm phòng khám thành công."));
    }

    @PutMapping("/update")
    public ResponseEntity<ApiResponse<String>> updateClinic(@RequestBody @Valid ClinicDTO clinic){
        clinicService.updateClinic(clinic);
        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK, "Cập nhật phòng khám thành công."));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse<String>> softDeleteClinic(@PathVariable  @NotBlank String id){
        clinicService.softDeleteClinic(id);
        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK, "Phòng khám đã được xóa."));
    }
}
