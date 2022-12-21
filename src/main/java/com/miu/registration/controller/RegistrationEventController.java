package com.miu.registration.controller;

import com.miu.registration.domain.*;
import com.miu.registration.service.DTO.RegistrationEventDTO;
import com.miu.registration.service.DTO.RegistrationEventResponseDTO;
import com.miu.registration.service.Impl.RegistrationEventService;
import com.miu.registration.service.JwtUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("registration-events")
public class RegistrationEventController {

    @Autowired
    private RegistrationEventService registrationEventService;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    JwtUserDetailsService jwtUserDetailsService;


    // Admin level endpoint
    @GetMapping
    public ResponseEntity<?> getAllRegistrationEvents() {
        User user = jwtUserDetailsService.getRequestUser();
        if(user.getRole() == Role.ADMIN){
            List<RegistrationEvent> registrationEvents = registrationEventService.getAllRegistrationEvent();
            return new ResponseEntity<List<RegistrationEvent>>(registrationEvents, HttpStatus.OK);
        }else{
            return new ResponseEntity<String>("UnAuthorized Request", HttpStatus.UNAUTHORIZED);
        }

    }

    // Student level endpoint
    @GetMapping("/latest")
    public ResponseEntity<?> getLatestEvent(){
        try{
            Student student = (Student)jwtUserDetailsService.getRequestDomain();
            RegistrationEventResponseDTO registrationEventResponseDTO = registrationEventService.getLatestRegistrationEvent(student.getStudentId());
            return new ResponseEntity<RegistrationEventResponseDTO>( registrationEventResponseDTO, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<String>("You are not authorized to access it!", HttpStatus.UNAUTHORIZED);
        }


    }

}
