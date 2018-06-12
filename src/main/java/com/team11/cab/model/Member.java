package com.team11.cab.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="user")
public class Member {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="UserId")
	private int userid;
	
	@Basic(optional=false)
	@Column(name="FirstName")
	private String firstName;
	
	@Basic(optional=false)
	@Column(name="LastName")
	private String lastName;
	
	@Basic(optional=false)
	@Column(name="Email")
	private String email;
	
	@Column(name="Address")
	private String address;
	
	@Basic(optional=false)
	@Column(name="ContactNo")
	private String phone;
	
	@Column(name="DateOfBirth", columnDefinition="DATETIME")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dob;
	
	@OneToMany(targetEntity=Booking.class, mappedBy="member", fetch=FetchType.EAGER)
	private List<Booking> bookings = new ArrayList<Booking>();
	
	public Member() {}

	public Member(int userid, String firstName, String lastName, String email, String address, String phone, Date dob
			//,ArrayList<Booking> bookings
			) {
		super();
		this.userid = userid;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.address = address;
		this.phone = phone;
		this.dob = dob;
		//this.bookings = bookings;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

//	public List<Booking> getBookings() {
//		return bookings;
//	}
//
//	public void setBookings(ArrayList<Booking> bookings) {
//		this.bookings = bookings;
//	}

	public int getUserid() {
		return userid;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
