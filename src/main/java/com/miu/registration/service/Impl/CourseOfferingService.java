package com.miu.registration.service.CourseOfferingServiceImplementation;

import com.miu.registration.service.DTO.CourseOfferingDTO;
import com.miu.registration.domain.CourseOffering;
import com.miu.registration.repositories.CourseOfferingRepo;
import com.miu.registration.service.Adaptors.CourseOfferingAdaptor;
import com.miu.registration.service.CourseOffServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseOfferingServiceImpl implements CourseOffServiceInterface {

    @Autowired
    CourseOfferingRepo courseOfferingRepo;


    public CourseOffering addCourseOffering(CourseOfferingDTO courseOfferingDTO){

    var a= courseOfferingRepo.save(CourseOfferingAdaptor.fromCourseOfferingDTO(courseOfferingDTO));


        return a;
    }

    public List<CourseOfferingDTO> getAllCourseOffering(){

           return courseOfferingRepo.findAll().stream()
                   .map(CourseOfferingAdaptor::fromCourseOffering).collect(Collectors.toList());
    }

    public CourseOfferingDTO findById(Long id){
      var a=  courseOfferingRepo.findById(id);
      if(a.isPresent())
       return  CourseOfferingAdaptor.fromCourseOffering(a.get());
      else
          return null;
    }

     public CourseOffering add(CourseOfferingDTO courseOfferingDTO){
        CourseOffering courseOffering=CourseOfferingAdaptor.fromCourseOfferingDTO(courseOfferingDTO);
       return  courseOfferingRepo.save(courseOffering);
     }


     public void deleteById(Long id){
        courseOfferingRepo.deleteById(id);
     }

    public void update(CourseOfferingDTO courseOfferingDTO ,Long id){
        var courseOffering=courseOfferingRepo.findById(id);
        if(courseOffering.isPresent()&&courseOfferingDTO!=null){
         CourseOffering courseOffering1=courseOffering.get();
         CourseOffering courseOffering2=CourseOfferingAdaptor.fromCourseOfferingDTO(courseOfferingDTO);

         courseOffering1.setCourse(courseOffering2.getCourse());
         courseOffering1.setFaculty(courseOffering2.getFaculty());
         courseOffering1.setRegistrationsOfStudents(courseOffering2.getRegistrationsOfStudents());
         courseOffering1.setCapacity(courseOffering2.getCapacity());
        courseOffering1.setAcademicBlock(courseOffering2.getAcademicBlock());
         courseOfferingRepo.save(courseOffering1);
        }

    }







}
