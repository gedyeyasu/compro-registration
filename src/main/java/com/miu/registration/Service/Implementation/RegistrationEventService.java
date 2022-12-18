package com.miu.registration.Service.Implementation;

import com.miu.registration.Repository.RegistrationEventRepository;
import com.miu.registration.Service.RegistrationEventInterface;
import com.miu.registration.dto.RegistrationEventDTO;
import com.miu.registration.model.RegistrationEvent;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class RegistrationEventService implements RegistrationEventInterface {

    @Autowired
    private RegistrationEventRepository registrationEventRepository;

    @Override
    public List<RegistrationEvent> getAllRegistrationEvent() {
        return null;
    }

    @Override
    public void viewRegisterationEvent(RegistrationEventDTO registrationEventDTO) {

        RegistrationEvent registrationEvent = new RegistrationEvent();
        BeanUtils.copyProperties(registrationEventDTO, registrationEvent);
        registrationEventRepository.save(registrationEvent);

    }

    @Override
    public void deleteRegistrationList(Long registrationeventId) {
        registrationEventRepository.deleteAll();

    }

    @Override
    public  RegistrationEvent getlatesetevent() {
        return (RegistrationEvent) registrationEventRepository.findAll(Sort.by(Sort.Direction.DESC,""));
    }


    @Override
    public List<RegistrationEvent> getFetchRegistrationList() {
        return registrationEventRepository.findAll();
    }


    public List<RegistrationEvent> updateevents(Long updateid, Date startDate, Date endDate) {
        return registrationEventRepository.findAll();
    }
}
