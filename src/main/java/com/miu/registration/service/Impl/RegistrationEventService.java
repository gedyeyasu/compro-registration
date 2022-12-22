package com.miu.registration.service.Impl;


import com.miu.registration.domain.*;
import com.miu.registration.repositories.RegistrationEventRepository;
import com.miu.registration.repositories.RegistrationRequestRepository;
import com.miu.registration.service.Adapters.RegistrationEventAdapter;
import com.miu.registration.service.DTO.RegistrationEventDTO;
import com.miu.registration.service.DTO.RegistrationEventResponseDTO;
import com.miu.registration.service.IRegistrationEventService;
import org.apache.kafka.connect.errors.NotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.chrono.ChronoLocalDate;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class RegistrationEventService implements IRegistrationEventService {

    @Autowired
    private RegistrationEventRepository registrationEventRepository;
    @Autowired
    private RegistrationEventAdapter registrationEventAdapter;

    @Autowired
    private RegistrationRequestRepository registrationRequestRepository;

    @Override
    public List<RegistrationEvent> getAllRegistrationEvent() {
        return registrationEventRepository.findAll();
    }



//    @Override
//    public void viewRegisterationEvent(RegistrationEventDTO registrationEventDTO) {
//
//        RegistrationEvent registrationEvent = new RegistrationEvent();
//        BeanUtils.copyProperties(registrationEventDTO, registrationEvent);
//        registrationEventRepository.save(registrationEvent);
//
//    }
    public RegistrationEvent latest(long studentID) {
        List<RegistrationEvent> events = getAllRegistrationEvent();
        List<RegistrationEvent> studentEvents = new ArrayList<>();

        for(RegistrationEvent registrationEvent: events){
            for(RegistrationGroup registrationGroup: registrationEvent.getRegistrationGroups()){
                for(Student student: registrationGroup.getStudents()){
                    if(student.getStudentId() == studentID){
                        studentEvents.add(registrationEvent);
                    }
                }
            }
        }
        studentEvents.sort((e1,e2) -> e2.getEndDate().compareTo(e1.getEndDate()));
        if(studentEvents.size() ==0 ){
            return null;
        }
        return studentEvents.get(0);
    }


    public RegistrationEventResponseDTO getLatestRegistrationEvent(long studentId) {
        RegistrationEvent latestRegistrationEvent = latest(studentId);
        RegistrationEventDTO latestRegistrationEventDTO = registrationEventAdapter.getDTOFromDomain(latestRegistrationEvent);
        return new RegistrationEventResponseDTO(latestRegistrationEvent.getEventStatus(), latestRegistrationEventDTO);
    }

    public void processRegistrationEvent(long id) throws Exception{
        Optional<RegistrationEvent> registrationEvent = registrationEventRepository.findById(id);
        if(registrationEvent.isPresent()){
            for(RegistrationGroup registrationGroup: registrationEvent.get().getRegistrationGroups()){
                List<Student> shuffledStudents = registrationGroup.getStudents();
                Collections.shuffle(shuffledStudents);
                for(Student student: shuffledStudents) {
//                    Map<CourseOffering,Integer> registrationRequestsMap = registrationRequestRepository.findRegistrationRequestByStudentId(student.getStudentId()).stream().collect(Collectors.toMap(RegistrationRequest::getCourseOffering,RegistrationRequest::getPriority));
                    Map<AcademicBlock, PriorityQueue<CourseOffering>> blockCourseOfferingMap = new HashMap<>();
                    for(AcademicBlock academicBlock: registrationGroup.getAcademicBlocks()){
//                        registrationRequestsMap = registrationRequestRepository.findRegistrationRequestByStudentIdAndCourseOfferingOrderByPriority(student.getStudentId()).stream().collect(Collectors.toMap(RegistrationRequest::getCourseOffering,RegistrationRequest::getPriority));
                        for(CourseOffering courseOffering: academicBlock.getCourseOfferings()){
                            PriorityQueue<RegistrationRequest> requestPriorityQueue = registrationRequestRepository.findRegistrationRequestByStudentIdAndCourseOfferingOrderByPriority(student.getStudentId(), courseOffering);
                        }
                        Map<Integer, CourseOffering>  courseChoiceMap = new HashMap<>();
                        Map<String, RegistrationRequest> registrationRequestMap = new HashMap<>();
//                        student will send registration request for all available courses in a block

                        academicBlock.getCourseOfferings();

                    }
                    List<RegistrationRequest> registrationRequests = registrationRequestRepository.findRegistrationRequestByStudentId(student.getStudentId());
                }
                for(AcademicBlock academicBlock: registrationGroup.getAcademicBlocks()){
                    for(CourseOffering courseOffering: academicBlock.getCourseOfferings()){

                    }
                }
                for(Student student: shuffledStudents){
                    List<RegistrationRequest> registrationRequests = registrationRequestRepository.findRegistrationRequestByStudentId(student.getStudentId());
                    for(RegistrationRequest registrationRequest: registrationRequests){
//                        validate registration request is for valid course offering
//                        boolean isValid = registrationGroup.getAcademicBlocks().stream().flatMap(academicBlock -> academicBlock.getCourseOfferings().stream()).anyMatch((courseOffering -> courseOffering.getCode().equals(registrationRequest.getCourseOffering().getCode())));

                        // check if request has availble seat
                        registrationRequest.getCourseOffering().getAvailableSeat();
                    }
                }
            }

        }else
        throw new NotFoundException("Registration Event with Id "+id+" not found!");
    }
}
