package com.miu.registration.controller;


import com.miu.registration.service.DTO.RegistrationRequestDTO;
import com.miu.registration.currentTypeError.ErrorOccured;
import com.miu.registration.service.RegistrationRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequiredArgsConstructor
@RequestMapping("/request")
public class RegistrationRequestController {

    private final RegistrationRequestService requestService;

    @GetMapping
    public ResponseEntity<?> displayRegistrationRequest(){

        Collection<RegistrationRequestDTO> requestDTOS= requestService.getAllSubmitRequests();
        return new ResponseEntity<>(requestDTOS, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> displayRequestById(@PathVariable("id") long id){
        RegistrationRequestDTO requestDTO =requestService.getSubmittedRequest(id);
        if(requestDTO==null){
            return new ResponseEntity<ErrorOccured>(new ErrorOccured("not available"),HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(requestDTO,HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> saveRequest(@RequestBody RegistrationRequestDTO requestDTO){
        requestService.createSubmittedRequest(requestDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateRequests(@PathVariable("id") long id, @RequestBody RegistrationRequestDTO requestDTO){
        requestService.updateRequest(id,requestDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteRequests(@PathVariable long id){
        RegistrationRequestDTO requestDTO = requestService.getSubmittedRequest(id);
        if(requestDTO==null){
            return new ResponseEntity<>(new ErrorOccured("not available"),HttpStatus.NOT_FOUND);
        }
        requestService.deleteRequest(id);
        return new ResponseEntity<>(requestDTO,HttpStatus.NO_CONTENT);
    }
}
