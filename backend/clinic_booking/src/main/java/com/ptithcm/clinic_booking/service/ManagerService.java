package com.ptithcm.clinic_booking.service;

import com.ptithcm.clinic_booking.dto.manager.ManagerRequestDTO;
import com.ptithcm.clinic_booking.dto.manager.ManagerResponseDTO;
import com.ptithcm.clinic_booking.model.Manager;

import java.util.List;

public interface ManagerService {
    void addManager(ManagerRequestDTO managerRequestDTO);
    void updateManager(ManagerRequestDTO managerRequestDTO);
    void softDeleteManager(String id);

    List<ManagerResponseDTO> getAllManagers();
    ManagerResponseDTO getManagerById(String id);
}
