package com.project.busticketstore.repository;

import com.project.busticketstore.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsernameOrEmailOrNationalCodeOrMobileNumber(String username, String email, String nationalCode, String mobileNumber);
}
