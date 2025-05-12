package com.ptithcm.clinic_booking.service;

import com.ptithcm.clinic_booking.dto.ServiceDTO;
import com.ptithcm.clinic_booking.dto.mapper.ServiceMapper;
import com.ptithcm.clinic_booking.exception.ResourceNotFoundException;
import com.ptithcm.clinic_booking.model.Service;
import com.ptithcm.clinic_booking.repository.ServiceRepository;

import java.util.List;
import java.util.stream.Collectors;

@org.springframework.stereotype.Service
public class OfferingServiceImpl implements OfferingService{

    private final ServiceRepository serviceRepository;

    public OfferingServiceImpl(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    @Override
    public ServiceDTO getServiceById(String id) {
        Service service = serviceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy dịch vụ có id: "+ id));

        return ServiceMapper.toServiceDTO(service);
    }

    @Override
    public List<ServiceDTO> getAllServices() {
        List<Service> services = serviceRepository.findAll();
        if(services == null)
            throw new ResourceNotFoundException("Không thể lấy được danh sách dịch vụ.");
        return services.stream()
                .map(ServiceMapper::toServiceDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ServiceDTO> getAllActiveServices() {
        List<Service> services = serviceRepository.findAllByStatus("ACTIVE");
        if(services == null)
            throw new ResourceNotFoundException("Không thể lấy được danh sách dịch vụ.");
        return services.stream()
                .map(ServiceMapper::toServiceDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void addService(ServiceDTO serviceDTO) {
        if(serviceDTO == null) throw new IllegalArgumentException("Dữ liệu dịch vụ không hợp lệ.");
        try{
            Service service = ServiceMapper.toService(serviceDTO);
            service.setId(createdServiceId());
            serviceRepository.save(service);
        }catch (Exception e){
            throw new RuntimeException("Lỗi khi thêm dịch vụ: " + e.getMessage(), e);
        }
    }

    private String createdServiceId() {
        long countService =serviceRepository.count();
        return String.format("SV%05d", countService + 1);
    }

    @Override
    public void updateService(ServiceDTO serviceDTO) {
        if(serviceDTO == null || serviceDTO.getId() == null)
            throw new IllegalArgumentException("Dữ liệu dịch vụ không hợp lệ hoặc thiếu ID.");
        Service existingService = serviceRepository.findById( serviceDTO.getId()).orElse(null);
        if(existingService == null)
            throw  new ResourceNotFoundException("Không tìm thấy dịch vụ với ID: " + serviceDTO.getId());
        try{
            Service service = ServiceMapper.toService(serviceDTO);
            serviceRepository.save(service);
        }catch (Exception e){
            throw new RuntimeException("Lỗi khi thêm dịch vụ: " + e.getMessage(), e);
        }
    }


    @Override
    public void softDeleteService(String id) {
        Service service = serviceRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy dịch vụ có id: "+ id));
        try{
            service.setStatus("DELETING");
            serviceRepository.save(service);
        }catch( Exception e){
            throw new RuntimeException("Lỗi khi xóa dịch vụ" + e.getMessage(), e);
        }
    }
}
