package com.team11.cab.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

<<<<<<< HEAD
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
=======
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
>>>>>>> refs/remotes/origin/master

/* facility class */

@Entity
@Table(name = "facility")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "facilityId")
public class Facility {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int facilityId;
	private String facilityName;
	private String location;
	private String description;
<<<<<<< HEAD

	// @Transient
	// private int facTypeId;
	@JsonIgnore
=======
	private int status;

	// @Transient
	// private int facTypeId;
	// @JsonManagedReference
>>>>>>> refs/remotes/origin/master
	@ManyToOne
	@JoinColumn(name = "FacilityType")
	private FacilityType facilityType;
<<<<<<< HEAD

	
=======

>>>>>>> refs/remotes/origin/master
	@JsonIgnore
	@OneToMany(targetEntity = Booking.class, mappedBy = "facility", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Booking> bookings = new ArrayList<Booking>();

	public Facility() {
		super();
	}

	public Facility(int facilityId, String facilityName, String location, String description,
			FacilityType facilityType, int status) {
		super();
		this.facilityId = facilityId;
		this.facilityName = facilityName;
		this.location = location;
		this.description = description;
		this.facilityType = facilityType;
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public int getFacilityId() {
		return facilityId;
	}

	public String getFacilityName() {
		return facilityName;
	}

	public FacilityType getFacilityType() {
		return facilityType;
	}

	public String getLocation() {
		return location;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setFacilityId(int facilityId) {
		this.facilityId = facilityId;
	}

	public void setFacilityName(String facilityName) {
		this.facilityName = facilityName;
	}

	public void setFacilityType(FacilityType facilityType) {
		this.facilityType = facilityType;
	}

	public void setLocation(String location) {
		this.location = location;
	}

<<<<<<< HEAD
	@JsonGetter
	public String getFacilityTypeName() {
		return this.facilityType.getTypeName();
	}

	// public int getFacTypeId() {
	// return facTypeId;
	// }
	//
	// public void setFacTypeId(int facTypeId) {
	// this.facTypeId = facTypeId;
	// }
=======
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
>>>>>>> refs/remotes/origin/master

}