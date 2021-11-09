package com.alkemy.disneyapi.service.impl;

import com.alkemy.disneyapi.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;

public class EmailServiceImpl implements EmailService {

    @Autowired
    private Environment env;

    @Value("${alkemy.icons.email.sender}")
    private String emailSender;

    public void sendWelcomeEmailTo(String to) {

    }
}
