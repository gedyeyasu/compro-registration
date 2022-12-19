package com.miu.registration.service.Adapters;

import com.miu.registration.service.DTO.RegistrationDTO;
import com.miu.registration.domain.Registration;

public class RegistrationAdopter {


        public static Registration fromRegistrationDTO(RegistrationDTO registrationDTO){

            Registration registration=new Registration();
            return registration;
        }


        public static RegistrationDTO fromRegistration(Registration registration){

            RegistrationDTO registrationDTO=new RegistrationDTO();
            return registrationDTO;
        }

    }
