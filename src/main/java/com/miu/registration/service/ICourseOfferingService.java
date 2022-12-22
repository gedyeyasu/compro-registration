package com.miu.registration.service;

import com.miu.registration.domain.CourseOffering;
import com.miu.registration.service.DTO.CourseOfferingDTO;

import java.util.List;

public interface ICourseOfferingService {
     CourseOffering addCourseOffering(CourseOfferingDTO courseOfferingDTO);

   List<CourseOfferingDTO> getAllCourseOffering();
    CourseOfferingDTO findById(Long id);
 CourseOffering add(CourseOfferingDTO courseOfferingDTO);

    void deleteById(Long id);

 void update(CourseOfferingDTO courseOfferingDTO ,Long id);

    }


