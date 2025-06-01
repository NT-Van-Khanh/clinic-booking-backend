package com.ptithcm.clinic_booking.mapper;

import com.ptithcm.clinic_booking.dto.manager.ManagerRequestDTO;
import com.ptithcm.clinic_booking.dto.manager.ManagerResponseDTO;
import com.ptithcm.clinic_booking.model.Account;
import com.ptithcm.clinic_booking.model.Manager;
import com.ptithcm.clinic_booking.model.Role;

public class ManagerMapper {
    public static ManagerResponseDTO toManagerDTO(Manager manager){
        if (manager == null) return null;

        return ManagerResponseDTO.builder()
                .id(manager.getId())
                .account(AccountMapper.toAccountResponseDTO(manager.getAccount()))
                .name(manager.getName())
                .phone(manager.getPhone())
                .email(manager.getEmail())
                .address(manager.getAddress())
                .gender(manager.getGender())
                .status(manager.getStatus())
                .createdAt(manager.getCreatedAt())
                .build();
    }
    public static Manager toManager(ManagerRequestDTO dto) {
        if(dto == null) return null;
        return Manager.builder()
                //.id(dto.getId())
                .name(dto.getName())
                .phone(dto.getPhone())
                .email(dto.getEmail())
                .address(dto.getAddress())
                .gender(dto.getGender())
                .status(dto.getStatus())
                .account(AccountMapper.toAccount(dto.getAccount()))
                .build();
    }

    public static Manager toManager(ManagerResponseDTO dto) {
        if(dto == null) return null;
        return Manager.builder()
                .id(dto.getId())
                .name(dto.getName())
                .phone(dto.getPhone())
                .email(dto.getEmail())
                .address(dto.getAddress())
                .gender(dto.getGender())
                .status(dto.getStatus())
                .account(AccountMapper.toAccount(dto.getAccount()))
                .build();
    }
}
