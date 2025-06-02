package com.ptithcm.clinic_booking.service;

import com.ptithcm.clinic_booking.dto.PageResponse;
import com.ptithcm.clinic_booking.dto.PaginationRequest;
import com.ptithcm.clinic_booking.dto.appointment.AppointmentDTO;
import com.ptithcm.clinic_booking.dto.customer.CustomerDTO;
import com.ptithcm.clinic_booking.dto.customer.CustomerRequestDTO;

import java.util.List;

public interface CustomerService {
    List<CustomerDTO> getAllCustomers();
    List<CustomerDTO> getAllCustomersByStatus(String status);
    PageResponse<CustomerDTO> getPageCustomers(PaginationRequest pageRequest);
    PageResponse<CustomerDTO> searchCustomers(String keyword, PaginationRequest pageRequest);
    CustomerDTO getCustomerById(String id);
    List<CustomerDTO> getCustomerByPhoneAndEmail(String phone, String email);

    void changeStatusCustomer(String id, String status);
    CustomerDTO addCustomer(CustomerRequestDTO customerDTO);
    void updateCustomer(CustomerDTO customerDTO);
    void softDeleteCustomer(String id);
    void sendOtpToEmail(String email);
    void authEmail(String email, String otp);
    List<AppointmentDTO> getAppointmentsByCustomerId(String customerId);
}
