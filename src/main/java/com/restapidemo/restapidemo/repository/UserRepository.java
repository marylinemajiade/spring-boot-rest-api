package com.restapidemo.restapidemo.repository;

import com.restapidemo.restapidemo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
