package com.ptithcm.clinic_booking.service.impl;

import com.ptithcm.clinic_booking.dto.manager.ManagerRequestDTO;
import com.ptithcm.clinic_booking.dto.manager.ManagerResponseDTO;
import com.ptithcm.clinic_booking.exception.ResourceNotFoundException;
import com.ptithcm.clinic_booking.mapper.ManagerMapper;
import com.ptithcm.clinic_booking.model.Manager;
import com.ptithcm.clinic_booking.repository.ManagerRepository;
import com.ptithcm.clinic_booking.service.ManagerService;

import java.util.List;
import java.util.stream.Collectors;

public class ManagerServiceImpl implements ManagerService {
    private final ManagerRepository managerRepository;

    public ManagerServiceImpl(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }

    @Override
    public void addManager(ManagerRequestDTO managerRequestDTO) {
        if (managerRequestDTO == null) {
            throw new IllegalArgumentException("Dữ liệu quản lý không hợp lệ.");
        }
        try {
            Manager manager = ManagerMapper.toManager(managerRequestDTO);
            manager.setId(createManagerId());
            manager.setStatus("ACTIVE");
            managerRepository.save(manager);
        } catch (Exception e) {
            throw new RuntimeException("Lỗi khi thêm quản lý: " + e.getMessage(), e);
        }
    }

    private String createManagerId() {
        long count = managerRepository.count();
        return String.format("MN%03d", count + 1);
    }

    @Override
    public void updateManager(ManagerRequestDTO managerRequestDTO) {
        if (managerRequestDTO == null || managerRequestDTO.getId() == null) {
            throw new IllegalArgumentException("Dữ liệu quản lý không hợp lệ hoặc thiếu ID.");
        }

        Manager existing = managerRepository.findById(managerRequestDTO.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy quản lý với ID: " + managerRequestDTO.getId()));

        Manager updated = ManagerMapper.toManager(managerRequestDTO);
        updated.setStatus(existing.getStatus()); // giữ nguyên trạng thái
        managerRepository.save(updated);
    }

    @Override
    public void softDeleteManager(String id) {
        Manager manager = managerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy quản lý với ID: " + id));
        manager.setStatus("DELETED");
        managerRepository.save(manager);
    }

    @Override
    public List<ManagerResponseDTO> getAllManagers() {
        List<Manager> managers = managerRepository.findAll();
        return managers.stream()
                .map(ManagerMapper::toManagerDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ManagerResponseDTO getManagerById(String id) {
        Manager manager = managerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy quản lý với ID: " + id));
        return ManagerMapper.toManagerDTO(manager);
    }
}