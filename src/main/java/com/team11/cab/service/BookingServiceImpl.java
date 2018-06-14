package com.team11.cab.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.team11.cab.model.Booking;
import com.team11.cab.model.Slot;
import com.team11.cab.repository.BookingRepository;

@Service
public class BookingServiceImpl implements BookingService {
	@Autowired
	private FacilityService facilityService;
	@Resource
	private BookingRepository bookingRepository;

	@Override
	@Transactional
	public ArrayList<Booking> findAllBookings() {
		ArrayList<Booking> bookinglist = (ArrayList<Booking>) bookingRepository.findAll();

		return bookinglist;
	}

	@Override
<<<<<<< HEAD
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
=======
	@Transactional
	public ArrayList<Booking> findMyBookings(String username) {
		ArrayList<Booking> bookinglist = new ArrayList<Booking>();
		bookinglist = (ArrayList<Booking>) bookingRepository.findMyBookingsbyusername(username);
		return bookinglist;
	}

	public boolean isBookingValid(Booking newBooking) {
		ArrayList<Booking> bookings = findAllBookings();
		// if you find a booking with same facility and it the timings overlap with each
		// other, it's invalid
		for (Booking booking : bookings) {
			Boolean sameFac = (newBooking.getFacility().getFacilityId() == booking.getFacility().getFacilityId());
			Boolean overlaps = isOverlap(newBooking.getStartDateTime(), newBooking.getEndDateTime(),
					booking.getStartDateTime(), booking.getEndDateTime());
			Boolean invalidRange = ((newBooking.getStartDateTime().isAfter(newBooking.getEndDateTime())) || 
					(newBooking.getStartDateTime().equals(newBooking.getEndDateTime())));
			
			if ((sameFac && overlaps) || invalidRange) {
				return false;
			}
		}
		return true;
	}

	private boolean isOverlap(LocalDateTime start1, LocalDateTime end1, LocalDateTime start2, LocalDateTime end2) {
		return (start1.isBefore(end2)) && (start2.isBefore(end1));
>>>>>>> refs/remotes/origin/master
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
		return bookingRepository.findOne(id);
	}
<<<<<<< HEAD
	
	@Override
	public ArrayList<Slot> makeFacilityDaySchedule(int facilityId, LocalDate date) {
		
		ArrayList<Slot> day = new ArrayList<Slot>();
		// do 12 times
		LocalTime openingHr = LocalTime.of(9, 0);
		
=======

	@Override
	@Transactional
	public Booking changeBooking(Booking b) {
		bookingRepository.saveAndFlush(b);
		return b;
	}

	@Override
	public void removeBooking(Booking booking) {
		bookingRepository.delete(booking);
	}

	public ArrayList<Slot> makeFacilityDaySchedule(int facilityId, LocalDate date) {

		ArrayList<Slot> day = new ArrayList<Slot>();
		// do 12 times
		LocalTime openingHr = LocalTime.of(9, 0);

>>>>>>> refs/remotes/origin/master
		for (int i = 0; i < 12; i++) {
			// create a booking object
			Booking b = new Booking();
			LocalDateTime start = LocalDateTime.of(date, openingHr.plusHours(i));
			b.setStartDateTime(start);
			LocalDateTime end = LocalDateTime.of(date, openingHr.plusHours(i + 1));
			b.setEndDateTime(end);
			b.setFacility(facilityService.findFacilityById(facilityId));

			// check if that booking is valid
			boolean isValid = !isBookingValid(b);
			// get what should be displayed in the box
			String slotName = start.format(DateTimeFormatter.ofPattern("ha"));
			// create a slot
			Slot s = new Slot(slotName, isValid);
			// add it the ArrayList<Slot>
			day.add(s);
		}
		return day;
	}
}
