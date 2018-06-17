package com.team11.cab.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

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
import javax.persistence.Transient;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonSetter;

@Entity
@Table(name = "user")
public class Member implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "UserId")
	private int userid;

	@Basic(optional = false)
	@Column(name = "FirstName")
	@NotEmpty(message = "*Please provide your first name")
	private String firstName;

	@Basic(optional = false)
	@Column(name = "LastName")
	@NotEmpty(message = "*Please provide your last name")
	private String lastName;

	@Basic(optional = false)
	@Column(name = "Email")
	@Email(message = "*Please provide a valid email")
	@NotEmpty(message = "*Please provide an email")
	private String email;

	@Column(name = "Address")
	private String address;

	@Basic(optional = false)
	@Column(name = "ContactNo")
	@NotEmpty(message = "*Please provide a contact number")
	private String phone;

	@Column(name = "DateOfBirth", columnDefinition = "DATETIME")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dob;

	// @Transient
	@JsonIgnore
	@OneToMany(targetEntity = Booking.class, mappedBy = "member", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Booking> bookings = new ArrayList<Booking>();

	@Column(name = "username")
	@Length(min = 5, message = "*Your username must have at least 5 characters")
	@NotEmpty(message = "*Please provide your username")
	private String username;

	@JsonIgnore
	@Length(min = 5, message = "*Your password must have at least 5 characters")
	@NotEmpty(message = "*Please provide your password")
	private String password;

	private boolean enabled;

	@JsonManagedReference
	@OneToMany(mappedBy = "member", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval=true)
	private Set<Authority> authorities;
	
	@Transient
	private boolean changeAdmin;

	public Member() {
	}

	public Member(int userid, String username, String firstName, String lastName, String email, String address,
			String phone, Date dob
	// ,ArrayList<Booking> bookings
	) {
		super();
		this.userid = userid;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.address = address;
		this.phone = phone;
		this.dob = dob;
		// this.bookings = bookings;
	}

	public String getAddress() {
		return address;
	}

	public Set<Authority> getAuthorities() {
		return authorities;
	}

	public List<Booking> getBookings() {
		return bookings;
	}

	public Date getDob() {
		return dob;
	}

	public String getEmail() {
		return email;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getPassword() {
		return password;
	}

	public String getPhone() {
		return phone;
	}

	public int getUserid() {
		return userid;
	}

	public String getUsername() {
		return username;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setAuthorities(Set<Authority> authorities) {
		this.authorities = authorities;
	}

	public void setBookings(ArrayList<Booking> bookings) {
		this.bookings = bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@JsonGetter("admin")
	public boolean isAdmin() {
		return this.authorities.stream().filter(x -> x.getAuthority().equals("ROLE_ADMIN")).count() > 0;
	}
	
	@JsonSetter("admin")
	public void setAdmin(boolean changeAdmin) {
		this.changeAdmin = changeAdmin;
	}
	
	public boolean isChangeAdmin() {
		return changeAdmin;
	}
	
}
