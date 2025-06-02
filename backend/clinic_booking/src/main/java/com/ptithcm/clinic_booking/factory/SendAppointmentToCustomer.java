package com.ptithcm.clinic_booking.factory;

import com.ptithcm.clinic_booking.dto.appointment.AppointmentDTO;
import com.ptithcm.clinic_booking.model.Appointment;
import com.ptithcm.clinic_booking.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SendAppointmentToCustomer implements ISendMail<Appointment> {
    private final EmailService emailService;

    @Autowired
    public SendAppointmentToCustomer(EmailService emailService) {
        this.emailService = emailService;
    }

    @Override
    public void sendOtpToEmail(String email, Appointment data) {
        String subject = "Thông báo lịch khám bệnh - Mã cuộc hẹn: " + data.getId();

        String content = "Kính gửi quý khách hàng,\n\n" +
                "Chúng tôi xin thông báo lịch khám của quý khách như sau:\n" +
                "Mã cuộc hẹn: " + data.getId() + "\n" +
                "Dịch vụ: " + data.getService().getName() + "\n" +
                "Bác sĩ: " + data.getSchedule().getDoctor().getName() + "\n" +
                "Phòng khám: " + data.getSchedule().getClinic().getName() + "\n" +
                "Ngày hẹn: " + data.getSchedule().getDate().toString() + "\n" +
                "Giờ bắt đầu: " +String.valueOf(data.getSchedule().getTimeStart()) + "\n" +
                "Số thứ tự: " + data.getNumericalOrder() + "\n" +
                "Trạng thái: " + data.getStatus().toString() + "\n" +
                "Ghi chú: " + data.getNote() + "\n\n" +
                "Mong quý khách đến đúng giờ theo lịch hẹn.\n" +
                "Trân trọng cảm ơn!\n";
        emailService.sendMail(email, subject, content);
    }
}
