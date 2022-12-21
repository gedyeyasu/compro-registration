package com.miu.registration.repositories;

import com.miu.registration.domain.Student;
import com.miu.registration.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentRepository extends JpaRepository<Student, Long> {
    public Student findByStudentId(Long studentId);
    public Long deleteByStudentId(Long studentId);
    Student findStudentByUser(User user);
}
