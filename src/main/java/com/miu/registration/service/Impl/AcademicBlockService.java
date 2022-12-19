package com.miu.registration.service.Impl;



import com.miu.registration.service.DTO.AcademicBlockDTO;
import com.miu.registration.domain.AcademicBlock;

import com.miu.registration.repositories.AcademicBlockRepo;
import com.miu.registration.service.IAcademicBlockService;
import com.miu.registration.service.Adapters.AcademicBlockAdaptor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AcademicBlockService implements IAcademicBlockService {

    private final AcademicBlockRepo academicBlockRepo;

    @Override
    public Collection<AcademicBlockDTO> getAll() {

        Collection<AcademicBlockDTO> academicBlockDTOS=academicBlockRepo.findAll().stream()
                .map(AcademicBlockAdaptor::fromAcademicBlock).collect(Collectors.toList());
        return academicBlockDTOS;


    }

    @Override
    public AcademicBlockDTO getAcademicBlock(long id) {

       var academicBlock=academicBlockRepo.findById(id);
        return academicBlock.map(AcademicBlockAdaptor::fromAcademicBlock).orElse(null);
    }

    @Override
    public void create(AcademicBlockDTO academicBlockDTO) {
        academicBlockRepo.save(AcademicBlockAdaptor.fromAcademicDTO(academicBlockDTO));

    }

    @Override
    public void delete(long id) {
        academicBlockRepo.deleteById(id);

    }

    @Override
 // error
    public void update(long id, AcademicBlockDTO academicBlockDTO) {

       var academicBlock1 = academicBlockRepo.findById(id);
       if (academicBlock1.isPresent() && academicBlockDTO!=null) {

           AcademicBlock academicBlock = academicBlock1.get();
           AcademicBlock academic = AcademicBlockAdaptor.fromAcademicDTO(academicBlockDTO);
           academicBlock.setCode(academic.getCode());
           academicBlock.setName(academic.getName());
           academicBlock.setStartDate(academic.getEndDate());
           academicBlock.setEndDate(academic.getEndDate());
           academicBlock.setCourseOfferings(academic.getCourseOfferings());
            academicBlockRepo.save(academicBlock);

       }


    }
}
