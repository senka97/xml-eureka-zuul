package com.team19.emailmicroservice.service;

import com.google.gson.Gson;
import com.team19.emailmicroservice.rabbitmq.RegistrationMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.core.env.Environment;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    /*
     * Koriscenje klase za ocitavanje vrednosti iz application.properties fajla
     */
    @Autowired
    private Environment env;

    @Async
    public void sendEmailForRejectingRegistrationRequest(String messageJson) throws MailException {
        System.out.println(messageJson);
        Gson gson = new Gson();
        RegistrationMessage message = gson.fromJson(messageJson, RegistrationMessage.class);
        System.out.println("*****************************");
        System.out.println(message.getEmail());
        System.out.println("*****************************");
        System.out.println(message.getContent());
        System.out.println("*****************************");
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(message.getEmail());
        mail.setFrom(env.getProperty("spring.mail.username"));
        mail.setSubject("Registration request rejected");
        mail.setText(message.getContent());
        javaMailSender.send(mail);
        System.out.println("********* Email sent! **********");
    }

    @Async
    public void sendEmailForApprovingRegistrationRequest(String messageJson) throws MailException {
        System.out.println(messageJson);
        Gson gson = new Gson();
        RegistrationMessage message = gson.fromJson(messageJson, RegistrationMessage.class);
        System.out.println("*****************************");
        System.out.println(message.getEmail());
        System.out.println("*****************************");
        System.out.println(message.getContent());
        System.out.println("*****************************");
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(message.getEmail());
        mail.setFrom(env.getProperty("spring.mail.username"));
        mail.setSubject("Registration request approved");
        mail.setText(message.getContent());
        javaMailSender.send(mail);
        System.out.println("********* Email sent! **********");
    }
}
