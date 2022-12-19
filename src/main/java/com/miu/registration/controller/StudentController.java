package com.miu.registration.controller;


import com.miu.registration.Service.Implementation.StudentService;
import com.miu.registration.dto.StudentDTO;
import com.miu.registration.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/students")
    public void addStudent (@RequestBody StudentDTO studentDTO){
        studentService.addNewStudnt(studentDTO);
    }

    @GetMapping("/students")
    public List<Student> getAllStudent(){

        return studentService.getAllStudents();
    }
    @GetMapping ("/students/id")
    public Student getStudent(){
        return studentService.getStudentById();
    }
    @PutMapping("/students/id")
    public ResponseEntity<Student> getUpdateStudent(@RequestBody Student student , @PathVariable Long id) {

        return studentService.getUpdateStudent(id);

    }


}
