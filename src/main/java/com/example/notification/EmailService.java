package com.example.notification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import org.springframework.mail.javamail.JavaMailSender;

@Service
public class EmailService implements IEmailService{

    @Autowired
    private JavaMailSender emailSender;

    @Override
    public void sendSimpleMessage(String content){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("Week-end Notification");
        message.setText(content);
        message.setTo("vap3101@gmail.com");
        message.setFrom("no-reply@gmail.com");

        emailSender.send(message);
    }
}
