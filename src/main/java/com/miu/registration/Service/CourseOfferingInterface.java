package com.miu.registration.Service;


import com.miu.registration.Service.Implementation.CourseOfferingService;
import com.miu.registration.dto.CourseOfferingDTO;

import java.util.List;

public interface CourseOfferingInterface {

    public List<CourseOfferingService> getAllCourseOffering();
    public void addNewCourseOffering(CourseOfferingDTO courseOfferingDTO);

}
