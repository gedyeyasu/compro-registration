package com.miu.registration.Service.Implementation;

import com.miu.registration.Repository.CourseOfferingRepository;
import com.miu.registration.Repository.CourseRepository;
import com.miu.registration.Service.CourseOfferingInterface;
import com.miu.registration.Service.CourseServiceInterface;
import com.miu.registration.dto.CourseDTO;
import com.miu.registration.dto.CourseOfferingDTO;
import com.miu.registration.model.Course;
import com.miu.registration.model.CourseOffering;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseOfferingService implements CourseOfferingInterface {
    @Autowired
    private CourseOfferingRepository courseOfferingRepository;


    @Override
    public List<CourseOfferingService> getAllCourseOffering() {
        return null;
    }

    @Override
    public void addNewCourseOffering(CourseOfferingDTO courseOfferingDTO) {

        CourseOffering courseOffering = new CourseOffering();
        BeanUtils.copyProperties(courseOfferingDTO,courseOffering);
        courseOfferingRepository.save(courseOffering);

    }
}
