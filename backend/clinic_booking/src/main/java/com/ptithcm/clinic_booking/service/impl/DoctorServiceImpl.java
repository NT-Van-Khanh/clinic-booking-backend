package com.ptithcm.clinic_booking.service.impl;

import com.ptithcm.clinic_booking.dto.doctor.DoctorCreateDTO;
import com.ptithcm.clinic_booking.dto.doctor.DoctorSimpleResponseDTO;
import com.ptithcm.clinic_booking.dto.doctor.DoctorResponseDTO;
import com.ptithcm.clinic_booking.mapper.DoctorMapper;
import com.ptithcm.clinic_booking.exception.ResourceNotFoundException;
import com.ptithcm.clinic_booking.model.Doctor;
import com.ptithcm.clinic_booking.model.MedicalSpecialty;
import com.ptithcm.clinic_booking.repository.DoctorRepository;
import com.ptithcm.clinic_booking.service.DoctorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;

    public DoctorServiceImpl(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Override
    public DoctorSimpleResponseDTO getDoctorSimpleById(String id) {
        return null;
    }

    @Override
    public DoctorResponseDTO getDoctorById(String id) {
        Doctor  doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy bác sĩ với ID: " + id));
        return DoctorMapper.toDoctorDTO(doctor);
    }

    @Override
    public List<DoctorResponseDTO> getAllDoctors() {
        List<Doctor> doctors = doctorRepository.findAll();
        if(doctors == null) throw new ResourceNotFoundException("Không lấy được danh sách bác sĩ.");
        return doctors.stream()
                .map(DoctorMapper::toDoctorDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<DoctorSimpleResponseDTO> getAllActiveDoctors() {
        List<Doctor> doctors = doctorRepository.findByStatus("ACTIVE");
        if(doctors == null) throw new ResourceNotFoundException("Không lấy được danh sách bác sĩ.");
        return doctors.stream()
                .map(DoctorMapper::toDoctorSimpleDTO)
                .collect(Collectors.toList());
    }

//    @Override
//    public List<DoctorDTO> getDoctorsByService(String serviceId) {
//        List<Doctor> doctors = doctorRepository.findByService_Id(serviceId);
//        if(doctors == null) throw new ResourceNotFoundException("Không lấy được danh sách bác sĩ theo dịch vụ có id: "+serviceId);
//        return doctors.stream()
//                .map(DoctorMapper::toDoctorDTO)
//                .collect(Collectors.toList());
//    }

    @Override
    public List<DoctorSimpleResponseDTO> getDoctorsByMedicalSpecialty(String medicalSpecialtyId) {
        List<Doctor> doctors = doctorRepository.findByMedicalSpecialty_Id(medicalSpecialtyId);
        if(doctors == null) throw new ResourceNotFoundException("Không lấy được danh sách bác sĩ theo chuyên khoa có id: " + medicalSpecialtyId);
        return doctors.stream()
                .map(DoctorMapper::toDoctorSimpleDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void addDoctor(DoctorCreateDTO doctorDTO) {
        if( doctorDTO == null) throw new IllegalArgumentException("Dữ liệu bác sĩ không hợp lệ.");
        try{
            Doctor doctor = DoctorMapper.toDoctor(doctorDTO);
            doctor.setId(createDoctorId());
            doctorRepository.save(doctor);
        } catch (Exception e) {
            throw new RuntimeException("Lỗi khi thêm bác sĩ: " + e.getMessage(), e);
        }
    }

    private String createDoctorId() {
        long countDoctor =  doctorRepository.count();
        return String.format("DC%03d", countDoctor);
    }

    @Override
    public void updateDoctor(DoctorSimpleResponseDTO doctorDTO) {
        if( doctorDTO == null||doctorDTO.getId() == null)
            throw new IllegalArgumentException("Dữ liệu bác sĩ không hợp lệ hoặc thiếu ID");
        Doctor doctor = doctorRepository.findById( doctorDTO.getId())
           .orElseThrow(() ->new ResourceNotFoundException("Không tìm thấy phòng khám với ID: " +  doctorDTO.getId()));
        try{
//            Doctor doctor = DoctorMapper.toDoctor(doctorDTO);
            MedicalSpecialty specialty = new MedicalSpecialty();
            specialty.setId(doctorDTO.getMedicalSpecialtyId());
            doctor.setMedicalSpecialty(specialty);
            doctor.setName(doctorDTO.getName());
            doctor.setPhone(doctorDTO.getPhone());
            doctor.setEmail(doctorDTO.getEmail());
            doctor.setAddress(doctorDTO.getAddress());
            doctor.setGender(doctorDTO.getGender());
            doctor.setStatus(doctorDTO.getStatus());
            doctorRepository.save(doctor);
        } catch (Exception e) {
            throw new RuntimeException("Lỗi khi thêm bác sĩ: " + e.getMessage(), e);
        }
    }

    @Override
    public void blockDoctor(String id) {
        try{
            Doctor d = doctorRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Không thể xóa. Không tìm thấy phòng khám với ID: " + id));
            d.setStatus("BLOCKED");
            doctorRepository.save(d);
        }catch (Exception e){
            throw new RuntimeException("Lỗi khi xóa mềm phòng khám: " + e.getMessage(), e);
        }
    }

    @Override
    public void softDeletingDoctor(String id) {
        try{
            Doctor d = doctorRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Không thể xóa. Không tìm thấy phòng khám với ID: " + id));
            d.setStatus("DELETING");
            doctorRepository.save(d);
        }catch (Exception e){
            throw new RuntimeException("Lỗi khi xóa phòng khám: " + e.getMessage(), e);
        }
    }
}
