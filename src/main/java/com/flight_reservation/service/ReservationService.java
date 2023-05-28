package com.flight_reservation.service;

import com.flight_reservation.dto.ReservationRequest;
import com.flight_reservation.entities.Reservation;

public interface ReservationService {
  Reservation bookFlight(ReservationRequest request);
}
