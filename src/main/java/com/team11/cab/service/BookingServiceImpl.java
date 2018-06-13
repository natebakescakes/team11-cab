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
		ArrayList<Booking> bookinglist = (ArrayList<Booking>) bookingRepository.findAll();

		return bookinglist;
	}

	@Override
	public boolean isBookingValid(LocalDateTime start1, LocalDateTime end1, LocalDateTime start2, LocalDateTime end2) {
		return !((start1.isBefore(end2)) && (start2.isBefore(end1))) ? true : false;
	}

	@Override
	@Transactional
	public Booking makeBooking(Booking newBooking) {
		Booking result = bookingRepository.save(newBooking);
		return result;
	}

	public boolean validateBookings(int id) {

		if (bookingRepository.findOne(id) != null)
			return true;
		else
			return false;

	}

	@Override
	public Booking findBookingByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Booking createBooking(Booking booking) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Booking changeBooking(Booking booking) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeBooking(Booking booking) {
		// TODO Auto-generated method stub
		
	}
}
