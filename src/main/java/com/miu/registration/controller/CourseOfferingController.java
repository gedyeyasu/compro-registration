package com.miu.registration.controller;

import com.miu.registration.service.DTO.CourseOfferingDTO;
import com.miu.registration.currentTypeError.ErrorOccured;
import com.miu.registration.service.CourseOffServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/courseOffering")

public class CourseOfferingController {

    @Autowired
    CourseOffServiceInterface courseOffService;

@GetMapping
    public ResponseEntity<?> getAll(){

    var courseOfferings =courseOffService.getAllCourseOffering();

    if(courseOfferings.size()!=0){
        return new ResponseEntity<>(courseOfferings, HttpStatus.OK);
    }else{
        return new ResponseEntity<>(new ErrorOccured(),HttpStatus.NOT_FOUND);
    }

}

    @GetMapping("{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Long id){

        var courseOffering =courseOffService.findById(id);

        if(courseOffering!=null){
            return new ResponseEntity<>(courseOffering, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(new ErrorOccured(),HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping("/{id}")
    public void updateCourseOffering(@RequestBody CourseOfferingDTO courseOfferingDTO,
                                                  @PathVariable("id") Long id){
        courseOffService.update(courseOfferingDTO,id);
    }

    @PostMapping

    public ResponseEntity<?> addCourseOffering(@RequestBody CourseOfferingDTO courseOfferingDTO) {

     var courseOffering=courseOffService.add(courseOfferingDTO);
        if(courseOffering!=null){
            return new ResponseEntity<>(courseOffering, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(new ErrorOccured("not saved"),HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Long id){
    courseOffService.deleteById(id);
    }





}
