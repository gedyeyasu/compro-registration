package com.miu.registration.service.DTO;


import com.miu.registration.domain.Student;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationRequestDTO {

    private long id;
    private int priority;
    private CourseOfferingDTO courseOfferingDTO;
    private Student student;
}
