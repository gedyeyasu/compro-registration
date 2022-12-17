package com.miu.registration.controller;

import com.miu.registration.Service.AcademicBlockSerivce;
import com.miu.registration.Service.RegistrationEventService;
import com.miu.registration.Service.RegistrationGroupsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationAllController {

    @Autowired
    private RegistrationEventService registrationEventService;

    @Autowired
    private RegistrationGroupsService registrationGroupsService;

    @Autowired
    private AcademicBlockSerivce academicBlockSerivce;


}
