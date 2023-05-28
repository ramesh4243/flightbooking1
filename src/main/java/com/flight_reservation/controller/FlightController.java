package com.flight_reservation.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.flight_reservation.entities.Flight;
import com.flight_reservation.repository.FlightRepository;

@Controller
public class FlightController {

	@Autowired
	private FlightRepository flightRepo;
	
	@RequestMapping("/findFlights")
	public String findFlights(@RequestParam("from") String from, @RequestParam("to") String to,
			@RequestParam("departureDate") @DateTimeFormat(pattern="MM-dd-yyyy") Date departureDate, Model map)
	{
		List<Flight> findFlights = flightRepo.findFlights(from, to, departureDate);
		map.addAttribute("findFlights", findFlights);
		return "login/displayFlight";
	}
	@RequestMapping("/showCompleteReservation")
	public String showCompleteReservation(@RequestParam("flightId") Long flightId, Model map) {
           Optional<Flight> findById = flightRepo.findById(flightId);
           Flight flight = findById.get();
           map.addAttribute("flight",flight);
           return "login/showReservation";
}
}
