package com.ptithcm.clinic_booking.service;

import com.ptithcm.clinic_booking.dto.specialty.BaseMedicalSpecialtyDTO;
import com.ptithcm.clinic_booking.dto.specialty.MedicalSpecialtyRequestDTO;
import com.ptithcm.clinic_booking.dto.specialty.MedicalSpecialtyResponseDTO;
import com.ptithcm.clinic_booking.exception.ResourceNotFoundException;
import com.ptithcm.clinic_booking.mapper.MedicalSpecialtyMapper;
import com.ptithcm.clinic_booking.model.MedicalSpecialty;
import com.ptithcm.clinic_booking.repository.MedicalSpecialtyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MedicalSpecialtyServiceImpl implements  MedicalSpecialtyService{
    private final MedicalSpecialtyRepository specialtyRepository;

    public MedicalSpecialtyServiceImpl(MedicalSpecialtyRepository specialtyRepository) {
        this.specialtyRepository = specialtyRepository;
    }

    @Override
    public List<MedicalSpecialtyResponseDTO> getAllMSpecialties() {
        List<MedicalSpecialty> medicalSpecialties = specialtyRepository.findAll();

        return medicalSpecialties .stream()
                .map(MedicalSpecialtyMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public MedicalSpecialtyResponseDTO getMSpecialtyById(String id) {
        MedicalSpecialty medicalSpecialty = specialtyRepository.findById(id)
                .orElseThrow(() ->new ResourceNotFoundException("Không tìm thấy chuyên khoa với ID: " + id));
        return MedicalSpecialtyMapper.toResponseDTO(medicalSpecialty);
    }

    @Override
    public void addMSpecialty(MedicalSpecialtyRequestDTO specialtyRequestDTO) {
        if (specialtyRequestDTO == null)
            throw new IllegalArgumentException("Dữ liệu chuyên khoa không hợp lệ");
        try {
            MedicalSpecialty specialty = MedicalSpecialtyMapper.toEntity(specialtyRequestDTO);
            specialty.setId(createSpecialtyId());
            specialtyRepository.save(specialty);
        } catch (Exception e) {
            throw new RuntimeException("Lỗi khi thêm chuyên khoa: " + e.getMessage(), e);
        }
    }

    private String createSpecialtyId() {
        long countClinic = specialtyRepository.count();
        return String.format("CL%04d", countClinic);
    }

    @Override
    public void updateMSpecialty(MedicalSpecialtyRequestDTO specialtyRequestDTO) {
        if (specialtyRequestDTO == null || specialtyRequestDTO.getId() == null)
            throw new IllegalArgumentException("Dữ liệu chuyên khoa không hợp lệ hoặc thiếu ID");

        MedicalSpecialty existingSpecialty = specialtyRepository.findById(specialtyRequestDTO.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy chuyên khoa với ID: " + specialtyRequestDTO.getId()));

        try {
            // Cập nhật các trường cần thiết
            existingSpecialty.setName(specialtyRequestDTO.getName());
            existingSpecialty.setStatus(specialtyRequestDTO.getStatus());
            existingSpecialty.setDescription(specialtyRequestDTO.getDescription());

            specialtyRepository.save(existingSpecialty);
        } catch (Exception e) {
            throw new RuntimeException("Lỗi khi cập nhật chuyên khoa: " + e.getMessage(), e);
        }
    }

    @Override
    public void softDeleteMSpecialty(String specialtyId) {
        try {
            MedicalSpecialty specialty = specialtyRepository.findById(specialtyId)
                    .orElseThrow(() -> new ResourceNotFoundException("Không thể xóa. Không tìm thấy chuyên khoa với ID: " + specialtyId));

            specialty.setStatus("DELETING");
            specialtyRepository.save(specialty);
        } catch (Exception e) {
            throw new RuntimeException("Lỗi khi xóa mềm chuyên khoa: " + e.getMessage(), e);
        }
    }

    @Override
    public List<BaseMedicalSpecialtyDTO> getAllActiveMSpecialties() {
        List<MedicalSpecialty> activeSpecialties = specialtyRepository.findByStatus("ACTIVE");
        return activeSpecialties.stream()
                .map(MedicalSpecialtyMapper::toBaseDTO)
                .collect(Collectors.toList());
    }
}
