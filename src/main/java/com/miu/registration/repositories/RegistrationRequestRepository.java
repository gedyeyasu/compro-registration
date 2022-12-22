package com.miu.registration.repositories;

import com.miu.registration.domain.CourseOffering;
import com.miu.registration.domain.RegistrationRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.PriorityQueue;

@Repository
public interface RegistrationRequestRepository extends JpaRepository<RegistrationRequest,Long> {

    List<RegistrationRequest> findRegistrationRequestByStudentId(Long studentId);
    PriorityQueue<RegistrationRequest> findRegistrationRequestByStudentIdAndCourseOfferingOrderByPriority(Long studentId, CourseOffering courseOffering);
}
