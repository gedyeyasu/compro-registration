package com.miu.registration.service;

import com.miu.registration.domain.Student;

import java.util.Collection;

public interface IStudentService {
    public StudentDTO createStudent(Student student);

    public StudentDTO getStudent(Long studentId);

    public Collection<StudentDTO> getAllStudents();
}
