package com.miu.registration.controller;
import com.miu.registration.exception.NotFoundException;
import com.miu.registration.service.ICourseOfferingService;
import com.miu.registration.service.DTO.CourseOfferingDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/courseOffering")

public class CourseOfferingController {

    @Autowired
    ICourseOfferingService courseOffService;

@GetMapping
    public ResponseEntity<?> getAll(){

    var courseOfferings =courseOffService.getAllCourseOffering();

    if(courseOfferings.size()!=0){
        return new ResponseEntity<>(courseOfferings, HttpStatus.OK);
    }else{
        return new ResponseEntity<NotFoundException>(new NotFoundException("No Course Offering is found."),HttpStatus.NOT_FOUND);
    }

}

    @GetMapping("{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Long id){

        var courseOffering =courseOffService.findById(id);

        if(courseOffering!=null){
            return new ResponseEntity<>(courseOffering, HttpStatus.OK);
        }else{
            return new ResponseEntity<NotFoundException>(new NotFoundException("Course Offering with " +
                    "Id= "+id+" not found."),HttpStatus.NOT_FOUND);
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
            return new ResponseEntity<NotFoundException>(new NotFoundException("Not Saved."),
                    HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Long id){
    courseOffService.deleteById(id);
    }





}
