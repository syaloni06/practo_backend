package com.springboot.practo.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.practo.Entities.Booking;
import com.springboot.practo.repositories.BookingRepository;
import com.springboot.practo.services.BookingService;
@Service
public class BookingServiceImpl implements BookingService{
	
	@Autowired
	BookingRepository bookingRepository;

	@Override
	public List<Booking> getBookingList() {
		return bookingRepository.findAll();
	}
	

}
