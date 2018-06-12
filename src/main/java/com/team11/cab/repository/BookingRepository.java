package com.team11.cab.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.team11.cab.model.Booking;

public interface BookingRepository extends JpaRepository<Booking, Integer> {


}
