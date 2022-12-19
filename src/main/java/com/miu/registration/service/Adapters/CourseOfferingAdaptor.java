package com.miu.registration.service.Adaptors;


import com.miu.registration.domain.*;
import com.miu.registration.service.DTO.*;

import java.util.Collection;
import java.util.stream.Collectors;

public class CourseOfferingAdaptor {



    public static CourseOffering fromCourseOfferingDTO(CourseOfferingDTO courseOfferingDTO){

        CourseOffering courseOffering=new CourseOffering();

       Course course=CourseAdapter.fromCourseDTO(courseOfferingDTO.getCourseDTO());
       Faculty faculty=FacultyAdaptor.fromFacultyDTO(courseOfferingDTO.getFaculty());
        Collection<Registration> registrations=courseOfferingDTO.getRegistrationsOfStudents().stream()
                        .map(RegistrationAdopter::fromRegistrationDTO).collect(Collectors.toList());

        AcademicBlock academicBlock=AcademicBlockAdaptor.fromAcademicDTO(courseOfferingDTO.getAcademicBlockDTO());




       courseOffering.setCourse(course);
       courseOffering.setCapacity(courseOfferingDTO.getCapacity());
      courseOffering.setFaculty(faculty);
      courseOffering.setAvailableSeat(courseOfferingDTO.getAvailableSeat());
      courseOffering.setAcademicBlock(academicBlock);
      courseOffering.setRegistrationsOfStudents(registrations);

        return courseOffering;
    }


    public static CourseOfferingDTO fromCourseOffering(CourseOffering courseOffering){

        CourseOfferingDTO courseOfferingDTO=new CourseOfferingDTO();

        CourseDTO courseDTO=CourseAdapter.fromCourse(courseOffering.getCourse());

        FacultyDTO facultyDTO=FacultyAdaptor.fromFaculty(courseOffering.getFaculty());
        Collection<RegistrationDTO> registrationsDTO=courseOffering.getRegistrationsOfStudents().stream()
                .map(RegistrationAdopter::fromRegistration).collect(Collectors.toList());
        AcademicBlockDTO academicBlockDTO=AcademicBlockAdaptor.fromAcademicBlock(courseOffering.getAcademicBlock());



        courseOfferingDTO.setCourseDTO(courseDTO);
        courseOfferingDTO.setCapacity(courseOffering.getCapacity());
        courseOfferingDTO.setFaculty(facultyDTO);
        courseOfferingDTO.setAvailableSeat(courseOffering.getAvailableSeat());
        courseOfferingDTO.setAcademicBlockDTO(academicBlockDTO);
        courseOfferingDTO.setRegistrationsOfStudents(registrationsDTO);

        return courseOfferingDTO;
    }



}
