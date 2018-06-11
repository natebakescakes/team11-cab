package com.team11.cab.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Facility {

	@Id
	private int FacilityId;
	private String FacilityName;
	private int FacilityType;
	private String Location;
	private String Description;

//	public Facility(int FacilityId, String FacilityName, int FacilityType, String Location, String Description) {
//		super();
//		FacilityId = this.FacilityId;
//		FacilityName = this.FacilityName;
//		FacilityType = this.FacilityType;
//		Location = this.Location;
//		Description = this.Description;
//	}

	public int getFacilityId() {
		return FacilityId;
	}

	public void setFacilityId(int facilityId) {
		FacilityId = facilityId;
	}

	public String getFacilityName() {
		return FacilityName;
	}

	public void setFacilityName(String facilityName) {
		FacilityName = facilityName;
	}

	public int getFacilityType() {
		return FacilityType;
	}

	public void setFacilityType(int facilityType) {
		FacilityType = facilityType;
	}

	public String getLocation() {
		return Location;
	}

	public void setLocation(String location) {
		Location = location;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	@Override
	public String toString() {
		return "Facility [FacilityId=" + FacilityId + ", FacilityName=" + FacilityName + ", FacilityType="
				+ FacilityType + ", Location=" + Location + ", Description=" + Description + "]";
	}
}
