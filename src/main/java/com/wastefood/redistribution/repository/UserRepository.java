package com.wastefood.redistribution.repository;

import com.wastefood.redistribution.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

}