package com.ptithcm.clinic_booking.factory;

import com.ptithcm.clinic_booking.service.EmailService;

public class SendMailToGetPassword implements ISendMail {
    private EmailService emailService;

    public SendMailToGetPassword() {
    }

    @Override
    public void sendOtpToEmail(String email) {
        String subject = "Quên mật khẩu - Mã OTP lấy lại mật khẩu";
        String otp = emailService.generateOtp();
        String content = "Mã OTP của bạn là: " + otp + "\nVui lòng không chia sẻ mã này với người khác.";
        emailService.sendMail(email, subject, content);
    }
}
