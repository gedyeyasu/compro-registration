package com.miu.registration.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;


@Component
public class EmailSender {
    @Autowired
    private KafkaTemplate<String, EmailMessage> kafkaTemplate;

    public void send(String topic, EmailMessage emailMessage){
        System.out.println("sending message "+ emailMessage);
        kafkaTemplate.send(topic, emailMessage);
    }
}
