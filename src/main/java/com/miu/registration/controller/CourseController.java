package com.miu.registration.controller;
import com.miu.registration.exception.NotFoundException;
import com.miu.registration.repositories.CourseRepository;
import com.miu.registration.service.ICourseService;
import com.miu.registration.service.DTO.CourseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("courses")
public class CourseController {

    @Autowired
    ICourseService courseService;
    @Autowired
    private CourseRepository courseRepository;

    @GetMapping
    public ResponseEntity<?> getAll(){

        var course =courseService.getAllCourses();

        if(course.size()!=0){
            return new ResponseEntity<>(course, HttpStatus.OK);
        }else{
            return new ResponseEntity<NotFoundException>(new NotFoundException("No Course Found."),
                    HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/{code}")
    public ResponseEntity<?> getCourse(@PathVariable String code){
        CourseDTO courseDTO =courseService.getCourse(code);
        if(courseDTO==null){
            return new ResponseEntity<NotFoundException>(new NotFoundException("Course with " +
                    "Code= "+code+" not found."),HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(courseDTO, HttpStatus.OK);

    }

//    @PutMapping("/{code}")
//    public ResponseEntity<?> updateCourse(@PathVariable String code,
//                             @RequestBody CourseDTO courseDTO){
////
////        CourseDTO cDTO = courseService.updateCourse(code, courseDTO);
////        if(cDTO==null) {
////            return new ResponseEntity<NotFoundException>(new NotFoundException("Course with Code= "
////                    + code + " is not found."), HttpStatus.NOT_FOUND);
////        }
////        return new ResponseEntity<CourseDTO>(cDTO, HttpStatus.OK);
//    }

    @PostMapping
    public ResponseEntity<?> addCourseOffering(@RequestBody CourseDTO courseDTO) {

        CourseDTO cDTO = courseService.addCourse(courseDTO);
        return new ResponseEntity<String>("Course with Code= "+
                courseDTO.getCode()+" is added successfully.", HttpStatus.OK);

    }

    @DeleteMapping("/{code}")
    public ResponseEntity<?> deleteCourse(@PathVariable String code){
        Long numOfCoursesDeleted = courseService.deleteCourse(code);
        if(numOfCoursesDeleted==0){
            return new ResponseEntity<NotFoundException>(new NotFoundException("Course with Code= "+code+" not found."),
                    HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<String>("Course with Code= "+code+" deleted successfully.",
                HttpStatus.OK);
    }


}
