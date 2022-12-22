package com.miu.registration.service.Impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.miu.registration.domain.Address;
import com.miu.registration.domain.Role;
import com.miu.registration.domain.Student;
import com.miu.registration.domain.User;
import com.miu.registration.repositories.AddressRepository;
import com.miu.registration.repositories.StudentRepository;
import com.miu.registration.service.Adapters.AddressAdapter;
import com.miu.registration.service.Adapters.StudentAdapter;
import com.miu.registration.service.DTO.AddressDTO;
import com.miu.registration.service.DTO.StudentDTO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {StudentService.class})
@ExtendWith(SpringExtension.class)
class StudentServiceTest {
    @MockBean
    private AddressAdapter addressAdapter;

    @MockBean
    private AddressRepository addressRepository;

    @MockBean
    private StudentAdapter studentAdapter;

    @MockBean
    private StudentRepository studentRepository;

    @Autowired
    private StudentService studentService;

    /**
     * Method under test: {@link StudentService#createStudent(StudentDTO)}
     */
    @Test
    void testCreateStudent() {
        Address address = new Address();
        address.setCity("Oxford");
        address.setCountry("GB");
        address.setId(123L);
        address.setPostalCode(1L);
        address.setState("MD");
        address.setStreet("Street");
        when(addressAdapter.getDomainFromDTO((AddressDTO) any())).thenReturn(address);

        Address address1 = new Address();
        address1.setCity("Oxford");
        address1.setCountry("GB");
        address1.setId(123L);
        address1.setPostalCode(1L);
        address1.setState("MD");
        address1.setStreet("Street");
        when(addressRepository.save((Address) any())).thenReturn(address1);

        Address address2 = new Address();
        address2.setCity("Oxford");
        address2.setCountry("GB");
        address2.setId(123L);
        address2.setPostalCode(1L);
        address2.setState("MD");
        address2.setStreet("Street");

        Address address3 = new Address();
        address3.setCity("Oxford");
        address3.setCountry("GB");
        address3.setId(123L);
        address3.setPostalCode(1L);
        address3.setState("MD");
        address3.setStreet("Street");

        User user = new User();
        user.setPassword("iloveyou");
        user.setRole(Role.STUDENT);
        user.setUsername("janedoe");

        Student student = new Student();
        student.setEmail("jane.doe@example.org");
        student.setFirstName("Jane");
        student.setHomeAddress(address2);
        student.setId(123L);
        student.setLastName("Doe");
        student.setMailAddress(address3);
        student.setStudentId(123L);
        student.setUser(user);
        when(studentAdapter.getDomainFromDTO((StudentDTO) any())).thenReturn(student);

        Address address4 = new Address();
        address4.setCity("Oxford");
        address4.setCountry("GB");
        address4.setId(123L);
        address4.setPostalCode(1L);
        address4.setState("MD");
        address4.setStreet("Street");

        Address address5 = new Address();
        address5.setCity("Oxford");
        address5.setCountry("GB");
        address5.setId(123L);
        address5.setPostalCode(1L);
        address5.setState("MD");
        address5.setStreet("Street");

        User user1 = new User();
        user1.setPassword("iloveyou");
        user1.setRole(Role.STUDENT);
        user1.setUsername("janedoe");

        Student student1 = new Student();
        student1.setEmail("jane.doe@example.org");
        student1.setFirstName("Jane");
        student1.setHomeAddress(address4);
        student1.setId(123L);
        student1.setLastName("Doe");
        student1.setMailAddress(address5);
        student1.setStudentId(123L);
        student1.setUser(user1);
        when(studentRepository.save((Student) any())).thenReturn(student1);
        StudentDTO studentDTO = new StudentDTO();
        assertSame(studentDTO, studentService.createStudent(studentDTO));
        verify(addressAdapter, atLeast(1)).getDomainFromDTO((AddressDTO) any());
        verify(addressRepository, atLeast(1)).save((Address) any());
        verify(studentAdapter).getDomainFromDTO((StudentDTO) any());
        verify(studentRepository).save((Student) any());
    }

    /**
     * Method under test: {@link StudentService#getStudent(Long)}
     */
    @Test
    void testGetStudent() {
        StudentDTO studentDTO = new StudentDTO();
        when(studentAdapter.getDTOFromDomain((Student) any())).thenReturn(studentDTO);

        Address address = new Address();
        address.setCity("Oxford");
        address.setCountry("GB");
        address.setId(123L);
        address.setPostalCode(1L);
        address.setState("MD");
        address.setStreet("Street");

        Address address1 = new Address();
        address1.setCity("Oxford");
        address1.setCountry("GB");
        address1.setId(123L);
        address1.setPostalCode(1L);
        address1.setState("MD");
        address1.setStreet("Street");

        User user = new User();
        user.setPassword("iloveyou");
        user.setRole(Role.STUDENT);
        user.setUsername("janedoe");

        Student student = new Student();
        student.setEmail("jane.doe@example.org");
        student.setFirstName("Jane");
        student.setHomeAddress(address);
        student.setId(123L);
        student.setLastName("Doe");
        student.setMailAddress(address1);
        student.setStudentId(123L);
        student.setUser(user);
        when(studentRepository.findByStudentId((Long) any())).thenReturn(student);
        assertSame(studentDTO, studentService.getStudent(123L));
        verify(studentAdapter).getDTOFromDomain((Student) any());
        verify(studentRepository, atLeast(1)).findByStudentId((Long) any());
    }

    /**
     * Method under test: {@link StudentService#getAllStudents()}
     */
    @Test
    void testGetAllStudents() {
        ArrayList<StudentDTO> studentDTOList = new ArrayList<>();
        when(studentAdapter.getDTOsFromDomains((List<Student>) any())).thenReturn(studentDTOList);
        when(studentRepository.findAll()).thenReturn(new ArrayList<>());
        Collection<StudentDTO> actualAllStudents = studentService.getAllStudents();
        assertSame(studentDTOList, actualAllStudents);
        assertTrue(actualAllStudents.isEmpty());
        verify(studentAdapter).getDTOsFromDomains((List<Student>) any());
        verify(studentRepository).findAll();
    }

    /**
     * Method under test: {@link StudentService#deleteStudent(Long)}
     */
    @Test
    void testDeleteStudent() {
        when(studentRepository.deleteByStudentId((Long) any())).thenReturn(123L);
        assertEquals(123L, studentService.deleteStudent(123L).longValue());
        verify(studentRepository).deleteByStudentId((Long) any());
    }

    /**
     * Method under test: {@link StudentService#updateStudent(Long, StudentDTO)}
     */
    @Test
    void testUpdateStudent() {
        Address address = new Address();
        address.setCity("Oxford");
        address.setCountry("GB");
        address.setId(123L);
        address.setPostalCode(1L);
        address.setState("MD");
        address.setStreet("Street");
        when(addressAdapter.getDomainFromDTO((AddressDTO) any())).thenReturn(address);

        Address address1 = new Address();
        address1.setCity("Oxford");
        address1.setCountry("GB");
        address1.setId(123L);
        address1.setPostalCode(1L);
        address1.setState("MD");
        address1.setStreet("Street");
        when(addressRepository.save((Address) any())).thenReturn(address1);

        Address address2 = new Address();
        address2.setCity("Oxford");
        address2.setCountry("GB");
        address2.setId(123L);
        address2.setPostalCode(1L);
        address2.setState("MD");
        address2.setStreet("Street");

        Address address3 = new Address();
        address3.setCity("Oxford");
        address3.setCountry("GB");
        address3.setId(123L);
        address3.setPostalCode(1L);
        address3.setState("MD");
        address3.setStreet("Street");

        User user = new User();
        user.setPassword("iloveyou");
        user.setRole(Role.STUDENT);
        user.setUsername("janedoe");

        Student student = new Student();
        student.setEmail("jane.doe@example.org");
        student.setFirstName("Jane");
        student.setHomeAddress(address2);
        student.setId(123L);
        student.setLastName("Doe");
        student.setMailAddress(address3);
        student.setStudentId(123L);
        student.setUser(user);
        when(studentAdapter.getDomainFromDTO((StudentDTO) any())).thenReturn(student);
        when(studentAdapter.getDTOFromDomain((Student) any())).thenReturn(new StudentDTO());

        Address address4 = new Address();
        address4.setCity("Oxford");
        address4.setCountry("GB");
        address4.setId(123L);
        address4.setPostalCode(1L);
        address4.setState("MD");
        address4.setStreet("Street");

        Address address5 = new Address();
        address5.setCity("Oxford");
        address5.setCountry("GB");
        address5.setId(123L);
        address5.setPostalCode(1L);
        address5.setState("MD");
        address5.setStreet("Street");

        User user1 = new User();
        user1.setPassword("iloveyou");
        user1.setRole(Role.STUDENT);
        user1.setUsername("janedoe");

        Student student1 = new Student();
        student1.setEmail("jane.doe@example.org");
        student1.setFirstName("Jane");
        student1.setHomeAddress(address4);
        student1.setId(123L);
        student1.setLastName("Doe");
        student1.setMailAddress(address5);
        student1.setStudentId(123L);
        student1.setUser(user1);

        Address address6 = new Address();
        address6.setCity("Oxford");
        address6.setCountry("GB");
        address6.setId(123L);
        address6.setPostalCode(1L);
        address6.setState("MD");
        address6.setStreet("Street");

        Address address7 = new Address();
        address7.setCity("Oxford");
        address7.setCountry("GB");
        address7.setId(123L);
        address7.setPostalCode(1L);
        address7.setState("MD");
        address7.setStreet("Street");

        User user2 = new User();
        user2.setPassword("iloveyou");
        user2.setRole(Role.STUDENT);
        user2.setUsername("janedoe");

        Student student2 = new Student();
        student2.setEmail("jane.doe@example.org");
        student2.setFirstName("Jane");
        student2.setHomeAddress(address6);
        student2.setId(123L);
        student2.setLastName("Doe");
        student2.setMailAddress(address7);
        student2.setStudentId(123L);
        student2.setUser(user2);
        when(studentRepository.deleteByStudentId((Long) any())).thenReturn(123L);
        when(studentRepository.save((Student) any())).thenReturn(student2);
        when(studentRepository.findByStudentId((Long) any())).thenReturn(student1);
        StudentDTO studentDTO = new StudentDTO();
        assertSame(studentDTO, studentService.updateStudent(123L, studentDTO));
        verify(addressAdapter, atLeast(1)).getDomainFromDTO((AddressDTO) any());
        verify(addressRepository, atLeast(1)).save((Address) any());
        verify(studentAdapter).getDomainFromDTO((StudentDTO) any());
        verify(studentAdapter).getDTOFromDomain((Student) any());
        verify(studentRepository, atLeast(1)).findByStudentId((Long) any());
        verify(studentRepository).deleteByStudentId((Long) any());
        verify(studentRepository).save((Student) any());
    }
}

