package com.bispo.crm.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bispo.crm.model.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {
	
	
	Optional<Booking> reserveName(String nm);
	

}
