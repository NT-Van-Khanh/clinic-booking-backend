package com.ptithcm.clinic_booking.service;

import com.ptithcm.clinic_booking.dto.AppointmentDTO;
import com.ptithcm.clinic_booking.dto.customer.CustomerDTO;

import java.util.List;

public interface CustomerService {
    List<CustomerDTO> getAllCustomers();
    List<CustomerDTO> getAllCustomersByStatus(String status);
    List<CustomerDTO> searchCustomers(String keyword);
    CustomerDTO getCustomerById(String id);

    void addCustomer(CustomerDTO customerDTO);
    void updateCustomer(CustomerDTO customerDTO);
    void softDeleteCustomer(String id);
    void sendOtpToEmail(String email);
    void authEmail(String email, String otp);
    List<AppointmentDTO> getAppointmentsByCustomerId(String customerId);
}
