package com.miu.registration.repositories;

import com.miu.registration.domain.CourseOffering;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseOfferingRepository extends JpaRepository<CourseOffering,Long> {

    CourseOffering findCourseOfferingByCode(String code);
}
