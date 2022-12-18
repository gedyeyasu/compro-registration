package com.miu.registration.Service;

import com.miu.registration.dto.AcademicBlockDTO;
import com.miu.registration.model.AcademicBlock;

import java.util.List;

public interface AcademicBlockServiceInterface {


    public List<AcademicBlock> getAllacademicBlock();
    public void viewAcademicBlock(AcademicBlockDTO academicBlockDTO);
}
