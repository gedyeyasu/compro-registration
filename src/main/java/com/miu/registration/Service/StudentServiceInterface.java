package com.miu.registration.Service;

import com.miu.registration.dto.StudentDTO;
import com.miu.registration.model.Student;

import java.util.List;

public interface StudentServiceInterface {

    public List<Student> getAllStudents();
    public void addNewStudnt(StudentDTO studentDTO);
}
