package com.ptithcm.clinic_booking.factory;

import com.ptithcm.clinic_booking.model.EmailOtp;
import org.springframework.stereotype.Component;

@Component
public class SendEmailFactory {
    public static ISendMail createISendMail(String email, EmailOtp.OtpPurpose otpPurpose) {
        switch (otpPurpose){
            case APPOINTMENT:
                return new SendMailToAuth();
            case ACCOUNT_VERIFY:
                return new SendMailToGetPassword();
            default:
                throw new IllegalArgumentException("Unknown type");
        }
    }
}
