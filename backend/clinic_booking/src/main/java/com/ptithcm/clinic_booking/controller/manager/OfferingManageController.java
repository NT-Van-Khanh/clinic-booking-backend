package com.ptithcm.clinic_booking.controller.manager;

import com.ptithcm.clinic_booking.dto.PageResponse;
import com.ptithcm.clinic_booking.dto.PaginationRequest;
import com.ptithcm.clinic_booking.dto.service.ServiceCreateDTO;
import com.ptithcm.clinic_booking.dto.service.ServiceDTO;
import com.ptithcm.clinic_booking.model.ApiResponse;
import com.ptithcm.clinic_booking.service.OfferingService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/m/services")
@Validated
public class OfferingManageController {
    private final OfferingService offeringService;

    public OfferingManageController(OfferingService offeringService) {
        this.offeringService = offeringService;
    }

    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<ServiceDTO>>> getAllServices() {
        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK, offeringService.getAllServices()));
    }
    @GetMapping("/page")
    public ResponseEntity<ApiResponse<PageResponse<ServiceDTO>>> getPageServices(@ModelAttribute @Valid PaginationRequest pageRequest) {
        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK, offeringService.getPageServices(pageRequest)));
    }

    @GetMapping("/search")
    public ResponseEntity<ApiResponse<PageResponse<ServiceDTO>>> searchServices( @RequestParam @NotBlank String keyword, @ModelAttribute @Valid PaginationRequest pageRequest) {
        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK, offeringService.searchServices(keyword, pageRequest)));
    }

    @PostMapping("/add")
    public ResponseEntity<ApiResponse<String>> addService(@RequestBody @Valid ServiceCreateDTO serviceDTO) {
        offeringService.addService(serviceDTO);
        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK, "Thêm dịch vụ thành công."));
    }

    @PutMapping("/update")
    public ResponseEntity<ApiResponse<String>> updateService(@RequestBody @Valid ServiceDTO serviceDTO) {
        offeringService.updateService(serviceDTO);
        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK, "Cập nhật dịch vụ thành công."));
    }
    @PutMapping("/update/status/{id}")
    public ResponseEntity<ApiResponse<String>> updateStatusClinic(@PathVariable @NotBlank String id, @NotBlank String status){
        offeringService.changeStatusService(id, status);
        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK, "Cập nhật trạng thái dịch vụ thành công."));
    }
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<ApiResponse<String>> softDeleteService(@PathVariable  @NotBlank String id) {
//        offeringService.softDeleteService(id);
//        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK, "Dịch vụ đã được xóa."));
//    }
}
