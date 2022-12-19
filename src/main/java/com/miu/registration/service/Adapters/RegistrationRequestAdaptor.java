package com.miu.registration.service.Adapters;

import com.miu.registration.service.DTO.CourseOfferingDTO;
import com.miu.registration.service.DTO.RegistrationRequestDTO;
import com.miu.registration.domain.CourseOffering;
import com.miu.registration.domain.RegistrationRequest;
import com.miu.registration.domain.Student;
import com.miu.registration.service.DTO.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationRequestAdaptor {

    @Autowired
    StudentAdapter studentAdapter;

    public  RegistrationRequest fromRegistrationRequestDto(RegistrationRequestDTO registrationRequestDTO){
        RegistrationRequest registrationRequest = new RegistrationRequest();
        registrationRequest.setId(registrationRequestDTO.getId());
        CourseOffering courseOffering =CourseOfferingAdaptor.fromCourseOfferingDTO(registrationRequestDTO.getCourseOfferingDTO());
        registrationRequest.setCourseOffering(courseOffering);
        Student student = studentAdapter.getDomainFromDTO(registrationRequestDTO.getStudentDTO());
        registrationRequest.setStudent(student);
        return registrationRequest;


    }
    public  RegistrationRequestDTO fromRegistrationRequest(RegistrationRequest registrationRequest) {
        RegistrationRequestDTO registrationRequestDTO = new RegistrationRequestDTO();
        registrationRequestDTO.setId(registrationRequestDTO.getId());
        CourseOfferingDTO courseOffering = CourseOfferingAdaptor.fromCourseOffering(registrationRequest.getCourseOffering());
        registrationRequestDTO.setCourseOfferingDTO(courseOffering);
        StudentDTO studentDTO = studentAdapter.getDTOFromDomain(registrationRequest.getStudent());
        registrationRequestDTO.setStudentDTO(studentDTO);
        return registrationRequestDTO;
    }
}
