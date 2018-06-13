package com.team11.cab.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/* facility class */

@Entity
@Table(name = "facility")
public class Facility {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int facilityId;
	private String facilityName;
	private String location;
	private String description;
	private int status;
	


	@ManyToOne
	@JoinColumn(name = "FacilityType")
	private FacilityType facilityType;

	public Facility() {
		super();
	}

	public Facility(int facilityId, String facilityName, String location, String description,
			FacilityType facilityType) {
		super();
		this.facilityId = facilityId;
		this.facilityName = facilityName;
		this.location = location;
		this.description = description;
		this.facilityType = facilityType;
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
	
	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
}