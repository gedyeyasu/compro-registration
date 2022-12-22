package com.miu.registration.repositories;

import com.miu.registration.domain.Admin;
import com.miu.registration.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {

    Admin findAdminByUser(User user);
}
