package com.ptithcm.clinic_booking.factory;

import com.ptithcm.clinic_booking.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SendMailToAuth implements ISendMail {
    private EmailService emailService;

    public SendMailToAuth() {
    }

    @Override
    public void sendOtpToEmail(String email) {
        String otp = emailService.generateOtp();
        String content = "Mã OTP của bạn là: " + otp + ". Vui lòng không chia sẻ mã này với người khác.";
        emailService.sendMail(email,"Đặt lịch khám bệnh - Mã OTP xác minh email", content);
    }
}
