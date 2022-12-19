package com.miu.registration.service.DTO;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter


public class RegistrationRequestDTO {

    private long id;
    private CourseOfferingDTO courseOfferingDTO;
    private StudentDTO studentDTO;
}
