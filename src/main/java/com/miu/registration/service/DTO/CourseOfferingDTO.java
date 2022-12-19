package com.miu.registration.service.DTO;

import lombok.*;

import java.util.ArrayList;
import java.util.Collection;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CourseOfferingDTO {

    Integer  initialValue=50;
    private Integer capacity=50;
    private Collection<RegistrationDTO> registrationsOfStudents =new ArrayList<>();
    private CourseDTO courseDTO;
    private FacultyDTO faculty;
    private Integer availableSeat=capacity-registrationsOfStudents.size();
    private AcademicBlockDTO academicBlockDTO;
}
