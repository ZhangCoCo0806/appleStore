package com.coco.service.sendEmail.impl;

import com.coco.service.sendEmail.EmailTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

@Service
public class EmailToolsImpl implements EmailTools {
    @Autowired
    JavaMailSenderImpl mailSender;

    @Override
    public String sendEmailCode(String title, String text, String toPerson, String fromPerson) {
        try {
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setSubject(title);
            simpleMailMessage.setText(text);
            simpleMailMessage.setTo(toPerson);
            simpleMailMessage.setFrom(fromPerson);
            mailSender.send(simpleMailMessage);
            return "true";
        } catch (Exception e) {
            return "false";
        }
    }
}
