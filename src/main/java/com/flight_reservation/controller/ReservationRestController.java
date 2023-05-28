package com.flight_reservation.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flight_reservation.dto.ReservationUpdateRequest;
import com.flight_reservation.entities.Reservation;
import com.flight_reservation.repository.ReservationRepository;

@RestController  //convert Java Object to json object & json object to Java Object.
@RequestMapping("/reservation")
public class ReservationRestController {
	@Autowired
	private ReservationRepository reserRepo;
	
	//create method for find by id
	@GetMapping("/{id}")
	public Reservation findReservation(@PathVariable("id")Long id) {
		Optional<Reservation> findById = reserRepo.findById(id);
		Reservation reservation = findById.get();
		return reservation;
	}
	@PostMapping
	public Reservation updateReservation(
		@RequestBody ReservationUpdateRequest request) 
	{	
		Optional<Reservation> findById = reserRepo.findById(request.getId());
		Reservation reservation = findById.get();
		reservation.setCheckedIn(request.isCheckedIn());
		reservation.setNumberOfBags(request.getNumberOfBags());
		Reservation save = reserRepo.save(reservation);
		return save;
	}
	@RequestMapping("/findAll")
	public List<Reservation> findAllDetails(){
		List<Reservation> findAll =reserRepo.findAll();
		return findAll;
		}
	

}
