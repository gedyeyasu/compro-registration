package com.miu.registration.service.Adapters;

import com.miu.registration.domain.Student;
import com.miu.registration.service.DTO.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@Component
public class StudentAdapter implements IAdapter<Student, StudentDTO>{
    @Autowired
    AddressAdapter addressAdapter;
    @Override
    public Student getDomainFromDTO(StudentDTO studentDTO) {
        Student student = new Student();
//      student.setId(studentDTO.getId());
        student.setStudentId(studentDTO.getStudentId());
        student.setFirstName(studentDTO.getFirstName());
        student.setLastName(studentDTO.getLastName());
        student.setEmail(studentDTO.getEmail());
        student.setHomeAddress(addressAdapter.getDomainFromDTO(studentDTO.getHomeAddress()));
        student.setMailAddress(addressAdapter.getDomainFromDTO(studentDTO.getMailAddress()));

        return student;
    }

    @Override
    public StudentDTO getDTOFromDomain(Student student) {
        StudentDTO studentDTO = new StudentDTO();
//        studentDTO.setId(student.getId());
        studentDTO.setFirstName(student.getFirstName());
        studentDTO.setStudentId(student.getStudentId());
        studentDTO.setLastName(student.getLastName());
        studentDTO.setEmail(student.getEmail());
        studentDTO.setHomeAddress(addressAdapter.getDTOFromDomain(student.getHomeAddress()));
        studentDTO.setMailAddress(addressAdapter.getDTOFromDomain(student.getMailAddress()));

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
