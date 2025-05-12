package com.ptithcm.clinic_booking.service;

import com.ptithcm.clinic_booking.dto.ServiceDTO;

import java.util.List;

public interface OfferingService {
    ServiceDTO getServiceById(String id);
    List<ServiceDTO> getAllServices();
    List<ServiceDTO> getAllActiveServices();
    void addService(ServiceDTO serviceDTO);
    void updateService(ServiceDTO serviceDTO);
    void softDeleteService(String id);
}
