package com.flight_reservation.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flight_reservation.dto.ReservationRequest;
import com.flight_reservation.entities.Flight;
import com.flight_reservation.entities.Passenger;
import com.flight_reservation.entities.Reservation;
import com.flight_reservation.repository.FlightRepository;
import com.flight_reservation.repository.PassengerRepository;
import com.flight_reservation.repository.ReservationRepository;
import com.flight_reservation.utilities.EmailUtil;
import com.flight_reservation.utilities.PdfGenerator;

 @Service
public class ReservationServiceImpl implements ReservationService {
	 
	 @Autowired
	 private PdfGenerator pdf;

	 @Autowired
	 private PassengerRepository passengerRepository;
	  @Autowired
	 private FlightRepository flightRepository;
	  @Autowired
	  private ReservationRepository reservationRepository;
	  
	  @Autowired
	  private EmailUtil utils;

	  
	@Override
	public Reservation bookFlight(ReservationRequest request) {
		
		Passenger passenger = new Passenger();
		passenger.setFirstName(request.getFirstName());
		passenger.setMiddleName(request.getMiddleName());
		passenger.setLastName(request.getLastName());
		passenger.setEmail(request.getEmail());
		passenger.setPhone(request.getPhone());
		passengerRepository.save(passenger);
		
		long flightId = request.getFlightId();
		Optional<Flight> findById = flightRepository.findById(flightId);
		Flight flight = findById.get();
		
		Reservation reservation = new Reservation();
		reservation.setFlight(flight);
		reservation.setPassenger(passenger);
		reservation.setCheckedIn(false);
		reservation.setNumberOfBags(0);
		Reservation savedReservation = reservationRepository.save(reservation);
		
		String filePath = "D:\\flightTickets\\reservation" + reservation.getId() + ".pdf";
		  pdf.generatePDF(filePath, request.getFirstName(), request.getMiddleName(),
		          request.getLastName(), request.getEmail(), request.getPhone(), flight.getOperatingAirlines(),
		          flight.getDateOfDeparture(), flight.getDepartureCity(), flight.getArrivalCity());
		  
		  utils.sendEmail(request.getEmail(), filePath);
		  
		return savedReservation;
	}

}
