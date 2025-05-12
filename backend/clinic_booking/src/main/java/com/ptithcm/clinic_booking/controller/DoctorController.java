package com.ptithcm.clinic_booking.controller;

import com.ptithcm.clinic_booking.dto.DoctorDTO;
import com.ptithcm.clinic_booking.model.ApiResponse;
import com.ptithcm.clinic_booking.service.DoctorSerivce;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;
import java.util.List;

@RequestMapping("/api/doctor")
@RestController
public class DoctorController {

    private final DoctorSerivce doctorSerivce;
    @Autowired
    public DoctorController(DoctorSerivce doctorSerivce) {
        this.doctorSerivce = doctorSerivce;
    }
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<DoctorDTO>> getDoctorById(@PathVariable String id){
        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK, doctorSerivce.getDoctorById(id)));
    }

    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<DoctorDTO>>> getAllDoctors(){
        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK, doctorSerivce.getAllDoctors()));
    }


    @GetMapping("/active")
    public ResponseEntity<ApiResponse<List<DoctorDTO>>> getActiveDoctors(){
        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK, doctorSerivce.getAllActiveDoctors()));
    }

    @PostMapping("/add")
    public ResponseEntity<ApiResponse<String>> addDoctor(@RequestBody @Valid DoctorDTO doctor){
        doctorSerivce.addDoctor(doctor);
        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK, "Cập nhật bác sĩ thành công"));
    }

    @PutMapping("/update")
    public ResponseEntity<ApiResponse<String>> updateDoctor(@RequestBody @Valid DoctorDTO doctor){
        doctorSerivce.updateDoctor(doctor);
        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK, "Cập nhật bác sĩ thành công"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse<String>> softDeleteDoctor(@PathVariable String id){
        doctorSerivce.softDeletingDoctor(id);
        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK, "Bác sĩ đã được xóa."));
    }
}
