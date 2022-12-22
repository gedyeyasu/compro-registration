package com.miu.registration.service.Impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.miu.registration.domain.Address;
import com.miu.registration.domain.EventStatus;
import com.miu.registration.domain.RegistrationEvent;
import com.miu.registration.domain.RegistrationGroup;
import com.miu.registration.domain.RegistrationGroupEnum;
import com.miu.registration.domain.Role;
import com.miu.registration.domain.Student;
import com.miu.registration.domain.User;
import com.miu.registration.repositories.RegistrationEventRepository;
import com.miu.registration.repositories.RegistrationRequestRepository;
import com.miu.registration.service.Adapters.RegistrationEventAdapter;
import com.miu.registration.service.DTO.RegistrationEventDTO;
import com.miu.registration.service.DTO.RegistrationEventResponseDTO;

import java.time.LocalDate;

import java.util.ArrayList;
import java.util.List;

import org.apache.kafka.connect.errors.NotFoundException;
import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {RegistrationEventService.class})
@ExtendWith(SpringExtension.class)
class RegistrationEventServiceTest {
    @MockBean
    private RegistrationEventAdapter registrationEventAdapter;

    @MockBean
    private RegistrationEventRepository registrationEventRepository;

    @Autowired
    private RegistrationEventService registrationEventService;

    @MockBean
    private RegistrationRequestRepository registrationRequestRepository;

    /**
     * Method under test: {@link RegistrationEventService#getAllRegistrationEvent()}
     */
    @Test
    void testGetAllRegistrationEvent() {
        ArrayList<RegistrationEvent> registrationEventList = new ArrayList<>();
        when(registrationEventRepository.findAll()).thenReturn(registrationEventList);
        List<RegistrationEvent> actualAllRegistrationEvent = registrationEventService.getAllRegistrationEvent();
        assertSame(registrationEventList, actualAllRegistrationEvent);
        assertTrue(actualAllRegistrationEvent.isEmpty());
        verify(registrationEventRepository).findAll();
    }

    /**
     * Method under test: {@link RegistrationEventService#getAllRegistrationEvent()}
     */
    @Test
    void testGetAllRegistrationEvent2() {
        when(registrationEventRepository.findAll()).thenThrow(new NotFoundException("foo"));
        assertThrows(NotFoundException.class, () -> registrationEventService.getAllRegistrationEvent());
        verify(registrationEventRepository).findAll();
    }

    /**
     * Method under test: {@link RegistrationEventService#getLatestRegistrationEvent(long)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetLatestRegistrationEvent() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.miu.registration.service.Impl.RegistrationEventService.getLatestRegistrationEvent(RegistrationEventService.java:74)
        //   See https://diff.blue/R013 to resolve this issue.

        when(registrationEventAdapter.getDTOFromDomain((RegistrationEvent) any())).thenReturn(new RegistrationEventDTO());
        when(registrationEventRepository.findAll()).thenReturn(new ArrayList<>());
        registrationEventService.getLatestRegistrationEvent(123L);
    }

    /**
     * Method under test: {@link RegistrationEventService#getLatestRegistrationEvent(long)}
     */
    @Test
    void testGetLatestRegistrationEvent2() {
        when(registrationEventAdapter.getDTOFromDomain((RegistrationEvent) any())).thenReturn(new RegistrationEventDTO());
        when(registrationEventRepository.findAll()).thenThrow(new NotFoundException("foo"));
        assertThrows(NotFoundException.class, () -> registrationEventService.getLatestRegistrationEvent(123L));
        verify(registrationEventRepository).findAll();
    }

    /**
     * Method under test: {@link RegistrationEventService#getLatestRegistrationEvent(long)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetLatestRegistrationEvent3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.miu.registration.service.Impl.RegistrationEventService.getLatestRegistrationEvent(RegistrationEventService.java:74)
        //   See https://diff.blue/R013 to resolve this issue.

        when(registrationEventAdapter.getDTOFromDomain((RegistrationEvent) any())).thenReturn(new RegistrationEventDTO());

        RegistrationEvent registrationEvent = new RegistrationEvent();
        registrationEvent.setEndDate(LocalDate.ofEpochDay(1L));
        registrationEvent.setId(123L);
        registrationEvent.setRegistrationGroups(new ArrayList<>());
        registrationEvent.setStartDate(LocalDate.ofEpochDay(1L));

        ArrayList<RegistrationEvent> registrationEventList = new ArrayList<>();
        registrationEventList.add(registrationEvent);
        when(registrationEventRepository.findAll()).thenReturn(registrationEventList);
        registrationEventService.getLatestRegistrationEvent(123L);
    }

    /**
     * Method under test: {@link RegistrationEventService#getLatestRegistrationEvent(long)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetLatestRegistrationEvent4() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.miu.registration.service.Impl.RegistrationEventService.getLatestRegistrationEvent(RegistrationEventService.java:74)
        //   See https://diff.blue/R013 to resolve this issue.

        when(registrationEventAdapter.getDTOFromDomain((RegistrationEvent) any())).thenReturn(new RegistrationEventDTO());

        RegistrationGroup registrationGroup = new RegistrationGroup();
        registrationGroup.setAcademicBlocks(new ArrayList<>());
        registrationGroup.setGroupEnum(RegistrationGroupEnum.FPP_TRACK);
        registrationGroup.setId(123L);
        registrationGroup.setStudents(new ArrayList<>());

        ArrayList<RegistrationGroup> registrationGroupList = new ArrayList<>();
        registrationGroupList.add(registrationGroup);

        RegistrationEvent registrationEvent = new RegistrationEvent();
        registrationEvent.setEndDate(LocalDate.ofEpochDay(1L));
        registrationEvent.setId(123L);
        registrationEvent.setRegistrationGroups(registrationGroupList);
        registrationEvent.setStartDate(LocalDate.ofEpochDay(1L));

        ArrayList<RegistrationEvent> registrationEventList = new ArrayList<>();
        registrationEventList.add(registrationEvent);
        when(registrationEventRepository.findAll()).thenReturn(registrationEventList);
        registrationEventService.getLatestRegistrationEvent(123L);
    }

    /**
     * Method under test: {@link RegistrationEventService#getLatestRegistrationEvent(long)}
     */
    @Test
    void testGetLatestRegistrationEvent5() {
        RegistrationEventDTO registrationEventDTO = new RegistrationEventDTO();
        when(registrationEventAdapter.getDTOFromDomain((RegistrationEvent) any())).thenReturn(registrationEventDTO);

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

        ArrayList<Student> studentList = new ArrayList<>();
        studentList.add(student);

        RegistrationGroup registrationGroup = new RegistrationGroup();
        registrationGroup.setAcademicBlocks(new ArrayList<>());
        registrationGroup.setGroupEnum(RegistrationGroupEnum.FPP_TRACK);
        registrationGroup.setId(123L);
        registrationGroup.setStudents(studentList);

        ArrayList<RegistrationGroup> registrationGroupList = new ArrayList<>();
        registrationGroupList.add(registrationGroup);

        RegistrationEvent registrationEvent = new RegistrationEvent();
        registrationEvent.setEndDate(LocalDate.ofEpochDay(1L));
        registrationEvent.setId(123L);
        registrationEvent.setRegistrationGroups(registrationGroupList);
        registrationEvent.setStartDate(LocalDate.ofEpochDay(1L));

        ArrayList<RegistrationEvent> registrationEventList = new ArrayList<>();
        registrationEventList.add(registrationEvent);
        when(registrationEventRepository.findAll()).thenReturn(registrationEventList);
        RegistrationEventResponseDTO actualLatestRegistrationEvent = registrationEventService
                .getLatestRegistrationEvent(123L);
        assertEquals(EventStatus.CLOSED, actualLatestRegistrationEvent.getEventStatus());
        assertSame(registrationEventDTO, actualLatestRegistrationEvent.getLatestRegistrationEvent());
        verify(registrationEventAdapter).getDTOFromDomain((RegistrationEvent) any());
        verify(registrationEventRepository).findAll();
    }

    /**
     * Method under test: {@link RegistrationEventService#getLatestRegistrationEvent(long)}
     */
    @Test
    void testGetLatestRegistrationEvent6() {
        RegistrationEventDTO registrationEventDTO = new RegistrationEventDTO();
        when(registrationEventAdapter.getDTOFromDomain((RegistrationEvent) any())).thenReturn(registrationEventDTO);

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

        User user1 = new User();
        user1.setPassword("iloveyou");
        user1.setRole(Role.STUDENT);
        user1.setUsername("janedoe");

        Student student1 = new Student();
        student1.setEmail("jane.doe@example.org");
        student1.setFirstName("Jane");
        student1.setHomeAddress(address2);
        student1.setId(123L);
        student1.setLastName("Doe");
        student1.setMailAddress(address3);
        student1.setStudentId(123L);
        student1.setUser(user1);

        ArrayList<Student> studentList = new ArrayList<>();
        studentList.add(student1);
        studentList.add(student);

        RegistrationGroup registrationGroup = new RegistrationGroup();
        registrationGroup.setAcademicBlocks(new ArrayList<>());
        registrationGroup.setGroupEnum(RegistrationGroupEnum.FPP_TRACK);
        registrationGroup.setId(123L);
        registrationGroup.setStudents(studentList);

        ArrayList<RegistrationGroup> registrationGroupList = new ArrayList<>();
        registrationGroupList.add(registrationGroup);

        RegistrationEvent registrationEvent = new RegistrationEvent();
        registrationEvent.setEndDate(LocalDate.ofEpochDay(1L));
        registrationEvent.setId(123L);
        registrationEvent.setRegistrationGroups(registrationGroupList);
        registrationEvent.setStartDate(LocalDate.ofEpochDay(1L));

        ArrayList<RegistrationEvent> registrationEventList = new ArrayList<>();
        registrationEventList.add(registrationEvent);
        when(registrationEventRepository.findAll()).thenReturn(registrationEventList);
        RegistrationEventResponseDTO actualLatestRegistrationEvent = registrationEventService
                .getLatestRegistrationEvent(123L);
        assertEquals(EventStatus.CLOSED, actualLatestRegistrationEvent.getEventStatus());
        assertSame(registrationEventDTO, actualLatestRegistrationEvent.getLatestRegistrationEvent());
        verify(registrationEventAdapter).getDTOFromDomain((RegistrationEvent) any());
        verify(registrationEventRepository).findAll();
    }

    /**
     * Method under test: {@link RegistrationEventService#getLatestRegistrationEvent(long)}
     */
    @Test
    void testGetLatestRegistrationEvent7() {
        RegistrationEventDTO registrationEventDTO = new RegistrationEventDTO();
        when(registrationEventAdapter.getDTOFromDomain((RegistrationEvent) any())).thenReturn(registrationEventDTO);

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

        User user1 = new User();
        user1.setPassword("iloveyou");
        user1.setRole(Role.STUDENT);
        user1.setUsername("janedoe");

        Student student1 = new Student();
        student1.setEmail("jane.doe@example.org");
        student1.setFirstName("Jane");
        student1.setHomeAddress(address2);
        student1.setId(123L);
        student1.setLastName("Doe");
        student1.setMailAddress(address3);
        student1.setStudentId(123L);
        student1.setUser(user1);

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

        User user2 = new User();
        user2.setPassword("iloveyou");
        user2.setRole(Role.STUDENT);
        user2.setUsername("janedoe");

        Student student2 = new Student();
        student2.setEmail("jane.doe@example.org");
        student2.setFirstName("Jane");
        student2.setHomeAddress(address4);
        student2.setId(123L);
        student2.setLastName("Doe");
        student2.setMailAddress(address5);
        student2.setStudentId(123L);
        student2.setUser(user2);

        ArrayList<Student> studentList = new ArrayList<>();
        studentList.add(student2);
        studentList.add(student1);
        studentList.add(student);

        RegistrationGroup registrationGroup = new RegistrationGroup();
        registrationGroup.setAcademicBlocks(new ArrayList<>());
        registrationGroup.setGroupEnum(RegistrationGroupEnum.FPP_TRACK);
        registrationGroup.setId(123L);
        registrationGroup.setStudents(studentList);

        ArrayList<RegistrationGroup> registrationGroupList = new ArrayList<>();
        registrationGroupList.add(registrationGroup);

        RegistrationEvent registrationEvent = new RegistrationEvent();
        registrationEvent.setEndDate(LocalDate.ofEpochDay(1L));
        registrationEvent.setId(123L);
        registrationEvent.setRegistrationGroups(registrationGroupList);
        registrationEvent.setStartDate(LocalDate.ofEpochDay(1L));

        ArrayList<RegistrationEvent> registrationEventList = new ArrayList<>();
        registrationEventList.add(registrationEvent);
        when(registrationEventRepository.findAll()).thenReturn(registrationEventList);
        RegistrationEventResponseDTO actualLatestRegistrationEvent = registrationEventService
                .getLatestRegistrationEvent(123L);
        assertEquals(EventStatus.CLOSED, actualLatestRegistrationEvent.getEventStatus());
        assertSame(registrationEventDTO, actualLatestRegistrationEvent.getLatestRegistrationEvent());
        verify(registrationEventAdapter).getDTOFromDomain((RegistrationEvent) any());
        verify(registrationEventRepository).findAll();
    }

    /**
     * Method under test: {@link RegistrationEventService#getLatestRegistrationEvent(long)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetLatestRegistrationEvent8() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.miu.registration.service.Impl.RegistrationEventService.getLatestRegistrationEvent(RegistrationEventService.java:74)
        //   See https://diff.blue/R013 to resolve this issue.

        when(registrationEventAdapter.getDTOFromDomain((RegistrationEvent) any())).thenReturn(new RegistrationEventDTO());

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
        Student student = mock(Student.class);
        when(student.getStudentId()).thenReturn(1L);
        doNothing().when(student).setEmail((String) any());
        doNothing().when(student).setFirstName((String) any());
        doNothing().when(student).setId((Long) any());
        doNothing().when(student).setLastName((String) any());
        doNothing().when(student).setUser((User) any());
        doNothing().when(student).setHomeAddress((Address) any());
        doNothing().when(student).setMailAddress((Address) any());
        doNothing().when(student).setStudentId((Long) any());
        student.setEmail("jane.doe@example.org");
        student.setFirstName("Jane");
        student.setHomeAddress(address);
        student.setId(123L);
        student.setLastName("Doe");
        student.setMailAddress(address1);
        student.setStudentId(123L);
        student.setUser(user);

        ArrayList<Student> studentList = new ArrayList<>();
        studentList.add(student);

        RegistrationGroup registrationGroup = new RegistrationGroup();
        registrationGroup.setAcademicBlocks(new ArrayList<>());
        registrationGroup.setGroupEnum(RegistrationGroupEnum.FPP_TRACK);
        registrationGroup.setId(123L);
        registrationGroup.setStudents(studentList);

        ArrayList<RegistrationGroup> registrationGroupList = new ArrayList<>();
        registrationGroupList.add(registrationGroup);

        RegistrationEvent registrationEvent = new RegistrationEvent();
        registrationEvent.setEndDate(LocalDate.ofEpochDay(1L));
        registrationEvent.setId(123L);
        registrationEvent.setRegistrationGroups(registrationGroupList);
        registrationEvent.setStartDate(LocalDate.ofEpochDay(1L));

        ArrayList<RegistrationEvent> registrationEventList = new ArrayList<>();
        registrationEventList.add(registrationEvent);
        when(registrationEventRepository.findAll()).thenReturn(registrationEventList);
        registrationEventService.getLatestRegistrationEvent(123L);
    }
}

