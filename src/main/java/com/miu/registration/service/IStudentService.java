package com.miu.registration.service;

import com.miu.registration.service.DTO.StudentDTO;

import java.util.Collection;

public interface IStudentService {
    public StudentDTO createStudent(StudentDTO studentDTO);

    public StudentDTO getStudent(Long studentId);

    public Collection<StudentDTO> getAllStudents();

    public Long deleteStudent(Long studentId);

    public StudentDTO updateStudent(Long studentId, StudentDTO studentDTO);
}
