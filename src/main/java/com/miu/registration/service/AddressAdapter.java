package com.miu.registration.service;

import com.miu.registration.domain.Address;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AddressAdapter implements  IAdapter<Address, AddressDTO> {
    @Override
    public Address getDomainFromDTO(AddressDTO addressDTO) {
        Address address = new Address();

        address.setStreet(addressDTO.getStreet());
        address.setCity(addressDTO.getCity());
        address.setPostalCode(addressDTO.getPostalCode());
        address.setState(addressDTO.getState());
        address.setCountry(addressDTO.getCountry());

        return address;
    }

    @Override
    public AddressDTO getDTOFromDomain(Address address) {
        AddressDTO addressDTO = new AddressDTO();

        addressDTO.setStreet(address.getStreet());
        addressDTO.setCity(address.getCity());
        addressDTO.setPostalCode(address.getPostalCode());
        addressDTO.setState(address.getState());
        addressDTO.setCountry(address.getCountry());

        return addressDTO;
    }

    @Override
    public List<Address> getDomainsFromDTOs(List<AddressDTO> addressDTOS) {
        return addressDTOS.stream()
                .map(addressDTO -> getDomainFromDTO(addressDTO))
                .collect(Collectors.toList());
    }

    @Override
    public List<AddressDTO> getDTOsFromDomains(List<Address> addresses) {
        return addresses.stream()
                .map(address -> getDTOFromDomain(address))
                .collect(Collectors.toList());
    }
}
