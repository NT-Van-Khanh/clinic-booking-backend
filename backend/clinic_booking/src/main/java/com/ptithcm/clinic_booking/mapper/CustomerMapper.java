package com.ptithcm.clinic_booking.mapper;

import com.ptithcm.clinic_booking.dto.customer.CustomerDTO;
import com.ptithcm.clinic_booking.dto.customer.CustomerRequestDTO;
import com.ptithcm.clinic_booking.model.Customer;

public class CustomerMapper {
    public static CustomerDTO toCustomerDTO(Customer customer) {
        if (customer == null) return null;

        return CustomerDTO.builder()
                .id(customer.getId())
                .name(customer.getName())
                .phone(customer.getPhone())
                .email(customer.getEmail())
                .address(customer.getAddress())
                .gender(customer.getGender())
                .status(customer.getStatus())
                .createdAt(customer.getCreatedAt())
                .build();
    }

    public static Customer toCustomer(CustomerDTO dto) {
        if (dto == null) return null;

        return Customer.builder()
                .id(dto.getId())
                .name(dto.getName())
                .phone(dto.getPhone())
                .email(dto.getEmail())
                .address(dto.getAddress())
                .gender(dto.getGender())
                .status(dto.getStatus())
                .build();
    }

    public static Customer toCustomer(CustomerRequestDTO dto) {
        if (dto == null) return null;

        return Customer.builder()
                .name(dto.getName())
                .phone(dto.getPhone())
                .email(dto.getEmail())
                .address(dto.getAddress())
                .gender(dto.getGender())
                .build();
    }
}
