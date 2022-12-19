package com.miu.registration.controller;


import com.miu.registration.Service.Implementation.AcademicBlockSerivce;
import com.miu.registration.Service.Implementation.RegistrationEventService;
import com.miu.registration.Service.Implementation.RegistrationGroupsService;
import com.miu.registration.Service.Implementation.RegistrationService;
import com.miu.registration.dto.AcademicBlockDTO;
import com.miu.registration.dto.RegistrationEventDTO;
import com.miu.registration.dto.RegistrationGroupsDTO;
import com.miu.registration.model.Registration;
import com.miu.registration.model.RegistrationEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/registrations")

public class RegistrationController {



    @Autowired
    private RegistrationGroupsService registrationGroupsService;
    @Autowired
    private RegistrationService registrationService;

    @Autowired
    private AcademicBlockSerivce academicBlockSerivce;
    // FOT RegistrationEvent CRUD


    // FOR Registration CRUD  ---- use case - 6

    @GetMapping("/")
    public List<Registration> getRegistrationList()
    {
        return registrationService.registrationList();
    }


    @PostMapping("/group")
        public void addRegistrationGroup(@RequestBody RegistrationGroupsDTO registrationGroupsDTO){

        registrationGroupsService.addRegistrationGroups(registrationGroupsDTO);
    }


//    @PostMapping("/acdemicBlock")
//    public void viewAcademicBlock(@RequestBody AcademicBlockDTO academicBlockDTO){
//        academicBlockSerivce.viewAcademicBlock(academicBlockDTO);
//    }



}
