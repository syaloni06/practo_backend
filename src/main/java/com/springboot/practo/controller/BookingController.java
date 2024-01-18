package com.springboot.practo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.practo.Entities.Booking;
import com.springboot.practo.services.BookingService;

@RestController
@RequestMapping("/api/booking")
public class BookingController {
	
	@Autowired
	BookingService bookingService;
	
	@GetMapping("/find")
	public List<Booking> getBookingList(){
		return bookingService.getBookingList();
	}

}
