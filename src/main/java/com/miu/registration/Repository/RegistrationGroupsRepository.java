package com.miu.registration.Repository;


import com.miu.registration.model.RegistrationGroups;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;

@Repository
public interface RegistrationGroupsRepository extends JpaRepository<RegistrationGroups,Long> {
}
