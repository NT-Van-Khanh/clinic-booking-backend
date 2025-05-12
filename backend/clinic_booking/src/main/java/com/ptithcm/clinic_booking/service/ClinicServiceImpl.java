package com.ptithcm.clinic_booking.service;

import com.ptithcm.clinic_booking.dto.ClinicDTO;
import com.ptithcm.clinic_booking.dto.mapper.ClinicMapper;
import com.ptithcm.clinic_booking.exception.ResourceNotFoundException;
import com.ptithcm.clinic_booking.model.Clinic;
import com.ptithcm.clinic_booking.repository.ClinicRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class ClinicServiceImpl implements ClinicService{

    private final ClinicRepository clinicRepository;

    public ClinicServiceImpl(ClinicRepository clinicRepository) {
        this.clinicRepository = clinicRepository;
    }

    public ClinicDTO getClinicById(String id){
        Clinic clinic = clinicRepository.findById(id)
                                    .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy phòng khám với ID: " + id));
        return ClinicMapper.toClinicDTO(clinic);
    }

    public List<ClinicDTO> getAllClinics(){
        List<Clinic> clinics = clinicRepository.findAll();
        if(clinics == null) throw new ResourceNotFoundException("Không thể lấy danh sách phòng khám.");

        return clinics.stream()
                .map(ClinicMapper::toClinicDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ClinicDTO> getAllActiveClinics() {
        List<Clinic> clinics = clinicRepository.findByStatus("ACTIVE");
        if(clinics == null) throw new ResourceNotFoundException("Không thể lấy danh sách phòng khám.");

        return clinics.stream()
                .map(ClinicMapper::toClinicDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void addClinic(ClinicDTO clinicDTO) {
        if(clinicDTO == null)
            throw new IllegalArgumentException("Dữ liệu phòng khám không hợp lệ hoặc thiếu ID");
        try {
            Clinic clinic = ClinicMapper.toClinic(clinicDTO);
            clinic.setId(createClinicId());
            clinicRepository.save(clinic);
        } catch (Exception e) {
            throw new RuntimeException("Lỗi khi thêm phòng khám: " + e.getMessage(), e);
        }
    }

    private String createClinicId() {
        long countClinic = clinicRepository.count();
        return String.format("CL%04d", countClinic);
    }

    @Override
    public void updateClinic(ClinicDTO clinicDTO) {
        if (clinicDTO == null || clinicDTO.getId() == null)
            throw new IllegalArgumentException("Dữ liệu phòng khám không hợp lệ hoặc thiếu ID");

        Clinic existingClinic = clinicRepository.findById(clinicDTO.getId()).orElse(null);
        if (existingClinic == null)
            throw new ResourceNotFoundException("Không tìm thấy phòng khám với ID: " + clinicDTO.getId());

        try{
            Clinic clinic = ClinicMapper.toClinic(clinicDTO);
            clinicRepository.save(clinic);
        } catch (Exception e) {
            throw new RuntimeException("Lỗi khi cập nhật phòng khám: " + e.getMessage(), e);
        }
    }

    @Transactional
    @Override
    public void softDeleteClinic(String clinicId) {
        try{
            Clinic c = clinicRepository.findById(clinicId)
                    .orElseThrow(() -> new ResourceNotFoundException("Không thể xóa. Không tìm thấy phòng khám với ID: " + clinicId));
            c.setStatus("DELETING");
            clinicRepository.save(c);
        }catch (Exception e){
            throw new RuntimeException("Lỗi khi xóa mềm phòng khám: " + e.getMessage(), e);
        }
    }
}
