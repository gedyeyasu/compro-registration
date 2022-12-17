package com.miu.registration.controller;

import com.miu.registration.Service.StudentService;
import com.miu.registration.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value ="registration-events")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping(value ="/latest-students")
    public List<Student> displayStudents(){
        return studentService.getAllStudents();
    }
}
