
package com.team11.cab.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "booking")
public class Booking {
	@Id
	@Column(name = "BookingId")
	private int bookingId;
	@Column(name = "TransDate")
	private LocalDateTime transDate;

	@Column(name = "FacilityId")
	private int facilityId;

	@Column(name = "UserId")
	private int userid;

	@Column(name = "StartDate")
	// , columnDefinition="DATE")
	// @Temporal(TemporalType.DATE)
	// @DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDateTime startDate;

	@Column(name = "EndDate")
	// , columnDefinition="DATE")
	// @Temporal(TemporalType.DATE)
	// @DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDateTime endDate;

	@JsonIgnore
	@OneToOne
	@JoinColumn(name = "facilityId")
	private Facility facility;

	@JsonIgnore
	@OneToOne
	@JoinColumn(name = "userId")
	private Member member;

	public int getBookingId() {
		return bookingId;
	}

	public LocalDateTime getEndDate() {
		return endDate;
	}

	public Facility getFacility() {
		return facility;
	}

	public int getFacilityId() {
		return facilityId;
	}

	public Member getMember() {
		return member;
	}

	public LocalDateTime getStartDate() {
		return startDate;
	}

	public LocalDateTime getTransDate() {
		return transDate;
	}

	public int getUserId() {
		return userid;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}

	public void setFacilityId(int facilityId) {
		this.facilityId = facilityId;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	public void setTransDate(LocalDateTime transDate) {
		this.transDate = transDate;
	}

	public void setUserId(int userId) {
		this.userid = userId;
	}

}