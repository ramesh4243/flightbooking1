package com.flight_reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.flight_reservation.dto.ReservationRequest;
import com.flight_reservation.entities.Reservation;
import com.flight_reservation.service.ReservationService;



@Controller
public class ReservationController {
 @Autowired
	private ReservationService reservationService;
 
 @RequestMapping("/completeReservation")
 public String confirmReservation(ReservationRequest request, Model map) {
	 Reservation reservationId = reservationService.bookFlight(request);
	 map.addAttribute("reservationId", reservationId);
	 
	  return "login/confirmReservation";
 }
}
