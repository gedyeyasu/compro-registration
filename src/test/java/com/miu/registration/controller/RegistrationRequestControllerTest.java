package com.miu.registration.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.miu.registration.domain.Address;
import com.miu.registration.domain.Role;
import com.miu.registration.domain.Student;
import com.miu.registration.domain.User;
import com.miu.registration.repositories.RegistrationRequestRepository;
import com.miu.registration.service.DTO.CourseOfferingDTO;
import com.miu.registration.service.DTO.RegistrationRequestDTO;
import com.miu.registration.service.DTO.RegistrationRequestResponseDTO;
import com.miu.registration.service.IRegistrationRequestService;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {RegistrationRequestController.class})
@ExtendWith(SpringExtension.class)
class RegistrationRequestControllerTest {
    @MockBean
    private IRegistrationRequestService iRegistrationRequestService;

    @Autowired
    private RegistrationRequestController registrationRequestController;

    @MockBean
    private RegistrationRequestRepository registrationRequestRepository;

    /**
     * Method under test: {@link RegistrationRequestController#displayRegistrationRequest()}
     */
    @Test
    void testDisplayRegistrationRequest() throws Exception {
        when(iRegistrationRequestService.getAllRegistrationRequests()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/registration-requests");
        MockMvcBuilders.standaloneSetup(registrationRequestController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link RegistrationRequestController#displayRegistrationRequest()}
     */
    @Test
    void testDisplayRegistrationRequest2() throws Exception {
        when(iRegistrationRequestService.getAllRegistrationRequests()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/registration-requests");
        getResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(registrationRequestController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link RegistrationRequestController#displayRequestByStudentId(long)}
     */
    @Test
    void testDisplayRequestByStudentId() throws Exception {
        when(iRegistrationRequestService.getRegistrationRequestByStudentId(anyLong())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/registration-requests/{studentId}",
                123L);
        MockMvcBuilders.standaloneSetup(registrationRequestController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link RegistrationRequestController#displayRequestByStudentId(long)}
     */
    @Test
    void testDisplayRequestByStudentId2() throws Exception {
        when(iRegistrationRequestService.getAllRegistrationRequests()).thenReturn(new ArrayList<>());
        when(iRegistrationRequestService.getRegistrationRequestByStudentId(anyLong())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/registration-requests/{studentId}",
                "", "Uri Variables");
        MockMvcBuilders.standaloneSetup(registrationRequestController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link RegistrationRequestController#saveRequest(RegistrationRequestResponseDTO)}
     */
    @Test
    void testSaveRequest() throws Exception {
        when(iRegistrationRequestService.getAllRegistrationRequests()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.get("/registration-requests")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(new RegistrationRequestResponseDTO(123L, new ArrayList<>())));
        MockMvcBuilders.standaloneSetup(registrationRequestController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link RegistrationRequestController#updateRequests(long, RegistrationRequestDTO)}
     */
    @Test
    void testUpdateRequests() throws Exception {
        doNothing().when(iRegistrationRequestService)
                .updateRegistrationRequest(anyLong(), (RegistrationRequestDTO) any());

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

        RegistrationRequestDTO registrationRequestDTO = new RegistrationRequestDTO();
        registrationRequestDTO.setCourseOfferingDTO(new CourseOfferingDTO());
        registrationRequestDTO.setId(123L);
        registrationRequestDTO.setPriority(1);
        registrationRequestDTO.setStudent(student);
        String content = (new ObjectMapper()).writeValueAsString(registrationRequestDTO);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/registration-requests/{id}", 123L)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(registrationRequestController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}

