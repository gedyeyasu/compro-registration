package com.miu.registration.controller;


import com.miu.registration.Service.Implementation.StudentService;
import com.miu.registration.dto.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/students")
public class StudentController {
    @Autowired

    private StudentService studentService;

    @PostMapping()
    public void addStudent (@RequestBody StudentDTO studentDTO){
        studentService.addNewStudnt(studentDTO);
    }


}
