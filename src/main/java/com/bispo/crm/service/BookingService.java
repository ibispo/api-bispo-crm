package com.bispo.crm.service;

import java.time.Period;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bispo.crm.model.Booking;
import com.bispo.crm.repository.BookingRepository;

@Service
public class BookingService {

	@Autowired
	BookingRepository bookingRepository;
	
	
	public int daysCalculatorWithDatabase(String name) {

		Optional<Booking> bookingModelOptional = bookingRepository.reserveName(name);
		
		return Period.between(bookingModelOptional.get().getCheckIn(), 
			bookingModelOptional.get().getCheckOut()).getDays();
	}

}
