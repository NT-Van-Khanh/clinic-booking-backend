package com.ptithcm.clinic_booking.controller;

import com.ptithcm.clinic_booking.dto.AppointmentDTO;
import com.ptithcm.clinic_booking.dto.customer.CustomerDTO;
import com.ptithcm.clinic_booking.model.ApiResponse;
import com.ptithcm.clinic_booking.service.CustomerService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<CustomerDTO>> getCustomerById(@PathVariable @NotBlank String id){
        CustomerDTO customer  = customerService.getCustomerById(id);
        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK, customer));
    }

    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<CustomerDTO>>> getAllCustomers(){
        List<CustomerDTO> customers = customerService.getAllCustomers();
        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK, customers));
    }

    @GetMapping("/all/{status}")
    public ResponseEntity<ApiResponse<List<CustomerDTO>>> getAllCustomersByStatus(@PathVariable @NotBlank String status){
        List<CustomerDTO> customers = customerService.getAllCustomersByStatus(status);
        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK, customers));
    }
//
//    @PostMapping("/add")
//    public ResponseEntity<ApiResponse<String>> addCustomer(@RequestBody @Valid CustomerDTO customerDTO) {
//        customerService.addCustomer(customerDTO);
//        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.CREATED, "Thêm khách hàng thành công."));
//    }
//
//    @PutMapping("/update")
//    public ResponseEntity<ApiResponse<String>> updateCustomer(@RequestBody @Valid CustomerDTO customerDTO) {
//        customerService.updateCustomer(customerDTO);
//        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK, "Cập nhật khách hàng thành công."));
//    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse<String>> softDeleteCustomer(@PathVariable @NotBlank String id) {
        customerService.softDeleteCustomer(id);
        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK, "Xóa khách hàng thành công (soft delete)."));
    }

    @PostMapping("/send-otp")
    public ResponseEntity<ApiResponse<String>> sendOtpToEmail(@RequestParam @Email String email) {
        customerService.sendOtpToEmail(email);
        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK, "Gửi mã OTP thành công."));
    }

    @PostMapping("/auth-email")
    public ResponseEntity<ApiResponse<String>> authEmail(@RequestParam @Email String email, @RequestParam @NotBlank String otp) {
        customerService.authEmail(email, otp);
        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK, "Xác thực email thành công."));
    }

    @GetMapping("/{customerId}/appointments")
    public ResponseEntity<ApiResponse<List<AppointmentDTO>>> getAppointmentsByCustomerId(@PathVariable @NotBlank String customerId) {
        List<AppointmentDTO> appointments = customerService.getAppointmentsByCustomerId(customerId);
        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK, appointments));
    }

    @GetMapping("/search")
    public ResponseEntity<ApiResponse<List<CustomerDTO>>> searchCustomers(@RequestParam @NotBlank String keyword) {
        List<CustomerDTO> customers = customerService.searchCustomers(keyword);
        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK, customers));
    }

}
