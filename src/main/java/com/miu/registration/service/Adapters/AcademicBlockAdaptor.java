package com.miu.registration.service.Adapters;

import com.miu.registration.service.DTO.AcademicBlockDTO;
import com.miu.registration.service.DTO.CourseOfferingDTO;
import com.miu.registration.domain.AcademicBlock;
import com.miu.registration.domain.CourseOffering;


import java.util.Collection;
import java.util.stream.Collectors;

public class AcademicBlockAdaptor {

    public static AcademicBlock fromAcademicDTO(AcademicBlockDTO academicBlockDTO){
        AcademicBlock academicBlock = new AcademicBlock();
        academicBlock.setId(academicBlockDTO.getId());
        academicBlock.setCode(academicBlockDTO.getCode());
        academicBlock.setName(academicBlockDTO.getName());
        academicBlock.setStartDate(academicBlockDTO.getStartDate());
        academicBlock.setEndDate(academicBlockDTO.getEndDate());


        //error
        Collection<CourseOffering> courseOfferings = academicBlockDTO.getCourseOfferings().stream().
               map(CourseOfferingAdaptor::fromCourseOfferingDTO).collect(Collectors.toList());
               academicBlock.setCourseOfferings(courseOfferings);

        return academicBlock;


    }
    public  static AcademicBlockDTO fromAcademicBlock(AcademicBlock academicBlock){
        AcademicBlockDTO academicBlockDTO = new AcademicBlockDTO();
        academicBlockDTO.setId(academicBlock.getId());
        academicBlockDTO.setCode(academicBlock.getCode());
        academicBlockDTO.setName(academicBlock.getName());
        academicBlockDTO.setStartDate(academicBlock.getStartDate());
        academicBlockDTO.setEndDate(academicBlock.getEndDate());
        Collection<CourseOfferingDTO>courseOfferingDTO =academicBlock.getCourseOfferings().stream()
                .map(CourseOfferingAdaptor::fromCourseOffering).collect(Collectors.toList());
       academicBlockDTO.setCourseOfferings(courseOfferingDTO);
        return academicBlockDTO;
    }

}
