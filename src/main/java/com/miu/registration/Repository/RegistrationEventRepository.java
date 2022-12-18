package com.miu.registration.Repository;

import com.miu.registration.model.RegistrationEvent;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface RegistrationEventRepository extends JpaRepository<RegistrationEvent,Long> {

}
