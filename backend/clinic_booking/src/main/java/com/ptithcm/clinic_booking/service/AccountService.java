package com.ptithcm.clinic_booking.service;

import com.ptithcm.clinic_booking.dto.account.AccountRequestDTO;
import com.ptithcm.clinic_booking.dto.account.AccountResponseDTO;
import org.springframework.data.domain.Page;

public  interface AccountService {
    AccountResponseDTO getAccountById(String username);

    void addAccount(AccountRequestDTO accountRequestDTO);
    void updateAccount(String username, AccountRequestDTO accountRequestDTO);
    void deleteAccount(String username);

    Page<AccountResponseDTO> getAllAccounts();
    boolean existsByUsername(String username);
}
