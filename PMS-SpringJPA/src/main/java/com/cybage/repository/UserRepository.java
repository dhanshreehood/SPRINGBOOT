package com.cybage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cybage.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
