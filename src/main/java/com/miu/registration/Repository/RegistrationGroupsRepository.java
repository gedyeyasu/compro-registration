package com.miu.registration.Repository;


import com.miu.registration.model.RegistrationGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationGroupsRepository extends JpaRepository<RegistrationGroup,Long> {
}
