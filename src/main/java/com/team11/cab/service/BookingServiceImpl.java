package com.team11.cab.service;

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
	public boolean validateBookings(int id) {

		
		if(bookingRepository.findOne(id)!= null) return true;
		else return false;
		
	}

	@Override
	public Booking findBookingByID(int id) {
		return bookingRepository.findOne(id);
	}
	
	@Override
	@Transactional
	public Booking createBooking(Booking booking) {
		return bookingRepository.saveAndFlush(booking);
	}

	
	@Override
	@Transactional
	public Booking changeBooking(Booking booking) {
		return bookingRepository.saveAndFlush(booking);
	}

	@Override
	@Transactional
	public void removeBooking(Booking booking) {
		bookingRepository.delete(booking);
	}

}
