package com.miu.registration.service;

import com.miu.registration.domain.Student;
import com.miu.registration.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class StudentService implements IStudentService{
    @Autowired
    StudentAdapter studentAdapter;
    @Autowired
    StudentRepository studentRepository;
    @Override
    public StudentDTO createStudent(Student student) {

        studentRepository.save(student);

        return studentAdapter.getDTOFromDomain(student);
    }

    // Get a single student by student id
    @Override
    public StudentDTO getStudent(Long studentId) {
        return studentAdapter.getDTOFromDomain((studentRepository.findByStudentId(studentId)));
    }

    // Get all students
    @Override
    public Collection<StudentDTO> getAllStudents() {
        return studentAdapter.getDTOsFromDomains(studentRepository.findAll());
    }
}
