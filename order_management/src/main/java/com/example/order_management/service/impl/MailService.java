package com.example.order_management.service.impl;

import com.example.order_management.entity.MailEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {
    private JavaMailSender javaMailSender;

    @Autowired
    public MailService(JavaMailSender javaMailSender)
    {
        this.javaMailSender=javaMailSender;
    }

    public void sendMail(MailEntity mailEntity)
    {
        SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
        simpleMailMessage.setTo(mailEntity.getEmail());
        simpleMailMessage.setFrom("aman.11606099@gmail.com");
        simpleMailMessage.setSubject("Order Placed!!");
        simpleMailMessage.setText("Hi!! "+mailEntity.getName()+" \n "+mailEntity.getText());

        javaMailSender.send(simpleMailMessage);
    }

}
