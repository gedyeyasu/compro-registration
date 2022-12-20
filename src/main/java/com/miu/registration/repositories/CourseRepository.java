package com.miu.registration.repositories;

import com.miu.registration.domain.Course;
import com.miu.registration.service.Impl.CourseService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {
    public Course findCourseByCode(String code);
    public Long deleteCourseByCode(String code);
}
