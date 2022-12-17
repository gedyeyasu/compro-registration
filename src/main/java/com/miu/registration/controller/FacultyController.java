package com.miu.registration.controller;

import com.miu.registration.Service.Implementation.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FacultyController {

    @Autowired
    private FacultyService facultyService;

}
