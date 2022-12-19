package com.miu.registration.controller;

import com.miu.registration.exception.NotFoundException;
import com.miu.registration.repositories.StudentRepository;
import com.miu.registration.service.Adapters.StudentAdapter;
import com.miu.registration.service.DTO.StudentDTO;
import com.miu.registration.service.Impl.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@CrossOrigin
@RequestMapping("/students")
public class StudentController {
    @Autowired
    StudentService studentService;
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    StudentAdapter studentAdapter;

    @GetMapping
    public ResponseEntity<?> getAllStudents(Long studentId){
        System.out.println("id: "+studentId);
        Collection<StudentDTO> studentDTOS = studentService.getAllStudents();
        if(studentDTOS.size() > 0){
            return new ResponseEntity<Collection<StudentDTO>>(studentDTOS, HttpStatus.OK);
        }
        return new ResponseEntity<NotFoundException>(new NotFoundException("No Student Found"), HttpStatus.NOT_FOUND);

    }

    @GetMapping("/{studentId}")
    public ResponseEntity<?> getStudent(@PathVariable Long studentId){
        StudentDTO studentDTO = studentService.getStudent(studentId);
         if(studentDTO == null){
            return new ResponseEntity<NotFoundException>(new NotFoundException("Student with Id= "
                    + studentId + " not found."), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<StudentDTO>(studentDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addStudent(@RequestBody StudentDTO studentDTO){
         StudentDTO stdDTO = studentService.createStudent(studentDTO);
         return new ResponseEntity<StudentDTO>(stdDTO, HttpStatus.OK);

    }

    @DeleteMapping("/{studentId}")
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

    @PutMapping("//{studentId}")
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
