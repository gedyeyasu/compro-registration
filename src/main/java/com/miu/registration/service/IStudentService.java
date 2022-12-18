package com.miu.registration.service;

import com.miu.registration.domain.Student;

import java.util.Collection;

public interface IStudentService {
    public StudentDTO createStudent(StudentDTO studentDTO);

    public StudentDTO getStudent(Long studentId);

    public Collection<StudentDTO> getAllStudents();
}
