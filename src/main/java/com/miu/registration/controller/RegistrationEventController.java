package com.miu.registration.controller;

import com.miu.registration.Service.Implementation.AcademicBlockSerivce;
import com.miu.registration.Service.Implementation.RegistrationEventService;
import com.miu.registration.Service.Implementation.RegistrationGroupsService;

import com.miu.registration.Service.Implementation.RegistrationService;
import com.miu.registration.dto.AcademicBlockDTO;
import com.miu.registration.dto.RegistrationEventDTO;
import com.miu.registration.model.Registration;
import com.miu.registration.model.RegistrationEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/registrationEvents")

public class RegistrationEventController {

    @Autowired
    private RegistrationEventService registrationEventService;

    @Autowired
    private RegistrationGroupsService registrationGroupsService;
    @Autowired
    private RegistrationService registrationService;

    @Autowired
    private AcademicBlockSerivce academicBlockSerivce;
// FOT RegistrationEvent CRUD
    @PostMapping("")
    public void addRegistrationEvent(@RequestBody RegistrationEventDTO registrationEventDTO){
        registrationEventService.viewRegisterationEvent(registrationEventDTO);

    }
//    @GetMapping("/")
//    public List<RegistrationEvent> fetchRegistrationList()
//    {
//        return registrationEventService.getFetchRegistrationList();
//    }
    @GetMapping("/latest")
    public List<RegistrationEvent> getAlllatesetOffering(){
        return  registrationEventService.getlatesetevent();

    }
    @PutMapping("/registartionEvents/{startevent}/{endevent}")
     public List<RegistrationEvent> updateEvent(@PathVariable Long updateid, @PathVariable Date startDate, @PathVariable Date endDate){
        return registrationEventService.updateevents(updateid,startDate,endDate);

    }


    @DeleteMapping ("/registrationEvents/{id}")
    public String  deleteRegistrationList(@PathVariable("id")Long registrationeventId){
        registrationEventService.deleteRegistrationList(registrationeventId);
        return " Deleted Event Suceesfully";

    }
    // FOR Registration CRUD  ---- use case - 6






    @PostMapping("/acdemicBlock")
    public void viewAcademicBlock(@RequestBody AcademicBlockDTO academicBlockDTO){
        academicBlockSerivce.viewAcademicBlock(academicBlockDTO);
    }



}
