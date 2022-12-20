package com.miu.registration.service.Impl;

import com.miu.registration.service.DTO.CourseOfferingDTO;
import com.miu.registration.domain.CourseOffering;
import com.miu.registration.repositories.CourseOfferingRepository;
import com.miu.registration.service.Adapters.CourseOfferingAdapter;
import com.miu.registration.service.ICourseOfferingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseOfferingService implements ICourseOfferingService {

    @Autowired
    CourseOfferingRepository courseOfferingRepository;

    @Autowired
    CourseOfferingAdapter courseOfferingAdapter;


    public CourseOffering addCourseOffering(CourseOfferingDTO courseOfferingDTO){
        var a= courseOfferingRepository.save(courseOfferingAdapter.getDomainFromDTO(courseOfferingDTO));
        return a;
    }

    public List<CourseOfferingDTO> getAllCourseOffering(){

           return courseOfferingRepository.findAll().stream()
                   .map(courseOfferingAdapter::getDTOFromDomain).collect(Collectors.toList());
    }

    public CourseOfferingDTO findById(Long id){
      var a=  courseOfferingRepository.findById(id);
      if(a.isPresent())
       return  courseOfferingAdapter.getDTOFromDomain(a.get());
      else
          return null;
    }

     public CourseOffering add(CourseOfferingDTO courseOfferingDTO){
        CourseOffering courseOffering= courseOfferingAdapter.getDomainFromDTO(courseOfferingDTO);
       return  courseOfferingRepository.save(courseOffering);
     }


     public void deleteById(Long id){
        courseOfferingRepository.deleteById(id);
     }

    public void update(CourseOfferingDTO courseOfferingDTO ,Long id){
        var courseOffering= courseOfferingRepository.findById(id);
        if(courseOffering.isPresent()&&courseOfferingDTO!=null){
             CourseOffering courseOffering1=courseOffering.get();
             CourseOffering courseOffering2= courseOfferingAdapter.getDomainFromDTO(courseOfferingDTO);

             courseOffering1.setCourse(courseOffering2.getCourse());
             courseOffering1.setFaculty(courseOffering2.getFaculty());
             courseOffering1.setRegistrationsOfStudents(courseOffering2.getRegistrationsOfStudents());
             courseOffering1.setCapacity(courseOffering2.getCapacity());
             courseOfferingRepository.save(courseOffering1);
        }

    }







}
