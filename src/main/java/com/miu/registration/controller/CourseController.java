package com.miu.registration.controller;
import com.miu.registration.exception.NotFoundException;
import com.miu.registration.service.ICourseService;
import com.miu.registration.service.DTO.CourseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("course")
public class CourseController {

    @Autowired
    ICourseService courseService;

    @GetMapping
    public ResponseEntity<?> getAll(){

        var course =courseService.getAllCourse();

        if(course.size()!=0){
            return new ResponseEntity<>(course, HttpStatus.OK);
        }else{
            return new ResponseEntity<NotFoundException>(new NotFoundException("No Course Found."),
                    HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Long id){

        var course =courseService.findById(id);

        if(course!=null){
            return new ResponseEntity<>(course, HttpStatus.OK);
        }else{
            return new ResponseEntity<NotFoundException>(new NotFoundException("Course with " +
                    "Id= "+id+" not found."),HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping("/{id}")
    public void updateCourse(@RequestBody CourseDTO courseDTO,
                                     @PathVariable("id") Long id){
        courseService.update(courseDTO,id);
    }

    @PostMapping

    public ResponseEntity<?> addCourseOffering(@RequestBody CourseDTO courseDTO) {

        var course=courseService.add(courseDTO);
        if(course!=null){
            return new ResponseEntity<>(course, HttpStatus.OK);
        }else{
            return new ResponseEntity<NotFoundException>(new NotFoundException("Course not saved."),HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Long id){
        courseService.deleteById(id);
    }


}
