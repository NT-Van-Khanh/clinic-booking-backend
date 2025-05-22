package com.ptithcm.clinic_booking.controller.shared;


import com.ptithcm.clinic_booking.dto.account.ChangePasswordDTO;
import com.ptithcm.clinic_booking.model.ApiResponse;
import com.ptithcm.clinic_booking.service.AccountService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping("/api/v1/sh/accounts")
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/change-password")
    public ResponseEntity<ApiResponse<String>> changePassword(@RequestBody @Valid ChangePasswordDTO request) {
        accountService.changePassword(request.getUsername(), request.getCurrentPassword(), request.getNewPassword());
        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK, "Đổi mật khẩu thành công"));
    }
}
