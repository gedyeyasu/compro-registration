package com.miu.registration.service.Adaptors;

import com.miu.registration.service.DTO.FacultyDTO;
import com.miu.registration.domain.Faculty;

public class FacultyAdaptor {

    public static  Faculty fromFacultyDTO(FacultyDTO facultyDTO){

        Faculty faculty=new Faculty();
        return faculty;
    }


    public static FacultyDTO fromFaculty(Faculty faculty){

        FacultyDTO facultyDTO=new FacultyDTO();
        return facultyDTO;
    }


}
