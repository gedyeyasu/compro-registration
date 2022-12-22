package com.miu.registration.service.Adapters;

import com.miu.registration.service.DTO.AcademicBlockDTO;
import com.miu.registration.service.DTO.CourseOfferingDTO;
import com.miu.registration.domain.AcademicBlock;
import com.miu.registration.domain.CourseOffering;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
@Component
public class AcademicBlockAdapter implements IAdapter<AcademicBlock, AcademicBlockDTO> {
    @Autowired
    CourseOfferingAdapter courseOfferingAdapter;
    @Override
    public AcademicBlock getDomainFromDTO(AcademicBlockDTO academicBlockDTO) {
        AcademicBlock academicBlock = new AcademicBlock();
        academicBlock.setId(academicBlockDTO.getId());
        academicBlock.setCode(academicBlockDTO.getCode());
        academicBlock.setName(academicBlockDTO.getName());
        academicBlock.setStartDate(academicBlockDTO.getStartDate());
        academicBlock.setEndDate(academicBlockDTO.getEndDate());
        //error
        Collection<CourseOffering> courseOfferings = academicBlockDTO.getCourseOfferings().stream().
                map(courseOfferingAdapter::getDomainFromDTO).collect(Collectors.toList());
        academicBlock.setCourseOfferings(courseOfferings);

        return academicBlock;
    }

    @Override
    public AcademicBlockDTO getDTOFromDomain(AcademicBlock academicBlock) {
        AcademicBlockDTO academicBlockDTO = new AcademicBlockDTO();
        academicBlockDTO.setId(academicBlock.getId());
        academicBlockDTO.setCode(academicBlock.getCode());
        academicBlockDTO.setName(academicBlock.getName());
        academicBlockDTO.setStartDate(academicBlock.getStartDate());
        academicBlockDTO.setEndDate(academicBlock.getEndDate());
        Collection<CourseOfferingDTO>courseOfferingDTO =academicBlock.getCourseOfferings().stream()
                .map(courseOfferingAdapter::getDTOFromDomain).collect(Collectors.toList());
        academicBlockDTO.addCourseOfferings(courseOfferingDTO);
        return academicBlockDTO;
    }

    @Override
    public List<AcademicBlock> getDomainsFromDTOs(List<AcademicBlockDTO> academicBlockDTOS) {
        return academicBlockDTOS.stream()
                .map(academicBlockDTO -> getDomainFromDTO(academicBlockDTO))
                .collect(Collectors.toList());
    }

    @Override
    public List<AcademicBlockDTO> getDTOsFromDomains(List<AcademicBlock> academicBlocks) {
        return academicBlocks.stream()
                .map(academicBlock -> getDTOFromDomain(academicBlock))
                .collect(Collectors.toList());
    }
}
