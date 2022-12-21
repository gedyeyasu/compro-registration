package com.miu.registration.kafka;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailMessage {

    private String recipient;
    private String messageBody;

    private String subject;
}
