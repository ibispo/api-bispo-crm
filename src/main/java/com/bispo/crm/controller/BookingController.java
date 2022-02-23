package com.bispo.crm.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bispo.crm.model.Booking;

@RestController
@RequestMapping("/bookings")
public class BookingController {

	@GetMapping
	@ResponseBody
	// @ResponseStatus(code = HttpStatus.CREATED)
	public String getAll() {
		return "Bispo GetAll";
	}
	
	@PostMapping
	public ResponseEntity<Booking> save(Booking booking) {
		return ResponseEntity.status(HttpStatus.OK).body(booking);
	}
	
	
}
