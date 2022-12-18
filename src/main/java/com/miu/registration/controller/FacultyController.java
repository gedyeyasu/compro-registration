package com.miu.registration.controller;

import com.miu.registration.Service.Implementation.FacultyService;
import com.miu.registration.dto.FacultyDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/faculties")
public class FacultyController {

    @Autowired
    private FacultyService facultyService;

    @PostMapping()
    public void addNewFaculty(@RequestBody FacultyDTO facultyDTO){
        facultyService.addNewFaculty(facultyDTO);

    }



}
