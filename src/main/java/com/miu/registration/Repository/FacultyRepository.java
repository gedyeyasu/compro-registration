package com.miu.registration.Repository;

import com.miu.registration.model.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty,Long> {
    Faculty findById(Faculty faculty);
}
