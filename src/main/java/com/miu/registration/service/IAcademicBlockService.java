package com.miu.registration.service;






import com.miu.registration.service.DTO.AcademicBlockDTO;

import java.util.Collection;

public interface IAcademicBlockService {

    Collection<AcademicBlockDTO> getAll();
    AcademicBlockDTO getAcademicBlock(long id);
    void create(AcademicBlockDTO academicBlockDTO);
    void delete(long id);
    void update(long id,AcademicBlockDTO academicBlockDTO);


}
