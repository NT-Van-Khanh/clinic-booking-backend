package com.ptithcm.clinic_booking.mapper;

import com.ptithcm.clinic_booking.dto.account.AccountRequestDTO;
import com.ptithcm.clinic_booking.dto.account.AccountResponseDTO;
import com.ptithcm.clinic_booking.model.Account;
import com.ptithcm.clinic_booking.model.Role;

public class AccountMapper {
    public static AccountResponseDTO toAccountResponseDTO(Account account) {
        if (account == null) return null;

        AccountResponseDTO dto = new AccountResponseDTO();
        dto.setUsername(account.getUsername());
        dto.setRoleName(account.getRole().getName());
        dto.setStatus(account.getStatus());
        dto.setCreatedAt(account.getCreatedAt());

        return dto;
    }

    //    public static AccountRequestDTO toAccountRequestDTO(Account account) {
//        if (account == null) return null;
//
//        AccountRequestDTO dto = new AccountRequestDTO();
//        dto.setUsername(account.getUsername());
//        dto.setPassword(account.getPassword()); // Chú ý bảo mật: nếu trả về client thì nên bỏ hoặc mã hóa
//        dto.setRoleId(account.getRole().getId()); // Mapper Role riêng
//        dto.setStatus(account.getStatus());
//        return dto;
//    }
    public static Account toAccount(AccountRequestDTO dto) {
        if (dto == null) return null;

        Account account = new Account();
        account.setUsername(dto.getUsername());
        account.setPassword(dto.getPassword());
        account.setRole(new Role(dto.getRoleId()));
        account.setStatus(dto.getStatus());
        return account;
    }
}
