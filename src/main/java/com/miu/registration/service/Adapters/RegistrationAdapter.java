package com.miu.registration.service.Adapters;

import com.miu.registration.domain.CourseOffering;
import com.miu.registration.domain.Student;
import com.miu.registration.service.DTO.RegistrationDTO;
import com.miu.registration.domain.Registration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class RegistrationAdapter implements IAdapter<Registration, RegistrationDTO>{
    @Autowired
    StudentAdapter studentAdapter;

    @Autowired
    CourseOfferingAdapter courseOfferingAdapter;

    @Override
    public Registration getDomainFromDTO(RegistrationDTO registrationDTO) {
        Registration registration = new Registration();

        registration.setId(registrationDTO.getId());
        registration.setStudent(studentAdapter.getDomainFromDTO(registrationDTO.getStudentDTO()));
        registration.setCourseOffering(courseOfferingAdapter.getDomainFromDTO(registrationDTO.getCourseOfferingDTO()));

        return registration;
    }

    @Override
    public RegistrationDTO getDTOFromDomain(Registration registration) {
        RegistrationDTO registrationDTO = new RegistrationDTO();

        registrationDTO.setId(registrationDTO.getId());
        registrationDTO.setStudentDTO(studentAdapter.getDTOFromDomain(registration.getStudent()));
        registrationDTO.setCourseOfferingDTO(courseOfferingAdapter.getDTOFromDomain(registration.getCourseOffering()));

        return registrationDTO;
    }

    @Override
    public List<Registration> getDomainsFromDTOs(List<RegistrationDTO> registrationDTOS) {
        return null;
    }

    @Override
    public List<RegistrationDTO> getDTOsFromDomains(List<Registration> registrations) {
        return null;
    }
}
