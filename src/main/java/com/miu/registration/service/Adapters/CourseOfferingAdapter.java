package com.miu.registration.service.Adapters;


import com.miu.registration.domain.*;
import com.miu.registration.service.DTO.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
@Component
public class CourseOfferingAdapter implements IAdapter<CourseOffering, CourseOfferingDTO>{
    @Autowired
    CourseAdapter courseAdapter;

    @Autowired
    FacultyAdapter facultyAdapter;

    @Autowired
    RegistrationAdapter registrationAdapter;
    @Override
    public CourseOffering getDomainFromDTO(CourseOfferingDTO courseOfferingDTO) {
        CourseOffering courseOffering = new CourseOffering();

        courseOffering.setCapacity(courseOfferingDTO.getCapacity());
        courseOffering.setCode(courseOfferingDTO.getCode());
        courseOffering.setCourse(courseAdapter.getDomainFromDTO(courseOfferingDTO.getCourseDTO()));
        courseOffering.setFaculty(facultyAdapter.getDomainFromDTO(courseOfferingDTO.getFacultyDTO()));
        courseOffering.setAvailableSeat(courseOfferingDTO.getAvailableSeat());
        Collection<Registration> registrations = courseOfferingDTO.getRegistrationsOfStudents().stream()
                .map(registrationAdapter::getDomainFromDTO).collect(Collectors.toList());
        courseOffering.addRegistrationOfStudents(registrations);
        return courseOffering;
    }

    @Override
    public CourseOfferingDTO getDTOFromDomain(CourseOffering courseOffering) {
        CourseOfferingDTO courseOfferingDTO = new CourseOfferingDTO();

        courseOfferingDTO.setCapacity(courseOfferingDTO.getCapacity());
        courseOfferingDTO.setCode(courseOffering.getCode());
        courseOfferingDTO.setCourseDTO(courseAdapter.getDTOFromDomain(courseOffering.getCourse()));
        courseOfferingDTO.setFacultyDTO(facultyAdapter.getDTOFromDomain(courseOffering.getFaculty()));
        courseOfferingDTO.setAvailableSeat(courseOfferingDTO.getAvailableSeat());
        Collection<RegistrationDTO> registrations = courseOffering.getRegistrationsOfStudents().stream()
                .map(registrationAdapter::getDTOFromDomain).collect(Collectors.toList());
        courseOfferingDTO.addRegistrationOfStudents(registrations);

        return courseOfferingDTO;
    }

    @Override
    public List<CourseOffering> getDomainsFromDTOs(List<CourseOfferingDTO> courseOfferingDTOS) {
        return null;
    }

    @Override
    public List<CourseOfferingDTO> getDTOsFromDomains(List<CourseOffering> courseOfferings) {
        return null;
    }
}
