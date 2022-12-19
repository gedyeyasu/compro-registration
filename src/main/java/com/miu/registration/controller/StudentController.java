package com.miu.registration.controller;

import com.miu.registration.exception.NotFoundException;
import com.miu.registration.repositories.StudentRepository;
import com.miu.registration.service.StudentAdapter;
import com.miu.registration.service.StudentDTO;
import com.miu.registration.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@CrossOrigin
public class StudentController {
    @Autowired
    StudentService studentService;
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    StudentAdapter studentAdapter;

    @GetMapping("/students")
    public ResponseEntity<?> getAllStudents(Long studentId){
        System.out.println("id: "+studentId);
        Collection<StudentDTO> studentDTOS = studentService.getAllStudents();
        if(studentDTOS.size() > 0){
            return new ResponseEntity<Collection<StudentDTO>>(studentDTOS, HttpStatus.OK);
        }
        return new ResponseEntity<NotFoundException>(new NotFoundException("No Student Found"), HttpStatus.NOT_FOUND);

    }

    @GetMapping("/students/{studentId}")
    public ResponseEntity<?> getStudent(@PathVariable Long studentId){
        StudentDTO studentDTO = studentService.getStudent(studentId);
         if(studentDTO == null){
            return new ResponseEntity<NotFoundException>(new NotFoundException("Student with Id= "
                    + studentId + " not found."), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<StudentDTO>(studentDTO, HttpStatus.OK);
    }

    @PostMapping("/students")
    public ResponseEntity<?> addStudent(@RequestBody StudentDTO studentDTO){
         StudentDTO stdDTO = studentService.createStudent(studentDTO);
         return new ResponseEntity<StudentDTO>(stdDTO, HttpStatus.OK);

    }

    @DeleteMapping("/students/{studentId}")
    public ResponseEntity<?> deleteStudent(@PathVariable Long studentId){
        Long numOfStudentDeleted = studentService.deleteStudent(studentId);

        if(numOfStudentDeleted > 0) {
            return new ResponseEntity<String>("Student with Id= "+studentId+" deleted successfully.",
                    HttpStatus.OK);
        }
        else{
            return new ResponseEntity<NotFoundException>(new NotFoundException("Student with Id= "+studentId+" not found."),
                    HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping("/students/{studentId}")
    public ResponseEntity<?> updateStudent(@PathVariable Long studentId, @RequestBody StudentDTO studentDTO){
        StudentDTO studDTO = studentService.updateStudent(studentId, studentDTO);
        if(studDTO == null) {
            return new ResponseEntity<NotFoundException>(new NotFoundException("Student with ID= " +
                    studentId + " isn't found."),HttpStatus.NOT_FOUND );
        }

        return new ResponseEntity<String>("Student with Id= "+studentId+" updated successfully."
        , HttpStatus.OK);

    }
}
