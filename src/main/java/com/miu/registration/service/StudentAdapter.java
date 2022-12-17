package com.miu.registration.service;

import com.miu.registration.domain.Student;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Component
public class StudentAdapter implements IAdapter<Student, StudentDTO>{
    @Override
    public Student getDomainFromDTO(StudentDTO studentDTO) {
        Student student = new Student();

        student.setStudentId(studentDTO.getStudentId());
        student.setFirstName(studentDTO.getFirstName());
        student.setLastName(studentDTO.getLastName());
        student.setEmail(studentDTO.getEmail());
        student.setHomeAddress(studentDTO.getHomeAddress());
        student.setMailAddress(studentDTO.getMailAddress());

        return student;
    }

    @Override
    public StudentDTO getDTOFromDomain(Student student) {
        StudentDTO studentDTO = new StudentDTO();

        studentDTO.setFirstName(student.getFirstName());
        studentDTO.setStudentId(student.getStudentId());
        studentDTO.setLastName(student.getLastName());
        studentDTO.setEmail(student.getEmail());
        studentDTO.setHomeAddress(student.getHomeAddress());
        studentDTO.setMailAddress(student.getMailAddress());

        return studentDTO;
    }

    @Override
    public List<Student> getDomainsFromDTOs(List<StudentDTO> studentDTOS) {
        return studentDTOS.stream()
                .map(studentDTO -> getDomainFromDTO(studentDTO))
                .collect(Collectors.toList());
    }

    @Override
    public List<StudentDTO> getDTOsFromDomains(List<Student> students) {
        return students.stream()
                .map(student -> getDTOFromDomain(student))
                .collect(Collectors.toList());
    }
}
