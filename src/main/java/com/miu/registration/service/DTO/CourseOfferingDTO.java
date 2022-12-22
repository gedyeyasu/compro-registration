package com.miu.registration.service.DTO;

import lombok.*;

import java.util.ArrayList;
import java.util.Collection;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseOfferingDTO {
    private Integer capacity=50;
    private Collection<RegistrationDTO> registrationsOfStudents =new ArrayList<>();
    private CourseDTO courseDTO;
    private FacultyDTO facultyDTO;
    private Integer availableSeat;

    private String code;
    public Integer getAvailableSeat() {
        return capacity-registrationsOfStudents.size();
    }

    public void setAvailableSeat(Integer availableSeat) {
        this.availableSeat = availableSeat;
    }
    public void addRegistrationOfStudents(Collection<RegistrationDTO> registrationsOfStudents){
        this.registrationsOfStudents.addAll(registrationsOfStudents);
    }
}
