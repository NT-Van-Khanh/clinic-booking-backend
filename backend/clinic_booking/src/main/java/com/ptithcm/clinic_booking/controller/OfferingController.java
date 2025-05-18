package com.ptithcm.clinic_booking.controller;

import com.ptithcm.clinic_booking.dto.ClinicDTO;
import com.ptithcm.clinic_booking.dto.ServiceDTO;
import com.ptithcm.clinic_booking.model.ApiResponse;
import com.ptithcm.clinic_booking.model.Service;
import com.ptithcm.clinic_booking.service.OfferingService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/service")
@Validated
public class OfferingController {
    private final OfferingService offeringService;

    @Autowired
    public OfferingController(OfferingService offeringService) {
        this.offeringService = offeringService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<ServiceDTO>> getServiceById(@PathVariable  @NotBlank String id){
        ServiceDTO service = offeringService.getServiceById(id);
        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK, service));
    }

    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<ServiceDTO>>> getAllService() {
        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK, offeringService.getAllServices()));
    }

    @GetMapping("/active")
    public ResponseEntity<ApiResponse<List<ServiceDTO>>> getAllActiveServices() {
        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK, offeringService.getAllActiveServices()));
    }

    @PostMapping("/add")
    public ResponseEntity<ApiResponse<String>> addService(@RequestBody @Valid ServiceDTO serviceDTO) {
        offeringService.addService(serviceDTO);
        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK, "Thêm dịch vụ thành công."));
    }

    @PutMapping("/update")
    public ResponseEntity<ApiResponse<String>> updateService(@RequestBody @Valid ServiceDTO serviceDTO) {
        offeringService.updateService(serviceDTO);
        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK, "Cập nhật dịch vụ thành công."));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse<String>> softDeleteService(@PathVariable  @NotBlank String id) {
        offeringService.softDeleteService(id);
        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK, "Dịch vụ đã được xóa."));
    }
}
