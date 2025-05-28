package com.ptithcm.clinic_booking.service;

import com.ptithcm.clinic_booking.dto.service.ServiceCreateDTO;
import com.ptithcm.clinic_booking.dto.service.ServiceDTO;

import java.util.List;

public interface OfferingService {
    ServiceDTO getServiceById(String id);
    List<ServiceDTO> getAllServices();
    List<ServiceDTO> getAllActiveServices();
    void addService(ServiceCreateDTO serviceDTO);
    void updateService(ServiceDTO serviceDTO);
    void softDeleteService(String id);
}
