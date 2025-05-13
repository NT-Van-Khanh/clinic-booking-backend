package com.ptithcm.clinic_booking.controller;

import com.ptithcm.clinic_booking.dto.DoctorDTO;
import com.ptithcm.clinic_booking.model.ApiResponse;
import com.ptithcm.clinic_booking.service.DoctorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/doctor")
@RestController
public class DoctorController {

    private final DoctorService doctorService;

    @Autowired
    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<DoctorDTO>> getDoctorById(@PathVariable String id){
        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK, doctorService.getDoctorById(id)));
    }

    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<DoctorDTO>>> getAllDoctors(){
        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK, doctorService.getAllDoctors()));
    }

    @GetMapping("/by_medical_specialty")
    public ResponseEntity<ApiResponse<List<DoctorDTO>>> getDoctorsByMedicalSpecialty(@RequestParam String medicalSpecialtyId){
        return ResponseEntity
                .ok(new ApiResponse<>(HttpStatus.OK, doctorService.getDoctorsByMedicalSpecialty(medicalSpecialtyId)));
    }

    @GetMapping("/active")
    public ResponseEntity<ApiResponse<List<DoctorDTO>>> getActiveDoctors(){
        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK, doctorService.getAllActiveDoctors()));
    }

    @PostMapping("/add")
    public ResponseEntity<ApiResponse<String>> addDoctor(@RequestBody @Valid DoctorDTO doctor){
        doctorService.addDoctor(doctor);
        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK, "Cập nhật bác sĩ thành công"));
    }

    @PutMapping("/update")
    public ResponseEntity<ApiResponse<String>> updateDoctor(@RequestBody @Valid DoctorDTO doctor){
        doctorService.updateDoctor(doctor);
        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK, "Cập nhật bác sĩ thành công"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse<String>> softDeleteDoctor(@PathVariable String id){
        doctorService.softDeletingDoctor(id);
        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK, "Bác sĩ đã được xóa."));
    }
}
