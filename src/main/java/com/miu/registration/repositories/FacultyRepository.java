package com.miu.registration.repositories;

import com.miu.registration.domain.Faculty;
import com.miu.registration.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {
    Faculty findFacultiesByUser(User user);
}
