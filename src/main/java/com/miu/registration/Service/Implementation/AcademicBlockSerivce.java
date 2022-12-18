package com.miu.registration.Service.Implementation;

import com.miu.registration.Repository.AcademicBlockRepository;
import com.miu.registration.Service.AcademicBlockServiceInterface;
import com.miu.registration.dto.AcademicBlockDTO;
import com.miu.registration.model.AcademicBlock;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AcademicBlockSerivce implements AcademicBlockServiceInterface {

    @Autowired
    private AcademicBlockRepository academicBlockRepository;

    @Override
    public List<AcademicBlock> getAllacademicBlock() {
        return null;
    }

    @Override
    public void viewAcademicBlock(AcademicBlockDTO academicBlockDTO) {

        AcademicBlock academicBlock = new AcademicBlock();
        BeanUtils.copyProperties(academicBlockDTO,academicBlock);
        academicBlockRepository.save(academicBlock);

    }
}
