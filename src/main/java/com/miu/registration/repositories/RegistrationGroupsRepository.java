package com.miu.registration.repositories;



import com.miu.registration.domain.RegistrationGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationGroupsRepository extends JpaRepository<RegistrationGroup,Long> {
}
