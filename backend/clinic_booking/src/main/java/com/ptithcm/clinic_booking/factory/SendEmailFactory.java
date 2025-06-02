package com.ptithcm.clinic_booking.factory;

import com.ptithcm.clinic_booking.model.EmailPurpose;
import org.springframework.stereotype.Component;

@Component
public class SendEmailFactory {

    private final SendMailToAuth sendMailToAuth;
    private final SendMailToGetPassword sendMailToGetPassword;
    private final SendAppointmentToCustomer sendAppointmentToCustomer;
    public SendEmailFactory(SendMailToAuth sendMailToAuth,
                            SendMailToGetPassword sendMailToGetPassword,
                            SendAppointmentToCustomer sendAppointmentToCustomer) {
        this.sendMailToAuth = sendMailToAuth;
        this.sendMailToGetPassword = sendMailToGetPassword;
        this.sendAppointmentToCustomer = sendAppointmentToCustomer;
    }
    public ISendMail createISendMail(EmailPurpose emailPurpose) {
        switch (emailPurpose){
            case CUSTOMER_VERIFY:
                return sendMailToAuth;
            case ACCOUNT_VERIFY:
                return sendMailToGetPassword;
            case APPOINTMENT_CONFIRMATION:
                return sendAppointmentToCustomer;
            default:
                throw new IllegalArgumentException("Unknown type");
        }
    }
}
