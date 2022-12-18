package com.miu.registration.Service;

import com.miu.registration.dto.StudentDTO;
import com.miu.registration.model.Student;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface StudentServiceInterface {

    public List<Student> getAllStudents(Student student);
    public void addNewStudnt(StudentDTO studentDTO);

    ResponseEntity<Student> getUpdateStudent(Long id);



    Student getStudentById();
}
