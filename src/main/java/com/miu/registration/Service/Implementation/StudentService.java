package com.miu.registration.Service.Implementation;


import com.miu.registration.Repository.StudentRepository;
import com.miu.registration.Service.StudentServiceInterface;
import com.miu.registration.dto.StudentDTO;
import com.miu.registration.model.Student;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements StudentServiceInterface {

    @Autowired
    private StudentRepository studentRepository;



    @Override
    public List<Student> getAllStudents(Student student) {
        return studentRepository.findAll();
    }

    @Override
    public void addNewStudnt(StudentDTO studentDTO) {
        Student student = new Student();
        BeanUtils.copyProperties(studentDTO,student);
        studentRepository.save(student);
    }

    @Override
    public ResponseEntity<Student> getUpdateStudent(Long id) {
        return null;
    }

    @Override
    public Student getStudentById() {
        return null;
    }


    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
}
