
package com.team11.cab.model;

import java.util.Date;

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
	private Date transDate;
	@Column(name = "UserId")
	private int userid;
	@Column(name = "StartDate")
	private Date startDate;
	@Column(name = "EndDate")
	private Date endDate;

	@OneToOne
	@JoinColumn(name = "FacilityId")
	private Facility facility;

	@OneToOne
	@JoinColumn(name = "userId")
	private Member member;

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

	public int getUserId() {
		return userid;
	}

	public void setUserId(int userId) {
		this.userid = userId;
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

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}


}