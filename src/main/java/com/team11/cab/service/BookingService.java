package com.team11.cab.service;

import java.time.LocalDate;
import java.util.ArrayList;

import com.team11.cab.model.Booking;
import com.team11.cab.model.Slot;

public interface BookingService {
	ArrayList<Booking> findAllBookings();
<<<<<<< HEAD
	boolean isBookingValid(Booking newBooking);
=======

	boolean isBookingValid(Booking newBooking);

>>>>>>> refs/remotes/origin/master
	Booking makeBooking(Booking newBooking);

	boolean validateBookings(int id);

	Booking findBookingByID(int id);
<<<<<<< HEAD
	ArrayList<Slot> makeFacilityDaySchedule(int facilityId, LocalDate date);
=======

	ArrayList<Slot> makeFacilityDaySchedule(int facilityId, LocalDate date);

	Booking changeBooking(Booking booking);

	void removeBooking(Booking booking);

	ArrayList<Booking> findMyBookings(String username);

>>>>>>> refs/remotes/origin/master
}
