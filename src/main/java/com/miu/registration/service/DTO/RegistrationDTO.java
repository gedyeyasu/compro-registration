package com.miu.registration.service.DTO;

import com.miu.registration.domain.CourseOffering;
import com.miu.registration.domain.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationDTO {
    private long id;
    private StudentDTO studentDTO;
    private CourseOfferingDTO courseOfferingDTO;
}
