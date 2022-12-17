package com.miu.registration.Service.Implementation;

import com.miu.registration.Repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacultyService {

    @Autowired
    private FacultyRepository facultyRepository;
}
