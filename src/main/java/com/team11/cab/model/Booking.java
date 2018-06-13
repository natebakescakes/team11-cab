
package com.team11.cab.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Department class
 *
 * @version $Revision: 1.0
 */
@Entity
@Table(name = "booking")
public class Booking {
	@Id
	@Column(name = "BookingId")
	private int bookingId;
	@Column(name = "TransDate")
	private LocalDateTime transDate;
	@Column(name = "StartDate")
	private LocalDateTime startDateTime;
	@Column(name = "EndDate")
	private LocalDateTime endDateTime;

	@OneToOne
	@JoinColumn(name = "FacilityId")
	private Facility facility;

	@OneToOne
	@JoinColumn(name = "UserId")
	private Member member;

	public Booking() {
		super();
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public LocalDateTime getTransDate() {
		return transDate;
	}

	public void setTransDate(LocalDateTime transDate) {
		this.transDate = transDate;
	}

	public LocalDateTime getStartDate() {
		return startDateTime;
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDateTime = startDate;
	}

	public LocalDateTime getEndDate() {
		return endDateTime;
	}

	public void setEndDate(LocalDateTime endDate) {
		this.endDateTime = endDate;
	}

	public Facility getFacility() {
		return facility;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

}