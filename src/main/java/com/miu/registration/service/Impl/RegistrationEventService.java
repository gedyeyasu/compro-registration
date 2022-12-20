package com.miu.registration.service.Impl;


import com.miu.registration.domain.RegistrationGroup;
import com.miu.registration.domain.Student;
import com.miu.registration.repositories.RegistrationEventRepository;
import com.miu.registration.service.DTO.RegistrationEventDTO;
import com.miu.registration.domain.RegistrationEvent;
import com.miu.registration.service.IRegistrationEventService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RegistrationEventService implements IRegistrationEventService {

    @Autowired
    private RegistrationEventRepository registrationEventRepository;

    @Override
    public List<RegistrationEvent> getAllRegistrationEvent() {
        return registrationEventRepository.findAll();
    }

    @Override
    public void viewRegisterationEvent(RegistrationEventDTO registrationEventDTO) {

        RegistrationEvent registrationEvent = new RegistrationEvent();
        BeanUtils.copyProperties(registrationEventDTO, registrationEvent);
        registrationEventRepository.save(registrationEvent);

    }
    public RegistrationEvent latest(long studentID) {
        List<RegistrationEvent> events = registrationEventRepository.findAll();
        List<RegistrationEvent> studentEvents = new ArrayList<>();

        for(RegistrationEvent registrationEvent: events){
            for(RegistrationGroup registrationGroup: registrationEvent.getRegistrationGroupsList()){
                for(Student student: registrationGroup.getStudents()){
                    if(student.getStudentId() == studentID){
                        studentEvents.add(registrationEvent);
                    }
                }
            }
        }
        studentEvents.sort((e1,e2) -> e1.getEndDate().compareTo(e2.getEndDate()));
        return studentEvents.get(0);
    }
}
