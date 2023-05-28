package com.flight_reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flight_reservation.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

 User findByEmail(String email);

}
