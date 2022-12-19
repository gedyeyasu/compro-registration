package com.miu.registration.repositories;

import com.miu.registration.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentRepository extends JpaRepository<Student, Long> {
    public Student findByStudentId(Long studentId);
    public long deleteByStudentId(Long studentId);
}
