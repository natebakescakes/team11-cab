package com.team11.cab.service;

import java.util.ArrayList;

import com.team11.cab.model.Booking;
import com.team11.cab.model.Department;

public interface BookingService
{
	
	ArrayList<Booking> findAllBookings();
	
	Booking findBooking(Integer bid);

	Booking createBooking(Booking book);

	Booking changeBooking(Booking book);

	void removeBooking(Booking book);

}
