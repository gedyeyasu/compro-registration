package com.miu.registration.controller;
import com.miu.registration.exception.NotFoundException;
import com.miu.registration.repositories.RegistrationRequestRepository;
import com.miu.registration.service.DTO.RegistrationRequestDTO;
import com.miu.registration.service.DTO.RegistrationRequestResponseDTO;
import com.miu.registration.service.IRegistrationRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/registration-requests")
public class RegistrationRequestController {

    private final IRegistrationRequestService requestService;
    private final RegistrationRequestRepository registrationRequestRepository;

    //    admin level endpoint
    @GetMapping
    public ResponseEntity<?> displayRegistrationRequest(){

        Collection<RegistrationRequestDTO> requestDTOS= requestService.getAllRegistrationRequests();
        return new ResponseEntity<>(requestDTOS, HttpStatus.OK);
    }
    @GetMapping("/{studentId}")
    public ResponseEntity<?> displayRequestByStudentId(@PathVariable long studentId){
        List<RegistrationRequestDTO> requestDTO =requestService.getRegistrationRequestByStudentId(studentId);
        if(requestDTO==null){
            return new ResponseEntity<NotFoundException>(new NotFoundException("Registration Request with " +
                    "Id= "+studentId+" not found."),HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(requestDTO,HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> saveRequest(@RequestBody RegistrationRequestResponseDTO registrationRequestResponseDTO){
        System.out.println("post");
        try{
            requestService.createRegistrationRequest(registrationRequestResponseDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch(Exception e){
            System.out.println(e.getMessage());
        return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateRequests(@PathVariable("id") long id, @RequestBody RegistrationRequestDTO requestDTO){
        requestService.updateRegistrationRequest(id,requestDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }
//    @DeleteMapping("/{id}")
//    public ResponseEntity<?> deleteRequests(@PathVariable long id){
//        RegistrationRequestDTO requestDTO = requestService.getRegistrationRequestByStudentId(id);
//        if(requestDTO==null){
//            return new ResponseEntity<NotFoundException>(new NotFoundException("Registration Request with " +
//                    "Id= "+id+" not found."),HttpStatus.NOT_FOUND);
//        }
//        requestService.deleteRegistrationRequest(id);
//        return new ResponseEntity<>(requestDTO,HttpStatus.NO_CONTENT);
//    }
}
