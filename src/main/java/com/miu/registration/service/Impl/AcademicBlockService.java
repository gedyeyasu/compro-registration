package com.miu.registration.service.Impl;



import com.miu.registration.service.DTO.AcademicBlockDTO;
import com.miu.registration.domain.AcademicBlock;

import com.miu.registration.repositories.AcademicBlockRepository;
import com.miu.registration.service.IAcademicBlockService;
import com.miu.registration.service.Adapters.AcademicBlockAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AcademicBlockService implements IAcademicBlockService {
    @Autowired
    private AcademicBlockRepository academicBlockRepository;

    @Autowired
    private AcademicBlockAdapter academicBlockAdapter;

    @Override
    public Collection<AcademicBlockDTO> getAll() {

        Collection<AcademicBlockDTO> academicBlockDTOS= academicBlockRepository.findAll().stream()
                .map(academicBlockAdapter::getDTOFromDomain).collect(Collectors.toList());
        return academicBlockDTOS;


    }

    @Override
    public AcademicBlockDTO getAcademicBlock(long id) {

       var academicBlock= academicBlockRepository.findById(id);
        return academicBlock.map(academicBlockAdapter::getDTOFromDomain).orElse(null);
    }

    @Override
    public void create(AcademicBlockDTO academicBlockDTO) {
        academicBlockRepository.save(academicBlockAdapter.getDomainFromDTO(academicBlockDTO));

    }

    @Override
    public void delete(long id) {
        academicBlockRepository.deleteById(id);

    }

    @Override
 // error
    public void update(long id, AcademicBlockDTO academicBlockDTO) {

       var academicBlock1 = academicBlockRepository.findById(id);
       if (academicBlock1.isPresent() && academicBlockDTO!=null) {

           AcademicBlock academicBlock = academicBlock1.get();
           AcademicBlock academic = academicBlockAdapter.getDomainFromDTO(academicBlockDTO);
           academicBlock.setCode(academic.getCode());
           academicBlock.setName(academic.getName());
           academicBlock.setStartDate(academic.getEndDate());
           academicBlock.setEndDate(academic.getEndDate());
           academicBlock.setCourseOfferings(academic.getCourseOfferings());
            academicBlockRepository.save(academicBlock);

       }


    }
}
