package com.miu.registration.service.Adapters;

import com.miu.registration.service.DTO.FacultyDTO;
import com.miu.registration.domain.Faculty;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class FacultyAdapter implements IAdapter<Faculty, FacultyDTO>{


    @Override
    public Faculty getDomainFromDTO(FacultyDTO facultyDTO) {
        Faculty faculty = new Faculty();

        faculty.setTitle(facultyDTO.getTitle());
        faculty.setFacultyId(facultyDTO.getFacultyId());

        return faculty;
    }

    @Override
    public FacultyDTO getDTOFromDomain(Faculty faculty) {
        FacultyDTO facultyDTO = new FacultyDTO();

        facultyDTO.setTitle(faculty.getTitle());
        facultyDTO.setFacultyId(faculty.getFacultyId());

        return facultyDTO;
    }

    @Override
    public List<Faculty> getDomainsFromDTOs(List<FacultyDTO> facultyDTOS) {
        return null;
    }

    @Override
    public List<FacultyDTO> getDTOsFromDomains(List<Faculty> faculties) {
        return null;
    }
}
