package com.bispo.crm.service;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;

import com.bispo.crm.model.Booking;
import com.bispo.crm.repository.BookingRepository;

// @RunWith(SpringRunner.class)
public class BookingServiceTest {

	// @TestConfiguration
	static class BookingServiceTestConfiguration {

		// @Bean
		public BookingService bookingService() {
			return new BookingService();
		}
		
	}
	
	// @Autowired
	BookingService bookingService;
	
	// @MockBean
	BookingRepository bookingRepository;
	
	// @Test
	public void bookingTestServiceDaysCalculator() {
		String name = "Bispo";
		int nroDias = bookingService.daysCalculatorWithDatabase(name);
		
		Assertions.assertEquals(nroDias, 10);
	}
	
	// @Before
	public void setup() {
		LocalDate checkIn = LocalDate.parse("2021-02-10");
		LocalDate checkOut = LocalDate.parse("2021-02-20");
		
		Booking booking = new Booking(1L, "Bispo", checkIn, checkOut, 2);
		
		Mockito.when(bookingRepository.reserveName(booking.getReserveName()))
			.thenReturn(java.util.Optional.of(booking));
	}
	
	
	
	
}
