package com.miu.registration.service.DTO;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationRequestDTO {

    private long id;
    private int priority;
    private CourseOfferingDTO courseOfferingDTO;
    private StudentDTO studentDTO;
}
