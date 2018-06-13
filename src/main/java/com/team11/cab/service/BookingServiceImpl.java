package com.team11.cab.service;

import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.team11.cab.model.Booking;
import com.team11.cab.repository.BookingRepository;


@Service
public class BookingServiceImpl implements BookingService {

	@Resource
	private BookingRepository bookingRepository;
	
	@Override
	@Transactional
	public ArrayList<Booking> findAllBookings() {
		ArrayList<Booking> bookinglist = (ArrayList<Booking>)bookingRepository.findAll();
		return bookinglist;
	}

	@Override
	public boolean isBookingValid(Booking newBooking) {
		ArrayList<Booking> bookings = findAllBookings();
		// if you find a booking with same facility and it the timings overlap with each other, it's invalid
		for (Booking booking : bookings) {
			Boolean sameFac = (newBooking.getFacility().getFacilityId() == booking.getFacility().getFacilityId());
			Boolean overlaps = isOverlap(newBooking.getStartDateTime(), newBooking.getEndDateTime(),
					booking.getStartDateTime(), booking.getEndDateTime());
			if (sameFac && overlaps) {
				return false;
			}
		}
		return true;
	}
	
	private boolean isOverlap(LocalDateTime start1, LocalDateTime end1, LocalDateTime start2, LocalDateTime end2) {
		 return (start1.isBefore(end2)) && (start2.isBefore(end1));
	}

	@Override
	@Transactional
	public Booking makeBooking(Booking newBooking) {
		Booking result = bookingRepository.save(newBooking);
		return result;
	}
	public boolean validateBookings(int id) {

		
		if(bookingRepository.findOne(id)!= null) return true;
		else return false;
		
	}

	@Override
	public Booking findBookingByID(int id) {
		return bookingRepository.findOne(id);
	}
}
