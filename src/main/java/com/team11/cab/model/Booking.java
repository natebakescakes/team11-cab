
package com.team11.cab.model;

import java.util.Date;


import javax.persistence.*;

/**
 * Department class
 *
 * @version $Revision: 1.0
 */
@Entity
@Table(name = "Booking")
public class Booking {
	@Id
	@Column(name = "BookingId")
	private int bookingId;
	@Column(name = "TransDate")
	private Date transDate;
	@Column(name = "FacilityId")
	private int facilityId;
	@Column(name = "UserId")
	private int userId;
	@Column(name = "StartDate")
	private Date startDate;
	@Column(name = "EndDate")
	private Date endDate;

	@OneToOne
	@JoinColumn(name = "facilityId")
	private Facility facility;

	@OneToOne
	@JoinColumn(name = "userId")
	private User user;

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public Date getTransDate() {
		return transDate;
	}

	public void setTransDate(Date transDate) {
		this.transDate = transDate;
	}

	public int getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(int facilityId) {
		this.facilityId = facilityId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Facility getFacility() {
		return facility;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}