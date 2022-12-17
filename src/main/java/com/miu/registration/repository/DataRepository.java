package com.miu.registration.repository;

import com.miu.registration.domain.Data;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataRepository extends JpaRepository<Data,Long> {
}
