package com.miu.registration.service.Impl;



import com.miu.registration.domain.*;
import com.miu.registration.exception.NotFoundException;
import com.miu.registration.repositories.CourseOfferingRepository;
import com.miu.registration.repositories.CourseRepository;
import com.miu.registration.repositories.StudentRepository;
import com.miu.registration.service.Adapters.StudentAdapter;
import com.miu.registration.service.DTO.RegistrationRequestDTO;

import com.miu.registration.repositories.RegistrationRequestRepository;
import com.miu.registration.service.Adapters.RegistrationRequestAdapter;
import com.miu.registration.service.DTO.RegistrationRequestResponseDTO;
import com.miu.registration.service.IRegistrationRequestService;
import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.ast.Not;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.chrono.ChronoLocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class RegistrationRequestService implements IRegistrationRequestService {
    @Autowired
    private RegistrationRequestRepository registrationRequestRepository;
    @Autowired
    private RegistrationRequestAdapter registrationRequestAdaptor;
    @Autowired
    private StudentService studentService;

    @Autowired RegistrationEventService registrationEventService;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private CourseOfferingRepository courseOfferingRepository;
    @Autowired
    private StudentAdapter studentAdapter;

    @Override
    public Collection<RegistrationRequestDTO> getAllRegistrationRequests() {
        Collection<RegistrationRequestDTO>registrationRequestDTOS = registrationRequestRepository.findAll().stream()
                .map(registrationRequestAdaptor::getDTOFromDomain).collect(Collectors.toList());

        return registrationRequestDTOS;
    }

    @Override
    public List<RegistrationRequestDTO> getRegistrationRequestByStudentId(long studentId) {
        List<RegistrationRequest> registrationRequests = registrationRequestRepository.findRegistrationRequestByStudentId(studentId);
        return registrationRequests.stream()
                .map(registrationRequestAdaptor::getDTOFromDomain)
                .collect(Collectors.toList());
    }



    @Override
    public void createRegistrationRequest(RegistrationRequestResponseDTO registrationRequestResponseDTO) throws Exception {
        long studentId = registrationRequestResponseDTO.getStudentId();
        RegistrationEvent latestEvent = registrationEventService.latest(studentId);
        Map<String, Integer> existingRegistrationRequests = registrationRequestRepository.findRegistrationRequestByStudentId(studentId).stream()
                .collect(Collectors.toMap((registrationRequest -> registrationRequest.getCourseOffering().getCode()), RegistrationRequest::getPriority));
        if(latestEvent.getEventStatus() == EventStatus.OPEN) {
            Student student = studentRepository.findByStudentId(studentId);
            if(student==null) {
                throw new Exception("Student "  + studentId +" is not in the database");
            }
            List<RegistrationRequest> registrationRequests = new ArrayList<>();
            for(RegistrationRequestDTO registrationRequestDTO: registrationRequestResponseDTO.getRegistrationRequestDTOS()){
//                set student to each registration request
                registrationRequestDTO.setStudent(student);
                RegistrationRequest request = registrationRequestAdaptor.getDomainFromDTO(registrationRequestDTO);
                request.setStudent(student);
                CourseOffering courseOffering = courseOfferingRepository.findCourseOfferingByCode(registrationRequestDTO.getCourseOfferingDTO().getCode());
                if(courseOffering == null){
                    throw new Exception("CourseOffering Not found!");
                }
                request.setCourseOffering(courseOffering);

                if(existingRegistrationRequests.containsKey(courseOffering.getCode())){
                    System.out.println("same course");
                    if(request.getPriority() == existingRegistrationRequests.get(courseOffering.getCode())){
                        System.out.println("same priority");
                        throw new Exception("Duplicate Course Offering Request!");
                    }
                }
                registrationRequests.add(request);

            }
            registrationRequestRepository.saveAll(registrationRequests);
        }
        else throw new Exception("registration event is closed");
    }

    @Override
    //?????????
    public void updateRegistrationRequest(long id, RegistrationRequestDTO registrationRequestDTO) {
        var request = registrationRequestRepository.findById(id);
        if (request.isPresent() && registrationRequestDTO!=null){

            RegistrationRequest registrationRequest = request.get();
            RegistrationRequest request1 = registrationRequestAdaptor.getDomainFromDTO(registrationRequestDTO);

            registrationRequest.setStudent(request1.getStudent());
            registrationRequest.setCourseOffering(request1.getCourseOffering());
            registrationRequestRepository.save(registrationRequest);
        }

    }


    @Override
    public void deleteRegistrationRequest(long id) {
        registrationRequestRepository.deleteById(id);
    }
}
