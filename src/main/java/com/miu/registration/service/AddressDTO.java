package com.miu.registration.service;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressDTO {
    private String street;
    private String city;
    private long postalCode;
    private String state;
    private String country;
}
