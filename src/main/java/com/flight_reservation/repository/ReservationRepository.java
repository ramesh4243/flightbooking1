package com.flight_reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flight_reservation.entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
