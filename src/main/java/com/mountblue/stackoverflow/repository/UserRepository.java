package com.mountblue.stackoverflow.repository;

import com.mountblue.stackoverflow.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
