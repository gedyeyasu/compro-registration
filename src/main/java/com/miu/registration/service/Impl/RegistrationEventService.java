package com.miu.registration.service.Impl;


import com.miu.registration.domain.RegistrationGroup;
import com.miu.registration.domain.Student;
import com.miu.registration.repositories.RegistrationEventRepository;
import com.miu.registration.service.DTO.RegistrationEventDTO;
import com.miu.registration.domain.RegistrationEvent;
import com.miu.registration.service.IRegistrationEventService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.chrono.ChronoLocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class RegistrationEventService implements IRegistrationEventService {

    @Autowired
    private RegistrationEventRepository registrationEventRepository;

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
        studentEvents.sort((e1,e2) -> e1.getEndDate().compareTo(e2.getEndDate()));
        if(studentEvents.size() ==0 ){
            return null;
        }
        return studentEvents.get(0);
    }

    public boolean isRegistrationEventOpen(long studentId){
        LocalDate currentDate = LocalDate.now();
        RegistrationEvent currentEvent = latest(studentId);
        if(currentDate.isAfter(ChronoLocalDate.from(currentEvent.getStartDate().atStartOfDay()).minus(Period.ofDays(1))) &&
                currentDate.isBefore(ChronoLocalDate.from(currentEvent.getEndDate().atTime(LocalTime.parse("11:59pm")))))
            return true;
        else
            return false;
    }
}
