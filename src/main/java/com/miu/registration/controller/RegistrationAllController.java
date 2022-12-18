package com.miu.registration.controller;

import com.miu.registration.Service.Implementation.AcademicBlockSerivce;
import com.miu.registration.Service.Implementation.RegistrationEventService;
import com.miu.registration.Service.Implementation.RegistrationGroupsService;

import com.miu.registration.dto.AcademicBlockDTO;
import com.miu.registration.dto.RegistrationEventDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = {"/registrationGroups"})

public class RegistrationAllController {

    @Autowired
    private RegistrationEventService registrationEventService;

    @Autowired
    private RegistrationGroupsService registrationGroupsService;

    @Autowired
    private AcademicBlockSerivce academicBlockSerivce;

    @PostMapping()
    public void viewRegistrationEvent(@RequestBody RegistrationEventDTO registrationEventDTO){
        registrationEventService.viewRegisterationEvent(registrationEventDTO);

    }
    @PostMapping("/acdemicBlock")
    public void viewAcademicBlock(@RequestBody AcademicBlockDTO academicBlockDTO){
        academicBlockSerivce.viewAcademicBlock(academicBlockDTO);
    }



}
