package com.miu.registration.service.Impl;



import com.miu.registration.service.DTO.RegistrationRequestDTO;
import com.miu.registration.domain.RegistrationRequest;

import com.miu.registration.repositories.RegistrationRequestRepository;
import com.miu.registration.service.Adapters.RegistrationRequestAdaptor;
import com.miu.registration.service.IRegistrationRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RegistrationRequestService implements IRegistrationRequestService {

    private final RegistrationRequestRepository requestRepository;

    private final RegistrationRequestAdaptor registrationRequestAdaptor;
    @Override
    public Collection<RegistrationRequestDTO> getAllSubmitRequests() {
        Collection<RegistrationRequestDTO>registrationRequestDTOS = requestRepository.findAll().stream()
                .map(registrationRequestAdaptor::fromRegistrationRequest).collect(Collectors.toList());

        return registrationRequestDTOS;
    }

    @Override
    public RegistrationRequestDTO getSubmittedRequest(long id) {
        var registration = requestRepository.findById(id);
        return registration.map(registrationRequestAdaptor::fromRegistrationRequest).orElse(null);


    }

    @Override
    public void createSubmittedRequest(RegistrationRequestDTO requestDTO) {
        requestRepository.save(registrationRequestAdaptor.fromRegistrationRequestDto(requestDTO));

    }

    @Override
    //?????????
    public void updateRequest(long id, RegistrationRequestDTO registrationRequestDTO) {
        var request = requestRepository.findById(id);
        if (request.isPresent() && registrationRequestDTO!=null){

            RegistrationRequest registrationRequest = request.get();
            RegistrationRequest request1 = registrationRequestAdaptor.fromRegistrationRequestDto(registrationRequestDTO);

            registrationRequest.setStudent(request1.getStudent());
            registrationRequest.setCourseOffering(request1.getCourseOffering());
            requestRepository.save(registrationRequest);
        }

    }


    @Override
    public void deleteRequest(long id) {
        requestRepository.deleteById(id);
    }
}
