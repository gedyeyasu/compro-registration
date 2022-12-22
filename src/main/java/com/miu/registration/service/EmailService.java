package com.miu.registration.service;

import com.miu.registration.kafka.EmailMessage;
import com.miu.registration.kafka.EmailPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired
    private EmailPublisher emailPublisher;

    @Value("${topic}")
    private String kafkaTopic;
    public void sendEmail(EmailMessage emailMessage){
        emailPublisher.publish(kafkaTopic, emailMessage);
    }
}
