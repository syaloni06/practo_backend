package com.springboot.practo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.practo.Entities.Booking;

public interface BookingRepository extends JpaRepository<Booking,Long>{

}
