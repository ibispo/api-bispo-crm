package com.bispo.crm.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Booking {

	@Id
	private Long id;
	private String reserveName;
	private LocalDate checkIn;
	private LocalDate checkOut;
	private Integer numberGuests;

	public Booking(Long id, String reserveName, LocalDate checkIn, LocalDate checkOut, Integer numberGuests) {
		super();
		this.id = id;
		this.reserveName = reserveName;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.numberGuests = numberGuests;
	}
	
	
}
