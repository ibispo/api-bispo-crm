package com.bispo.crm;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.bispo.crm.model.Booking;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BookingControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;
	
	
	@Test
	public void bookingTestGetAll() throws Exception {
		mockMvc.perform(get("/bookings"))
			.andExpect(status().isOk());
	}
	
	
	
	@Test
	public void bookingTestSave() throws Exception {
		
		LocalDate checkIn = LocalDate.parse("2021-02-10");
		LocalDate checkOut = LocalDate.parse("2021-02-20");
		
		Booking booking = new Booking(1L, "Bispo", checkIn, checkOut, 2);
		
		mockMvc.perform(post("/bookings")
			.contentType("application/json")
			.content(objectMapper.writeValueAsString(booking)))
			.andExpect(status().isOk());
		
	}
	
	
	
}
