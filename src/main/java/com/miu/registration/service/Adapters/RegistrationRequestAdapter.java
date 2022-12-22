package com.miu.registration.service.Adapters;

import com.miu.registration.service.DTO.CourseOfferingDTO;
import com.miu.registration.service.DTO.RegistrationRequestDTO;
import com.miu.registration.domain.CourseOffering;
import com.miu.registration.domain.RegistrationRequest;
import com.miu.registration.domain.Student;
import com.miu.registration.service.DTO.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
public class RegistrationRequestAdapter implements IAdapter<RegistrationRequest, RegistrationRequestDTO>{
    @Autowired
    StudentAdapter studentAdapter;
    @Autowired
    CourseOfferingAdapter courseOfferingAdapter;
    @Override
    public RegistrationRequest getDomainFromDTO(RegistrationRequestDTO registrationRequestDTO) {
        RegistrationRequest registrationRequest = new RegistrationRequest();

        registrationRequest.setId(registrationRequestDTO.getId());
        registrationRequest.setPriority(registrationRequestDTO.getPriority());
        registrationRequest.setCourseOffering(courseOfferingAdapter.getDomainFromDTO(registrationRequestDTO.getCourseOfferingDTO()));
        registrationRequest.setStudent(registrationRequestDTO.getStudent());

        return registrationRequest;
    }

    @Override
    public RegistrationRequestDTO getDTOFromDomain(RegistrationRequest registrationRequest) {
        RegistrationRequestDTO registrationRequestDTO = new RegistrationRequestDTO();

        registrationRequestDTO.setId(registrationRequest.getId());
        registrationRequestDTO.setPriority(registrationRequest.getPriority());
        registrationRequestDTO.setCourseOfferingDTO(courseOfferingAdapter.getDTOFromDomain(registrationRequest.getCourseOffering()));
        registrationRequestDTO.setStudent(registrationRequest.getStudent());

        return registrationRequestDTO;
    }

    @Override
    public List<RegistrationRequest> getDomainsFromDTOs(List<RegistrationRequestDTO> registrationRequestDTOS) {
        return null;
    }

    @Override
    public List<RegistrationRequestDTO> getDTOsFromDomains(List<RegistrationRequest> registrationRequests) {
        return null;
    }
}
