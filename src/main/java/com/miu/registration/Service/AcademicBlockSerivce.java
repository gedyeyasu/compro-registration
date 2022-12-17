package com.miu.registration.Service;

import com.miu.registration.Repository.AcademicBlockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AcademicBlockSerivce {

    @Autowired
    private AcademicBlockRepository academicBlockRepository;
}
