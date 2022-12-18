package com.miu.registration.controller;

import com.miu.registration.Service.Implementation.FacultyService;
import com.miu.registration.dto.FacultyDTO;
import com.miu.registration.model.Faculty;
import com.miu.registration.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/faculties")
public class FacultyController {

    @Autowired
    private FacultyService facultyService;

    @PostMapping()
    public void addNewFaculty(@RequestBody FacultyDTO facultyDTO){
        facultyService.addNewFaculty(facultyDTO);

    }
    @GetMapping(value ="/{id}")
    public Faculty getFacultybyId(){
        return facultyService.getFacultyId();

    }
    @GetMapping()
    public List<Faculty> getAllFaculties(){

        return facultyService.getAllFaculties();
    }



}
