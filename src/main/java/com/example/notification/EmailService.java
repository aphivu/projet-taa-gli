package com.example.notification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import org.springframework.mail.javamail.JavaMailSender;

@Service
public class EmailService implements IEmailService{

    /**
     * Using spring boot mail dependency
     */
    @Autowired
    private JavaMailSender emailSender;

    @Override
    public void sendSimpleMessage(String to, String content){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("Week-end Notification");
        message.setText(content);
        message.setTo(to);
        message.setFrom("no-reply@gmail.com");

        emailSender.send(message);
    }
}
