package com.ptithcm.clinic_booking.controller;

import com.ptithcm.clinic_booking.exception.MessageConstants;
import com.ptithcm.clinic_booking.exception.ResourceNotFoundException;
import com.ptithcm.clinic_booking.model.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.ptithcm.clinic_booking.model.Clinic;
import com.ptithcm.clinic_booking.service.ClinicService;

import java.util.List;

@RestController
@RequestMapping("/api/clinics")
public class ClinicController {
    private final ClinicService clinicService;

    @Autowired
    public ClinicController(ClinicService clinicService) {
        this.clinicService = clinicService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Clinic>> getClinicById(@PathVariable String id) {
        Clinic clinic = clinicService.getClinicById(id);
        if (clinic == null) {
            throw new ResourceNotFoundException("Không tìm thấy phòng khám với ID: " + id);
        }
        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK, clinic));
    }

    @GetMapping("")
    public ResponseEntity<ApiResponse<List<Clinic>>> getAllClinic() {
        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK, clinicService.getAllClinic()));
    }
}
