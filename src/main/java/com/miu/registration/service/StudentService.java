package com.miu.registration.service;

import com.miu.registration.domain.Address;
import com.miu.registration.domain.Student;
import com.miu.registration.repositories.AddressRepository;
import com.miu.registration.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;

@Service
@Transactional
public class StudentService implements IStudentService{
    @Autowired
    StudentAdapter studentAdapter;

    @Autowired
    AddressAdapter addressAdapter;
    @Autowired
    StudentRepository studentRepository;

    @Autowired
    AddressRepository addressRepository;
    @Override
    public StudentDTO createStudent(StudentDTO studentDTO) {
        Student student = studentAdapter.getDomainFromDTO(studentDTO);
        Address homeAddress = addressAdapter.getDomainFromDTO(studentDTO.getHomeAddress());
        Address mailAddress = addressAdapter.getDomainFromDTO(studentDTO.getMailAddress());
        student.setHomeAddress(homeAddress);
        student.setMailAddress(mailAddress);
        addressRepository.save(homeAddress);
        addressRepository.save(mailAddress);
        studentRepository.save(student);
        return studentDTO;
    }

    // Get a single student by student id
    @Override
    public StudentDTO getStudent(Long studentId) {
        Student student = studentRepository.findByStudentId(studentId);
        if(student==null){
            return null;
        }
        return studentAdapter.getDTOFromDomain((studentRepository.findByStudentId(studentId)));
    }

    // Get all students
    @Override
    public Collection<StudentDTO> getAllStudents() {
        return studentAdapter.getDTOsFromDomains(studentRepository.findAll());
    }
}