package com.miu.registration.service.Adapters;

import java.util.List;

public interface IAdapter<Domain, DTO> {
    public Domain getDomainFromDTO(DTO dto);
    public DTO getDTOFromDomain(Domain domain);

    public List<Domain> getDomainsFromDTOs(List<DTO> dtos);

    public List<DTO> getDTOsFromDomains(List<Domain> domains);
}
