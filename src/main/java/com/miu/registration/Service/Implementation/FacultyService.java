package com.miu.registration.Service.Implementation;

import com.miu.registration.Repository.FacultyRepository;
import com.miu.registration.Service.FacultyServiceInterface;
import com.miu.registration.dto.FacultyDTO;
import com.miu.registration.model.Faculty;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacultyService implements FacultyServiceInterface {

    @Autowired
    private FacultyRepository facultyRepository;

    @Override
    public List<Faculty> getAllFaculties() {
        return null;
    }

    @Override
    public void addNewFaculty(FacultyDTO facultyDTO) {
        Faculty faculty = new Faculty();
        BeanUtils.copyProperties(facultyDTO,faculty);
        facultyRepository.save(faculty);

    }
}
