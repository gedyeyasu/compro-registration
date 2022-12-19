package com.miu.registration.service.DTO;

import com.miu.registration.domain.Student;

import java.util.List;

public interface IAdapter<Domain, DTO> {
    public Domain getDomainFromDTO(DTO dto);
    public DTO getDTOFromDomain(Domain domain);

    public List<Domain> getDomainsFromDTOs(List<DTO> dtos);

    public List<DTO> getDTOsFromDomains(List<Domain> domains);
}
