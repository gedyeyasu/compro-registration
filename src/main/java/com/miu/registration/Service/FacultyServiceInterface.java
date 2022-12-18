package com.miu.registration.Service;

import com.miu.registration.dto.FacultyDTO;
import com.miu.registration.model.Faculty;

import java.util.List;

public interface FacultyServiceInterface {

    public List<Faculty> getAllFaculties();
    public void addNewFaculty(FacultyDTO facultyDTO);

}
