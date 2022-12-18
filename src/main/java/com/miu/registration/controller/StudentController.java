package com.miu.registration.controller;


import com.miu.registration.Service.Implementation.StudentService;
import com.miu.registration.dto.StudentDTO;
import com.miu.registration.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping()
    public void addStudent (@RequestBody StudentDTO studentDTO){
        studentService.addNewStudnt(studentDTO);
    }

    @GetMapping()
    public List<Student> getAllStudent(){

        return studentService.getAllStudents();
    }
    @GetMapping (value = {"/id"})
    public Student getStudent(){
        return studentService.getStudentById();
    }
    @PutMapping(value="/{id}")
    public ResponseEntity<Student> getUpdateStudent(@RequestBody Student student ,
                                                   @PathVariable Long id) {

        return studentService.getUpdateStudent(id);


    }


}
