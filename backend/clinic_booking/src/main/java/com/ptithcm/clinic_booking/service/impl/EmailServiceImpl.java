package com.ptithcm.clinic_booking.service.impl;

import com.ptithcm.clinic_booking.exception.MailSendException;
import com.ptithcm.clinic_booking.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {
    private final JavaMailSender javaMailSender;

    @Autowired
    public EmailServiceImpl(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Override
    public void sendMail(String to, String subject, String content){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(content);
        try {
            javaMailSender.send(message);
            System.out.println("Email sent successfully to " + to);
        }catch(Exception e){
            throw new MailSendException("Gửi email thất bại đến " + to, e);
        }
    }
}
