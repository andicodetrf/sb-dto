package com.andi.springbootdto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andi.springbootdto.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
