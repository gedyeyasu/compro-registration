package com.miu.registration.repositories;


import com.miu.registration.domain.AcademicBlock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcademicBlockRepo extends JpaRepository<AcademicBlock,Long> {
}
