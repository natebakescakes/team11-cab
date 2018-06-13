package com.team11.cab.service;

import java.util.ArrayList;

import com.team11.cab.model.Booking;

public interface BookingService {
	
	ArrayList<Booking> findAllBookings();
	boolean validateBookings(int id);
	Booking findBookingByID(int id);
	Booking createBooking(Booking booking);
	Booking changeBooking(Booking booking);
	void removeBooking(Booking booking);
}
