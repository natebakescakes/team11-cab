package com.team11.cab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.team11.cab.model.Booking;

public interface BookingRepository extends JpaRepository<Booking, Integer> {

	
	@Query("SELECT c from Booking c WHERE c.bookingId = :id")
	Booking findBookingByID(@Param("id") String id);
}
