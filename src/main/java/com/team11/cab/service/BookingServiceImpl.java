package com.team11.cab.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.team11.cab.model.Booking;
import com.team11.cab.model.Department;
import com.team11.cab.model.Member;
import com.team11.cab.repository.BookingRepository;
import com.team11.cab.repository.MemberRepository;


@Service
public class BookingServiceImpl implements BookingService 
{
	@Resource
	private BookingRepository bookingRepository;
	
	@Override
	@Transactional
	public ArrayList<Booking> findAllBookings() 
	{
		ArrayList<Booking> bookinglist = (ArrayList<Booking>)bookingRepository.findAll();
		
		return bookinglist;
	}

	
	@Override
	public Booking findBooking(Integer bid)
	{	
		return bookingRepository.findOne(bid);
	}

	@Override
	@Transactional
	public Booking createBooking(Booking book)
	{	
		return bookingRepository.saveAndFlush(book);
	}
	
	@Override
	@Transactional
	public Booking changeBooking(Booking book)
	{
		return bookingRepository.saveAndFlush(book);
	}

	@Override
	@Transactional
	public void removeBooking(Booking book)
	{	
		System.out.println(book.toString());
		bookingRepository.delete(book);
	}

}
